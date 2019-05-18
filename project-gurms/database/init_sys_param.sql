delete from sys_param;
delete from sys_param_info;

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1000, '0');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, dictcode, valuelist, valuelength, texttitle, texttail) 
values (1000, '系统模式', '0', '0', '1', 0, '', 1, '', '');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1001, '1');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, dictcode, valuelist, valuelength, texttitle, texttail) 
values (1001, '超级用户UserId', '1', '1', '0', 0, '', 32, '', '');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1002, '6');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, dictcode, valuelist, valuelength, texttitle, texttail) 
values (1002, '密码最小长度', '6', '1', '2', 0, '', 2, '', '');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1003, '10');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, dictcode, valuelist, valuelength, texttitle, texttail) 
values (1003, '密码输入错误次数锁定', '10', '1', '2', 0, '', 2, '', '');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1004, '0');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, dictcode, valuelist, valuelength, texttitle, texttail) 
values (1004, '删除存在用户的机构', '0', '1', '2', 0, '0|不允许删除;1|删除后用户移到上级机构', 2, '', '');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1005, '0');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, dictcode, valuelist, valuelength, texttitle, texttail) 
values (1005, '删除存在子机构的机构', '0', '1', '2', 0, '0|不允许删除;1|删除后子机构上移;2|子机构一起删除', 2, '', '');

commit;