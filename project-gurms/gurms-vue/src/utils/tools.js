/**
 * 添加动态(菜单)路由
 * @param {*} menuList 菜单列表
 * @param {*} routes 递归创建的动态(菜单)路由
 */
export function addDynamicMenuRoutes(menuList = [], routes = []) {
    var temp = [];
    for (var i = 0; i < menuList.length; i++) {
        if (menuList[i].subMenus && menuList[i].subMenus.length > 0) {
            temp = temp.concat(menuList[i].subMenus);
        } else if (menuList[i].menuurl) {
            menuList[i].menuurl = menuList[i].menuurl.replace(/^\//, '');
            // 根据菜单URL动态加载vue组件，这里要求vue组件须按照url路径存储
            // 如url="sys/user"，则组件路径应是"@/views/sys/user.vue",否则组件加载不到
            let url = menuList[i].menuurl + '.vue';
            // 创建路由配置
            var route = {
                path: menuList[i].menuurl,
                name: menuList[i].menuurl,
                component: resolve => require([`@/views/${url}`], resolve)
            }
            routes.push(route);
        }
    }
    if (temp.length > 0) {
        addDynamicMenuRoutes(temp, routes)
    }
    return routes;
}
