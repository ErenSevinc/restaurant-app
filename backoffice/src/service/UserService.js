import axios from 'axios';


const user_list_base_url = "http://localhost:8080/users/listall";
const user_add_base_url = "http://localhost:8080/users/add";
const user_update_base_url = "http://localhost:8080/users/update";
const user_delete_base_url = "http://localhost:8080/users/delete";

const auth_update_base_url = "http://localhost:8080/auth/update";
const auth_delete_base_url = "http://localhost:8080/auth/delete";

const user_auth="http://localhost:8080/auth/add";
const auth_list="http://localhost:8080/auth/listall";


class UserService {

    getUser(tkn){
        return axios.get(user_list_base_url,{
            headers:{
                 Authorization:tkn //sessionStorage.getItem("token")
            }
        });
    }
    getUserById(username,tkn){
        return axios.get( user_list_base_url+ '/' + username,{
            headers:{
                Authorization:tkn//sessionStorage.getItem("token")
            }
        });
    }
    addUser(user,tkn){
        return axios.post(user_add_base_url,user,{
            headers:{
                Authorization:tkn//sessionStorage.getItem("token")
            }
        });
    }
    addUserAuth(auth,tkn){
        return axios.post(user_auth,auth,{
            headers:{
                Authorization:tkn//sessionStorage.getItem("token")
            }
        });
    }
    getUserAuth(tkn){
        return axios.get(auth_list,{
            headers:{
                Authorization:tkn//sessionStorage.getItem("token")
            }
        });
    }
    updateUser(user,tkn){
        return axios.put(user_update_base_url, user,{
            headers:{
                Authorization:tkn//sessionStorage.getItem("token")
            }
        });
    }
    deleteUser(username,tkn){
        return axios.delete(user_delete_base_url + '/' + username,{
            headers:{
                Authorization:tkn//sessionStorage.getItem("token")
            }
        });
    }

    updateAuth(user,tkn){
        return axios.put(auth_update_base_url, user,{
            headers:{
                Authorization:tkn//sessionStorage.getItem("token")
            }
        });
    }
    deleteAuth(username,tkn){
        return axios.delete(auth_delete_base_url + '/' + username,{
            headers:{
                Authorization:tkn//sessionStorage.getItem("token")
            }
        });
    }
}
export default new UserService();
