import React, {Component} from 'react';
import WaiterService from "../../service/WaiterService";
import ProductService from "../../service/ProductService";
import UserContext from "../../UserContext";

class WaiterList extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);

        this.state={
            waiters:[],
        }
        this.add = this.add.bind(this)
        this.updatedWaiter = this.updatedWaiter.bind(this)
        this.deletedWaiter = this.deletedWaiter.bind(this)
        this.detailWaiter = this.detailWaiter.bind(this)

    }
    add() {
        this.props.history.push('/waiter-add');
    }

    updatedWaiter(waiter) {
        this.props.history.push(`/waiter-update/${waiter.id}`);
    }

    deletedWaiter(waiter) {
        const{token}=this.context
        WaiterService.deleteWaiter(waiter.id,token).then(res => {
            this.props.history.push('/waiter-add');
        });
    }

    detailWaiter(waiter) {
        this.props.history.push(`/waiter-detail/${waiter.id}`);
    }
    componentDidMount() {
        const{token}=this.context
        WaiterService.getWaiter(token).then((res)=>{
            this.setState({waiters: res.data})
        });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Product List</h2>

                <div>
                    <button className="btn btn-success" onClick={this.add}>Add Waiter</button>
                </div>
                <div>
                    <table className="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Waiter Name</th>
                            <th>Waiter Phone</th>
                            <th>Waiter Mail</th>
                            <th>Waiter Address</th>
                            <th>Waiter Image</th>
                            <th>Waiter Salary</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.waiters.map(
                                waiter =>
                                    <tr key={waiter.id}>
                                        <td>{waiter.name}</td>
                                        <td>{waiter.phoneNumber}</td>
                                        <td>{waiter.mail}</td>
                                        <td>{waiter.address}</td>
                                        <td><img src={waiter.urlToImage} width="150" height="150"/></td>
                                        <td>{waiter.salary}</td>
                                        <td>
                                            <button onClick={() => this.updatedWaiter(waiter)}
                                                    className="btn btn-info" style={{margin: "5px"}}>Update
                                            </button>
                                            <button onClick={() => this.deletedWaiter(waiter)}
                                                    className="btn btn-danger">Delete
                                            </button>
                                            <button onClick={() => this.detailWaiter(waiter)}
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

export default WaiterList;