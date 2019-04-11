/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/3/27 23:19:09                           */
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
   unioncode            char(4) not null default '0000',
   dictcode             decimal(4) not null default 0 comment '字典代码',
   dictname             varchar(32) not null comment '字典名称',
   dictgroup            char(1) not null default '0' comment '所属分组',
   editflag             tinyint not null default 0 comment '是否可编辑（0-不可见，1-只读，2-读写）',
   primary key (dictcode, unioncode)
);

alter table sys_dict_index comment '[cache]';

/*==============================================================*/
/* Table: sys_dict_value                                        */
/*==============================================================*/
create table sys_dict_value
(
   unioncode            char(4) not null default '0000',
   dictcode             decimal(4) not null default 0 comment '字典代码',
   itemcode             varchar(8) not null comment '选项代码',
   itemname             varchar(32) not null comment '选项名称',
   primary key (dictcode, itemcode, unioncode)
);

alter table sys_dict_value comment '[cache]';

/*==============================================================*/
/* Table: sys_log_login                                         */
/*==============================================================*/
create table sys_log_login
(
   logid                bigint not null auto_increment comment '[identity]',
   userid               bigint not null default 0,
   logindate            char(8) comment '登录日期',
   logintime            char(6) comment '登录时间',
   loginpasswd          char(32) not null comment '登录密码',
   loginip              varchar(16) comment '登录IP',
   logintype            tinyint not null default 0 comment '登录方式（1-pc，2-手机）',
   loginresult          tinyint not null default 0 comment '登录是否成功 0-失败，1-成功',
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
   menutype             tinyint not null default 0 comment '菜单类型0-目录，1-菜单，2-页面链接',
   opentype             tinyint not null default 0 comment '打开方式，0-本页刷新，1-打开新页，2-弹出窗口',
   status               tinyint not null default 0 comment '菜单状态，0-无效，1-有效',
   primary key (menuid)
);

alter table sys_menu comment '[cache]';

/*==============================================================*/
/* Table: sys_org                                               */
/*==============================================================*/
create table sys_org
(
   orgid                bigint not null comment '机构ID',
   unioncode            char(4) not null default '0000',
   shortname            varchar(16) not null comment '机构简称',
   fullname             varchar(32) comment '机构全称',
   linkman              varchar(32) comment '联系人',
   linktel              varchar(16) comment '联系电话',
   faxno                varchar(16) comment '传真',
   address              varchar(64) comment '联系地址',
   postcode             varchar(8) comment '邮政编码',
   email                varchar(64) comment '电子邮件',
   parentorg            bigint comment '上级机构',
   orgtype              tinyint not null default 0 comment '机构类型(0-虚拟，可选，1-总，2-分，3-支)',
   remark               varchar(32) comment '备注',
   primary key (orgid)
);

alter table sys_org comment '[cache]';

/*==============================================================*/
/* Table: sys_param                                             */
/*==============================================================*/
create table sys_param
(
   unioncode            char(4) not null default '0000',
   paramid              decimal(4) not null default 0,
   paramvalue           varchar(16) not null,
   primary key (paramid, unioncode)
);

alter table sys_param comment '[cache]';

/*==============================================================*/
/* Table: sys_param_ext                                         */
/*==============================================================*/
create table sys_param_ext
(
   paramid              decimal(4) not null default 0 comment '参数ID',
   paramname            varchar(16) not null comment '参数名称',
   texttitle            varchar(16) comment '描述头',
   texttail             varchar(16) comment '描述尾',
   distype              tinyint not null default 0 comment '0 不可见，1 text 无法修改；2 input 可以修改；3 select 可以修改',
   dictcode             decimal(4) not null default 0 comment '字典代码，对应的值列表为已知数据字典，优先于valuelist',
   valuelist            varchar(32) comment '控件显示的值列表，如“0|否;1|是”',
   initvalue            varchar(16) not null comment '初始值',
   valuelength          decimal(4) not null default 0 comment '输入值长度',
   primary key (paramid)
);

alter table sys_param_ext comment '[cache]';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   unioncode            char(4) not null default '0000',
   roleid               decimal(4) not null default 0 comment '角色ID',
   rolename             varchar(16) not null comment '角色名称',
   status               tinyint not null default 0 comment '角色状态，0-无效，1-有效',
   roletype             tinyint not null default 0 comment '角色类型，0-公共，1-私有',
   startdate            char(8) not null comment '角色生效日期',
   enddate              char(8) not null comment '角色失效日期',
   creator              bigint not null default 0 comment '创建人',
   primary key (roleid)
);

alter table sys_role comment '[cache]';

/*==============================================================*/
/* Table: sys_role_menu                                         */
/*==============================================================*/
create table sys_role_menu
(
   roleid               decimal(8) not null default 0,
   menuid               varchar(8) not null,
   primary key (roleid, menuid)
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   userid               bigint not null auto_increment comment '用户ID,内部自动生成[identity]',
   unioncode            char(4) not null default '0000',
   username             varchar(32) not null comment '用户名称',
   loginid              varchar(16) comment '登录名',
   loginpasswd          char(32) not null comment '登录密码',
   salt                 varchar(8) not null comment '密码盐',
   mobileno             varchar(16) not null comment '手机号码',
   email                varchar(64) comment '电子邮件',
   orgid                bigint not null comment '所属机构',
   idtype               char(1) not null default '0' comment '证件类型',
   idcode               varchar(32) comment '证件号码',
   logindate            char(8) comment '登录日期',
   logintime            char(6) comment '登录时间',
   status               tinyint not null default 0 comment '用户状态，0，已删除；1，正常；2，锁定',
   loginerror           decimal(4) not null default 0 comment '连续登录失败次数',
   passwdvaliddate      char(8) not null comment '密码失效日期',
   primary key (userid)
);

/*==============================================================*/
/* Table: sys_user_info                                         */
/*==============================================================*/
create table sys_user_info
(
   userid               bigint not null comment '用户ID,内部自动生成',
   unioncode            char(4) not null default '0000',
   sex                  char(1) not null default '0' comment '性别（0-女，1-男）',
   birthday             char(8) comment '生日',
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
   userid               bigint not null,
   roleid               decimal(8) not null default 0,
   primary key (userid, roleid)
);
