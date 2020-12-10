import axios from "axios";

const tableCategoryUrl = "http://localhost:8080/categoryTable/list";
const tableCategoryAdd = "http://localhost:8080/categoryTable/add";
const tableCategoryUpdate = "http://localhost:8080/categoryTable/update";
const tableCategoryDelete = "http://localhost:8080/categoryTable/delete";
const token=sessionStorage.getItem("token")

class TableCategoryService {
    getTableCategory() {
        return axios.get(tableCategoryUrl,{
            headers:{
                Authorization:sessionStorage.getItem("token")
            }
        });
    }
    getByTableCategoryID(id){
        return axios.get(tableCategoryUrl+'/'+id,{
            headers:{
                Authorization:sessionStorage.getItem("token")
            }
        });
    }
    addTableCategoryItem(category) {
        return axios.post(tableCategoryAdd, category,{
            headers:{
                Authorization:sessionStorage.getItem("token")
            }
        });
    }
    updateTableCategory(category){
        return axios.put(tableCategoryUpdate,category,{
            headers:{
                Authorization:sessionStorage.getItem("token")
            }
        });
    }
    deleteTableCategory(id){
        return axios.delete(tableCategoryDelete+'/'+id,{
            headers:{
                Authorization:sessionStorage.getItem("token")
            }
        });
    }
}
export default new TableCategoryService();