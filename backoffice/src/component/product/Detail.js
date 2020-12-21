import React, {Component} from 'react';
import ProductService from "../../service/ProductService";
import Header from "../Header";
import Loader from "../../Loader";
import UserContext from "../../UserContext";

class Detail extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);

        this.state={
            id:this.props.match.params.id,
            product:{},

            loaded:false,
        }
    }
    componentDidMount() {
        const{token}=this.context;
        this.setState({loaded:!this.state.loaded});
        ProductService.getProductById(this.state.id,token).then( res => {
            this.setState({product: res.data});
            if(res.status =='200'){
                this.setState({loaded:!this.state.loaded});
            }
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
                {
                    this.state.loaded ?(
                        <Loader/>
                    ):null
                }
            </div>
        );
    }
}

export default Detail;