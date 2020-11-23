import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import Header from "../Header";

class List extends Component {
    constructor(props) {
        super(props);

        this.state = {
            products:[]
        }
        this.add=this.add.bind(this)
        this.updatedProduct=this.updatedProduct.bind(this)
        this.deletedProduct=this.deletedProduct.bind(this)
        this.detailProduct=this.detailProduct.bind(this)


    }
    add(){
        this.props.history.push('/add');
    }
    updatedProduct(id){
        this.props.history.push(`/update/${id}`);
    }
    deletedProduct(id){
        ProductService.deleteProduct(id).then( res => {
            window.location.reload();
        });
    }
    detailProduct(id){
        this.props.history.push(`/product-detail/${id}`);
    }
    componentDidMount() {
        ProductService.getProducts().then((res)=>{
            this.setState({ products: res.data});
        });
    }

    render() {
        return (
            <div className="container">
                <h2 className="text-center">Product List</h2>
                <div className="row">
                    <button className="btn btn-success" onClick={this.add}>Add Product</button>
                </div>
                <div className="row">
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
                                            <td>{product.category}</td>
                                            <td><img src={product.urlToImage} width="150" height="150"/></td>
                                            <td>
                                                <button onClick={()=>this.updatedProduct(product.id)}
                                                className="btn btn-info" style={{margin:"5px"}}>Update</button>
                                                <button onClick={()=>this.deletedProduct(product.id)}
                                                        className="btn btn-danger">Delete</button>
                                                <button onClick={()=>this.detailProduct(product.id)}
                                                        className="btn btn-warning" style={{margin:"5px"}}>Detail</button>
                                            </td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default List;