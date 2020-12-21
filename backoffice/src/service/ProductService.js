import axios from 'axios';
//"Basic YWRtaW46cGFzczM="
import {UserContext} from "../component/Login";

const authTokenAdmin = "Basic YWRtaW46cGFzczM="
const product_list_base_url = "http://localhost:8080/base/list-products";
const product_add_base_url = "http://localhost:8080/base/add-products";
const product_update_base_url = "http://localhost:8080/base/update-products";
const product_delete_base_url = "http://localhost:8080/base/delete-products";
const basket_list_url = "http://localhost:8080/product/basket/list";

const urlListUsers = "http://localhost:8080/users/login";

const token = sessionStorage.getItem("token")

class ProductService {

    getProducts(tkn) {
        return axios.get(product_list_base_url, {
            headers: {
                Authorization: tkn
            }
        });
    }

    getProductById(id, tkn) {
        return axios.get(product_list_base_url + '/' + id,{
            headers:{
                Authorization: tkn
            }
        });
    }

    addProduct(product, tkn) {
        return axios.post(product_add_base_url, product,{
            headers:{
                Authorization: tkn
            }
        });
    }

    updateProduct(product, tkn) {
        return axios.put(product_update_base_url, product,{
            headers:{
                Authorization: tkn
            }
        });
    }

    deleteProduct(id, tkn) {

        return axios.delete(product_delete_base_url + '/' + id,{
            headers:{
                Authorization: tkn
            }
        });
    }

    listSales(tkn) {
        return axios.get(basket_list_url,{
                headers:{
                    Authorization: tkn
                }
        });
    }
}
export default new ProductService();






















    //  localStorage.setItem("token",("Basic"+btoa('eren:1234')))


    //addProduct()
    //    addProduct(product){
    //          if(localStorage.getItem("token")===authToken)
    //         return axios.post(product_add_base_url,product,{
    //             headers:{
    //                 Authorization:authToken
    //             }
    //         });
    //     }



