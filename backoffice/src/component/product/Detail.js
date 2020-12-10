import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import Header from "../Header";

class Detail extends Component {
    constructor(props) {
        super(props);

        this.state={
            id:this.props.match.params.id,
            product:{}
        }
    }
    componentDidMount() {
        ProductService.getProductById(this.state.id).then( res => {
            this.setState({product: res.data});
        })
    }
    render() {
        return (
            <div>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> Product Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Product Name: </label>
                            <div> { this.state.product.name }</div>
                        </div>
                        <div className = "row">
                            <label> Product Brand: </label>
                            <div> { this.state.product.brand }</div>
                        </div>
                        <div className = "row">
                            <label> Product Price: </label>
                            <div> { this.state.product.price }</div>
                        </div>
                        <div className = "row">
                            <label> Product Category: </label>
                            <div> { this.state.product.productCategory }</div>
                        </div>
                        <div className = "row">
                            <label> Product Image: </label>
                            <div> { this.state.product.urlToImage }</div>
                        </div>
                    </div>

                </div>
            </div>
        );
    }
}

export default Detail;