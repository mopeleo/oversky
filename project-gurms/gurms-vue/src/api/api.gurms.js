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
    userList (params) {
        return axios.post(`${baseURL}/sysuser/list`, params);
    },
    // 用户编辑
    userSave (params) {
        return axios.post(`${baseURL}/sysuser/save`, params);
    },
    // 用户详情
    userDetail (userid) {
        return axios.get(`${baseURL}/sysuser/detail`, {
            params: {userid: userid}
        });
    },
    // 用户删除
    userDelete (userid) {
        return axios.get(`${baseURL}/sysuser/delete/${userid}`);
    }
    // 其他接口…………
}
