import axios from "axios";

const tableCategoryUrl = "http://localhost:8080/categoryTable/list";
const tableCategoryAdd = "http://localhost:8080/categoryTable/add";
const tableCategoryUpdate = "http://localhost:8080/categoryTable/update";
const tableCategoryDelete = "http://localhost:8080/categoryTable/delete";
const token=sessionStorage.getItem("token");


class TableCategoryService {
    getTableCategory(tkn) {
        return axios.get(tableCategoryUrl,{
            headers:{
                Authorization:tkn
            }
        });
    }
    getByTableCategoryID(id,tkn){
        return axios.get(tableCategoryUrl+'/'+id,{
            headers:{
                Authorization:tkn
            }
        });
    }
    addTableCategoryItem(category,tkn) {
        return axios.post(tableCategoryAdd, category,{
            headers:{
                Authorization:tkn
            }
        });
    }
    updateTableCategory(category,id,tkn){
        return axios.put(tableCategoryUpdate+'/'+id, category,{
            headers:{
                Authorization:tkn
            }
        });
    }
    deleteTableCategory(id,tkn){
        return axios.delete(tableCategoryDelete+'/'+id,{
            headers:{
                Authorization:tkn
            }
        });
    }
}
export default new TableCategoryService();