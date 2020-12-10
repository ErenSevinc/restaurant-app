import React, {Component} from 'react';
import WaiterService from "../../service/WaiterService";
import UserContext from "../../UserContext";

class WaiterDetail extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);

        this.state={
            id:this.props.match.params.id,
            waiter:{}
        }
    }
    componentDidMount() {
        const{token}=this.context
        WaiterService.getWaiterById(this.state.id,token).then((res)=>{
            this.setState({waiter:res.data})
        })
    }

    render() {
        return (
            <div>
                <div className="card col-md-6 offset-md-3">
                    <h3 className="text-center"> Product Details</h3>
                    <div className="card-body">
                        <div className="row">
                            <label> Waiter Name: </label>
                            <div> {this.state.waiter.name}</div>
                        </div>
                        <div className="row">
                            <label> Waiter Number: </label>
                            <div> {this.state.waiter.phoneNumber}</div>
                        </div>
                        <div className="row">
                            <label> Waiter Mail: </label>
                            <div> {this.state.waiter.mail}</div>
                        </div>
                        <div className="row">
                            <label> Waiter Address: </label>
                            <div> {this.state.waiter.address}</div>
                        </div>
                        <div className="row">
                            <label> Waiter Image: </label>
                            <div> {this.state.waiter.urlToImage}</div>
                        </div>
                        <div className="row">
                            <label> Waiter Image: </label>
                            <div> {this.state.waiter.salary}</div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default WaiterDetail;