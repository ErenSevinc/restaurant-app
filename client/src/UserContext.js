import React, {Component} from "react";

const UserContext = React.createContext();
class UserContextProvider extends Component{
    state={
        username:'adminCont',
        password:'123Cont',
        token:'token',
    }

    setUsername=(username)=>{
        this.setState((prevState) => ({ username }))
    }
    setPassword=(password)=>{
        this.setState((prevState) => ({ password }))
    }
    setToken=(token)=>{
        this.setState((prevState) => ({ token }))
    }
    render(){
        const {username,password,token}=this.state;
        const {setUsername,setPassword,setToken}=this;

        return(
            <UserContext.Provider value={{username,setUsername,password,setPassword,token,setToken}}>
                {this.props.children}
            </UserContext.Provider>
        );
    }
}
export default UserContext;
export {UserContextProvider};