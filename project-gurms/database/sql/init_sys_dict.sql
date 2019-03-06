delete from sys_dict_index;
delete from sys_dict_value;

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1, '账户状态', 1, '');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1, '0', '已删除');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1, '1', '正常');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1, '2', '密码锁定');

commit;
