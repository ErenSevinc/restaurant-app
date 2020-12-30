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
    componentDidMount(){
        const{token}=this.context;
        UserService.getUserById(this.state.id,token).then( (res) =>{
            let user = res.data;
            this.setState({
                username: user.username,
                email:user.email,
                password: user.password,
                enabled: user.enabled,
                roles:user.rolesDTO
            });
            console.log(user);
        });

        UserService.getRoles(token).then((res)=>{
            this.setState({role:res.data});
        });
    }
    updatedUser =(e)=>{
        e.preventDefault();
        let user = {
            username: this.state.username,
            password: this.state.password,
            enabled: this.state.enabled,
            email:this.state.email,
            rolesDTO:this.state.roles,
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
    changeUserEmailHandler =(e)=>{
        this.setState({email : e.target.value});
    }
    changeUserNameHandler = (e)=>{
        this.setState({username : e.target.value});
    }
    changePasswordHandler = (e)=>{
        this.setState({password : e.target.value});
    }
    changeEnabledHandler = (e)=>{
        this.setState({enabled : e.target.value});
    }
    changeRoleHandler=(e)=>{
        this.setState({role: e.target.value});
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
                            <h3 className="text-center">UPDATE USER</h3>
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