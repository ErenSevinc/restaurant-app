import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import CustomerService from "../../service/CustomerService";
import Loader from "../../Loader";
import MediaService from "../../service/MediaService";

class CustomerAdd extends Component {
    constructor(props) {
        super(props);
        this.state={
            firstName:'',
            lastName:'',
            phoneNumber:'',
            address:'',
            image_List:[],
            media:null,

            loaded:false,
        }
        this.changeFirstNameHandler=this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler=this.changeLastNameHandler.bind(this);
        this.changePhoneNumberHandler=this.changePhoneNumberHandler.bind(this);
        this.changeAddressHandler=this.changeAddressHandler.bind(this);
    }
    changeFirstNameHandler = (e)=>{
        this.setState({firstName : e.target.value});
    }
    changeLastNameHandler = (e)=>{
        this.setState({lastName : e.target.value});
    }
    changePhoneNumberHandler= (e)=>{
        this.setState({phoneNumber : e.target.value});
    }
    changeAddressHandler=(e)=>{
        this.setState({address : e.target.value});
    }
    componentDidMount() {
        MediaService.getImage().then(res=>{
            this.setState({image_List:res.data})
        });

    }

    saveCustomer =(e)=>{
        const{token}=this.context;
        this.setState({loaded:!this.state.loaded});
        e.preventDefault();
        let customer = {
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            phoneNumber: this.state.phoneNumber,
            address:this.state.address,
            mediaDTO:this.state.media,
        };
        CustomerService.addCustomer(token,customer).then(res =>{
            this.props.history.push('/customer');
            if(res.status == '200'){
                this.setState({loaded:!this.state.loaded});
            }
        });
    }
    cancel(){
        this.props.history.push('/customer');
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
                <div className = "row">
                    <div className = "card col-md-6 offset-md-3 offset-md-3">
                        <h3 className="text-center">ADD PRODUCT</h3>
                        <div className = "card-body">
                            <div>
                                <div className = "form-group">
                                    <label> Customer FirstName: </label>
                                    <input placeholder="Customer FirstName" name="firstName" className="form-control"
                                           value={this.state.firstName} onChange={this.changeFirstNameHandler}/>
                                </div>
                                <div className = "form-group">
                                    <label> Customer LastName: </label>
                                    <input placeholder="Customer LastName" name="lastName" className="form-control"
                                           value={this.state.lastName} onChange={this.changeLastNameHandler}/>
                                </div>
                                <div className = "form-group">
                                    <label> Customer PhoneNumber: </label>
                                    <input placeholder="Customer PhoneNumber" name="phoneNumber" className="form-control"
                                           value={this.state.phoneNumber} onChange={this.changePhoneNumberHandler}/>
                                </div>
                                <div className = "form-group">
                                    <label> Customer Address: </label>
                                    <input placeholder="Customer Address" name="address" className="form-control"
                                           value={this.state.address} onChange={this.changeAddressHandler}/>
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
                                <br/>
                                <button className="btn btn-success" onClick={this.saveCustomer}>Save</button>
                                <button className="btn btn-danger" style={{marginLeft: "10px"}} onClick={this.cancel.bind(this)}>Cancel</button>
                            </div>
                        </div>
                    </div>
                </div>
                {
                    this.state.loaded ?(
                        <Loader/>
                    ):null
                }
            </div>
        );
    }
}

export default CustomerAdd;