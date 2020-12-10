import React, {Component} from 'react';
import UserService from "../../service/UserService";
import Header from "../Header";
import UserContext from "../../UserContext";

class UserAdd extends Component {
    static contextType=UserContext;

    constructor(props) {
        super(props);

        this.state ={
            username : '',
            password : '',
            enabled : '',
            role:''
        }
        this.changeUserNameHandler=this.changeUserNameHandler.bind(this);
        this.changePasswordHandler=this.changePasswordHandler.bind(this);
        this.changeEnabledHandler=this.changeEnabledHandler.bind(this);
        this.changeRoleHandler=this.changeRoleHandler.bind(this);
    }
    saveUser =(e)=>{
        e.preventDefault();
        let user = {
            username: this.state.username,
            password: this.state.password,
            enabled: this.state.enabled,

        };
        const{token}=this.context;
         UserService.addUser(user,token).then(res =>{
             this.props.history.push('/user')
        })
        let userAuth={
             username:this.state.username,
             authority:this.state.role
        };
         UserService.addUserAuth(userAuth,token).then(res=>{
             this.props.history.push('/user')
         })
    }
    cancel=(e)=>{
        e.preventDefault();
        this.props.history.push('/user');
    }
    changeUserNameHandler = (e)=>{
        this.setState({username : e.target.value});
    }
    changePasswordHandler=(e)=>{
        this.setState({password : e.target.value});
    }
    changeEnabledHandler=(e)=> {
        this.setState({enabled: e.target.value});
    }
    changeRoleHandler=(e)=>{
        this.setState({role: e.target.value});
    }

    render() {
        return (
            <div>
                <div className = "container">
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">ADD USER</h3>
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group">
                                        <label> User Username: </label>
                                        <input placeholder="User Userame" name="username" className="form-control"
                                               value={this.state.username} onChange={this.changeUserNameHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> User Password: </label>
                                        <input type="password" placeholder="User Password" name="password" className="form-control"
                                               value={this.state.password} onChange={this.changePasswordHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> User Enabled: </label>
                                        <input placeholder="User Enabled" name="enabled" className="form-control"
                                               value={this.state.enabled} onChange={this.changeEnabledHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> User Role: </label>
                                        <input placeholder="User Role" name="role" className="form-control"
                                               value={this.state.role} onChange={this.changeRoleHandler}/>
                                    </div>
                                    <button className="btn btn-success" onClick={this.saveUser}>Save</button>
                                    <button  className="btn btn-danger" style={{marginLeft: "10px"}} onClick={this.cancel.bind(this)}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        );
    }
}

export default UserAdd;