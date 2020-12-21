import axios from 'axios';

//const authTokenAdmin='Basic '+btoa('user1:{noop}pass1');
const product_list_base_url = "http://localhost:8080/base/list-products";
const category_base_url = "http://localhost:8080/base/list-categories";
const cat_product_base_url="http://localhost:8080/base/list-by-categories-products";
const post_order_base_url="http://localhost:8080/product/basket";
// const token=sessionStorage.getItem("token");

const user_login="http://localhost:8080/users/login";


// getProducts() {
//     return axios.get(product_list_base_url,{
//         headers:{
//             Authorization:sessionStorage.getItem("token")
//         }
//     });
// }

class ClientService {

     getProducts() {
         return axios.get(product_list_base_url);
     }
    getCategory(){
        return axios.get(category_base_url);
    }
    getCategoryProduct(id){
        return axios.get(cat_product_base_url+'/'+id)
    }
    postOrder(basket){
         return axios.post(post_order_base_url,basket);
    }
    getLogin(){
         return axios.get(user_login);
    }
}
export default new ClientService();