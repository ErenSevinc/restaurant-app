import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import CategoryService from "../../service/CategoryService";
import TableService from "../TableService";
import TableCategoryService from "../../service/TableCategoryService";

class TableAdd extends Component {
    constructor(props) {
        super(props);

        this.state ={
            category_id:'',
            category_name:'kategori Seçiniz',
            table_category_list:[],
            number : '',
            category : ''
        }
        this.changeNumberHandler=this.changeNumberHandler.bind(this);
    }
    saveTable =(e)=>{
        e.preventDefault();
        let table = {
            number: this.state.number,
            category:this.state.category_name
        };
        TableService.addTable(this.state.category_id,table).then(res =>{
            this.props.history.push('/table-list')
        })
    }
    cancel(){
        this.props.history.push('/table-list');
    }
    changeNumberHandler = (e)=>{
        this.setState({number : e.target.value});
    }
    componentDidMount() {
        TableCategoryService.getTableCategory().then((res)=>{
            this.setState({table_category_list:res.data})
        });
    }
    onClickCategory=(e)=>{
        this.setState({
            category_id:e.id,
            category_name:e.name
        });
        console.log(e);
    }

    render() {
        return (
            <div>
                <div>
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">ADD TABLE</h3>
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group">
                                        <label> Table Number: </label>
                                        <input placeholder="Table Number" name="number" className="form-control"
                                               value={this.state.number} onChange={this.changeNumberHandler}/>
                                    </div>
                                    <div className="dropdown show">
                                        <a className="btn btn-secondary btn-block dropdown-toggle" href="#" role="button"
                                           id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
                                           aria-expanded="false">{this.state.category_name}
                                        </a>
                                        <div className="dropdown-menu btn-block" aria-labelledby="dropdownMenuLink">
                                            {
                                                this.state.table_category_list.map(
                                                    category=>
                                                        <a className="dropdown-item" onClick={this.onClickCategory.bind(this,category)}>{category.name}</a>
                                                )
                                            }

                                        </div>
                                    </div>
                                    <br/>
                                    <button className="btn btn-success" onClick={this.saveTable}>Save</button>
                                    <button className="btn btn-danger" style={{marginLeft: "10px"}} onClick={this.cancel.bind(this)}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default TableAdd;