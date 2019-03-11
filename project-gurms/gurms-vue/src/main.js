import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(ElementUI, { size: 'mini'});
Vue.config.productionTip = false;

import PUBDEFINE from '@/utils/pubdefine';
Vue.prototype.$pubdefine = PUBDEFINE; //全局定义的常量

import api from './api';
Vue.prototype.$api = api; // 将api挂载到vue的原型上

// 用户手动刷新页面，这是路由会被重设，要重新新增
if (sessionStorage.getItem(PUBDEFINE.KEY_USER)) {
    store.commit('pub/ADDROUTES');
}
// 登录状态判断
router.beforeEach((to, from , next) => {
    if (!sessionStorage.getItem(PUBDEFINE.KEY_USER) && to.path !== '/login') {
        next({
            path: '/login',
            query: {redirect: to.fullPath}
        });
    } else {
        next();
    }
})

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
