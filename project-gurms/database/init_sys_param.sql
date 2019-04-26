delete from sys_param;
delete from sys_param_info;

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1, '0');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, dictcode, valuelist, valuelength, texttitle, texttail) 
values (1, '系统模式', '0', '0', 0, 0, '', 1, '', '');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 2, '10');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, dictcode, valuelist, valuelength, texttitle, texttail) 
values (2, '密码输入错误次数锁定', '10', '0', 2, 0, '', 10, '', '');
