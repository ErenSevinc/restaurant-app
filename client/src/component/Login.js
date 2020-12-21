import React, {Component} from 'react';
import ClientService from "../service/ClientService";
import UserContext from "../UserContext";

class Login extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);
        this.state={
            userList:[],
            username:'',
            password:''
        }
        this.changeUsernameHandler=this.changeUsernameHandler.bind(this);
        this.changePasswordHandler=this.changePasswordHandler.bind(this);

    }
    changeUsernameHandler=(e)=>{
        this.setState({username : e.target.value});
    }
    changePasswordHandler=(e)=>{
        this.setState({password : e.target.value});
    }


    signIn=(e)=> {
        e.preventDefault();
        const{setUsername,setPassword,setToken}=this.context;
        const token='Basic ' + btoa(this.state.username + ':' + this.state.password);
        setToken(token);
        ClientService.getLogin().then((res)=>{
            if(res.status == '200'){
                console.log("hoşgeldin");
                console.log(token);
                this.props.history.push("/menu");
            }
        });

        // //'Basic '+btoa('admin:pass3')
        // sessionStorage.setItem("token", 'Basic ' + btoa(this.state.username + ':' + this.state.password));
        // this.props.history.push('/menu');
        //   e.preventDefault()
        //
        //   console.log(this.state.username)
        //   console.log(this.state.password)
        //   console.log(this.state.userList)
        //
        //   if(this.state.userList.filter(user => (user.username === this.state.username) && (user.password.substring(6,user.password.size) === this.state.password)).length>0){
        //       sessionStorage.setItem("token", 'Basic ' + btoa(this.state.username + ':' + this.state.password))
        //       this.props.history.push('/menu');
        //       window.alert("Giriş Başarılı Hoşgeldiniz: " + this.state.username)
        //   }
        //   else{
        //      this.props.history.push('/');
        //       window.alert("Kullanıcı adı veya şifre yanlış!!")
        //   }

    }
    render() {
        return (
            <div className="loginBody">
                <div className="card col-md-6 offset-md-3 offset-md-3 " >
                    <h3 className="text-center">User Sign In</h3>
                    <div className="card-body">
                        <form>
                            <div className="form-group">
                                <label>Username</label>
                                <input placeholder="Username" name="username" className="form-control"
                                       value={this.state.username} onChange={this.changeUsernameHandler}/>
                            </div>
                            <div className="form-group">
                                <label>Parola</label>
                                <input type ="password" placeholder="Password" name="password" className="form-control"
                                       value={this.state.password} onChange={this.changePasswordHandler}/>
                                <hr/>
                                <button className="btn btn-success" onClick={this.signIn} >Sign In</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}
export default Login;