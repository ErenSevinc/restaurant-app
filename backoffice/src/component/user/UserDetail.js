import React, {Component} from 'react';
import UserService from "../../service/UserService";
import Header from "../Header";
import UserContext from "../../UserContext";

class UserDetail extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);

        this.state={
            id:this.props.match.params.id,
            user:{},
            username : '',
            password : '',
            enabled : '',
            email:'',


        }
    }
    componentDidMount() {
        const{token}=this.context
        UserService.getUserById(this.state.id,token).then( res => {
            this.setState({user: res.data,
            id:res.data.id,
            enabled:res.data.enabled.toString(),
            username:res.data.username,
            email:res.data.email,
            password:res.data.password
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
                            <div> { this.state.username }</div>
                        </div>
                        <div className = "row">
                            <label> User Email: </label>
                            <div> { this.state.email}</div>
                        </div>
                        <div className = "row">
                            <label> User Password: </label>
                            <div> { this.state.password }</div>
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