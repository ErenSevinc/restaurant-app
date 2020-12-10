import React, {Component} from 'react';
import CategoryService from "../../service/CategoryService";
import TableCategoryService from "../../service/TableCategoryService";
import UserContext from "../../UserContext";

class TableCategoryList extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);

        this.state = {
            tableCategories:[]
        }
        this.addTableCategory=this.addTableCategory.bind(this);
        this.updatedTableCategory=this.updatedTableCategory.bind(this)
        this.deletedTableCategory=this.deletedTableCategory.bind(this)
        this.detailTableCategory=this.detailTableCategory.bind(this)
    }

    addTableCategory(){
        this.props.history.push(`/table-category-add/`);
    }

    updatedTableCategory(id){
        this.props.history.push(`/table-category-update/${id}`);
    }
    //
    deletedTableCategory(id){
        const{token}=this.context;
        TableCategoryService.deleteTableCategory(id,token).then( res => {
            this.props.history.push(`/table-category-add/`);
        });
    }
    detailTableCategory(id){
        this.props.history.push(`/table-category-detail/${id}`);
    }
    componentDidMount() {
        const{token}=this.context;
        TableCategoryService.getTableCategory(token).then((res)=>{
            this.setState({ tableCategories: res.data});
        });
    }
    render() {
        return (
            <div>
                <h2 className="text-center">Table Category List</h2>
                <div className="row">
                    <button className="btn btn-success" onClick={this.addTableCategory}>Add Table Category</button>
                </div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Table Category ID</th>
                            <th>Table Category Name</th>
                            <th>Table Amount</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.tableCategories.map(
                                tableCategory =>
                                    <tr key={tableCategory.id}>
                                        <td>{tableCategory.id}</td>
                                        <td>{tableCategory.name}</td>
                                        <td>{tableCategory.amount}</td>
                                        <td>
                                            <button onClick={()=>this.updatedTableCategory(tableCategory.id)}
                                                    className="btn btn-info" style={{margin:"5px"}}>Update</button>
                                            <button onClick={()=>this.deletedTableCategory(tableCategory.id)}
                                                    className="btn btn-danger">Delete</button>
                                            <button onClick={()=>this.detailTableCategory(tableCategory.id)}
                                                    className="btn btn-warning" style={{margin:"5px"}}>Detail</button>
                                        </td>
                                    </tr>
                            )
                        }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default TableCategoryList;