import React, {Component} from 'react';
import Loader from "../../Loader";
import CustomerService from "../../service/CustomerService";
import ProductService from "../../service/ProductService";

class CustomerUpdate extends Component {
    constructor(props) {
        super(props);
        this.state={
            id:this.props.match.params.id,
            firstName:'',
            lastName:'',
            phoneNumber:'',
            address:'',

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
        const {token} = this.context;
        this.setState({loaded: !this.state.loaded});
        CustomerService.getSelectedCustmoer(token,this.state.id).then((res) => {
            let customer = res.data;
            this.setState({
                firstName: customer.firstName,
                lastName: customer.lastName,
                phoneNumber: customer.phoneNumber,
                address:customer.address,
            });
            if (res.status == '200') {
                this.setState({loaded: !this.state.loaded});
            }
        });
    }
    updateCustomer =(e)=>{
        const{token}=this.context;
        this.setState({loaded:!this.state.loaded});
        e.preventDefault();
        let customer = {
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            phoneNumber: this.state.phoneNumber,
            address:this.state.address,
        };
        CustomerService.updateCustomer(token,customer,this.state.id).then(res =>{
            this.props.history.push('/customer');
            if(res.status == '200'){
                this.setState({loaded:!this.state.loaded});
            }
        });
    }
    cancel(){
        this.props.history.push('/customer');
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
                                <br/>
                                <button className="btn btn-success" onClick={this.updateCustomer}>Update</button>
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

export default CustomerUpdate;