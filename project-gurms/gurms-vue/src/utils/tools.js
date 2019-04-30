import { Message,MessageBox } from "element-ui";
import router from '../router';

/**
  * 跳转登录页
  * 携带当前页面路由，以期在登录页面完成登录后返回当前页面
  */
export function toLogin() {
    router.replace({
        path: '/login',
        query: {
            redirect: router.currentRoute.fullPath
        }
    });
}

/**
* 错误弹窗提示信息
*/
export function errTip(msg){
    Message({
        showClose: true,     //是否显示关闭按钮,默认false
        message: msg,        //消息文字
        duration: 0,         //显示时间, 毫秒。设为 0 则不会自动关闭,默认3000
        center: true,        //文字是否居中,默认 false
        type: 'error'        //消息类型，success/warning/info/error默认info
    });
}

export function succTip(msg){
    Message({
        showClose: true,     //是否显示关闭按钮,默认false
        message: msg,        //消息文字
        center: true,        //文字是否居中,默认 false
        type: 'success'        //消息类型，success/warning/info/error默认info
    });
}

export function confirmTip(msg, callback){
    MessageBox.confirm(msg, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
    }).then(()=>{
        callback();
    });
}

/**
 * 添加动态(菜单)路由
 * @param {*} menuList 菜单列表
 * @param {*} routes 递归创建的动态(菜单)路由
 */
export function addDynamicMenuRoutes(menuList = [], routes = []) {
    var temp = [];
    for (var i = 0; i < menuList.length; i++) {
        if (menuList[i].menuurl) {
            menuList[i].menuurl = menuList[i].menuurl.replace(/^\//, '');
            // 根据菜单URL动态加载vue组件，这里要求vue组件须按照url路径存储
            // 如url="sys/user"，则组件路径应是"@/views/sys/user.vue",否则组件加载不到
            let url = menuList[i].menuurl + '.vue';
            // 创建路由配置
            var route = {
                path: menuList[i].menuurl,
                name: menuList[i].menuurl,
                meta:{menuid: menuList[i].menuid, menuname: menuList[i].menuname, menutype: menuList[i].menutype, accesstype: menuList[i].accesstype},
                component: () => import(`@/views/${url}`)
                // component: resolve => require([`@/views/${url}`], resolve)
            }
            routes.push(route);
        }
        if (menuList[i].subMenus && menuList[i].subMenus.length > 0) {
            temp = temp.concat(menuList[i].subMenus);
        }
    }
    if (temp.length > 0) {
        addDynamicMenuRoutes(temp, routes)
    }
    return routes;
}

//根据菜单获取组件页面的name
//routeName : sysuser/list ==> sysuser_list
export function getComponentNameFromTab(tab) {
    var routeName = '';
    if(tab && tab.routeName){
        routeName = tab.routeName.replace(/\//, '_');
    }
    return routeName;
}
