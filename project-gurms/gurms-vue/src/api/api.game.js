/**
* gurms api接口统一管理
*/
import axios from '@/utils/axios';
// import qs from 'qs';

// const baseURL = 'http://localhost:8080';
const baseURL = '/dreamland';

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
    // 查询特殊字典
    getDictType (params) {
        return axios.post(`${baseURL}/sysdict/gettype`, params);
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
    // 序列号分页显示
    snoList (params) {
        return axios.post(`${baseURL}/syssno/list`, params);
    },
    // 序列号编辑
    snoUpdate (params) {
        return axios.post(`${baseURL}/syssno/update`, params);
    },
    // 序列号详情
    snoDetail (unioncode, noid) {
        return axios.get(`${baseURL}/syssno/detail`, {
            params: {unioncode: unioncode,noid: noid}
        });
    },


    //========================================================
    // 客户列表
    custInfoList (params) {
        return axios.post(`${baseURL}/custinfo/list`, params);
    },
    // 用户详情
    custInfoDetail (custno) {
        return axios.get(`${baseURL}/custinfo/detail`, {
            params: {custno: custno}
        });
    },
    // 修改密码
    custInfoUpdatePasswd (params) {
        return axios.post(`${baseURL}/sysuser/updatepassword`, params);
    },
    // 账号列表
    custAcctList (params) {
        return axios.post(`${baseURL}/custinfo/list`, params);
    },
    // 用户冻结
    custAcctFreeze (params) {
        return axios.post(`${baseURL}/sysuser/freeze`, params);
    },
    // 用户解冻
    custAcctUnfreeze (params) {
        return axios.post(`${baseURL}/sysuser/unfreeze`, params);
    },

    //========================================================
    // 游戏列表
    gameInfoList (params) {
        return axios.post(`${baseURL}/gameinfo/list`, params);
    },
    // 游戏新增
    gameInfoAdd (params) {
        return axios.post(`${baseURL}/gameinfo/add`, params);
    },
    // 游戏编辑
    gameInfoUpdate (params) {
        return axios.post(`${baseURL}/gameinfo/update`, params);
    },
    // 游戏详情
    gameInfoDetail (gameid) {
        return axios.get(`${baseURL}/gameinfo/detail/${gameid}`);
    },
    // 游戏删除
    gameInfoDelete (gameid) {
        return axios.get(`${baseURL}/gameinfo/delete/${gameid}`);
    },


}
