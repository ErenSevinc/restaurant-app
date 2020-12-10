import axios from "axios";

const tableAllUrl = "http://localhost:8080/restaurantTable/list";
const tableAddUrl = "http://localhost:8080/restaurantTable/add";
const tableDeleteUrl = "http://localhost:8080/restaurantTable/delete";
const tableUpdateUrl = "http://localhost:8080/restaurantTable/update";
const token=sessionStorage.getItem("token");

class TableService {
    getTable() {
        return axios.get(tableAllUrl,{
            headers:{
                Authorization:token
            }
        });
    }
    getTableId(id){
        return axios.get(tableAllUrl+'/'+id,{
            headers:{
                Authorization:token
            }
        })
    }
    addTable(id,table){
        return axios.post(tableAddUrl+'/'+id,table,{
            headers:{
                Authorization:token
            }
        })
    }
    deleteTable(id){
        return axios.delete(tableDeleteUrl+'/'+id,{
            headers:{
                Authorization:token
            }
        })
    }
    updateTable(category,id){
        return axios.put(tableUpdateUrl+'/'+id,category,{
            headers:{
                Authorization:token
            }
        });
    }

}

export default new TableService();