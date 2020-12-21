import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import Header from "../Header";
import UserContext from "../../UserContext";
import Loader from "../../Loader";

class Order extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);

        this.state = {
            orders: [],
            loaded:false,
        }
    }
    componentDidMount(){
        this.setState({loaded:!this.state.loaded});
        const{token}=this.context;
        ProductService.listSales(token).then((res)=>{
            this.setState({ orders: res.data});
            if (res.status == '200'){
                this.setState({loaded:!this.state.loaded});
            }
        });
    }
    render() {
        return (
            <div>
                <h2 className="text-center">Order List</h2>
                <div className="row">
                </div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Product ID</th>
                            <th>Total Price</th>
                            <th>Piece</th>
                            <th>Date</th>
                            <th>Table</th>
                            <th>Waiter Name</th>
                            <th>Payment Type</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.orders.map(
                                order =>
                                    <tr key={order.id}>
                                        <td>{order.productId}</td>
                                        <td>{order.totalPrice}</td>
                                        <td>{order.piece}</td>
                                        <td>{order.date}</td>
                                        <td>{order.tableName}</td>
                                        <td>{order.waiterName}</td>
                                        <td>{order.paymentType}</td>
                                    </tr>
                            )
                        }
                        </tbody>
                    </table>
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

export default Order;