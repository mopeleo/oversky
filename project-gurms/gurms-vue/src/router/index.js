import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/views/Home.vue'


Vue.use(Router)

export default new Router({
    // mode: 'history',  //去掉url中的#/
    routes: [
        {
            path: '/home',
            // name: 'home',
            component: Home,
            children:[
                {
                    path: '',
                    component: () => import('@/views/About.vue')
                },
                {
                    path: 'about',
                    name: 'about',
                    component: () => import('@/views/About.vue')
                },
                {
                    path: '404',
                    name: 'error404',
                    component: () => import('@/views/error/404.vue')
                },
                {
                    path: '500',
                    name: 'error500',
                    component: () => import('@/views/error/500.vue')
                }
            ]
        },
        {
            path: '/refresh',
            component: () => import('@/views/Refresh.vue')
        },
        {
            path: '/',
            redirect: '/login'
        },
        {
            path: '/login',
            component: () => import('@/views/Login.vue')
        },
        {
            path: '*',
            redirect: '/home/404'
        }
    ]
})
