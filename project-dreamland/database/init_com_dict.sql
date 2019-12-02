delete from com_dict;


-- 2000 性别
insert into com_dict(dictcode, itemcode, itemname) values (2000, '0', '女');
insert into com_dict(dictcode, itemcode, itemname) values (2000, '1', '男');

-- 2001 账户状态
insert into com_dict(dictcode, itemcode, itemname) values (2001, '1', '正常');
insert into com_dict(dictcode, itemcode, itemname) values (2001, '2', '密码锁定');
insert into com_dict(dictcode, itemcode, itemname) values (2001, '3', '冻结');

-- 2002 学历
insert into com_dict(dictcode, itemcode, itemname) values (2002, '1', '研究生');
insert into com_dict(dictcode, itemcode, itemname) values (2002, '2', '本科');
insert into com_dict(dictcode, itemcode, itemname) values (2002, '3', '专科');
insert into com_dict(dictcode, itemcode, itemname) values (2002, '4', '中专');
insert into com_dict(dictcode, itemcode, itemname) values (2002, '5', '技校');
insert into com_dict(dictcode, itemcode, itemname) values (2002, '6', '高中');
insert into com_dict(dictcode, itemcode, itemname) values (2002, '7', '初中');
insert into com_dict(dictcode, itemcode, itemname) values (2002, '8', '小学');
insert into com_dict(dictcode, itemcode, itemname) values (2002, '9', '文盲或半文盲');

-- 2003 国籍
insert into com_dict(dictcode, itemcode, itemname) values (2003, '156', '中国');
insert into com_dict(dictcode, itemcode, itemname) values (2003, '840', '美国');

-- 2004 个人证件类型
insert into com_dict(dictcode, itemcode, itemname) values (2004, '0', '身份证');
insert into com_dict(dictcode, itemcode, itemname) values (2004, '1', '户口本');
insert into com_dict(dictcode, itemcode, itemname) values (2004, '2', '护照');
insert into com_dict(dictcode, itemcode, itemname) values (2004, '3', '军官证');
insert into com_dict(dictcode, itemcode, itemname) values (2004, '4', '士兵证');
insert into com_dict(dictcode, itemcode, itemname) values (2004, '5', '港澳居民来往内地通行证');
insert into com_dict(dictcode, itemcode, itemname) values (2004, '6', '台湾同胞来往内地通行证');
insert into com_dict(dictcode, itemcode, itemname) values (2004, '7', '临时身份证');
insert into com_dict(dictcode, itemcode, itemname) values (2004, '8', '外国人居留证');
insert into com_dict(dictcode, itemcode, itemname) values (2004, '9', '警官证');
insert into com_dict(dictcode, itemcode, itemname) values (2004, 'X', '其他证件');

-- 2005 机构证件类型
insert into com_dict(dictcode, itemcode, itemname) values (2005, '0', '组织机构代码证');
insert into com_dict(dictcode, itemcode, itemname) values (2005, '1', '营业执照');
insert into com_dict(dictcode, itemcode, itemname) values (2005, '2', '行政机关');
insert into com_dict(dictcode, itemcode, itemname) values (2005, '3', '社会团体');
insert into com_dict(dictcode, itemcode, itemname) values (2005, '4', '军队');
insert into com_dict(dictcode, itemcode, itemname) values (2005, '5', '武警');
insert into com_dict(dictcode, itemcode, itemname) values (2005, '6', '下属机构(具有主管单位批文号)');
insert into com_dict(dictcode, itemcode, itemname) values (2005, '7', '基金会');
insert into com_dict(dictcode, itemcode, itemname) values (2005, '8', '其它');

-- 2007 用户类型
insert into com_dict(dictcode, itemcode, itemname) values (2007, '0', '机构');
insert into com_dict(dictcode, itemcode, itemname) values (2007, '1', '个人');

-- 2008 小数位数处理方式
insert into com_dict(dictcode, itemcode, itemname) values (2008, '0', '四舍五入');
insert into com_dict(dictcode, itemcode, itemname) values (2008, '1', '截位');
insert into com_dict(dictcode, itemcode, itemname) values (2008, '2', '进位');

-- 2009 区间头尾算法
insert into com_dict(dictcode, itemcode, itemname) values (2009, '0', '不算头不算尾');
insert into com_dict(dictcode, itemcode, itemname) values (2009, '1', '算头不算尾');
insert into com_dict(dictcode, itemcode, itemname) values (2009, '2', '不算头算尾');
insert into com_dict(dictcode, itemcode, itemname) values (2009, '3', '算头算尾');

-- 2010 菜单类型
insert into com_dict(dictcode, itemcode, itemname) values (2010, '0', '目录');
insert into com_dict(dictcode, itemcode, itemname) values (2010, '1', '页面');
insert into com_dict(dictcode, itemcode, itemname) values (2010, '2', '页面元素');

-- 2011 菜单访问权限
insert into com_dict(dictcode, itemcode, itemname) values (2011, '0', '可任意访问');
insert into com_dict(dictcode, itemcode, itemname) values (2011, '1', '登录可访问');
insert into com_dict(dictcode, itemcode, itemname) values (2011, '2', '需授权访问');

-- 2012 机构类型
insert into com_dict(dictcode, itemcode, itemname) values (2012, '1', '总');
insert into com_dict(dictcode, itemcode, itemname) values (2012, '2', '分');
insert into com_dict(dictcode, itemcode, itemname) values (2012, '3', '支');

-- 2013 客户级别
insert into com_dict(dictcode, itemcode, itemname) values (2013, '1', '初级');
insert into com_dict(dictcode, itemcode, itemname) values (2013, '2', '中级');
insert into com_dict(dictcode, itemcode, itemname) values (2013, '3', '高级');

-- 2014 游戏状态
insert into com_dict(dictcode, itemcode, itemname) values (2014, '1', '立项');
insert into com_dict(dictcode, itemcode, itemname) values (2014, '2', '开发');
insert into com_dict(dictcode, itemcode, itemname) values (2014, '3', '内测');
insert into com_dict(dictcode, itemcode, itemname) values (2014, '4', '公测');

commit;


