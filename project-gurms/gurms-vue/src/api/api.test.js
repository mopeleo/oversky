/**
* test api接口统一管理
*/
import axios from '@/utils/axios'

const baseURL = '';

const apiTest = {
    userList () {
        return axios.get(`${baseURL}/topics`);
    }
}

export default apiTest;
