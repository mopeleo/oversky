/**
* gurms api接口统一管理
*/
import axios from '@/utils/axios';
// import qs from 'qs';

// const baseURL = 'http://localhost:8080';
const baseURL = '/dreamland';

export default {

    //========================================================
    // 查询字典，多个字典
    getDictMap(dictkeys){
        return axios.get(`${baseURL}/comdict/getmap`, {
            params: {dictcode: dictkeys}
        });
    },
    // 查询字典，单个字典
    getDictList(dictcode){
        return axios.get(`${baseURL}/comdict/getlist/${dictcode}`);
    },
    // 查询特殊字典
    getDictType (params) {
        return axios.post(`${baseURL}/comdict/gettype`, params);
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
    // 客户列表
    custInfoList (params) {
        return axios.post(`${baseURL}/custinfo/list`, params);
    },
    // 客户新增
    custInfoAdd (params) {
        return axios.post(`${baseURL}/custinfo/add`, params);
    },
    // 客户编辑
    custInfoUpdate (params) {
        return axios.post(`${baseURL}/custinfo/update`, params);
    },
    // 客户详情
    custInfoDetail (custno) {
        return axios.get(`${baseURL}/custinfo/detail`, {
            params: {custno: custno}
        });
    },
    // 重置密码
    custInfoResetPasswd (params) {
        return axios.post(`${baseURL}/custinfo/resetpassword`, params);
    },
    // 用户冻结
    custInfoFreeze (params) {
        return axios.post(`${baseURL}/custinfo/freeze`, params);
    },
    // 用户解冻
    custInfoUnfreeze (params) {
        return axios.post(`${baseURL}/custinfo/unfreeze`, params);
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
        return axios.get(`${baseURL}/gameinfo/detail`, {
            params: {gameid: gameid}
        });
    },
    // 游戏删除
    gameInfoDelete (params) {
        return axios.post(`${baseURL}/gameinfo/delete`, params);
    },


    //========================================================
    // 游戏角色列表
    gameActorList (params) {
        return axios.post(`${baseURL}/gameactor/list`, params);
    },
    // 游戏角色新增
    gameActorAdd (params) {
        return axios.post(`${baseURL}/gameactor/add`, params);
    },
    // 游戏角色编辑
    gameActorUpdate (params) {
        return axios.post(`${baseURL}/gameactor/update`, params);
    },
    // 游戏角色详情
    gameActorDetail (actorid) {
        return axios.get(`${baseURL}/gameactor/detail`, {
            params: {actorid: actorid}
        });
    },
    // 游戏角色删除
    gameActorDelete (params) {
        return axios.post(`${baseURL}/gameactor/delete`, params);
    },


    //========================================================
    // 游戏装备列表
    gameEquipList (params) {
        return axios.post(`${baseURL}/gameequip/list`, params);
    },
    // 游戏装备新增
    gameEquipAdd (params) {
        return axios.post(`${baseURL}/gameequip/add`, params);
    },
    // 游戏装备编辑
    gameEquipUpdate (params) {
        return axios.post(`${baseURL}/gameequip/update`, params);
    },
    // 游戏装备详情
    gameEquipDetail (equipid) {
        return axios.get(`${baseURL}/gameequip/detail`, {
            params: {equipid: equipid}
        });
    },
    // 游戏装备删除
    gameEquipDelete (params) {
        return axios.post(`${baseURL}/gameequip/delete`, params);
    },


}
