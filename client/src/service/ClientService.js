import axios from 'axios';

//const authTokenAdmin='Basic '+btoa('user1:{noop}pass1');
const product_list_base_url = "http://localhost:8080/product/backoffice/list";
const category_base_url ="http://localhost:8080/product/backoffice/category";
const cat_product_base_url="http://localhost:8080/product/backoffice/list/category";
const post_order_base_url="http://localhost:8080/product/basket";
const token=sessionStorage.getItem("token")

const list='http://localhost:8080/users/listall';

class ClientService {

     getProducts() {
         return axios.get(product_list_base_url,{
             headers:{
                 Authorization:token
             }
         });
     }
    getCategory(){
        return axios.get(category_base_url,{
            headers:{
                Authorization:token
            }
        });
    }
    getCategoryProduct(categories){
        return axios.get(cat_product_base_url,{
            params: {
                category: categories
            },
            headers:{
                Authorization:token
            }
        })
    }
    postOrder(basket){
         return axios.post(post_order_base_url,basket,{
             headers:{
                 Authorization:token
             }
         });
    }
    listAll(){
         return axios.get(list,{
             headers:{
                 Authorization:token
             }
        })
    }
}
export default new ClientService;