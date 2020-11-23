import axios from 'axios';
//"Basic YWRtaW46cGFzczM="

const authTokenAdmin="Basic YWRtaW46cGFzczM="
const product_list_base_url = "http://localhost:8080/product/backoffice/list";
const product_add_base_url = "http://localhost:8080/product/backoffice/add";
const product_update_base_url = "http://localhost:8080/product/backoffice/update";
const product_delete_base_url = "http://localhost:8080/product/backoffice/delete";
const basket_list_url = "http://localhost:8080/product/basket/list";

const urlAdminUsers="http://localhost:8080/users/loadadminusers";
const urlAdminAuth="http://localhost:8080/auth/loadadminauth";
const urlListUsers="http://localhost:8080/users/listall";

const token=sessionStorage.getItem("token")

class ProductService {

    getProducts(){
        return axios.get(product_list_base_url,{
            headers:{
                Authorization:token
            }
        });
    }

    getProductById(id){
        return axios.get( product_list_base_url+ '/' + id,{
            headers:{
                Authorization:token
            }
        });
    }

    addProduct(product){
        return axios.post(product_add_base_url,product,{
            headers:{
                Authorization:token
            }
        });
    }

    updateProduct(product, id){
        return axios.put(product_update_base_url  + '/' + id, product,{
            headers:{
                Authorization:token
            }
        });
    }

    deleteProduct(id){
        return axios.delete(product_delete_base_url + '/' + id,{
            headers:{
                Authorization:token
            }
        });
    }

    listSales(){
        return axios.get(basket_list_url,{
            headers:{
                Authorization:token
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

    getAdminUser(){
        return axios.get(urlAdminUsers);
    }
    getAdminAuth(){
        return axios.get(urlAdminAuth);
    }

    getToken(){
        return token;
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