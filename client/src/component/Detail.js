import React, {Component} from 'react';
import ClientService from "../service/ClientService";

class Detail extends Component {
    constructor(props) {
        super(props)
        this.state ={
            products:[]
        }
    }
    componentDidMount() {
        ClientService.getProducts().then((res)=>{
            this.setState({products:res.data})
        });
    }

    render() {
        return (
            <div>
                <div className="col-6 col-md-4">
                    {this.state.products.map(
                        product=>
                    <div className="card-body">
                        <h5 className="card-title">{product.name}</h5>
                        <p className="card-text">{product.brand}</p>
                    </div>
                        )}
                </div>
            </div>
        )
    }
}

export default Detail;