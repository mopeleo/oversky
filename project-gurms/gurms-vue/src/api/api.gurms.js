/**
* gurms api接口统一管理
*/
import axios from '@/utils/axios';
// import qs from 'qs';

const baseURL = 'http://localhost:8080';

export default {
    // post提交
    login (params) {
        // return axios.post(`${baseURL}/login`, qs.stringify(params));
        return axios.post(`${baseURL}/login`, params);
    },
    // 用户列表
    userList () {
        return axios.get(`${baseURL}/sysuser/list`);
    },
    // 用户详情
    userDetail (userid, params) {
        return axios.get(`${baseURL}/sysuser/${userid}`, {
            params: params
        });
    }
    // 其他接口…………
}
