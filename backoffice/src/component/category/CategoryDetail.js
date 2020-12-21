import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import CategoryService from "../../service/CategoryService";
import Loader from "../../Loader";
import UserContext from "../../UserContext";

class CategoryDetail extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);

        this.state={
            id:this.props.match.params.id,
            category:{},

            loader:false,
        }
    }
    componentDidMount() {
        const{token}=this.context;
        this.setState({loader:!this.state.loader});
        CategoryService.getSelectedCategoryById(this.state.id,token).then( res => {
            this.setState({category: res.data});
            if (res.status == '200'){
                this.setState({loader:!this.state.loader});
            }
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

export default CategoryDetail;