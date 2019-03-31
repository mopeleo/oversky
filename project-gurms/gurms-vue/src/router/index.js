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
            path: '/error',
            component: () => import('@/views/error/index.vue'),
            children: [
                {
                    path: '401',
                    component: () => import('@/views/error/404.vue')
                },
                {
                    path: '403',
                    component: () => import('@/views/error/404.vue')
                },
                {
                    path: '404',
                    component: () => import('@/views/error/404.vue')
                },
                {
                    path: '500',
                    component: () => import('@/views/error/404.vue')
                }
            ]
        },
        {
            path: '*',
            redirect: '/error/404'
        }
    ]
})
