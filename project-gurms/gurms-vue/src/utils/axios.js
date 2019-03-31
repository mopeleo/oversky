/**
  * axios封装
  * 请求拦截、响应拦截、错误统一处理
  */
import axios from 'axios';
// import router from '../router';
import store from '../store';
import * as tools from '@/utils/tools'


/**
  * 跳转登录页
  * 携带当前页面路由，以期在登录页面完成登录后返回当前页面
  */
/*
const toLogin = () => {
    router.replace({
        path: '/login',
        query: {
            redirect: router.currentRoute.fullPath
        }
    });
}
*/
/**
  * 请求失败后的错误统一处理
  * @param {Number} status 请求失败的状态码
  */
/*
const errorHandle = (status, other) => {
    // 状态码判断
    switch (status) {
        // 401: 未登录状态，跳转登录页
        case 401:
            toLogin();
            break;
        // 403 token过期
        // 清除token并跳转登录页
        case 403:
            tools.errTip('登录过期，请重新登录');
            localStorage.removeItem('token');
            store.commit('loginSuccess', null);
            setTimeout(() => {
                toLogin();
            }, 1000);
            break;
        // 404请求不存在
        case 404:
            tools.errTip('请求的资源不存在');
            break;
        default:
            tools.errTip(other);
    }
}
*/

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
            if(res.data && res.data.success){
                return Promise.resolve(res);
            }else{
                return Promise.reject(res);
            }
        }else{
            return Promise.reject(res);
        }
        // return res.status === 200 ? Promise.resolve(res) : Promise.reject(res);
    },
    // 请求失败
    error => {
        const { response } = error;
        if (response) {
            // 请求已发出，但是不在2xx的范围
            // errorHandle(response.status, response.data.message);
            return Promise.reject(response);
        } else {
            // 请求超时或断网时
            return Promise.reject('服务器无响应');
        }
    });

export default instance;
