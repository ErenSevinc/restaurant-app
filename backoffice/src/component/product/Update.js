import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import Header from "../Header";
import CategoryService from "../../service/CategoryService";
import MediaService from "../../service/MediaService";
import Loader from "../../Loader";

class Update extends Component {
    constructor(props) {
        super(props);

        this.state ={
            id : this.props.match.params.id,
            name : '',
            brand : '',
            price : '',
            cat_id : '',
            media:{},
            image_List:[],
            categoriesDTOList:[],
            category_list:[],

            loaded:false,
        }
        this.changeNameHandler=this.changeNameHandler.bind(this);
        this.changeBrandHandler=this.changeBrandHandler.bind(this);
        this.changePriceHandler=this.changePriceHandler.bind(this);
        // this.changeCategoryHandler=this.changeCategoryHandler.bind(this);
        this.updatedProduct=this.updatedProduct.bind(this);
        this.selectMulti=this.selectMulti.bind(this);

    }
    componentDidMount(){
        const{token}=this.context;
        this.setState({loaded:!this.state.loaded});
        ProductService.getProductById(this.state.id,token).then( (res) =>{
            let products = res.data;
            this.setState({
                name: products.name,
                brand: products.brand,
                price : products.price,
                mediaDTO:this.state.media,
                categoriesDTOList: products.categoriesDTO,
            });
            if(res.status == '200'){
                this.setState({loaded:!this.state.loaded});
            }
        });
        CategoryService.getAllCategory(token).then((res)=>{
            this.setState({loaded:!this.state.loaded});
            this.setState({category_list:res.data})
            if(res.status == '200'){
                this.setState({loaded:!this.state.loaded});
            }
        });
        MediaService.getImage(token).then(res=>{
            this.setState({loaded:!this.state.loaded});
            this.setState({image_List:res.data})
            if(res.status == '200'){
                this.setState({loaded:!this.state.loaded});
            }
        });
        console.log(this.state.category_list);
    }
    updatedProduct =(e)=>{
        this.setState({loaded:!this.state.loaded});
        const{token}=this.context;
        e.preventDefault();
        let products = {
            id: this.state.id,
            name: this.state.name,
            brand: this.state.brand,
            price: this.state.price,
            mediaDTO:this.state.media,
            categoriesDTO: this.state.categoriesDTOList
        };
        ProductService.updateProduct(products,token).then(res =>{
            this.props.history.push('/products');
            if(res.status == '200'){
                this.setState({loaded:!this.state.loaded});
            }
        })
    }
    cancel(){
        this.props.history.push('/products');
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
    selectMulti=(e)=>{
        if(this.state.category_list.includes(e.id) !== true){
            this.state.categoriesDTOList.push(e);
        }
        console.log(this.state.categoriesDTOList);
    }
    onClickCategory=(e)=>{
        this.setState({
            media:e
        });
        console.log(e);
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
                                    <div className="dropdown show">
                                        <a className="btn btn-secondary btn-block dropdown-toggle" href="#" role="button"
                                           id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
                                           aria-expanded="false">
                                        </a>
                                        <div className="dropdown-menu btn-block clm" aria-labelledby="dropdownMenuLink">
                                            {
                                                this.state.image_List.map(
                                                    image=>
                                                        <a className="dropdown-item" onClick={this.onClickCategory.bind(this,image)}>{image.name}
                                                            <br/>
                                                            <img src={'data:image/png;base64,' + image.fileContent} width="45" height="45"></img>
                                                        </a>

                                                )
                                            }

                                        </div>
                                    </div>
                                    <div className="checkbox" style={{height:"4rem",overflow:"auto"}}>
                                        {
                                            this.state.category_list.map(
                                                category=>
                                                    <div className="row col-md -12">
                                                        <label><input type="checkbox" value="" onClick={()=>this.selectMulti(category)}/>{category.name}</label>
                                                    </div>
                                            )
                                        }
                                    </div>
                                    <button className="btn btn-success" onClick={this.updatedProduct}>Update</button>
                                    <button className="btn btn-danger" style={{marginLeft: "10px"}} onClick={this.cancel.bind(this)}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
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

export default Update;