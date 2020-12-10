import React, {Component} from 'react';
import Table from "react-bootstrap/Table";
import CategoryService from "../../service/CategoryService";

class PrdouctListByCategory extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id:this.props.match.params.id,
            product: [],
            category:[]
        }

    }
    componentDidMount() {
        CategoryService.getSelectedCategoryById(this.state.id).then((res)=>{
            this.setState({ category : res.data});
        })
        CategoryService.getProductByCategoryID(this.state.id).then((res)=>{
            this.setState({ product : res.data});
            console.log(this.state.product)
        });
    }

    render() {
        return (
            <div>

                <div className="productlist">

                    <h2 className="text-center ">{this.state.category.name}</h2>

                    <div className="row">

                    </div>
                    <div className="row">
                        <Table striped bordered hover >
                            <thead>
                            <tr>
                                <th>Product Name</th>
                                <th>Prorduct Brand</th>
                                <th>Product Price</th>

                            </tr>
                            </thead>
                            <tbody>
                            {
                                this.state.product.map(
                                    product =>
                                        <tr key={product.id}>
                                            <td>{product.name}</td>
                                            <td>{product.brand}</td>
                                            <td>{product.price}</td>
                                            <td>

                                            </td>
                                        </tr>
                                )
                            }
                            </tbody>
                        </Table>
                    </div>

                </div>
            </div>
        );
    }
}

export default PrdouctListByCategory;