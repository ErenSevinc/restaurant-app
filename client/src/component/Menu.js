import React, {Component} from 'react';

class Menu extends Component {

    getProductMenu=(e)=>{
        this.props.history.push('/product')
    }
    render() {
        return (
            <div>
                <button className="btn btn-secondary btnOpenOrClose">+</button>
                <div className="menuCard">
                    <a href="/product" className="btn btn-info menuBtn" onClick={this.getProductMenu.bind(this)}>Sipariş</a>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                </div>
            </div>
        );
    }
}

export default Menu;