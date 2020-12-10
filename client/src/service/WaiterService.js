import axios from 'axios';

const list_waiter="http://localhost:8080/waiter/list";
class WaiterService{
    getWaiter() {
        return axios.get(list_waiter);
    }


}
export default new WaiterService;