delete from sys_menu;

INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1000', 1, '设置', '', null, 0, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1100', 1, '参数设置', '', '1000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1110', 1, '数据字典', 'sysdict/list', '1100', 1, 1, 2, null);
                                                                                                                 
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1120', 1, '系统参数', 'sysparam/list', '1100', 1, 1, 2, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1121', 1, '参数修改', 'sysparam/update', '1120', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1122', 1, '参数初始化', 'sysparam/reset', '1120', 2, 1, 2, null);
                                                                                                                    
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1130', 1, '序列号维护', 'syssno/list', '1100', 1, 1, 2, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1131', 1, '序列号修改', 'syssno/update', '1130', 2, 1, 2, null);
                                                                                                                    
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1200', 1, '角色权限', '', '1000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1210', 1, '角色列表', 'sysrole/list', '1200', 1, 1, 2, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1211', 1, '角色详情', 'sysrole/detail', '1210', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1212', 1, '角色新增', 'sysrole/add', '1210', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1213', 1, '角色修改', 'sysrole/update', '1210', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1214', 1, '角色删除', 'sysrole/delete', '1210', 2, 1, 2, null);
                                                                                                                 
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1220', 1, '用户列表', 'sysuser/list', '1200', 1, 1, 2, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1221', 1, '用户详情', 'sysuser/detail', '1220', 1, 1, 2, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1222', 1, '用户新增', 'sysuser/add', '1220', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1223', 1, '用户修改', 'sysuser/update', '1220', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1224', 1, '用户删除', 'sysuser/delete', '1220', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1225', 1, '分配角色', 'sysuser/grantrole', '1220', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1226', 1, '重置密码', 'sysuser/resetpassword', '1220', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1227', 1, '冻结用户', 'sysuser/freeze', '1220', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1228', 1, '解冻用户', 'sysuser/unfreeze', '1220', 2, 1, 2, null);
                                                                                                                           
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1230', 1, '机构维护', 'sysorg/list', '1200', 1, 1, 1, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1231', 1, '机构新增', 'sysorg/add', '1230', 2, 1, 1, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1232', 1, '机构修改', 'sysorg/update', '1230', 2, 1, 1, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1233', 1, '机构删除', 'sysorg/delete', '1230', 2, 1, 1, null);
                                                                                                                           
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1240', 1, '菜单权限', 'sysmenu/list', '1200', 1, 1, 1, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1241', 1, '菜单设置', 'sysmenu/set', '1240', 2, 1, 1, null);
                                                                                                                           
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1300', 1, '复核设置', '', '1000', 0, 1, 0, null);
                                                                                                                          
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1400', 1, '日常', '', '1000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1410', 1, '我的日历', 'syswork/calendar', '1400', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1420', 1, '待办事项', 'syswork/todo', '1400', 0, 1, 0, null);
                                                                                                                          
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1900', 1, '查询', '', '1000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1910', 1, '登录日志', 'syslog/login', '1900', 0, 1, 0, null);
                                                                                                                          
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2000', 2, '游戏管理系统', '', null, 0, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2100', 2, '客户', '', '2000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2110', 2, '客户管理', 'custinfo/list', '2100', 1, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2111', 2, '客户详情', 'custinfo/detail', '2110', 2, 1, 0, null);                                                                                                                      
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2112', 2, '客户冻结', 'custinfo/freeze', '2110', 2, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2113', 2, '客户解冻', 'custinfo/unfreeze', '2110', 2, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2114', 2, '密码重置', 'custinfo/resetpassword', '2110', 2, 1, 0, null);
                                                                                                                      
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2200', 2, '游戏中心', '', '2000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2210', 2, '游戏管理', 'gameinfo/list', '2200', 1, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2211', 2, '游戏详情', 'gameinfo/detail', '2210', 2, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2212', 2, '游戏新增', 'gameinfo/add', '2210', 2, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2213', 2, '游戏修改', 'gameinfo/update', '2210', 2, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2214', 2, '游戏删除', 'gameinfo/delete', '2210', 2, 1, 0, null);
                                                                                                                    
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2220', 2, '场景维护', '', '2200', 1, 1, 0, null);
                                                                                                                   
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2230', 2, '角色维护', '', '2200', 1, 1, 0, null);
                                                                                                                  
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2240', 2, '装备维护', '', '2200', 1, 1, 0, null);
                                                                                                                      
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2250', 2, '道具维护', '', '2200', 1, 1, 0, null);
                                                                                                                    
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2300', 2, '运营', '', '2000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2400', 2, '复核', '', '2000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, sysid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2500', 2, '查询', '', '2000', 0, 1, 0, null);

commit;