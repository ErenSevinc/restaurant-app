import React, {Component} from 'react';
import TableCategoryService from "../../service/TableCategoryService";
import UserContext from "../../UserContext";

class TableCategoryAdd extends Component {
    static contextType=UserContext;
    constructor(props) {

        super(props);

        this.state ={
            name : '',
            amount: '',
        }
        this.changeNameHandler=this.changeNameHandler.bind(this);
        this.changeAmountHandler=this.changeAmountHandler.bind(this);
    }
    saveTableCategory =(e)=>{
        e.preventDefault();
        let category = {
            name: this.state.name,
            amount: this.state.amount,
        };
        const{token}=this.context;
        TableCategoryService.addTableCategoryItem(category,token).then(res =>{
            this.props.history.push('/table-category-list')
        })
    }
    cancel=(e)=>{
        e.preventDefault();
        this.props.history.push('/table-category-list');
    }
    changeNameHandler = (e)=>{
        this.setState({name : e.target.value});
    }
    changeAmountHandler = (e)=>{
        this.setState({amount: e.target.value})
    }
    render() {
        return (
            <div>
                <div>
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">ADD TABLE CATEGORY</h3>
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group">
                                        <label>Table Category Name: </label>
                                        <input placeholder="Category Name" name="name" className="form-control"
                                               value={this.state.name} onChange={this.changeNameHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label>Table Amount: </label>
                                        <input placeholder="Table Amount" name="amount" className="form-control"
                                               value={this.state.amount} onChange={this.changeAmountHandler}/>
                                    </div>
                                    <button className="btn btn-success" onClick={this.saveTableCategory}>Save</button>
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

export default TableCategoryAdd;