import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import List from "./List";
import Header from "../Header";
import CategoryService from "../../service/CategoryService";

class Add extends Component {
    constructor(props) {
        super(props);

        this.state ={
            category_name:'',
            category_list:[],
            category_Id_List:[],
            categoryNameList:[],

            name : '',
            brand : '',
            price : '',
            category : '',
            category_id:''
        }
        this.changeNameHandler=this.changeNameHandler.bind(this);
        this.changeBrandHandler=this.changeBrandHandler.bind(this);
        this.changePriceHandler=this.changePriceHandler.bind(this);
        // this.changeCategoryHandler=this.changeCategoryHandler.bind(this);
        this.changeCategoryIDHandler=this.changeCategoryIDHandler.bind(this);
        this.selectMulti=this.selectMulti.bind(this);
    }

    saveProduct =(e)=>{

        e.preventDefault();
        let product = {
            name: this.state.name,
            brand: this.state.brand,
            price: this.state.price,
            productCategory: this.state.category_name,
            urlToImage: this.state.urlToImage,
        };
        console.log(product)
        ProductService.addProduct(this.state.category_Id_List,product).then(res =>{
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
    changeCategoryIDHandler=(e)=>{
        this.setState({category_id : e.target.value});
    }
    componentDidMount() {
        CategoryService.getAllCategory().then((res)=>{
           this.setState({category_list:res.data})
        });
    }
    onClickCategory=(e)=>{
        this.setState({
            category_id:e.id,
            category_name:e.name
        });
    }
    selectMulti=(e)=>{
        if(this.state.category_Id_List.includes(e) !== true){
            this.state.category_Id_List.push(e);
            this.state.categoryNameList.push(e);
        }
    }

    render() {
        return (
            <div>
                <div>
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">ADD PRODUCT</h3>
                            <div className = "card-body">
                                <div>
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
                                        <input placeholder="Product Image" name="category" className="form-control"
                                               value={this.state.urlToImage} onChange={this.changeImageHandler}/>
                                    </div>
                                    {/*<div className="dropdown show">*/}
                                    {/*    <a className="btn btn-secondary btn-block dropdown-toggle" href="#" role="button"*/}
                                    {/*       id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"*/}
                                    {/*       aria-expanded="false">{this.state.category_name}*/}
                                    {/*    </a>*/}
                                    {/*    <div className="dropdown-menu btn-block" aria-labelledby="dropdownMenuLink">*/}
                                    {/*        {*/}
                                    {/*            this.state.category_list.map(*/}
                                    {/*                category=>*/}
                                    {/*                    <a className="dropdown-item" onClick={this.onClickCategory.bind(this,category)}>{category.name}</a>*/}
                                    {/*            )*/}
                                    {/*        }*/}

                                    {/*    </div>*/}
                                    {/*</div>*/}
                                    <div className="checkbox" style={{height:"4rem",overflow:"auto"}}>
                                        {
                                            this.state.category_list.map(
                                                category=>
                                                    <div className="row col-md -12">
                                                        <label><input type="checkbox" value="" onClick={()=>this.selectMulti(category.id)}/>{category.name}</label>
                                                    </div>
                                            )
                                        }
                                    </div>

                                    <br/>
                                    <button className="btn btn-success" onClick={this.saveProduct}>Save</button>
                                    <button className="btn btn-danger" style={{marginLeft: "10px"}} onClick={this.cancel.bind(this)}>Cancel</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Add;