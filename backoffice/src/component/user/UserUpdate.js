import React, {Component} from 'react';
import UserService from "../../service/UserService";
import Header from "../Header";
import UserContext from "../../UserContext";

class UserUpdate extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props)

        this.state ={
            id : this.props.match.params.id,
            username : '',
            password : '',
            role : '',

        }
        this.changeUsernameHandler=this.changeUsernameHandler.bind(this);
        this.changePasswordHandler=this.changePasswordHandler.bind(this);
        this.changeEnabledHandler=this.changeEnabledHandler.bind(this);
    }
    componentDidMount(){
        const{token}=this.context;
        UserService.getUserById(this.state.id,token).then( (res) =>{
            let user = res.data;
            this.setState({
                username: user.username,
                password: user.password,
                enabled : user.enabled
            });
        });
    }
    updatedUser =(e)=>{
        e.preventDefault();
        let user = {
            username: this.state.username,
            password: this.state.password,
            enabled: this.state.enabled
        };
        const{token}=this.context;
         UserService.updateUser(user,token).then(res =>{
             this.props.history.push('/user')
         })
    }
    cancel=(e)=>{
        e.preventDefault();
        this.props.history.push('/user');
    }

    changeUsernameHandler = (e)=>{
        this.setState({username : e.target.value});
    }
    changePasswordHandler = (e)=>{
        this.setState({password : e.target.value});
    }
    changeEnabledHandler = (e)=>{
        this.setState({enabled : e.target.value});
    }
    render() {
        return (
            <div>
                <div className = "container">
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">UPDATE USER</h3>
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group">
                                        <label> User Userame: </label>
                                        <input placeholder="User Username" name="username" className="form-control"
                                               value={this.state.username} onChange={this.changeUsernameHandler}/>
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
                                    <button className="btn btn-success" onClick={this.updatedUser}>Update</button>
                                    <button className="btn btn-danger" style={{marginLeft: "10px"}} onClick={this.cancel.bind(this)}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default UserUpdate;