import React, {Component} from 'react';
import TableCategoryService from "../../service/TableCategoryService";
import UserContext from "../../UserContext";
import MediaService from "../../service/MediaService";

class TableCategoryAdd extends Component {
    static contextType=UserContext;
    constructor(props) {

        super(props);

        this.state ={
            name : '',
            amount: '',
            image_List:[],
            media:{},
        }
        this.changeNameHandler=this.changeNameHandler.bind(this);
        this.changeAmountHandler=this.changeAmountHandler.bind(this);
    }
    changeNameHandler = (e)=>{
        this.setState({name : e.target.value});
    }
    changeAmountHandler = (e)=>{
        this.setState({amount: e.target.value})
    }

    componentDidMount() {
        MediaService.getImage().then(res=>{
            this.setState({image_List:res.data})
        });
    }

    saveTableCategory =(e)=>{
        e.preventDefault();
        let category = {
            name: this.state.name,
            amount: this.state.amount,
            mediaDTO:this.state.media,
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
    selectImage=(e)=>{
        this.setState({media:e})
        console.log(e);
    }
    onClickCategory=(e)=>{
        this.setState({
            media:e
        });
        console.log(e);
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
                                    <div className="dropdown show">
                                        <a className="btn btn-secondary btn-block dropdown-toggle" href="#" role="button"
                                           id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
                                           aria-expanded="false">
                                        </a>
                                        <div className="dropdown-menu btn-block clm" aria-labelledby="dropdownMenuLink">
                                            {
                                                this.state.image_List.map(
                                                    image=>
                                                        <a className="dropdown-item" onClick={this.onClickCategory.bind(this,image)}>{image.name}
                                                            <br/>
                                                            <img src={'data:image/png;base64,' + image.fileContent} width="45" height="45"></img>
                                                        </a>

                                                )
                                            }

                                        </div>
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