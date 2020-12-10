import React, {Component} from 'react';
import TableCategoryService from "../../service/TableCategoryService";
import UserContext from "../../UserContext";

class TableCategoryUptade extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);

        this.state ={
            id : this.props.match.params.id,
            name : '',
            amount: ''
        }
        this.changeNameHandler=this.changeNameHandler.bind(this);
        this.changeAmountHandler=this.changeAmountHandler.bind(this)
        this.updatedTableCategory=this.updatedTableCategory.bind(this);

    }
    componentDidMount(){
        const{token}=this.context
        TableCategoryService.getByTableCategoryID(this.state.id,token).then( (res) =>{
            let category = res.data;
            this.setState({
                name: category.name,
                amount: category.amount
            });
        });
    }
    updatedTableCategory =(e)=>{
        e.preventDefault();
        let category = {
            name: this.state.name,
            amount: this.state.amount
        };
        const{token}=this.context
        TableCategoryService.updateTableCategory(category,this.state.id,token).then(res =>{
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
    changeAmountHandler =(e)=>{
        this.setState({amount: e.target.value});
    }
    render() {
        return (
            <div>
                <div>
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">UPDATE TABLE CATEGORY</h3>
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group">
                                        <label> Category Name: </label>
                                        <input placeholder="Table Category Name" name="name" className="form-control"
                                               value={this.state.name} onChange={this.changeNameHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Table Amount: </label>
                                        <input placeholder="Table Amount" name="amount" className="form-control"
                                               value={this.state.amount} onChange={this.changeAmountHandler}/>
                                    </div>
                                    <button className="btn btn-success" onClick={this.updatedTableCategory}>Update</button>
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

export default TableCategoryUptade;