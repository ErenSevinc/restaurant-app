import axios from 'axios';

class MediaService{
    getImage(){
        return axios.get("http://localhost:8080/file/list");
    }

}

export default new MediaService();