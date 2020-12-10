import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import CategoryService from "../../service/CategoryService";
import TableCategoryService from "../../service/TableCategoryService";
import TableService from "../TableService";

class TableList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            tableList: [],
            category: [],
        }
        this.add = this.add.bind(this)
        this.updatedTable = this.updatedTable.bind(this)
        this.deletedTable = this.deletedTable.bind(this)
        this.detailTable = this.detailTable.bind(this)

    }

    add() {
        this.props.history.push('/table-add');
    }

    updatedTable(id) {
        this.props.history.push(`/table-update/${id}`);
    }

    deletedTable(id) {
        TableService.deleteTable(id).then(res => {
            window.location.reload();
        });
    }

    detailTable(id) {
        this.props.history.push(`/table-detail/${id}`);
    }

    componentDidMount() {
        TableService.getTable().then((res) => {
            this.setState({tableList: res.data});
        });
        TableCategoryService.getTableCategory().then((res) => {
            this.setState({category: res.data})
        })
    }
    render() {
        return (
            <div>
                <h2 className="text-center">Table List</h2>

                <div>
                    <button className="btn btn-success" onClick={this.add}>Add Table</button>
                </div>
                <div>

                    <table className="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Table Number</th>
                            <th>Table Category</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.tableList.map(
                                table =>
                                    <tr key={table.id}>
                                        <td>{table.number}</td>
                                        <td><button className="btn btn-link">{table.category}</button></td>
                                        <td>
                                            <button onClick={() => this.updatedTable(table.id)}
                                                    className="btn btn-info" style={{margin: "5px"}}>Update
                                            </button>
                                            <button onClick={() => this.deletedTable(table.id)}
                                                    className="btn btn-danger">Delete
                                            </button>
                                            <button onClick={() => this.detailTable(table.id)}
                                                    className="btn btn-warning" style={{margin: "5px"}}>Detail
                                            </button>
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

export default TableList;