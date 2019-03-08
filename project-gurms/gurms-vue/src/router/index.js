import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/views/Home.vue'


Vue.use(Router)

export default new Router({
    // mode: 'history',  //去掉url中的#/
    routes: [
        {
            path: '/home',
            name: 'home',
            component: Home,
            children:[
                {
                    path: '',
                    component: () => import('@/views/About.vue')
                }
            ]
        },
        {
            path: '/',
            redirect: '/login'
        },
        {
            path: '/login',
            component: () => import('@/views/Login.vue')
        }
    ]
})
