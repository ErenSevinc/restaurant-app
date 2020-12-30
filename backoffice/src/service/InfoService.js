import axios from 'axios';

const url= "http://localhost:8080/getAppProperties";
const  url_bean="http://localhost:8080/beans";
const token=sessionStorage.getItem("token");
class InfoService {
    getAppProperties(tkn){
        return axios.get(url,{
            headers:{
                Authorization:tkn
            }
        });
    }
    getAllBeans(tkn){
        return axios.get(url_bean,{
            headers:{
                Authorization:tkn
            }
        })
    }
}
export default new InfoService();