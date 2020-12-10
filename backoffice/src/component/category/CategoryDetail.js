import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import CategoryService from "../../service/CategoryService";

class CategoryDetail extends Component {
    constructor(props) {
        super(props);

        this.state={
            id:this.props.match.params.id,
            category:{}
        }
    }
    componentDidMount() {
        CategoryService.getSelectedCategoryById(this.state.id).then( res => {
            this.setState({category: res.data});
        })
    }
    render() {
        return (
            <div>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> Category Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Category Name: </label>
                            <div> { this.state.category.name }</div>
                        </div>
                        <div className = "row">
                            <label> Category Descriptiop: </label>
                            <div> { this.state.category.description }</div>
                        </div>
                        <div className = "row">
                            <label> Category Image: </label>
                            <div> { this.state.category.urlToImage }</div>
                        </div>
                    </div>

                </div>
            </div>
        );
    }
}

export default CategoryDetail;