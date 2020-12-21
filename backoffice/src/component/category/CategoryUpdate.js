import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import CategoryService from "../../service/CategoryService";
import MediaService from "../../service/MediaService";
import Loader from "../../Loader";
import UserContext from "../../UserContext";

class CategoryUpdate extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);

        this.state ={
            id : this.props.match.params.id,
            name : '',
            description : '',
            media:{},
            image_List:[],

            loader:false,
        }
        this.changeNameHandler=this.changeNameHandler.bind(this);
        this.changeDescriptionHandler=this.changeDescriptionHandler.bind(this);
        this.changeImageHandler=this.changeImageHandler.bind(this);
        this.updatedCategory=this.updatedCategory.bind(this);

    }
    componentDidMount(){
        const{token}=this.context;
        this.setState({loader:!this.state.loader});
        CategoryService.getSelectedCategoryById(this.state.id,token).then( (res) =>{
            let category = res.data;

            this.setState({
                id:category.id,
                name: category.name,
                description: category.description,
                media : category.mediaDTO,
            });
            if(res.status == '200'){
                this.setState({loader:!this.state.loader})
            }
            this.setState({loader:!this.state.loader});
        });
        MediaService.getImage(token).then(res=>{
            this.setState({image_List:res.data})
            if (res.status == '200'){
                this.setState({loader:!this.state.loader});
            }
        });
    }
    updatedCategory =(e)=>{
        const{token}=this.context;
        this.setState({loader:!this.state.loader});
        e.preventDefault();
        let category = {
            id:this.state.id,
            name: this.state.name,
            description: this.state.description,
            mediaDTO: this.state.media
        };
        CategoryService.updateCategory(category,token).then(res =>{
            if(res.status =='200'){
                this.setState({loader:!this.state.loader});
            }
            this.props.history.push('/category')
        });
    }
    cancel(){
        this.props.history.push('/category');
    }

    changeNameHandler = (e)=>{
        this.setState({name : e.target.value});
    }
    changeDescriptionHandler = (e)=>{
        this.setState({description : e.target.value});
    }
    changeImageHandler =(e)=>{
        this.setState({urlToImage : e.target.value});
    }
    selectImage(e){
        this.setState({media:e})
        console.log(e);
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
                            <h3 className="text-center">UPDATE CATEGORY</h3>
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group">
                                        <label> Category Name: </label>
                                        <input placeholder="Category Name" name="name" className="form-control"
                                               value={this.state.name} onChange={this.changeNameHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Category Description: </label>
                                        <input placeholder="Category Description" name="brand" className="form-control"
                                               value={this.state.description} onChange={this.changeDescriptionHandler}/>
                                    </div>
                                    {/*<div>*/}
                                    {/*    {*/}
                                    {/*        this.state.image_List.map(*/}
                                    {/*            value=>*/}
                                    {/*                <div className="form-check">*/}
                                    {/*                    <input className="form-check-input" type="radio"*/}
                                    {/*                           name="image" id="image"*/}
                                    {/*                           onClick={()=>this.selectImage(value)}/>*/}
                                    {/*                    <label>{value.name}</label>*/}
                                    {/*                </div>*/}


                                    {/*        )*/}
                                    {/*    }*/}
                                    {/*</div>*/}
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
                                    <br/>
                                    <button className="btn btn-success" onClick={this.updatedCategory}>Update</button>
                                    <button className="btn btn-danger" style={{marginLeft: "10px"}} onClick={this.cancel.bind(this)}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                {
                    this.state.loader ?(
                        <Loader/>
                    ):null
                }
            </div>
        );
    }
}

export default CategoryUpdate;