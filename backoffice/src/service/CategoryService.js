import axios from 'axios';
import {UserContext} from "../component/Login";
import AuthService from "./AuthService";

const category_list_base_url = "http://localhost:8080/category/listAll";
const product_list_base = "http://localhost:8080/category/listProductByCategory";
const category_add_base_url = "http://localhost:8080/category/addCategory";
const category_update_base_url = "http://localhost:8080/category/updateCategory";
const category_delete_base_url = "http://localhost:8080/category/deleteCategory";
const token=sessionStorage.getItem("token");
class CategorySevice {
    asd(){
        //token al metod
    }

    getAllCategory(){
        return axios.get(category_list_base_url,{
            headers:{
                Authorization:token
            }
        });
    }
    getSelectedCategoryById(id){
        return axios.get(category_list_base_url+'/'+id,{
            headers:{
                Authorization:token
            }
        });
    }
    getProductByCategoryID(id){
        return axios.get(product_list_base+'/'+id,{
            headers:{
                Authorization:token
            }
        });
    }

    addCategoryItem(category){
        return axios.post(category_add_base_url,category,{
            headers:{
                Authorization:token
            }
        });
    }
    updateCategory(id,category){
        return axios.put(category_update_base_url+'/'+id,category,{
            headers:{
                Authorization:token
            }
        });
    }
    deleteCategory(id){
        return axios.delete(category_delete_base_url+'/'+id,{
            headers:{
                Authorization:token
            }
        });
    }

}
export default new CategorySevice();