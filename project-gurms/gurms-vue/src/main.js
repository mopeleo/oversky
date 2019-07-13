import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import i18n from './i18n/i18n'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'font-awesome/css/font-awesome.css'
import './assets/iconfont/iconfont.css'
import './assets/style/index.scss' // 自定义样式

Vue.config.productionTip = false;
Vue.use(ElementUI, { size: 'medium' });

import api from './api';
Vue.prototype.$api = api; // 将api挂载到vue的原型上

import PUBDEFINE from './utils/pubdefine';
Vue.prototype.$pubdefine = PUBDEFINE; //全局定义的常量

import permissions from './utils/permission';
Vue.prototype.$permission = permissions;
Vue.directive('permission', {
    inserted: function(el, binding) {
        let menus = store.getters['pub/userinfo'].menuTree.subMenus;
        let menu = menus.find((menu) => menu.menuid === binding.value);
        if (!menu) {
            el.parentNode.removeChild(el);
        }
    }
});

import storage from './utils/storage';
// 用户手动刷新页面，这是路由会被重设，要重新新增
if (storage.get(PUBDEFINE.KEY_USER)) {
    store.commit('pub/ADDROUTES');
}

// 登录状态判断
router.beforeEach((to, from, next) => {
    //刷新后标签生成标签
    if (to.meta && to.meta.menuid) {
        store.commit('pub/ADDTAB', {
            tabId: to.meta.menuid,
            tabName: to.meta.menuname,
            routeName: to.name
        });
    }
    if (to.meta && to.meta.accesstype && to.meta.accesstype !== '0') {
        // alert(JSON.stringify(to.params));
        // if(to.params){
        //     to.params['resourceid'] = to.meta.menuid;
        // }else{
        //     to.params = {'resourceid' : to.meta.menuid};
        // }
        const token = storage.get(PUBDEFINE.KEY_USER);
        if (token) { //判断用户是否登录
            if (Object.keys(from.query).length === 0) { //判断路由来源是否有query，处理不是目的跳转的情况
                next();
            } else {
                let redirect = from.query.redirect //如果来源路由有query
                if (to.path === redirect) { //这行是解决next无限循环的问题
                    next();
                } else {
                    next({ path: redirect }); //跳转到目的路由
                }
            }
        } else {
            if (to.path === "/login") {
                next();
            } else {
                next({
                    path: "/login",
                    query: { redirect: to.fullPath } //将目的路由地址存入login的query中
                });
            }
        }

    } else {
        next();
    }

});

new Vue({
    router,
    store,
    i18n,
    render: h => h(App)
}).$mount('#app');
