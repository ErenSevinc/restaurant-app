import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import Header from "../Header";

class Order extends Component {
    constructor(props) {
        super(props);

        this.state = {
            orders: []
        }
    }
    componentDidMount(){
        ProductService.listSales().then((res)=>{
            this.setState({ orders: res.data});
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
                                        <td>{order.paymentType}</td>
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

export default Order;