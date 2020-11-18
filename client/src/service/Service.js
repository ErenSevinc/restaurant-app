import axios from 'axios';

const product_list_base_url = "http://localhost:8080/backoffice/list";

class Service {

    listProductById(id) {
        return axios.get(product_list_base_url + '/' + id);
    }

    listProducts() {
        return axios.get(product_list_base_url);
    }
}
export default Service;