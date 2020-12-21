import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import Header from "../Header";
import CategoryService from "../../service/CategoryService";
import UserContext from "../../UserContext";
import Loader from "../../Loader";

class List extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);

        this.state = {
            products: [],
            productCategory: [],

            loaded:false,
        }
        this.add = this.add.bind(this)
        this.updatedProduct = this.updatedProduct.bind(this)
        this.deletedProduct = this.deletedProduct.bind(this)
        this.detailProduct = this.detailProduct.bind(this)
        this.filterList = this.filterList.bind(this)

    }

    add() {
        this.props.history.push('/add');
    }

    updatedProduct(id) {
        this.props.history.push(`/update-product/${id}`);
    }

    deletedProduct(id) {
        const{token}=this.context;
        this.setState({loaded:!this.state.loaded});
        ProductService.deleteProduct(id,token).then(res => {
            this.props.history.push('/add');
            if (res.status == '200'){
                this.setState({loaded:!this.state.loaded});
            }
        });
    }

    detailProduct(id) {
        this.props.history.push(`/products-detail/${id}`);
    }

    componentDidMount() {
        const{token}=this.context;
        this.setState({loaded:!this.state.loaded});
        ProductService.getProducts(token).then((res) => {
            this.setState({products: res.data});
            if(res.status == '200'){
                this.setState({loaded:!this.state.loaded});
            }
        });
        CategoryService.getAllCategory(token).then((res) => {
            this.setState({loaded:!this.state.loaded});
            this.setState({productCategory: res.data});
            if(res.status == '200'){
                this.setState({loaded:!this.state.loaded});
            }
        })
    }
    filterList(category){
        console.log(category);
        this.setState({products:this.state.products.filter(
            productByFilter=>productByFilter.categoriesDTO.name==category.name
            )

        })
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Product List</h2>

                <div>
                    <button className="btn btn-success" onClick={this.add}>Add Product</button>
                </div>
                <div>

                    <table className="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Product Name</th>
                            <th>Product Brand</th>
                            <th>Product Price</th>
                            <th>Product Category</th>
                            <th>Product Image</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.products.map(
                                product =>
                                    <tr key={product.id}>
                                        <td>{product.name}</td>
                                        <td>{product.brand}</td>
                                        <td>{product.price}</td>
                                        <td>{
                                            product.categoriesDTO.map(
                                                name=>
                                                <button className="btn btn-link btn-block" onClick={()=>this.filterList(name)}>
                                                    {name.name}
                                                </button>
                                            )

                                        }</td>
                                        <td><img src={'data:image/png;base64,' +product.mediaDTO.fileContent} width="150" height="150"/></td>
                                        <td>
                                            <button onClick={() => this.updatedProduct(product.id)}
                                                    className="btn btn-info" style={{margin: "5px"}}>Update
                                            </button>
                                            <button onClick={() => this.deletedProduct(product.id)}
                                                    className="btn btn-danger">Delete
                                            </button>
                                            <button onClick={() => this.detailProduct(product.id)}
                                                    className="btn btn-warning" style={{margin: "5px"}}>Detail
                                            </button>
                                        </td>
                                    </tr>
                            )
                        }
                        </tbody>
                    </table>
                </div>
                {
                    this.state.loaded ?(
                        <Loader/>
                    ):null
                }
            </div>
        );
    }
}

export default List;