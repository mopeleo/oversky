/**
* gurms api接口统一管理
*/
import axios from '@/utils/axios';
// import qs from 'qs';

// const baseURL = 'http://localhost:8080';
const baseURL = '/gurms';

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
    // 查询字典，多个字典
    getDictMap(dictkeys, unioncode){
        if(unioncode){
            return axios.get(`${baseURL}/sysdict/getmap`, {
                params: {dictcode: dictkeys, unioncode: unioncode}
            });
        }else{
            return axios.get(`${baseURL}/sysdict/getmap`, {
                params: {dictcode: dictkeys}
            });
        }
    },
    // 查询字典，单个字典
    getDictList(dictcode, unioncode){
        return axios.get(`${baseURL}/sysdict/getlist/${dictcode}/${unioncode}`);
    },
    // 字典分页显示
    dictPage (params) {
        return axios.post(`${baseURL}/sysdict/list`, params);
    },

    //========================================================
    // 查询参数，多个参数
    getParamList(paramids, unioncode){
        return axios.get(`${baseURL}/sysparam/getlist`, {
            params: {paramids: paramids, unioncode: unioncode}
        });
    },
    // 查询参数，单个参数
    getParam(paramid, unioncode){
        return axios.get(`${baseURL}/sysparam/getparam/${paramid}/${unioncode}`);
    },
    // 参数展示
    paramPage (unioncode) {
        return axios.get(`${baseURL}/sysparam/page/${unioncode}`);
    },
    // 参数修改
    paramUpdate (unioncode, paramlist) {
        return axios.post(`${baseURL}/sysparam/update`, {paramlist: paramlist, unioncode: unioncode});
    },
    // 参数重置
    paramReset (unioncode) {
        return axios.get(`${baseURL}/sysparam/reset/${unioncode}`);
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
    // 用户分配角色
    userGrantRoles (params) {
        return axios.post(`${baseURL}/sysuser/grantrole`, params);
    },
    // 用户冻结
    userFreeze (params) {
        return axios.post(`${baseURL}/sysuser/freeze`, params);
    },
    // 用户解冻
    userUnfreeze (params) {
        return axios.post(`${baseURL}/sysuser/unfreeze`, params);
    },
    // 用户解冻
    userResetPassword (params) {
        return axios.post(`${baseURL}/sysuser/resetpassword`, params);
    },
    // 用户详情
    userDetail (userid) {
        return axios.get(`${baseURL}/sysuser/detail`, {
            params: {userid: userid}
        });
    },
    // 用户删除
    userDelete (params) {
        return axios.post(`${baseURL}/sysuser/delete`, params);
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
        return axios.get(`${baseURL}/sysrole/detail/${roleid}`);
    },
    // 角色删除
    roleDelete (roleid) {
        return axios.get(`${baseURL}/sysrole/delete/${roleid}`);
    },
    // 可授权的角色
    canGrantRoles (userid, unioncode) {
        return axios.get(`${baseURL}/sysrole/cangrantroles`, {
            params: {userid: userid, unioncode: unioncode}
        });
    },
    // 已授权的角色
    hasRoles (userid, unioncode) {
        return axios.get(`${baseURL}/sysrole/hasroles`, {
            params: {userid: userid, unioncode: unioncode}
        });
    },

    //========================================================
    // 机构树列表
    orgTree (params) {
        return axios.post(`${baseURL}/sysorg/tree`, params);
    },
    // 机构新增
    orgAdd (params) {
        return axios.post(`${baseURL}/sysorg/add`, params);
    },
    // 机构编辑
    orgUpdate (params) {
        return axios.post(`${baseURL}/sysorg/update`, params);
    },
    // 机构详情
    orgDetail (orgid) {
        return axios.get(`${baseURL}/sysorg/detail/${orgid}`);
    },
    // 机构删除
    orgDelete (params) {
        return axios.post(`${baseURL}/sysorg/delete`, params);
    },


    //========================================================
    // 菜单列表
    menuTree (params) {
        return axios.post(`${baseURL}/sysmenu/tree`, params);
    },
    // 菜单详情
    menuDetail (menuid) {
        return axios.get(`${baseURL}/sysmenu/detail/${menuid}`);
    },





}
