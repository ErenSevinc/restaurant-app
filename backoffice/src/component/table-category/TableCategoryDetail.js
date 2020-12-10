import React, {Component} from 'react';
import TableCategoryService from "../../service/TableCategoryService";
import UserContext from "../../UserContext";

class TableCategoryDetail extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);
        this.state={
            id:this.props.match.params.id,
            tableCategory:{}
        }
    }
    componentDidMount() {
        const{token}=this.context
        TableCategoryService.getByTableCategoryID(this.state.id,token).then((res)=>{
            this.setState({tableCategory : res.data})
        })
    }

    render() {
        return (
            <div>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> Category Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Table Category Name: </label>
                            <div> { this.state.tableCategory.name }</div>
                        </div>
                        <div className = "row">
                            <label> Table Amount: </label>
                            <div> { this.state.tableCategory.amount }</div>
                        </div>
                    </div>

                </div>
            </div>
        );
    }
}

export default TableCategoryDetail;