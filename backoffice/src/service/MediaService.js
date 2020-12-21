import axios from 'axios';

class MediaService{
    getImage(tkn){
        return axios.get("http://localhost:8080/file/list",{
            headers:{
                Authorization: tkn
            }
        });
    }

}
export default new MediaService();