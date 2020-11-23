import axios from 'axios';
import ProductService from "./ProductService";

const user_list_base_url = "http://localhost:8080/users/listall";
const user_add_base_url = "http://localhost:8080/users/add";
const user_update_base_url = "http://localhost:8080/users/update";
const user_delete_base_url = "http://localhost:8080/users/delete";

const auth_update_base_url = "http://localhost:8080/auth/update";
const auth_delete_base_url = "http://localhost:8080/auth/delete";

const user_auth="http://localhost:8080/auth/add";
const auth_list="http://localhost:8080/auth/listall";


class UserService {

    getUser(){
        return axios.get(user_list_base_url,{
            headers:{
                Authorization:ProductService.getToken()
            }
        });
    }
    getUserById(username){
        return axios.get( user_list_base_url+ '/' + username,{
            headers:{
                Authorization:ProductService.getToken()
            }
        });
    }
    addUser(user){
        return axios.post(user_add_base_url,user,{
            headers:{
                Authorization:ProductService.getToken()
            }
        });
    }
    addUserAuth(auth){
        return axios.post(user_auth,auth,{
            headers:{
                Authorization:ProductService.getToken()
            }
        });
    }
    getUserAuth(){
        return axios.get(auth_list,{
            headers:{
                Authorization:ProductService.getToken()
            }
        });
    }
    updateUser(user){
        return axios.put(user_update_base_url, user,{
            headers:{
                Authorization:ProductService.getToken()
            }
        });
    }
    deleteUser(username){
        return axios.delete(user_delete_base_url + '/' + username,{
            headers:{
                Authorization:ProductService.getToken()
            }
        });
    }

    updateAuth(user){
        return axios.put(auth_update_base_url, user,{
            headers:{
                Authorization:ProductService.getToken()
            }
        });
    }
    deleteAuth(username){
        return axios.delete(auth_delete_base_url + '/' + username,{
            headers:{
                Authorization:ProductService.getToken()
            }
        });
    }
}
export default new UserService();
