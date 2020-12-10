import React, {Component} from 'react';
import WaiterService from "../../service/WaiterService";

class WaiterUpdate extends Component {
    constructor(props) {
        super(props);
        this.state={
            id : this.props.match.params.id,
            name:'',
            phoneNumber:'',
            mail:'',
            address:'',
            urlToImage:'',
            salary:''
        }
        this.changeNameHandler=this.changeNameHandler.bind(this);
        this.changePhoneHandler=this.changePhoneHandler.bind(this);
        this.changeMailHandler=this.changeMailHandler.bind(this);
        this.changeAddressHandler=this.changeAddressHandler.bind(this);
        this.changeImageHandler=this.changeImageHandler.bind(this);
        this.changeSalaryHandler=this.changeSalaryHandler.bind(this);
    }
    componentDidMount() {
        WaiterService.getWaiterById(this.state.id).then((res)=>{
            let waiter=res.data
            this.setState({
                name:waiter.name,
                phoneNumber:waiter.phoneNumber,
                mail:waiter.mail,
                address:waiter.address,
                urlToImage:waiter.urlToImage,
                salary:waiter.salary
            });
        })
    }
    updateWaiter=(e)=>{
        e.preventDefault();
        let waiter={
            id:this.state.id,
            name:this.state.name,
            phoneNumber:this.state.phoneNumber,
            mail:this.state.mail,
            address:this.state.address,
            urlToImage:this.state.urlToImage,
            salary:this.state.salary
        }
        WaiterService.updateWaiter(waiter).then(res=>{
            this.props.history.push('/waiter')
        });
    }

    cancel(){
        this.props.history.push('/waiter');
    }
    changeNameHandler = (e)=>{
        this.setState({name : e.target.value});
    }
    changePhoneHandler = (e)=>{
        this.setState({phoneNumber : e.target.value});
    }
    changeMailHandler = (e)=>{
        this.setState({mail : e.target.value});
    }
    changeAddressHandler = (e)=>{
        this.setState({address : e.target.value});
    }
    changeImageHandler = (e)=>{
        this.setState({urlToImage : e.target.value});
    }
    changeSalaryHandler = (e)=>{
        this.setState({salary : e.target.value});
    }
    render() {
        return (
            <div>
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        <h3 className="text-center">ADD UPDATE</h3>
                        <div className="card-body">
                            <form>
                                <div className="form-group">
                                    <label> Waiter Name: </label>
                                    <input placeholder="Waiter Name" name="name" className="form-control"
                                           value={this.state.name} onChange={this.changeNameHandler}/>
                                </div>
                                <div className="form-group">
                                    <label> Waiter Phone: </label>
                                    <input placeholder="Waiter Phone" name="phoneNumber" className="form-control"
                                           value={this.state.phoneNumber} onChange={this.changePhoneHandler}/>
                                </div>
                                <div className="form-group">
                                    <label> Waiter E-Mail: </label>
                                    <input type="email" placeholder="Waiter E-Mail" name="mail" className="form-control"
                                           value={this.state.mail} onChange={this.changeMailHandler}/>
                                </div>
                                <div className="form-group">
                                    <label> Waiter Address: </label>
                                    <input placeholder="Waiter Address" name="address" className="form-control"
                                           value={this.state.address} onChange={this.changeAddressHandler}/>
                                </div>
                                <div className="form-group">
                                    <label> Waiter Image: </label>
                                    <input placeholder="Waiter Image" name="urlToImage" className="form-control"
                                           value={this.state.urlToImage} onChange={this.changeImageHandler}/>
                                </div>
                                <div className="form-group">
                                    <label> Waiter Salary: </label>
                                    <input placeholder="Waiter Salary" name="salary" className="form-control"
                                           value={this.state.salary} onChange={this.changeSalaryHandler}/>
                                </div>
                                <br/>
                                <button className="btn btn-success" onClick={this.updateWaiter}>Save</button>
                                <button className="btn btn-danger" style={{marginLeft: "10px"}}
                                        onClick={this.cancel.bind(this)}>Cancel
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default WaiterUpdate;