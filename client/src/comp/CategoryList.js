import React, {Component} from 'react';
import ClientService from "../service/ClientService";

class CategoryList extends Component {
    constructor(props) {
        super(props);
        this.state={
            category: [],
        }

    }
    componentDidMount() {
        ClientService.getCategory().then((res) => {
            this.setState({category: res.data})
        });
    }

    render() {
        return (
            <div>
                <div className="card" style="width: 18rem;">
                    <div className="card-header">
                        Category List
                    </div>
                    <ul className="list-group list-group-flush">
                        {this.state.category.map(
                                    category =>
                                        <li><button className="btn btn-info">{category}</button></li>
                        )}
                    </ul>
                </div>
            </div>
        );
    }
}

export default CategoryList;