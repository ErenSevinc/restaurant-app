import React, {Component} from 'react';
import ClientService from "../service/ClientService";
import nextId from "react-id-generator";
import './Component.css';
import '../App.css';

class CategotyNew extends Component {
    constructor(props) {
        super(props)
        this.myRef=React.createRef()
        this.state = {
            category: [],
            products: [],
            cards: [],
            totalPayments: 0,

            hasNext:true,
            scrollTop:0,
            catergoriesId:1,
            pageNumber:0,
            newProductsList:[],
            counter:1,

            card: {
                productId: 0,
                cardId: 0,
                piece: 0,
                cardName: '',
                totalPrice: 0,
                productPrice: 0,
                paymentType: 'cash',
                tableName: '',
                waiterName: ''

            },
            orders: []
        }

        this.getCatProduct = this.getCatProduct.bind(this);
        this.getProductList = this.getProductList.bind(this);
        this.btnAdd = this.btnAdd.bind(this);
        this.btnCikar = this.btnCikar.bind(this);
        this.paymentSuccess = this.paymentSuccess.bind(this);
    }

    componentDidMount() {
        ClientService.getCategory().then((res) => {
            this.setState({category: res.data})
        });
        // ClientService.getProducts().then((res) => {
        //     this.setState({products: res.data})
        // });
        ClientService.getCatProd(this.state.categoriesId,0).then((res) => {
            this.setState({products: res.data.productsDTOList,hasNext:res.data.hasNext})
        });
        this.setState({orders: CategotyNew.getOrderFromStorage()})
        let orders = CategotyNew.getOrderFromStorage();
        if (orders.length > 0) {
            for (let i = 0; i < orders.length; i++) {
                if (orders[i][0].tableName.indexOf(sessionStorage.getItem("tbl")) > -1) {
                    for (let j = 0; j < orders[i].length; j++) {
                        this.state.cards.push(orders[i][j]);
                        this.state.totalPayments += (orders[i][j].totalPrice);
                    }
                    orders.splice(i, 1);
                }

            }
        }
    }
    onScroll=()=>{
        let scrollTop=this.myRef.current.scrollTop
        this.setState({
            scrollTop:scrollTop
        });
        console.log(scrollTop);
            if (scrollTop > 1370 * this.state.counter) {
                console.log(this.state.hasNext);
                if (this.state.hasNext) {
                    this.state.pageNumber += 1;
                    this.myRef.current.scrollTop = this.state.scrollTop;
                    this.state.counter += 1;
                    this.state.hasNext = !this.state.hasNext;
                    ClientService.getCatProd(this.state.categoriesId, this.state.pageNumber).then((res) => {
                        this.setState({hasNext: res.data.hasNext})
                        for (let i = 0; i < res.data.productsDTOList.length; i++) {
                            this.state.products.push(res.data.productsDTOList[i]);
                        }
                        this.setState({products: this.state.products})
                    })
                }
            }
            console.log(this.state.categoriesId);

    }

    // getCatProduct(id) {
    //     ClientService.getCategoryProduct(id).then((res) => {
    //         this.setState({products: res.data})
    //     });
    //     this.render();
    // }
    getCatProduct(id) {
        ClientService.getCatProd(id,0).then((res) => {
                    this.setState({products: res.data.productsDTOList})
                });
        this.setState({categoriesId:id});
        this.render();
    }

    getProductList = (p) => {
        this.state.totalPayments += p.price;
        if (this.state.cards.filter(c => c.productId == p.id).length > 0) {
            var arr = this.state.cards.filter(card => card.productId == p.id);
            arr[0].piece += 1;
            arr[0].totalPrice = arr[0].totalPrice + arr[0].productPrice;
            this.setState([{...this.state.cards, [arr[0].productId]: arr[0]}])
        } else {
            this.setState(
                {
                    card: {
                        cardId: nextId(),
                        productId: p.id,
                        piece: 1,
                        cardName: p.name,
                        totalPrice: p.price,
                        productPrice: p.price,
                        paymentType: 'cash',
                        tableName: sessionStorage.getItem("tbl"),
                        waiterName: localStorage.getItem("waiter"),

                    }
                }, () => this.setState({
                    cards: [...this.state.cards, this.state.card]
                })
            )
        }


    }

    btnAdd = (param) => {
        param.piece += 1;
        param.totalPrice = param.totalPrice + param.productPrice;
        this.state.totalPayments += param.productPrice;

        this.setState([{...this.state.cards, [param.cardId]: param}])
    }


    btnCikar = (param) => {
        param.piece -= 1;
        param.totalPrice = param.totalPrice - param.productPrice;
        this.state.totalPayments -= param.productPrice;
        if (param.piece == 0) {
            this.setState({cards: this.state.cards.filter(cards => cards.cardId !== param.cardId)});
        } else {
            this.setState([{...this.state.cards, [param.cardId]: param}])
        }
    }
    addLocal = async (e) => {

        // orders = CategotyNew.getOrderFromStorage();
        let ordersNew = this.state.orders;


        ordersNew.push(e);
        await localStorage.setItem("orders", JSON.stringify(ordersNew));

        this.setState({orders: ordersNew})

        this.props.history.push("/menu");
    }
    paymentSuccess = (e) => {
        let orders = [];
        orders = CategotyNew.getOrderFromStorage();
        orders.pop();
        localStorage.setItem("orders", JSON.stringify(orders));
        ClientService.postOrder(e).then(res => {
            window.alert("siparişiniz alınmıştır")
        })
        sessionStorage.removeItem("tbl");
        localStorage.removeItem("waiter");
        sessionStorage.setItem("tbl", "paket");
    }

    static getOrderFromStorage() {
        let orders;
        if (localStorage.getItem("orders") === null) {
            orders = [];
        } else {
            orders = JSON.parse(localStorage.getItem("orders"));
        }
        return orders;
    }


    render() {
        const {cards} = this.state;
        return (
            <div>
                <div className="container-fluid">
                    <div className="row">
                        <div className="col-3">
                            <div className="card">
                                <div className="card-header">
                                    <h4 className="d-inline">Category List</h4>
                                </div>
                                <div className="card-body clm">
                                    {this.state.category.map(
                                        category =>
                                            <button className="btn btn-info btn-block btnVolume"
                                                    onClick={() => this.getCatProduct(category.id)}>{category.name}
                                                <br/>
                                                <img src={'data:image/png;base64,' + category.mediaDTO.fileContent}
                                                     width="100" style={{margin: 10}}/>
                                            </button>
                                    )}
                                </div>
                            </div>
                        </div>
                        <div className="col-6">
                            <div className="card">
                                <div className="card-header">
                                    <h4 className="d-inline">Product List</h4>
                                </div>
                                <div className="row clm"  ref={this.myRef}
                                     onScroll={this.onScroll}>
                                    <div className="card-body">
                                        <div className="row">
                                            {
                                                this.state.products.map(
                                                    products =>
                                                        <div className="col-6">

                                                            <div className="card product-card">
                                                                <div className="card-header">
                                                                    <img
                                                                        src={'data:image/png;base64,' + products.mediaDTO.fileContent}
                                                                        width="250" height="100" style={{margin: 10}}
                                                                        alt="Card image cap"></img>
                                                                </div>
                                                                <div className="card-body">
                                                                    <h5 className="card-title">{products.name}</h5>
                                                                    <p className="card-text">{products.brand}</p>
                                                                    <p className="card-text">{products.price}</p>
                                                                    <button className="btn btn-success"
                                                                            onClick={() => this.getProductList(products)}>Sepete
                                                                        Ekle
                                                                    </button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                )
                                            }
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="col-3">
                            <div className="card">
                                <div className="card-header d-flex justify-content-between">
                                    <h4 className="d-inline">Basket</h4>
                                    <a onClick={() => this.addLocal(this.state.cards)}><i className="fa fa-bars"
                                                                                          style={{cursor: "pointer"}}></i></a>
                                </div>
                                <div className="row clm">
                                    <div className="card-body clm">
                                        {
                                            cards.map(v => {
                                                return (
                                                    <div>
                                                        <label>{v.piece}</label>
                                                        <label>{v.cardName}</label>
                                                        <br/>
                                                        <button className="btn btn-default"
                                                                onClick={() => this.btnAdd(v)}>+
                                                        </button>
                                                        <label>{v.productPrice} TL</label>
                                                        <button className="btn btn-default"
                                                                onClick={() => this.btnCikar(v)}>-
                                                        </button>
                                                        <hr/>
                                                    </div>
                                                )
                                            })
                                        }
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-3"></div>
                        <div className="col-6"></div>
                        <div className="col-3">
                            <h5 className="totalPrice">{this.state.totalPayments} TL</h5>
                            <button className="btn btn-success btn-block"
                                    onClick={() => this.paymentSuccess(this.state.cards)}>Öde
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default CategotyNew;