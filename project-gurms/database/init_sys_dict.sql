delete from sys_dict_index;
delete from sys_dict_value;

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1000, '是或否', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1000, '0', '否');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1000, '1', '是');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1001, '允许禁止', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1001, '0', '禁止');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1001, '1', '允许');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1002, '启用状态', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1002, '0', '停用');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1002, '1', '启用');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1003, '生效状态', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1003, '0', '无效');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1003, '1', '有效');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1004, '时间周期类型', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1004, '0', '天');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1004, '1', '周');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1004, '2', '月');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1004, '3', '季');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1004, '4', '年');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1005, '星期', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1005, '1', '星期一');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1005, '2', '星期二');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1005, '3', '星期三');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1005, '4', '星期四');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1005, '5', '星期五');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1005, '6', '星期六');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1005, '7', '星期天');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1006, '字典分组', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1006, '0', '系统级字典');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1006, '1', '用户相关字典');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1007, '参数分组', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1007, '0', '系统级参数');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1007, '1', '账户类参数');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1008, '操作类型', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1008, '0', '新增');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1008, '1', '修改');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1008, '2', '删除');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1009, '复核状态', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1009, '0', '未复核');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1009, '1', '复核通过');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1009, '2', '复核不通过');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1010, '结束标志', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1010, '0', '未结束');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1010, '1', '已结束');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1011, '执行标志', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1011, '0', '未执行');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1011, '1', '执行中');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1011, '2', '执行成功');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1011, '3', '执行失败');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1012, '访问方式', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1012, '0', '官方网站');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1012, '1', '手机APP');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1013, '读写标志', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1013, '0', '不可见');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1013, '1', '只读');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1013, '2', '读写');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1014, '长度标志', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1014, '0', '不固定');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1014, '1', '定长');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1015, '序列复位标志', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1015, '0', '不复位');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1015, '1', '按天复位');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1015, '2', '按月复位');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 1016, '成功失败标志', 1, '1');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1016, '0', '失败');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 1016, '1', '成功');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 2000, '性别', 1, '2');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2000, '0', '女');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2000, '1', '男');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 2001, '账户状态', 1, '2');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2001, '0', '注销');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2001, '1', '正常');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2001, '2', '密码锁定');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 2002, '学历', 1, '2');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2002, '1', '研究生');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2002, '2', '本科');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2002, '3', '专科');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2002, '4', '中专');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2002, '5', '技校');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2002, '6', '高中');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2002, '7', '初中');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2002, '8', '小学');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2002, '9', '文盲或半文盲');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 2003, '国籍', 1, '2');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2003, '156', '中国');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2003, '840', '美国');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 2004, '个人证件类型', 1, '2');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2004, '0', '身份证');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2004, '1', '户口本');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2004, '2', '护照');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2004, '3', '军官证');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2004, '4', '士兵证');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2004, '5', '港澳居民来往内地通行证');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2004, '6', '台湾同胞来往内地通行证');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2004, '7', '临时身份证');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2004, '8', '外国人居留证');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2004, '9', '警官证');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2004, 'X', '其他证件');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 2005, '机构证件类型', 1, '2');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2005, '0', '组织机构代码证');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2005, '1', '营业执照');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2005, '2', '行政机关');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2005, '3', '社会团体');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2005, '4', '军队');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2005, '5', '武警');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2005, '6', '下属机构(具有主管单位批文号)');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2005, '7', '基金会');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2005, '8', '其它');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 2006, '公私标志', 1, '2');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2006, '0', '公共');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2006, '1', '私有');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 2007, '用户类型', 1, '2');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2007, '0', '机构');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2007, '1', '个人');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 2008, '小数位数处理方式', 1, '2');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2008, '0', '四舍五入');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2008, '1', '截位');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2008, '2', '进位');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 2009, '区间头尾算法', 1, '2');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2009, '0', '不算头不算尾');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2009, '1', '算头不算尾');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2009, '2', '不算头算尾');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2009, '3', '算头算尾');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 2010, '菜单类型', 1, '2');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2010, '0', '目录');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2010, '1', '页面');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2010, '2', '页面元素');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 2011, '菜单访问权限', 1, '2');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2011, '0', '可任意访问');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2011, '1', '登录可访问');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2011, '2', '需授权访问');

insert into sys_dict_index(unioncode, dictcode, dictname, editflag, dictgroup) values ('0000', 2012, '机构类型', 1, '2');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2012, '1', '总');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2012, '2', '分');
insert into sys_dict_value(unioncode, dictcode, itemcode, itemname) values ('0000', 2012, '3', '支');

commit;


