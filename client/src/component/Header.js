import React, {Component} from 'react';

class Header extends Component {
    constructor(props) {
        super(props);

        this.state = {

        }
    }
    signOut=()=>{
        sessionStorage.removeItem("token");
        localStorage.removeItem("waiter");
        localStorage.removeItem("orders");
        sessionStorage.removeItem("tbl");
    }
    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <div className="navbar-brand"><a href="/menu"> Product List</a>
                            <a href="/" className="btn btn-danger  btnOut" onClick={this.signOut}>Sign Out</a>
                        </div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default Header;