/**
* gurms api接口统一管理
*/
import axios from '@/utils/axios';
// import qs from 'qs';

const baseURL = 'http://localhost:8080';
// const baseURL = '/gurms';

export default {
    // post提交
    login (params) {
        // return axios.post(`${baseURL}/login`, qs.stringify(params));
        return axios.post(`${baseURL}/login`, params);
    },
    logout (userid) {
        return axios.get(`${baseURL}/logout/${userid}`);
    },

    //========================================================
    // 用户列表
    userList (params) {
        return axios.post(`${baseURL}/sysuser/list`, params);
    },
    // 用户新增
    userAdd (params) {
        return axios.post(`${baseURL}/sysuser/add`, params);
    },
    // 用户编辑
    userUpdate (params) {
        return axios.post(`${baseURL}/sysuser/update`, params);
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
    },

    //========================================================
    // 角色列表
    roleList (params) {
        return axios.post(`${baseURL}/sysrole/list`, params);
    },
    // 角色新增
    roleAdd (params) {
        return axios.post(`${baseURL}/sysrole/add`, params);
    },
    // 角色编辑
    roleUpdate (params) {
        return axios.post(`${baseURL}/sysrole/update`, params);
    },
    // 角色详情
    roleDetail (roleid) {
        return axios.get(`${baseURL}/sysrole/detail/${roleid}`)
    },
    // 角色删除
    roleDelete (roleid) {
        return axios.get(`${baseURL}/sysrole/delete/${roleid}`);
    },
}
