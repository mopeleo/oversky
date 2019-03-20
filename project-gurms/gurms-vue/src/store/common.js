import router from '@/router'
import * as tools from '@/utils/tools'
import PUBDEFINE from '@/utils/pubdefine'

const state = {
    user:undefined,
    network:true
}

const getters = {
    userinfo(state){
        if(!state.user){
            state.user = JSON.parse(sessionStorage.getItem(PUBDEFINE.KEY_USER));
        }
        return state.user;
    }
}

const mutations = {
    LOGIN(state, payload){
        state.user = payload;
        sessionStorage.setItem(PUBDEFINE.KEY_USER, JSON.stringify(payload));
    },
    LOGOUT(state){
        sessionStorage.removeItem(PUBDEFINE.KEY_USER);
        state.user = undefined;
    },
    ADDROUTES(state){
        if(!state.user){
            state.user = JSON.parse(sessionStorage.getItem(PUBDEFINE.KEY_USER));
        }
        let routes = tools.addDynamicMenuRoutes(state.user.menuTree.subMenus);
        for (var i = 0; i < routes.length; i++) {
            router.options.routes[0].children.push(routes[i]);
        }
        router.addRoutes(router.options.routes);
    },
    CHANGENETWORK(state, status){
        state.network = status;
    }
}

const actions = {

}

export default {
    namespaced: true,
    state,
    getters,
    mutations,
    actions
}
