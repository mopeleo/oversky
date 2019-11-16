/**
  * axios封装
  * 请求拦截、响应拦截、错误统一处理
  */
import axios from 'axios';
import store from '../store';
import router from '../router';
import * as tools from '@/utils/tools';
import PUBDEFINE from '@/utils/pubdefine';


// 创建axios实例
var instance = axios.create({
    timeout: 1000 * 12,
    responseType: 'json',
    withCredentials: true  // 是否允许带cookie这些
});
// 设置post请求头
instance.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
/**
  * 请求拦截器
  * 每次请求前，如果存在token则在请求头中携带token
  */
instance.interceptors.request.use(
    config => {
        // 登录流程控制中，根据本地是否存在token判断用户的登录情况
        // 但是即使token存在，也有可能token是过期的，所以在每次的请求头中携带token
        // 后台根据携带的token判断用户的登录情况，并返回给我们对应的状态码
        // 而后我们可以在响应拦截器中，根据状态码进行一些统一的操作。
        const localUser = store.getters['pub/userinfo'];

        if(localUser && localUser.token){
            config.headers.Authorization = localUser.token;
        }
        // //添加全局参数
        if(config.method == 'post'){
            if(localUser){
                if(!config.data.operator){
                    config.data.operator = localUser.userid;
                }
                if(!config.data.unioncode){
                    config.data.unioncode = localUser.unioncode;
                }
            }
            if(!config.data.channelType){
                config.data.channelType = PUBDEFINE.CHANNEL_TYPE;
            }
        }
        if(config.method == 'get'){
            if(config.params){
                if(localUser){
                    if(!config.params.operator){
                        config.params.operator = localUser.userid;
                    }
                    if(!config.params.unioncode){
                        config.params.unioncode = localUser.unioncode;
                    }
                }
                if(!config.params.channelType){
                    config.params.channelType = PUBDEFINE.CHANNEL_TYPE;
                }
            }else{
                if(localUser){
                    config.params = {
                        operator : localUser.userid,
                        unioncode: localUser.unioncode,
                        channelType : PUBDEFINE.CHANNEL_TYPE,
                        ...config.params
                    }
                }else{
                    config.params = {
                        channelType : PUBDEFINE.CHANNEL_TYPE,
                        ...config.params
                    }
                }
            }
        }

        return config;
    },
    error => {
        tools.errTip('请求超时！');
        return Promise.reject(error);
    });

// 响应拦截器
instance.interceptors.response.use(
    // 请求成功
    res => {
        if(res.status === 200){
            // tools.errTip(JSON.stringify(res));
            if(res.data && (res.data === true || res.data.returncode === PUBDEFINE.RETURN_CODE_SUCCESS)){
                return Promise.resolve(res.data);
            }else{
                return Promise.reject(res.data.returnmsg);
            }
        }else{
            return Promise.reject(res.data.returnmsg);
        }
        // return res.status === 200 ? Promise.resolve(res) : Promise.reject(res);
    },
    // 默认除了2XX之外的都是错误的，就会走这里
    error => {
        const { response } = error;
        if (response) {
            var resMsg = response.data ? response.data.returnmsg : response.message;
            // alert(JSON.stringify(response));
            // 状态码判断
            switch (response.status) {
                // 401: 未登录状态，跳转登录页
                case 401:
                    store.commit('pub/LOGOUT');
                    tools.toLogin();
                    break;
                // 404: 未找到或需要授权
                case 404:
                    router.replace({name: 'error404', params: {message: resMsg}});
                    break;
                case 500:
                    if(!resMsg){
                        resMsg = "服务器无响应";
                    }
                    break;
                default:
                    break;
            }
            return Promise.reject(resMsg);
        } else {
            // 请求超时或断网时
            return Promise.reject('服务器无响应');
        }
    });

export default instance;
