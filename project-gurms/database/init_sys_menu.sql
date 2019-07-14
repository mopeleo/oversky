delete from sys_menu;

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1000', '设置', '', null, 0, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1100', '参数设置', '', '1000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1110', '数据字典', 'sysdict/list', '1100', 1, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1120', '系统参数', 'sysparam/list', '1100', 1, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1200', '角色权限', '', '1000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1210', '角色列表', 'sysrole/list', '1200', 1, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1211', '角色详情', 'sysrole/detail', '1210', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1212', '角色新增', 'sysrole/add', '1210', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1213', '角色修改', 'sysrole/update', '1210', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1214', '角色删除', 'sysrole/delete', '1210', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1220', '用户列表', 'sysuser/list', '1200', 1, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1221', '用户详情', 'sysuser/detail', '1220', 1, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1222', '用户新增', 'sysuser/add', '1220', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1223', '用户修改', 'sysuser/update', '1220', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1224', '用户删除', 'sysuser/delete', '1220', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1230', '机构维护', 'sysorg/list', '1200', 1, 1, 1, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1231', '机构新增', 'sysorg/add', '1230', 2, 1, 1, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1232', '机构修改', 'sysorg/update', '1230', 2, 1, 1, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1233', '机构删除', 'sysorg/delete', '1230', 2, 1, 1, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1240', '权限列表', 'sysmenu/list', '1200', 1, 1, 1, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1240', '权限设置', 'sysmenu/set', '1240', 2, 1, 1, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2000', '应用', '', null, 0, 1, 0, null);

commit;