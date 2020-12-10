import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import CategoryService from "../../service/CategoryService";

class CategoryAdd extends Component {
    constructor(props) {
        super(props);

        this.state ={
            name : '',
            description : '',
            urlToImage : '',
        }
        this.changeNameHandler=this.changeNameHandler.bind(this);
        this.changeDescriptionHandler=this.changeDescriptionHandler.bind(this);
        this.changeUrlToImageHandler=this.changeUrlToImageHandler.bind(this);

    }
    saveCategory =(e)=>{
        e.preventDefault();
        let category = {
            name: this.state.name,
            description: this.state.description,
            urlToImage: this.state.urlToImage
        };
        CategoryService.addCategoryItem(category).then(res =>{
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
    changeUrlToImageHandler= (e)=>{
        this.setState({urlToImage : e.target.value});
    }

    render() {
        return (
            <div>
                <div>
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">ADD CATEGORY</h3>
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group">
                                        <label> Category Name: </label>
                                        <input placeholder="Category Name" name="name" className="form-control"
                                               value={this.state.name} onChange={this.changeNameHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Category Description: </label>
                                        <input placeholder="Category Description" name="description" className="form-control"
                                               value={this.state.description} onChange={this.changeDescriptionHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Category URL: </label>
                                        <input placeholder="Category URL" name="urlToImage" className="form-control"
                                               value={this.state.urlToImage} onChange={this.changeUrlToImageHandler}/>
                                    </div>
                                    <button className="btn btn-success" onClick={this.saveCategory}>Save</button>
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

export default CategoryAdd;