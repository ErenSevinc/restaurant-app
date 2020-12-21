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
            email:'',
            role:[],
            roles:[]
        }
        this.changeUserNameHandler=this.changeUserNameHandler.bind(this);
        this.changePasswordHandler=this.changePasswordHandler.bind(this);
        this.changeEnabledHandler=this.changeEnabledHandler.bind(this);
        this.changeRoleHandler=this.changeRoleHandler.bind(this);
        this.changeUserEmailHandler=this.changeUserEmailHandler.bind(this);
    }
    saveUser =(e)=>{
        e.preventDefault();
        let userDTO = {
            username: this.state.username,
            email:this.state.email,
            password: this.state.password,
            enabled: this.state.enabled,
            rolesDTO:this.state.roles
        };
        const{token}=this.context;
         UserService.addUser(userDTO,token).then(res =>{
             this.props.history.push('/user');
        })
    }
    cancel=(e)=>{
        e.preventDefault();
        const{token}=this.context;
        this.props.history.push('/user');
    }
    changeUserNameHandler = (e)=>{
        this.setState({username : e.target.value});
    }
    changeUserEmailHandler =(e)=>{
        this.setState({email : e.target.value});
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
    componentDidMount() {
        const{token}=this.context;
        UserService.getRoles(token).then((res)=>{
           this.setState({role:res.data});
        });
    }
    selectMulti=(e)=>{
        if(this.state.role.includes(e.id) !== true){
            this.state.roles.push(e);
        }
        console.log(this.state.roles);
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
                                        <label> User Email: </label>
                                        <input placeholder="User Email" name="email" className="form-control"
                                               value={this.state.email} onChange={this.changeUserEmailHandler}/>
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
                                    <div className="checkbox" style={{height:"4rem",overflow:"auto"}}>
                                        {
                                            this.state.role.map(
                                                roles=>
                                                    <div className="row col-md -12">
                                                        <label><input type="checkbox" value="" onClick={()=>this.selectMulti(roles)}/>{roles.name}</label>
                                                    </div>
                                            )
                                        }
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