import axios from 'axios';

const waiter_list_base_url="http://localhost:8080/waiter/list";
const waiter_add_base_url="http://localhost:8080/waiter/add";
const waiter_update_base_url="http://localhost:8080/waiter/update";
const waiter_delete_base_url="http://localhost:8080/waiter/delete";

// const token=sessionStorage.getItem("token");

class WaiterService {

    getWaiter(tkn){
       return axios.get(waiter_list_base_url,{
           headers:{
               Authorization:tkn
           }
        });
    }
    getWaiterById(id,tkn){
        return axios.get(waiter_list_base_url+'/'+id,{
            headers:{
                Authorization:tkn
            }
        });
    }
    addWaiter(waiter,tkn){
        return axios.post(waiter_add_base_url,waiter,{
            headers:{
                Authorization:tkn
            }
        });
    }
    updateWaiter(waiter,tkn){
        return axios.put(waiter_update_base_url,waiter,{
            headers:{
                Authorization:tkn
            }
        });
    }
    deleteWaiter(id,tkn){
        return axios.delete(waiter_delete_base_url+'/'+id,{
            headers:{
                Authorization:tkn
            }
        });
    }

}

export default new WaiterService;