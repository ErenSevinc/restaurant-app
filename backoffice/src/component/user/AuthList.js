import React, {Component} from 'react';
import UserService from "../../service/UserService";

class AuthList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            authList: [],
            username: '',
            authority: ''
        }
        this.updatedAuth = this.updatedAuth.bind(this)
        this.deletedAuth = this.deletedAuth.bind(this)
    }
    updatedAuth() {
        this.props.history.push(`/auth-update/`);
    }
    deletedAuth(username){
        UserService.deleteAuth(username).then(res => {
            window.location.reload();
        });
    }

    componentDidMount() {
        UserService.getUserAuth().then((res) => {
            this.setState({authList: res.data});
        });
    }

    render() {
        return (
            <div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>User Name</th>
                            <th>Role</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.authList.map(
                                auth =>
                                    <tr>
                                        <td>{auth.username}</td>
                                        <td>{auth.authority}</td>
                                        <td>

                                            <button onClick={() => this.updatedAuth(auth)}
                                                className="btn btn-info" style={{margin: "5px"}}>Update
                                            </button>
                                            <button onClick={() => this.deletedAuth(auth.username)}
                                                className="btn btn-danger">Delete
                                            </button>
                                        </td>
                                    </tr>
                            )
                        }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default AuthList;