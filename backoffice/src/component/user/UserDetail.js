import React, {Component} from 'react';
import UserService from "../../service/UserService";
import Header from "../Header";

class UserDetail extends Component {
    constructor(props) {
        super(props);

        this.state={
            username:this.props.match.params.username,
            user:{},
            enabled:''

        }
    }
    componentDidMount() {
        const {enabled}=this.state.enabled;
        UserService.getUserById(sessionStorage.getItem("view")).then( res => {
            this.setState({user: res.data,
            enabled:res.data.enabled.toString()

            });
        })
        console.log(this.state.user)
    }
    render() {
        return (
            <div>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> User Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> User Username: </label>
                            <div> { this.state.user.username }</div>
                        </div>
                        <div className = "row">
                            <label> User Password: </label>
                            <div> { this.state.user.password }</div>
                        </div>
                        <div className = "row">
                            <label> User Enabled: </label>
                            <div> { this.state.enabled}</div>
                        </div>
                    </div>

                </div>
            </div>
        );
    }
}

export default UserDetail;