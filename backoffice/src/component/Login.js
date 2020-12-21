import React, {Component} from 'react';
import ProductService from "../service/ProductService";
import './Login.css'
import CategoryService from "../service/CategoryService";
import UserContext from "../UserContext";
import AuthService from "../service/AuthService";
import UserService from "../service/UserService";
import Loader from "../Loader";


class Login extends Component {
    static contextType=UserContext;
    // getToken(){
    //     const{username,setUsername}=this.context;
    //     const{password,setPassword}=this.context;
    //
    //     setUsername(this.state.username);
    //     setPassword(this.state.password);
    //     let usr=username;
    //     let pass=password;
    //     const auth='Basic '+btoa(usr + ':' + pass);
    //AuthService.tkn=auth;
    //
    //             console.log(AuthService.tkn);
    // }

    constructor(props) {
        super(props);
        this.state = {
            userList: [],
            username: '',
            password: '',
            rememberMe: false,
            loader:false,
        }
        this.changeUsernameHandler = this.changeUsernameHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);

    }

    changeUsernameHandler = (e) => {
        this.setState({username: e.target.value});
    }
    changePasswordHandler = (e) => {
        this.setState({password: e.target.value});
    }

    componentDidMount() {
        const{setToken}=this.context;
        if(localStorage.getItem("token") !==null){
            setToken(localStorage.getItem("token"));
            this.props.history.push("/user");
        }
    }

    signIn = (e) => {
        e.preventDefault();
        this.setState({loader:true})
        const{setUsername,setPassword,setToken}=this.context;
        const token='Basic ' + btoa(this.state.username + ':' + this.state.password);
        setUsername(this.state.username);
        setPassword(this.state.password);
        setToken(token);
        if(this.state.rememberMe){
            localStorage.setItem("token",token);
        }
        UserService.getLogin(token).then((res)=>{
           if(res.status == '200'){
               this.setState({loader:!this.state.loader})
               console.log("hoşgeldin");
               console.log(token);
               this.props.history.push("/products");
           }
        });

        // //'Basic '+btoa('admin:123')
        //sessionStorage.setItem("auth", 'Basic ' + btoa(this.state.username + ':' + this.state.password))
        // this.props.history.push("/product")
        // console.log(this.state.username)
        // console.log(this.state.password)
        // console.log(this.state.userList)
        // console.log("state", this.state.userList);
        // const{setUsername,setPassword,setToken}=this.context;
        // if (this.state.userList.filter(user => (user.username === this.state.username) && (user.password === this.state.password)).length > 0) {
        //     sessionStorage.setItem("token", 'Basic ' + btoa(this.state.username + ':' + this.state.password))
        //     setUsername(this.state.username);
        //     // setPassword(this.state.password);
        //     const tokn='Basic '+btoa(this.state.username+':'+this.state.password);
        //     setToken(tokn);
        //
        //     //sessionStorage.setItem("token", 'Basic ' + btoa(this.state.username + ':' + this.state.password));
        //     this.props.history.push('/user');
        //     window.alert("Giriş Başarılı Hoşgeldiniz: " + this.state.username)
        // } else {
        //     this.props.history.push('/');
        //     window.alert("Kullanıcı adı veya şifre yanlış!!")
        // }


        // const{username,setUsername}=this.context;
        // const{password,setPassword}=this.context;
        //
        // setUsername(this.state.username);
        // setPassword(this.state.password);
        // let usr=username;
        // let pass=password;
        //
        // const auth='Basic '+btoa(usr + ':' + pass);
        // const temp= AuthService.getAuthToken(auth);
        // console.log(temp);


        // const{username,setUsername} =this.context;
        // const{password,setPassword}= this.context;
        //
        // setUsername(this.state.username);
        // setPassword(this.state.password);
        //
        // console.log(username+"  "+password);
        // if (this.state.userList.username === username  && this.state.userList.password === password){
        //     console.log(this.state.userList.username);
        //     console.log("eşit");
        // }


    }
    toggleRememberMe = () => {
        this.setState({rememberMe: !this.state.rememberMe});

    }

    render() {
        return (
            <div className="loginBody">
                <div className="card col-md-6 offset-md-3 offset-md-3 ">
                    <h3 className="text-center">User Sign In</h3>
                    <div className="card-body">
                        <form>
                            <div className="form-group">
                                <label>Username</label>
                                <input placeholder="Username" name="username" className="form-control"
                                       value={this.state.username} onChange={this.changeUsernameHandler}/>
                            </div>
                            <div className="form-group">
                                <label>Password</label>
                                <input type="password" placeholder="Password" name="password"
                                       className="form-control"
                                       value={this.state.password} onChange={this.changePasswordHandler}/>
                                <div className="form-group">

                                    <input
                                        id="rememberMe"
                                        type="checkbox"
                                        ref="rememberMe"
                                        placeholder="remember me"
                                        onChange={this.toggleRememberMe}
                                    /><label>Remember Me</label>
                                </div>
                                <hr/>
                                <button className="btn btn-success" onClick={this.signIn}>Sign In</button>
                            </div>
                        </form>
                    </div>
                </div>
                {
                    this.state.loader ?(
                        <Loader/>
                        ) :null

                }
            </div>

        );
    }
}

export default Login;