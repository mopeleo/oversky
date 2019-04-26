delete from sys_param;
delete from sys_param_info;

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1000, '0');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, dictcode, valuelist, valuelength, texttitle, texttail) 
values (1000, '系统模式', '0', '0', 0, 0, '', 1, '', '');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1001, 'admin');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, dictcode, valuelist, valuelength, texttitle, texttail) 
values (1001, '超级用户', 'admin', '0', 0, 0, '', 32, '', '');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1002, '10');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, dictcode, valuelist, valuelength, texttitle, texttail) 
values (1002, '密码输入错误次数锁定', '10', '0', 2, 0, '', 2, '', '');

commit;