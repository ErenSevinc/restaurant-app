import React, {Component} from 'react';
import UserService from "../../service/UserService";
import Header from "../Header";


class UserList extends Component {
    constructor(props) {
        super(props)

        this.state = {
            users: []
        }

        this.updatedUser = this.updatedUser.bind(this)
        this.deletedUser = this.deletedUser.bind(this)
        this.detailUser = this.detailUser.bind(this)
    }

    add() {
       this.props.history.push('/user-add')
    }

    updatedUser(id) {
        this.props.history.push(`/user-update/${id}`);
    }

    deletedUser(username) {
        UserService.deleteUser(username).then(res => {
            window.location.reload();
        });
    }

    detailUser(username) {
        this.props.history.push(`/user-detail/${username}`);
        sessionStorage.setItem("view",username);

    }

    componentDidMount() {
        UserService.getUser().then((res) => {
            this.setState({users: res.data});
        });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">User List</h2>
                <div className="row">
                    <button className="btn btn-success" onClick={this.add.bind(this)}>Add User</button>
                </div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>User Name</th>
                            <th>Password</th>
                            <th>Enabled</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.users.map(
                                user =>
                                    <tr key={user.id}>
                                        <td>{user.username}</td>
                                        <td>{user.password}</td>
                                        <td>{user.enabled}</td>

                                        <td>

                                            <button onClick={() => this.updatedUser(user)}
                                                    className="btn btn-info" style={{margin: "5px"}}>Update
                                            </button>
                                            <button onClick={() => this.deletedUser(user.username)}
                                                    className="btn btn-danger">Delete
                                            </button>
                                            <button onClick={() => this.detailUser(user.username)}
                                                    className="btn btn-warning" style={{margin: "5px"}}>Detail
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

export default UserList;