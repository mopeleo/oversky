delete from sys_param;
delete from sys_param_info;

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1000, '2');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1000, '系统模式', '1', '0', '1', '1|单法人;2|多法人', 1, '', '');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1001, '1');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1001, '超级用户UserId', '1', '1', '2', '', 32, '', '(多个用户用逗号[,]分隔)');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1002, '1');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1002, '初始/重置密码', '1', '1', '2', '', 16, '', '');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1003, '10');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1003, '密码连续错误', '10', '1', '2', '', 2, '', '次锁定账号');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1004, '90');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1004, '密码有效期天数', '90', '1', '2', '', 2, '', '');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1005, '0');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1005, '删除存在子机构的机构', '0', '1', '3', '0|不允许删除;1|删除后子机构上移;2|子机构一起删除', 1, '', '');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1006, '0');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1006, '删除存在用户的机构', '0', '1', '3', '0|不允许删除;1|删除后用户移到上级机构', 1, '', '');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1007, '1');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1007, '删除用户是删除还是注销', '1', '1', '3', '0|注销;1|删除', 1, '', '');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 2001, '7');
insert into sys_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (2001, '身份Token有效期天数', '7', '1', '2', '', 2, '', '');


commit;