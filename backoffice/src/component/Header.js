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
                <header className="container">
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <div className="container-fluid">
                            <div className="navbar-header">
                                <a href="/product" className="navbar-brand"><h5>Product Manager</h5></a>
                                <a href="/add" className="btn btn-link">Add Product</a>
                                <a href="/order" className="btn btn-link">Orders List</a>
                                <a href="/user-add" className="btn btn-link">Users</a>
                                <a href="/auth" className="btn btn-link">Auth List</a>
                                <a href="/" className="btn btn-danger btnOut" onClick={this.signOut}>Sign Out</a>
                            </div>
                        </div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default Header;