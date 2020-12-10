import React, {Component} from 'react';
import UserService from "../../service/UserService";
import UserContext from "../../UserContext";

class AuthUpdate extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props)

        this.state ={
            id : this.props.match.params.id,
            username : '',
            authority : '',

        }
        this.changeUsernameHandler=this.changeUsernameHandler.bind(this);
        this.changeAuthorityHandler=this.changeAuthorityHandler.bind(this);
    }
    componentDidMount(){
        const {token}=this.context;
        UserService.getUserById(this.state.username,token).then( (res) =>{
            let user = res.data;
            this.setState({
                username: user.username,
                authority:user.authority,
            });
        });
    }
    updatedAuth =(e)=>{
        e.preventDefault();
        let user = {
            username: this.state.username,
            authority: this.state.authority,
        };
        const {token}=this.context;
        UserService.updateAuth(user,token).then(res =>{
            this.props.history.push('/auth')
        })
    }
    cancel=(e)=>{
        this.props.history.push('/auth');
    }

    changeUsernameHandler = (e)=>{
        this.setState({username : e.target.value});
    }
    changeAuthorityHandler = (e)=>{
        this.setState({authority : e.target.value});
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
                                        <input placeholder="User Authority" name="authority" className="form-control"
                                               value={this.state.authority} onChange={this.changeAuthorityHandler}/>
                                    </div>
                                    <button className="btn btn-success" onClick={this.updatedAuth}>Update</button>
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

export default AuthUpdate;