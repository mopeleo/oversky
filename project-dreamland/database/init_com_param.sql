delete from com_param;
delete from com_param_info;

insert into com_param(unioncode, paramid, paramvalue) values ('0000', 2002, '1');
insert into com_param_info(paramid, paramname, initvalue, edittype, valuelist, valuelength, texttitle, texttail) 
values (2002, '初始/重置密码', '1', '2', '', 16, '', '');

insert into com_param(unioncode, paramid, paramvalue) values ('0000', 2003, '5');
insert into com_param_info(paramid, paramname, initvalue, edittype, valuelist, valuelength, texttitle, texttail) 
values (2003, '密码输入错误次数锁定', '5', '2', '', 2, '', '');

insert into com_param(unioncode, paramid, paramvalue) values ('0000', 2004, '90');
insert into com_param_info(paramid, paramname, initvalue, edittype, valuelist, valuelength, texttitle, texttail) 
values (2004, '密码有效期天数', '90', '2', '', 4, '', '');

commit;