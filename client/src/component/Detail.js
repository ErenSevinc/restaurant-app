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
        return fetch('http://localhost:8080/client/list/'+e.id, {
            method: 'GET',
        }).then(response => response.json())

    }

    render() {
        const {id, name, brand, price, category,isVisible } = this.state;
        return (
            <div className="col-sm-6">
                    <div className="card-body">
                        <h5 className="card-title" onClick={this.onClickEvent.bind(this,{id})}>{category}</h5>
                        <p className="card-text">{name}</p>
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