import axios from "axios";

const tableCategoryUrl = "http://localhost:8080/categoryTable/list";
const tableCategoryAdd = "http://localhost:8080/categoryTable/add";
const tableCategoryUpdate = "http://localhost:8080/categoryTable/update";
const tableCategoryDelete = "http://localhost:8080/categoryTable/delete";
// const token=sessionStorage.getItem("token")

//    getTableCategory() {
//         return axios.get(tableCategoryUrl,{
//             headers:{
//                 Authorization:sessionStorage.getItem("token")
//             }
//         });
//     }
class TableCategoryService {
    getTableCategory() {
        return axios.get(tableCategoryUrl);
    }
    getByTableCategoryID(id){
        return axios.get(tableCategoryUrl+'/'+id);
    }
    addTableCategoryItem(category) {
        return axios.post(tableCategoryAdd, category);
    }
    updateTableCategory(category){
        return axios.put(tableCategoryUpdate,category);
    }
    deleteTableCategory(id){
        return axios.delete(tableCategoryDelete+'/'+id);
    }
}
export default new TableCategoryService();