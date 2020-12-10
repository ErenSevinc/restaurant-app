import React, {Component} from 'react';

class Header extends Component {
    constructor(props) {
        super(props);

        this.state = {

        }
    }
    signOut=()=>{
        sessionStorage.removeItem("token")
    }
    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <div className="container-fluid">
                            <div className="navbar-header">
                                <a href="/product" className="navbar-brand"><h5>Product Manager</h5></a>
                                <a href="/category" className="btn btn-outline-light btnLink">Category</a>
                                <a href="/add" className="btn btn-outline-light btnLink">Add Product</a>
                                <a href="/order" className="btn btn-outline-light btnLink">Orders List</a>
                                <a href="/user-add" className="btn btn-outline-light btnLink">Users</a>
                                <a href="/auth" className="btn btn-outline-light btnLink">Auth List</a>
                                <a href="/waiter" className="btn btn-outline-light btnLink">Waiter</a>
                                <a href="/app-properties" className="btn btn-outline-light btnLink">Info</a>
                                <a href="/table-category-list" className="btn btn-outline-light btnLink">Table Cat.</a>
                                <a href="/image" className="btn btn-outline-light btnLink">Image</a>
                                <a href="/" className="btn btn-outline-danger btnOut" onClick={this.signOut}>Sign Out</a>
                            </div>
                        </div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default Header;