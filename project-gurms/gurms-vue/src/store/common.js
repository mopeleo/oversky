import router from '@/router'
import * as tools from '@/utils/tools'
import PUBDEFINE from '@/utils/pubdefine'

const state = {
    indexTab:{
        tabId: 'index',
        tabName: '首页',
        routeName: 'about'
    },
    openTabs: [],
    cacheTabs: [],
    activeTab: '',
    user:undefined
}

const getters = {
    userinfo(state){
        if(!state.user){
            var localUser = localStorage.getItem(PUBDEFINE.KEY_USER);
            if(localUser){
                state.user = JSON.parse(localUser);
            }else{
                state.user = null;
            }
        }
        return state.user;
    },
    cacheTabs(state){
        return state.cacheTabs;
    }
}

const mutations = {
    LOGIN(state, payload){
        state.user = payload;
        localStorage.setItem(PUBDEFINE.KEY_USER, JSON.stringify(payload));
        //tab
        state.openTabs.push(state.indexTab);
        state.activeTab = state.indexTab.tabId;
        let cname = tools.getComponentNameFromTab(state.indexTab);
        state.cacheTabs.push(cname);
    },
    LOGOUT(state){
        localStorage.removeItem(PUBDEFINE.KEY_USER);
        state.user = undefined;
        state.openTabs = [];
        state.activeTab = '';
        state.cacheTabs = [];
    },
    ADDROUTES(state){
        if(!state.user){
            state.user = JSON.parse(localStorage.getItem(PUBDEFINE.KEY_USER));
        }
        let routes = tools.addDynamicMenuRoutes(state.user.menuTree.subMenus);
        for (var i = 0; i < routes.length; i++) {
            router.options.routes[0].children.push(routes[i]);
        }
        router.addRoutes(router.options.routes);
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

        if(state.openTabs.length >= 10){
            tools.confirmTip("打开的标签过多,将删除之前所有标签,是否继续?", function(){
                state.openTabs = [];
                state.openTabs.push(state.indexTab);
                state.openTabs.push(tabObj);
                state.activeTab = tabObj.tabId;

                state.cacheTabs = [];
                state.cacheTabs.push( tools.getComponentNameFromTab(state.indexTab) );
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
            state.activeTab = state.indexTab.tabId;
            state.openTabs.push(state.indexTab);
            state.cacheTabs.push( tools.getComponentNameFromTab(state.indexTab) );
            router.push({name: state.indexTab.routeName});
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
