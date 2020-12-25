import axios from 'axios';
import {UserContext} from "../component/Login";

const customer_base_url="http://localhost:8080/customer";
const cutomer_pagination_url="http://localhost:8080/customer/search";

class CustomerSevice {

    getCustomers(tkn){
        return axios.get(customer_base_url,{
            headers: {
                Authorization: tkn
            }
        });
    }

    getSelectedCustmoer(tkn,id){
        return axios.get(customer_base_url+'/'+id,{
            headers: {
                Authorization: tkn
            }
        });
    }

    addCustomer(tkn,customer){
        return axios.post(customer_base_url,customer,{
            headers: {
                Authorization: tkn
            }
        });
    }

    updateCustomer(tkn,customer,id){
        return axios.put(customer_base_url+'/'+id,customer,{
            headers: {
                Authorization: tkn
            }
        });
    }

    deleteCustomer(tkn,id){
        return axios.delete(customer_base_url+'/'+id,{
            headers: {
                Authorization: tkn
            }
        });
    }
    getPaginatonCustmoers(tkn,pageNumber,size){
        return axios.get(cutomer_pagination_url,{
            headers: {
                Authorization: tkn
            },
            params:{
                page:pageNumber,
                size:size
            }
        });
    }
}
export default new CustomerSevice();