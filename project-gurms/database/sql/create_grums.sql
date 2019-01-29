/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/1/29 9:46:39                            */
/*==============================================================*/


drop table if exists sys_dict_index;

drop table if exists sys_dict_value;

drop table if exists sys_log_login;

drop table if exists sys_menu;

drop table if exists sys_org;

drop table if exists sys_param;

drop table if exists sys_param_ext;

drop table if exists sys_role;

drop table if exists sys_role_menu;

drop table if exists sys_user;

drop table if exists sys_user_info;

drop table if exists sys_user_role;

/*==============================================================*/
/* Table: sys_dict_index                                        */
/*==============================================================*/
create table sys_dict_index
(
   unioncode            varchar(4) not null default '0000',
   dictcode             numeric(4,0) not null default 0 comment '字典代码',
   dictname             varchar(32) not null comment '字典名称',
   dictgroup            char(1) not null default '0' comment '所属分组',
   editflag             numeric(1,0) not null default 0 comment '是否可编辑（0-不可见，1-只读，2-读写）',
   primary key (dictcode, unioncode)
);

/*==============================================================*/
/* Table: sys_dict_value                                        */
/*==============================================================*/
create table sys_dict_value
(
   unioncode            varchar(4) not null default '0000',
   dictcode             numeric(4,0) not null default 0 comment '字典代码',
   itemcode             varchar(8) not null comment '选项代码',
   itemname             varchar(32) not null comment '选项名称',
   primary key (dictcode, itemcode, unioncode)
);

/*==============================================================*/
/* Table: sys_log_login                                         */
/*==============================================================*/
create table sys_log_login
(
   logid                char(32) not null,
   userid               numeric(10,0) not null default 0,
   logindate            varchar(8) comment '登录日期',
   logintime            varchar(6) comment '登录时间',
   loginpasswd          char(32) not null comment '登录密码',
   loginip              varchar(16) comment '登录IP',
   logintype            numeric(1,0) not null default 0 comment '登录方式（1-pc，2-手机）',
   loginresult          numeric(1,0) not null default 0 comment '登录是否成功 0-失败，1-成功',
   primary key (logid)
);

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu
(
   menuid               varchar(8) not null comment '菜单ID',
   menuname             varchar(16) not null comment '菜单名称',
   menuurl              varchar(32) not null comment '菜单地址',
   parentmenu           varchar(8) comment '上级菜单',
   menutype             numeric(1,0) not null default 0 comment '菜单类型0-目录，1-菜单，2-页面链接',
   opentype             numeric(1,0) not null default 0 comment '打开方式，0-本页刷新，1-打开新页，2-弹出窗口',
   status               numeric(1,0) not null default 0 comment '菜单状态，0-无效，1-有效',
   primary key (menuid)
);

/*==============================================================*/
/* Table: sys_org                                               */
/*==============================================================*/
create table sys_org
(
   orgid                varchar(8) not null comment '机构ID',
   unioncode            varchar(4) not null default '0000',
   shortname            varchar(16) not null comment '机构简称',
   fullname             varchar(32) comment '机构全称',
   linkman              varchar(32) comment '联系人',
   linktel              varchar(16) comment '联系电话',
   faxno                varchar(16) comment '传真',
   address              varchar(64) comment '联系地址',
   postcode             varchar(8) comment '邮政编码',
   email                varchar(64) comment '电子邮件',
   parentorg            varchar(8) not null comment '上级机构',
   orgtype              numeric(1,0) not null default 0 comment '机构类型(0-虚拟，可选，1-总，2-分，3-支)',
   remark               varchar(32) comment '备注',
   primary key (orgid)
);

/*==============================================================*/
/* Table: sys_param                                             */
/*==============================================================*/
create table sys_param
(
   unioncode            varchar(4) not null default '0000',
   paramid              numeric(4,0) not null default 0,
   paramvalue           varchar(16) not null,
   primary key (paramid, unioncode)
);

/*==============================================================*/
/* Table: sys_param_ext                                         */
/*==============================================================*/
create table sys_param_ext
(
   paramid              numeric(4,0) not null default 0 comment '参数ID',
   paramname            varchar(16) not null comment '参数名称',
   texttitle            varchar(16) comment '描述头',
   texttail             varchar(16) comment '描述尾',
   distype              numeric(1,0) not null default 0 comment '0 text 无法修改；1 input 可以修改；2 select 可以修改',
   dictcode             numeric(4,0) not null default 0 comment '字典代码，对应的值列表为已知数据字典，优先于valuelist',
   valuelist            varchar(32) comment '控件显示的值列表，如“0|否;1|是”',
   initvalue            varchar(16) not null comment '初始值',
   valuelength          numeric(4,0) not null default 0 comment '输入值长度',
   primary key (paramid)
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   unioncode            varchar(4) not null default '0000',
   roleid               numeric(8,0) not null default 0 comment '角色ID',
   rolename             varchar(16) not null comment '角色名称',
   status               numeric(1,0) not null default 0 comment '角色状态，0-无效，1-有效',
   roletype             numeric(1,0) not null default 0 comment '角色类型，0-公共，1-私有',
   startdate            varchar(8) not null comment '角色生效日期',
   enddate              varchar(8) not null comment '角色失效日期',
   creator              numeric(10,0) not null default 0 comment '创建人',
   primary key (roleid)
);

/*==============================================================*/
/* Table: sys_role_menu                                         */
/*==============================================================*/
create table sys_role_menu
(
   roleid               numeric(8,0) not null default 0,
   menuid               varchar(8) not null,
   primary key (roleid, menuid)
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   userid               numeric(10,0) not null default 0 comment '用户ID,内部自动生成',
   unioncode            varchar(4) not null default '0000',
   username             varchar(32) not null comment '用户名称',
   loginid              varchar(16) comment '登录名',
   loginpasswd          char(32) not null comment '登录密码',
   salt                 varchar(8) not null comment '密码盐',
   mobileno             varchar(16) not null comment '手机号码',
   email                varchar(64) comment '电子邮件',
   orgid                varchar(8) not null comment '所属机构',
   idtype               char(1) not null default '0' comment '证件类型',
   idcode               varchar(32) comment '证件号码',
   logindate            varchar(8) comment '登录日期',
   logintime            varchar(6) comment '登录时间',
   status               numeric(1,0) not null default 0 comment '用户状态，0，已删除；1，正常；2，锁定',
   loginerror           numeric(4,0) not null default 0 comment '连续登录失败次数',
   passwdvaliddate      varchar(8) not null comment '密码失效日期',
   primary key (userid)
);

/*==============================================================*/
/* Table: sys_user_info                                         */
/*==============================================================*/
create table sys_user_info
(
   userid               numeric(10,0) not null default 0 comment '用户ID,内部自动生成',
   unioncode            varchar(4) not null default '0000',
   sex                  char(1) not null default '0' comment '性别（0-女，1-男）',
   birthday             varchar(8) comment '生日',
   address              varchar(64) comment '联系地址',
   postcode             varchar(8) comment '邮政编码',
   province             varchar(8) comment '所在省份',
   city                 varchar(8) comment '所在城市',
   education            char(1) default '0' comment '教育程度',
   primary key (userid)
);

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   userid               numeric(10,0) not null default 0,
   roleid               numeric(8,0) not null default 0,
   primary key (userid, roleid)
);

