import axios from 'axios';

const product_list_base_url = "http://localhost:8080/backoffice/list";
const product_add_base_url = "http://localhost:8080/backoffice/add";
const product_update_base_url = "http://localhost:8080/backoffice/update";
const product_delete_base_url = "http://localhost:8080/backoffice/delete";

class ProductService {

    getProducts(){
        return axios.get(product_list_base_url);
    }
    getProductById(id){
        return axios.get( product_list_base_url+ '/' + id);
    }
    addProduct(product){
        return axios.post(product_add_base_url,product);
    }
    updateProduct(product, id){
        return axios.put(product_update_base_url  + '/' + id, product);
    }
    deleteProduct(id){
        return axios.delete(product_delete_base_url + '/' + id);
    }
}
export default new ProductService()