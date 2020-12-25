import axios from 'axios';
import {UserContext} from "../component/Login";

const customer_base_url="http://localhost:8080/customer";
const cutomer_pagination_url="http://localhost:8080/customer/search";

class CustomerSevice {
    addCustomer(customer){
        return axios.post(customer_base_url,customer,{
            // headers: {
            //     Authorization: tkn
            // }
        });
    }

    getPaginatonCustmoers(pageNumber,size){
        return axios.get(cutomer_pagination_url,{
            // headers: {
            //     Authorization: tkn
            // },
            params:{
                page:pageNumber,
                size:size
            }
        });
    }
}
export default new CustomerSevice();