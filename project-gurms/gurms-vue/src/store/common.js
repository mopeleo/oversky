const KEY_USER = 'userinfo';

const state = {
    user:undefined
}

const getters = {
    userinfo(state){
        if(!state.user){
            state.user = JSON.parse(sessionStorage.getItem(KEY_USER));
        }
        return state.user;
    }
}

const mutations = {
    LOGIN(state, payload){
        state.user = payload;
        sessionStorage.setItem(KEY_USER, JSON.stringify(payload));
    },
    LOGOUT(state){
        sessionStorage.removeItem(KEY_USER);
        state.user = undefined;
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
