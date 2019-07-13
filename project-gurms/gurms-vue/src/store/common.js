import router from '@/router'
import * as tools from '@/utils/tools'
import PUBDEFINE from '@/utils/pubdefine'
import storage from '@/utils/storage';

const state = {
    openTabs: [],
    cacheTabs: [],
    activeTab: '',
    menuCollapse: false,
    logoShow: false,
    permissions:null,
    user:undefined
}

const getters = {
    userinfo(state){
        if(!state.user){
            var localUser = storage.get(PUBDEFINE.KEY_USER);
            if(localUser){
                state.user = JSON.parse(localUser);
            }else{
                state.user = null;
            }
        }
        return state.user;
    },
    userPermission(state){
        if(!state.permissions){
            var localPermission = tools.addDynamicPermission(state.user.menuTree.subMenus);
            state.permissions = localPermission;
        }
        return state.permissions;
    },
    openTabs(state){
        if(state.openTabs.length === 0 || state.openTabs.indexOf(PUBDEFINE.NAVTAB_INDEX) === -1){
            state.openTabs.unshift(PUBDEFINE.NAVTAB_INDEX);
            if(state.openTabs.length === 0){
                state.activeTab = PUBDEFINE.NAVTAB_INDEX.tabId;
            }
            let cache_tab_name = tools.getComponentNameFromTab(PUBDEFINE.NAVTAB_INDEX);
            if(state.cacheTabs.indexOf(cache_tab_name) === -1){
                state.cacheTabs.push(cache_tab_name);
            }
        }
        return state.openTabs;
    },
    cacheTabs(state){
        return state.cacheTabs;
    }
}

const mutations = {
    LOGIN(state, payload){
        state.user = payload;
        storage.set(PUBDEFINE.KEY_USER, JSON.stringify(payload));
    },
    LOGOUT(state){
        storage.remove(PUBDEFINE.KEY_USER);
        state.user = undefined;
        state.permissions = null;
        state.openTabs = [];
        state.activeTab = '';
        state.cacheTabs = [];
    },
    ADDROUTES(state){
        if(!state.user){
            state.user = JSON.parse(storage.get(PUBDEFINE.KEY_USER));
        }
        let routes = tools.addDynamicMenuRoutes(state.user.menuTree.subMenus);
        for (var i = 0; i < routes.length; i++) {
            router.options.routes[0].children.push(routes[i]);
        }
        router.addRoutes(router.options.routes);
    },
    COLLAPSE_LEFT (state) {
        state.menuCollapse = !state.menuCollapse;
        if (state.logoShow) {
            setTimeout(function () {
                state.logoShow = false;
            }, 300);
        } else {
            state.logoShow = true;
        }
    },
    ADDTAB (state, tabObj) {
        //就是打开页
        if(state.activeTab === tabObj.tabId){
            return;
        }
        //存在，是非打开页
        for(var i = 0; i < state.openTabs.length; i++){
            if(state.openTabs[i].tabId === tabObj.tabId){
                state.activeTab = state.openTabs[i].tabId;
                // router.push({name: state.openTabs[i].routeName});
                return;
            }
        }

        if(state.openTabs.length >= PUBDEFINE.NAVTAB_SIZE){
            tools.confirmTip("打开的标签过多,将删除之前所有标签,是否继续?", ()=>{
                state.openTabs = [];
                state.cacheTabs = [];
                state.activeTab = tabObj.tabId;
                state.openTabs.push(tabObj);
                state.cacheTabs.push( tools.getComponentNameFromTab(tabObj) );
            });
        }else{
            state.activeTab = tabObj.tabId;
            state.openTabs.push(tabObj);
            state.cacheTabs.push( tools.getComponentNameFromTab(tabObj) );
        }
    },
    DELTAB (state, tabId) {
        let idx = 0;
        for(var i = 0; i < state.openTabs.length; i++){
            if(state.openTabs[i].tabId === tabId){
                break;
            }
            idx++;
        }
        state.openTabs.splice(idx, 1);
        state.cacheTabs.splice(idx, 1);
        if(state.openTabs.length == 0){
            router.push({name: PUBDEFINE.NAVTAB_INDEX.routeName});
            return;
        }
        if(tabId === state.activeTab){
            let nextTab = null;
            if(state.openTabs.length == idx){
                nextTab = state.openTabs[idx-1];
            }else{
                nextTab = state.openTabs[idx];
            }
            state.activeTab = nextTab.tabId;
            router.push({name: nextTab.routeName});
        }
    },
    DELALLTAB (state) {
        state.openTabs = [];
        state.activeTab = '';
        state.cacheTabs = [];
    },
    DELOTHERTAB (state, tabId) {
        let selectTab = null;
        for(var i = 0; i < state.openTabs.length; i++){
            if(state.openTabs[i].tabId === tabId){
                selectTab = state.openTabs[i];
                break;
            }
        }

        state.openTabs = [];
        state.cacheTabs = [];

        state.openTabs.push(selectTab);
        state.activeTab = selectTab.tabId;
        state.cacheTabs.push( tools.getComponentNameFromTab(selectTab) );
        router.push({name: selectTab.routeName});
    },
    CHANGETAB (state, tabId) {
        for(var i = 0; i < state.openTabs.length; i++){
            var m = state.openTabs[i];
            if(m.tabId === tabId){
                state.activeTab = m.tabId;
                router.push({name: m.routeName});
                break;
            }
        }
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
