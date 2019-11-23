delete from com_param;
delete from com_param_info;

insert into com_param(unioncode, paramid, paramvalue) values ('0000', 1002, '1');
insert into com_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1002, '初始/重置密码', '1', '1', '2', '', 2, '', '');

insert into com_param(unioncode, paramid, paramvalue) values ('0000', 1003, '5');
insert into com_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1003, '密码输入错误次数锁定', '5', '1', '2', '', 2, '', '');

insert into com_param(unioncode, paramid, paramvalue) values ('0000', 1004, '90');
insert into com_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1004, '密码有效期天数', '90', '1', '2', '', 2, '', '');

commit;