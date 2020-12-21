import React, {Component} from 'react';
import ClientService from "../service/ClientService";
import nextId from "react-id-generator";
import './Component.css';
import Table from 'react-bootstrap/Table';

class Category extends Component {
    constructor(props) {
        super(props)
        this.state = {
            category: [],
            products: [],
            cards: [],
            totalPayments: 0,
            card: {
                productId: 0,
                cardId: 0,
                piece: 0,
                cardName: '',
                totalPrice: 0,
                productPrice: 0,
                paymentType: 'cash',
                tableName:''

            }
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
        ClientService.getProducts().then((res)=>{
            this.setState({products:res.data})
        })
    }

    getCatProduct(id) {
        ClientService.getCategoryProduct(id).then((res) => {
            this.setState({products: res.data})
        });
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
                        tableName:sessionStorage.getItem("tbl")

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
    paymentSuccess = (e) => {
        ClientService.postOrder(e).then(res => {
            window.alert("siparişiniz alınmıştır")
            window.location.reload()
        })
        sessionStorage.setItem("tbl","Paket Servis");
    }

    render() {
        const {cards} = this.state;
        return (
            <div>
                <Table bordered>
                    <thead>
                    <tr>
                        <th className="categoryColumn">
                            <div className="card">
                                <div className="card-header">
                                    <h4 className="d-inline">Category List</h4>
                                </div>
                                <div className="card-body category-list">
                                    {this.state.category.map(
                                        category =>
                                            <button className="btn btn-info btn-block mb-1"
                                                    onClick={() => this.getCatProduct(category.id)}>{category.name}</button>
                                    )}
                                </div>
                            </div>
                        </th>
                        <th className="productColumn clm">
                            {/*<div className="card">*/}
                            {/*    <div className="card-header">*/}
                            {/*        <h4 className="d-inline">Product List</h4>*/}
                            {/*    </div>*/}
                            {/*    <div className="card-body products-list-body">*/}
                            {/*        {*/}
                            {/*            this.state.products.map(*/}
                            {/*                products =>*/}
                            {/*                    <div className="card products-card">*/}
                            {/*                        <div className="card-header">*/}
                            {/*                            <h4 className="d-inline">*/}
                            {/*                                {products.name}*/}
                            {/*                            </h4>*/}
                            {/*                        </div>*/}
                            {/*                        <div className="card-body">*/}
                            {/*                            <p className="card-text">{products.brand}</p>*/}
                            {/*                            <p className="card-text">{products.price}</p>*/}
                            {/*                            <button className="btn btn-success"*/}
                            {/*                                    onClick={() => this.getProductList(products)}>Sepete Ekle*/}
                            {/*                            </button>*/}
                            {/*                        </div>*/}
                            {/*                    </div>*/}
                            {/*            )*/}
                            {/*        }*/}
                            {/*    </div>*/}
                            {/*</div>*/}
                            {/*<div className="card-body products-list-body">*/}
                            {/*    {*/}
                            {/*        this.state.products.map(*/}
                            {/*            products =>*/}
                            {/*                <div className="card products-card">*/}
                            {/*                    <div className="card-header">*/}
                            {/*                        <h4 className="d-inline">*/}
                            {/*                            {products.name}*/}
                            {/*                        </h4>*/}
                            {/*                    </div>*/}
                            {/*                    <div className="card-body">*/}

                            {/*                        <p className="card-text">{products.brand}</p>*/}
                            {/*                        <p className="card-text">{products.price}</p>*/}
                            {/*                        <button className="btn btn-success"*/}
                            {/*                                onClick={() => this.getProductList(products)}>Sepete*/}
                            {/*                            Ekle*/}
                            {/*                        </button>*/}
                            {/*                    </div>*/}
                            {/*                </div>*/}
                            {/*        )*/}
                            {/*    }*/}
                            {/*</div>*/}
                            <div className="card" style="width: 18rem;">
                                <img className="card-img-top" src="..." alt="Card image cap"></img>
                                    <div className="card-body">
                                        <h5 className="card-title">Card title</h5>
                                        <p className="card-text">Some quick example text to build on the card title and
                                            make up the bulk of the card's content.</p>
                                        <a href="#" className="btn btn-primary">Go somewhere</a>
                                    </div>
                            </div>
                        </th>
                        <th className="basketColumn clm">
                            <div className="card">
                                <div className="card-header">
                                    <h5 className="d-inline">Basket</h5>
                                </div>
                                <div className="card-body basket">
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
                                                    <label>{v.productPrice}</label>
                                                    <button className="btn btn-default"
                                                            onClick={() => this.btnCikar(v)}>-
                                                    </button>
                                                    <hr/>

                                                </div>
                                            )
                                        })
                                    }
                                    <label>{this.state.totalPayments}</label>
                                    <br/>
                                    <button className="btn btn-success"
                                            onClick={() => this.paymentSuccess(this.state.cards)}>Öde
                                    </button>
                                </div>
                            </div>
                        </th>
                    </tr>
                    </thead>
                </Table>
            </div>
        );
    }
}

export default Category;