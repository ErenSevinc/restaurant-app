import React, {Component} from 'react';
import CategoryService from "../../service/CategoryService";
import Loader from "../../Loader";
import UserContext from "../../UserContext";

class Category extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);

        this.state = {
            categories: [],
            loader: false
        }
        this.addCategory = this.addCategory.bind(this)
        this.addProduct = this.addProduct.bind(this);
        this.updatedCategory = this.updatedCategory.bind(this)
        this.deletedCategory = this.deletedCategory.bind(this)
        this.detailCategory = this.detailCategory.bind(this)
    }

    addProduct() {
        this.props.history.push('/add');
    }

    addCategory() {
        this.props.history.push(`/category-add/`);
    }

    updatedCategory(id) {
        this.props.history.push(`/category-update/` + id);
    }

    deletedCategory(id) {
        const{token}=this.context;
        this.setState({loader: !this.state.loader})
        CategoryService.deleteCategory(id,token).then(res => {
            if (res.status == '200') {
                this.setState({loader: !this.state.loader});
            }
            this.props.history.push(`/category-add/`);
        });
    }

    detailCategory(id) {
        this.props.history.push(`/category-detail/${id}`);
    }

    componentDidMount() {
        const {token}=this.context;
        this.setState({loader: !this.state.loader})
        CategoryService.getAllCategory(token).then((res) => {
            this.setState({categories: res.data});
            if (res.status == '200') {
                this.setState({loader: !this.state.loader});
            }
        });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Category List</h2>
                <div className="row">
                    <button className="btn btn-success" onClick={this.addCategory}>Add Category</button>
                </div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Category ID</th>
                            <th>Category Name</th>
                            <th>Category Description</th>
                            <th>Category Image</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.categories.map(
                                category =>
                                    <tr key={category.id}>
                                        <td>{category.id}</td>
                                        <td>{category.name}</td>
                                        <td>{category.description}</td>
                                        <td><img src={'data:image/png;base64,' + category.mediaDTO.fileContent}
                                                 width="100" style={{margin: 10}}/></td>
                                        <td>
                                            {/*<button onClick={()=>this.addProduct(category.id)}*/}
                                            {/*        className="btn btn-info" style={{margin:"5px"}}>Update</button>*/}
                                            <button onClick={() => this.updatedCategory(category.id)}
                                                    className="btn btn-info" style={{margin: "5px"}}>Update
                                            </button>
                                            <button onClick={() => this.deletedCategory(category.id)}
                                                    className="btn btn-danger">Delete
                                            </button>
                                            <button onClick={() => this.detailCategory(category.id)}
                                                    className="btn btn-warning" style={{margin: "5px"}}>Detail
                                            </button>
                                        </td>
                                    </tr>
                            )
                        }
                        </tbody>
                    </table>
                </div>
                {
                    this.state.loader ? (
                        <Loader/>
                    ) : null
                }
            </div>
        );
    }
}

export default Category;