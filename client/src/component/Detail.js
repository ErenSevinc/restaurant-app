import React, {Component} from 'react';

class Detail extends Component {
    state={
        isVisible: false,
        id: this.props.id,
        name: this.props.name,
        brand: this.props.brand,
        price: this.props.price,
        category: this.props.category
    }

    onClickEvent = (e) =>{
        this.setState({
            isVisible: !this.state.isVisible
        })
        return fetch('http://localhost:8080/client/product/list/'+e.id, {
            method: 'GET',
        }).then(response => response.json())

    }
// <h2>Product</h2>
// <div className="card" style="width:400px">
// <img className="card-img-top" src="corba.jpg" alt="Card image" style="width:100%">
// <div className="card-body">
// <h4 className="card-title">{name}</h4>
// <p className=">{category}</p>
// <br/>
//  <p className=">{price}</p>
// <br/>
//  <p className=">{brand}</p>
// <a href="#" className="btn btn-primary">See Profile</a>
// </div>
// </div>
    render() {
        const {id, name, brand, price, category,isVisible } = this.state;
        return (
            <div className="col-sm-6">
                    <div className="card-body" style={{}}>
                        <h5 className="card-title" onClick={this.onClickEvent.bind(this,{id})}>{name}</h5>
                        <p className="card-text">{category}</p>
                    </div>
                    {isVisible ?
                        <ul className="list-group list-group-flush">
                            <li className="list-group-item">{brand}</li>
                            <li className="list-group-item">{price}</li>
                            <li className="list-group-item">{category}</li>
                        </ul> : null}
            </div>
        );
    }
}

export default Detail;