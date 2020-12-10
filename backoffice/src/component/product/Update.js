import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import Header from "../Header";
import CategoryService from "../../service/CategoryService";

class Update extends Component {
    constructor(props) {
        super(props);

        this.state ={
            category:{},
            id : this.props.match.params.id,
            name : '',
            brand : '',
            price : '',
            productCategory : '',
            urlToImage : '',
            cat_id : '',
        }
        this.changeNameHandler=this.changeNameHandler.bind(this);
        this.changeBrandHandler=this.changeBrandHandler.bind(this);
        this.changePriceHandler=this.changePriceHandler.bind(this);
        // this.changeCategoryHandler=this.changeCategoryHandler.bind(this);
        this.updatedProduct=this.updatedProduct.bind(this);

    }
    componentDidMount(){
        ProductService.getProductById(this.state.id).then( (res) =>{
            let product = res.data;
            this.setState({
                name: product.name,
                brand: product.brand,
                price : product.price,
                productCategory : product.productCategory,
                urlToImage : product.urlToImage,
                category: product.category,

            });
        });
        console.log(this.state.category);
    }
    updatedProduct =(e)=>{

        e.preventDefault();
        let product = {
            id: this.state.id,
            name: this.state.name,
            brand: this.state.brand,
            price: this.state.price,
            productCategory: this.state.productCategory,
            urlToImage: this.state.urlToImage,
            category: this.state.category,
        };
        ProductService.updateProduct(product,this.state.cat_id).then(res =>{
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

    changeImageHandler =(e)=>{
        this.setState({urlToImage : e.target.value});
    }
    render() {
        return (
            <div>
                <div>
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">UPDATE PRODUCT</h3>
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
                                        <label> Product Image: </label>
                                        <input placeholder="Product Image" name="urlToImage" className="form-control"
                                               value={this.state.urlToImage} onChange={this.changeImageHandler}/>
                                    </div>
                                    <button className="btn btn-success" onClick={this.updatedProduct}>Update</button>
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

export default Update;