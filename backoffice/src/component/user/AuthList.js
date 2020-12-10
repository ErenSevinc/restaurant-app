import React, {Component} from 'react';
import UserService from "../../service/UserService";
import UserContext from "../../UserContext";

class AuthList extends Component {
    static contextType=UserContext;
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
        const {token}=this.context;
        UserService.deleteAuth(username,token).then(res => {
            this.props.history.push(`/user`);
        });
    }

    componentDidMount() {
        const {token}=this.context;
        UserService.getUserAuth(token).then((res) => {
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