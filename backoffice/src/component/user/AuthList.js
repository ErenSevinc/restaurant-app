import React, {Component} from 'react';
import UserService from "../../service/UserService";
import UserContext from "../../UserContext";

class AuthList extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);
        this.state = {
            roleList: [],
            username: '',
            authority: ''
        }
        this.deletedAuth = this.deletedAuth.bind(this)
    }
    deletedAuth(id){
        const {token}=this.context;
        UserService.deleteAuth(id,token).then(res => {
            this.props.history.push(`/user`);
        });
    }

    componentDidMount() {
        const {token}=this.context;
        UserService.getRoles(token).then((res) => {
            this.setState({roleList: res.data});
        });
    }

    render() {
        return (
            <div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Role</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.roleList.map(
                                auth =>
                                    <tr>
                                        <td>{auth.id}</td>
                                        <td>{auth.name}</td>
                                        <td>
                                            <button onClick={() => this.deletedAuth(auth.id)}
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