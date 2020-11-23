import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import List from "./List";
import Header from "../Header";

class Add extends Component {
    constructor(props) {
        super(props);

        this.state ={
            name : '',
            brand : '',
            price : '',
            category : ''
        }
        this.changeNameHandler=this.changeNameHandler.bind(this);
        this.changeBrandHandler=this.changeBrandHandler.bind(this);
        this.changePriceHandler=this.changePriceHandler.bind(this);
        this.changeCategoryHandler=this.changeCategoryHandler.bind(this);
    }
    saveProduct =(e)=>{
        e.preventDefault();
        let product = {
            name: this.state.name,
            brand: this.state.brand,
            price: this.state.price,
            category: this.state.category,
            urlToImage: this.state.urlToImage
        };
        ProductService.addProduct(product).then(res =>{
            this.props.history.push('/product')
        })
    }
    cancel(){
        this.props.history.push('/product');
    }
    changeNameHandler = (e)=>{
        this.setState({name : e.target.value});
    }
    changeBrandHandler = (e)=>{
        this.setState({brand : e.target.value});
    }
    changePriceHandler= (e)=>{
        this.setState({price : e.target.value});
    }
    changeCategoryHandler= (e)=>{
        this.setState({category : e.target.value});
    }
    changeImageHandler =(e)=>{
        this.setState({urlToImage : e.target.value});
    }
    render() {
        return (
            <div>
                <div className = "container">
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">ADD PRODUCT</h3>
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group">
                                        <label> Product Name: </label>
                                        <input placeholder="Product Name" name="name" className="form-control"
                                            value={this.state.name} onChange={this.changeNameHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Product Brand: </label>
                                        <input placeholder="Product Brand" name="brand" className="form-control"
                                               value={this.state.brand} onChange={this.changeBrandHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Product Price: </label>
                                        <input placeholder="Product Price" name="price" className="form-control"
                                               value={this.state.price} onChange={this.changePriceHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Product Category: </label>
                                        <input placeholder="Product Category" name="category" className="form-control"
                                               value={this.state.category} onChange={this.changeCategoryHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Product Image: </label>
                                        <input placeholder="Product Image" name="category" className="form-control"
                                               value={this.state.urlToImage} onChange={this.changeImageHandler}/>
                                    </div>
                                    <button className="btn btn-success" onClick={this.saveProduct}>Save</button>
                                    <button className="btn btn-danger" style={{marginLeft: "10px"}} onClick={this.cancel.bind(this)}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        );
    }
}

export default Add;