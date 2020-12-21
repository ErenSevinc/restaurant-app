import axios from 'axios';

const url= "http://localhost:8080/getAppProperties";
const token=sessionStorage.getItem("token");
class InfoService {
    getAppProperties(tkn){
        return axios.get(url,{
            headers:{
                Authorization:tkn
            }
        });
    }
}
export default new InfoService();