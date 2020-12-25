import React, {Component} from 'react';
import UserContext from "../UserContext";
import {BrowserRouter, Route, Link} from "react-router-dom";
import Category from "./category/Category";


class Header extends Component {
    static contextType = UserContext;

    constructor(props) {
        super(props);

        this.state = {}
    }

    signOut = () => {
        localStorage.removeItem("token");
    }

    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <div className="container-fluid">
                            <div className="navbar-header">
                                <Link to='products'>
                                    <h5 className="navbar-brand">Product Manager</h5>
                                </Link>
                                <Link to='/category'>
                                    <button className="btn btn-outline-light btnLink">Category</button>
                                </Link>
                                <Link to='/add'>
                                    <button className="btn btn-outline-light btnLink">Add Product</button>
                                </Link>
                                <Link to='/order'>
                                    <button className="btn btn-outline-light btnLink">Orders List</button>
                                </Link>
                                <Link to='/customer'>
                                    <button className="btn btn-outline-light btnLink">Customers</button>
                                </Link>
                                <Link to='/user-add'>
                                    <button className="btn btn-outline-light btnLink">Users</button>
                                </Link>
                                <Link to='/auth'>
                                    <button className="btn btn-outline-light btnLink">Role List</button>
                                </Link>
                                <Link to='/waiter'>
                                    <button className="btn btn-outline-light btnLink">Waiter</button>
                                </Link>
                                <Link to='/app-properties'>
                                    <button className="btn btn-outline-light btnLink">Info</button>
                                </Link>
                                <Link to='/table-category-list'>
                                    <button className="btn btn-outline-light btnLink">Table Cat.</button>
                                </Link>
                                <Link to='/image'>
                                    <button className="btn btn-outline-light btnLink">Image</button>
                                </Link>
                                {/*<a href="/category" className="btn btn-outline-light btnLink">Category</a>*/}
                                {/*<a href="/add" className="btn btn-outline-light btnLink">Add Product</a>*/}
                                {/*<a href="/order" className="btn btn-outline-light btnLink">Orders List</a>*/}
                                {/*<a href="/user-add" className="btn btn-outline-light btnLink">Users</a>*/}
                                {/*<a href="/auth" className="btn btn-outline-light btnLink">Role List</a>*/}
                                {/*<a href="/waiter" className="btn btn-outline-light btnLink">Waiter</a>*/}
                                {/*<a href="/app-properties" className="btn btn-outline-light btnLink">Info</a>*/}
                                {/*<a href="/table-category-list" className="btn btn-outline-light btnLink">Table Cat.</a>*/}
                                {/*<a href="/image" className="btn btn-outline-light btnLink">Image</a>*/}
                                <a href="/" className="btn btn-outline-danger btnOut" onClick={this.signOut}>Sign
                                    Out</a>
                            </div>
                        </div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default Header;