delete from sys_param;
delete from sys_param_ext;

-- 0 独立法人，数据共享，1 多法人模式，数据隔离
insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 1, '0');
insert into sys_param_ext(paramid, paramname, initvalue, distype, dictcode, valuelist, valuelength, texttitle, texttail) 
                  values (1, '系统模式', '0', 0, 0, '', 1, '', '');

insert into sys_param(unioncode, paramid, paramvalue) values ('0000', 2, '10');
insert into sys_param_ext(paramid, paramname, initvalue, distype, dictcode, valuelist, valuelength, texttitle, texttail) 
                  values (2, '密码输入错误次数锁定', '10', 2, 0, '', 10, '', '');


commit;				   