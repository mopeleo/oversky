import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/views/Home.vue'


Vue.use(Router)

export default new Router({
    // mode: 'history',  //去掉url中的#/
    routes: [
        {
            path: '/',
            component: () => import('@/views/Login.vue')
        },
        {
            path: '/login',
            component: () => import('@/views/Login.vue')
        },
        {
            path: '/home',
            name: 'home',
            component: Home,
            children:[
                {
                    path: 'userlist',
                    component: () => import('@/views/system/user/UserList.vue')
                },
                {
                    path: 'useredit',
                    component: () => import('@/views/system/user/UserEdit.vue')
                },
                {
                    path: 'userdetail',
                    component: () => import('@/views/system/user/UserDetail.vue')
                },
                {
                    path: 'rolelist',
                    component: () => import('@/views/system/role/RoleList.vue')
                },
                {
                    path: '',
                    component: () => import('@/views/About.vue')
                }
            ]
        }
    ]
})
