import axios from 'axios';
import {UserContext} from "../component/Login";
import AuthService from "./AuthService";

const category_list_base_url = "http://localhost:8080/base/list-categories";
const product_list_base = "http://localhost:8080/category/listProductByCategory";
const category_add_base_url = "http://localhost:8080/base/add-categories";
const category_update_base_url = "http://localhost:8080/base/update-categories";
const category_delete_base_url = "http://localhost:8080/base/delete-categories";
const token=sessionStorage.getItem("token");
class CategorySevice {
    asd(){
        //token al metod
    }

    getAllCategory(tkn){
        return axios.get(category_list_base_url,{
            headers:{
                Authorization:tkn
            }
        });
    }
    getSelectedCategoryById(id,tkn){
        return axios.get(category_list_base_url+'/'+id,{
            headers:{
                Authorization:tkn
            }
        });
    }
    getProductByCategoryID(id,tkn){
        return axios.get(product_list_base+'/'+id,{
            headers:{
                Authorization:tkn
            }
        });
    }

    addCategoryItem(category,tkn){
        return axios.post(category_add_base_url,category,{
            headers:{
                Authorization:tkn
            }
        });
    }
    updateCategory(category,tkn){
        return axios.put(category_update_base_url,category,{
            headers:{
                Authorization:tkn
            }
        });
    }
    deleteCategory(id,tkn){
        return axios.delete(category_delete_base_url+'/'+id,{
            headers:{
                Authorization:tkn
            }
        });
    }

}
export default new CategorySevice();