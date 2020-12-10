import axios from 'axios';

const url= "http://localhost:8080/getAppProperties";
const token=sessionStorage.getItem("token");
class InfoService {
    getAppProperties(){
        return axios.get(url,{
            headers:{
                Authorization:token
            }
        });
    }
}
export default new InfoService();