import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import CategoryService from "../../service/CategoryService";

class CategoryUpdate extends Component {
    constructor(props) {
        super(props);

        this.state ={
            id : this.props.match.params.id,
            name : '',
            description : '',
            urlToImage : ''
        }
        this.changeNameHandler=this.changeNameHandler.bind(this);
        this.changeDescriptionHandler=this.changeDescriptionHandler.bind(this);
        this.changeImageHandler=this.changeImageHandler.bind(this);
        this.updatedCategory=this.updatedCategory.bind(this);

    }
    componentDidMount(){
        CategoryService.getSelectedCategoryById(this.state.id).then( (res) =>{
            let category = res.data;
            this.setState({
                name: category.name,
                description: category.description,
                urlToImage : category.urlToImage
            });
        });
    }
    updatedCategory =(e)=>{
        e.preventDefault();
        let category = {
            id:this.state.id,
            name: this.state.name,
            description: this.state.description,
            urlToImage: this.state.urlToImage
        };
        CategoryService.updateCategory(this.state.id,category).then(res =>{
            this.props.history.push('/category')
        })
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
                                    <div className = "form-group">
                                        <label> Category Image: </label>
                                        <input placeholder="Category Image" name="urlToImage" className="form-control"
                                               value={this.state.urlToImage} onChange={this.changeImageHandler}/>
                                    </div>
                                    <button className="btn btn-success" onClick={this.updatedCategory}>Update</button>
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

export default CategoryUpdate;