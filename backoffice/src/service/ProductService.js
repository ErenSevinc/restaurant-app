import axios from 'axios';
//"Basic YWRtaW46cGFzczM="

import {UserContext} from "../component/Login";

const authTokenAdmin="Basic YWRtaW46cGFzczM="
const product_list_base_url = "http://localhost:8080/product/list";
const product_add_base_url = "http://localhost:8080/category/addProductByCategory";
const product_update_base_url = "http://localhost:8080/product/update";
const product_delete_base_url = "http://localhost:8080/product/delete";
const basket_list_url = "http://localhost:8080/product/basket/list";

const urlListUsers="http://localhost:8080/users/listall";

//const token=sessionStorage.getItem("token")

class ProductService{

    getProducts(tkn){
        return axios.get(product_list_base_url,{
            headers:{
                Authorization:tkn
            }
        });
    }

    getProductById(id,tkn){
        return axios.get( product_list_base_url+ '/' + id,{
            headers:{
                Authorization:tkn
            }
        });
    }

    addProduct(id,product,tkn){
        return axios.post(product_add_base_url+'/'+id,product,{
            headers:{
                Authorization:tkn
            }
        });
    }

    updateProduct(product, id,tkn){

        return axios.put(product_update_base_url  + '/' + id, product,{
            headers:{
                Authorization:tkn
            }
        });
    }

    deleteProduct(id,tkn){

        return axios.delete(product_delete_base_url + '/' + id,{
            headers:{
                Authorization:tkn
            }
        });
    }

    listSales(tkn){
        return axios.get(basket_list_url,{
            headers:{
                Authorization:tkn
            }
        });
    }

    getProductLogin(){
        return axios.get(urlListUsers,{
            headers:{
                Authorization:authTokenAdmin
            }
        });
    }


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

}
export default new ProductService();