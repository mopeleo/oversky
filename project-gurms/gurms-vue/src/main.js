import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(ElementUI, { size: 'mini'});
Vue.config.productionTip = false;

import api from './api'
Vue.prototype.$api = api; // 将api挂载到vue的原型上

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
