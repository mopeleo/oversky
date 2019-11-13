delete from com_param;
delete from com_param_info;

insert into com_param(unioncode, paramid, paramvalue) values ('0000', 1000, '0');
insert into com_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1000, '系统模式', '0', '0', '1', '', 1, '', '');

insert into com_param(unioncode, paramid, paramvalue) values ('0000', 1001, '1');
insert into com_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1001, '超级用户UserId', '1', '1', '0', '', 32, '', '');

insert into com_param(unioncode, paramid, paramvalue) values ('0000', 1002, '6');
insert into com_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1002, '密码最小长度', '6', '1', '2', '', 2, '', '');

insert into com_param(unioncode, paramid, paramvalue) values ('0000', 1003, '10');
insert into com_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1003, '密码输入错误次数锁定', '10', '1', '2', '', 2, '', '');

insert into com_param(unioncode, paramid, paramvalue) values ('0000', 1004, '90');
insert into com_param_info(paramid, paramname, initvalue, paramgroup, edittype, valuelist, valuelength, texttitle, texttail) 
values (1004, '密码有效期天数', '90', '1', '2', '', 2, '', '');

commit;