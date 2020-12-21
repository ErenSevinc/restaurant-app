import axios from 'axios';


const user_list_base_url = "http://localhost:8080/users/list";
const user_add_base_url = "http://localhost:8080/users/add";
const user_update_base_url = "http://localhost:8080/users/update";
const user_delete_base_url = "http://localhost:8080/users/delete";
const user_login="http://localhost:8080/users/login";
const role_list="http://localhost:8080/users/list-roles";

// const auth_update_base_url = "http://localhost:8080/auth/update";
// const auth_delete_base_url = "http://localhost:8080/auth/delete";
//
// const user_auth="http://localhost:8080/auth/add";
// const auth_list="http://localhost:8080/auth/listall";

class UserService {

    getLogin(token){
        return axios.get(user_login,{
            headers:{
                Authorization:token
            }
        });
    }

    getUser(tkn){
        return axios.get(user_list_base_url
            ,{
            headers:{
                 Authorization:tkn //sessionStorage.getItem("token")
            }
        });
    }
    getRoles(tkn){
        return axios.get(role_list
            ,{
                headers:{
                    Authorization:tkn //sessionStorage.getItem("token")
                }
            });
    }
    getUserById(id,tkn){
        return axios.get( user_list_base_url+ '/' + id,{
            headers:{
                Authorization:tkn//sessionStorage.getItem("token")
            }
        });
    }
    addUser(userDTO,tkn){
        return axios.post(user_add_base_url,userDTO,{
            headers:{
                Authorization:tkn//sessionStorage.getItem("token")
            }
        });
    }
    updateUser(user,tkn){
        return axios.put(user_update_base_url, user,{
            headers:{
                Authorization:tkn
            }
        });
    }
    deleteUser(id,tkn){
        return axios.delete(user_delete_base_url + '/' + id,{
            headers:{
                Authorization:tkn
            }
        });
    }

    // deleteAuth(username,tkn){
    //     return axios.delete(auth_delete_base_url + '/' + username,{
    //         headers:{
    //             Authorization:tkn//sessionStorage.getItem("token")
    //         }
    //     });
    // }
}
export default new UserService();
