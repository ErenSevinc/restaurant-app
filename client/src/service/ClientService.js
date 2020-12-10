import axios from 'axios';

//const authTokenAdmin='Basic '+btoa('user1:{noop}pass1');
const product_list_base_url = "http://localhost:8080/product/list";
const category_base_url = "http://localhost:8080/category/listAll";
const cat_product_base_url="http://localhost:8080/category/listProductByCategory";
const post_order_base_url="http://localhost:8080/product/basket";
const token=sessionStorage.getItem("token")

const list='http://localhost:8080/users/listall';

class ClientService {

     getProducts() {
         return axios.get(product_list_base_url,{
             headers:{
                 Authorization:sessionStorage.getItem("token")
             }
         });
     }
    getCategory(){
        return axios.get(category_base_url,{
            headers:{
                Authorization:sessionStorage.getItem("token")
            }
        });
    }
    getCategoryProduct(id){
        return axios.get(cat_product_base_url+'/'+id,{
             headers:{
                 Authorization:sessionStorage.getItem("token")
             }
        })
    }
    postOrder(basket){
         return axios.post(post_order_base_url,basket,{
             headers:{
                 Authorization:sessionStorage.getItem("token")
             }
         });
    }
    listAll(){
         return axios.get(list,{
             headers:{
                 Authorization:"Basic dXNlcjE6cGFzczE="
             }
        })
    }
}
export default new ClientService;