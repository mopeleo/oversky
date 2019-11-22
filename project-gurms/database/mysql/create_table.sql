/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/11/22 21:41:34                          */
/*==============================================================*/


drop table if exists sys_confirm;

drop table if exists sys_confirm_checklog;

drop table if exists sys_confirm_datalog;

drop table if exists sys_confirm_user;

drop table if exists sys_dict_index;

drop table if exists sys_dict_value;

drop table if exists sys_menu;

drop table if exists sys_org;

drop table if exists sys_param;

drop table if exists sys_param_info;

drop table if exists sys_role;

drop table if exists sys_role_menu;

drop table if exists sys_sno;

drop index uk_sysuser_idcode on sys_user;

drop index uk_sysuser_email on sys_user;

drop index uk_sysuser_mobile on sys_user;

drop table if exists sys_user;

drop table if exists sys_user_actlog;

drop table if exists sys_user_login;

drop table if exists sys_user_role;

/*==============================================================*/
/* Table: sys_confirm                                           */
/*==============================================================*/
create table sys_confirm
(
   confirmid            numeric(4,0) not null default 0,
   unioncode            varchar(8) not null default '0000',
   tablename            varchar(32) not null comment '复核数据表名',
   checklevel           numeric(1,0) not null default 0 comment '复核级别,递增',
   primary key (unioncode, tablename)
);

alter table sys_confirm comment '复核配置表[cache]';

/*==============================================================*/
/* Table: sys_confirm_checklog                                  */
/*==============================================================*/
create table sys_confirm_checklog
(
   logid                bigint not null auto_increment comment '复核流水号[identity]',
   unioncode            varchar(8) not null default '0000',
   datalog              bigint not null comment '复核数据流水号',
   checker              bigint not null comment '复核人',
   checklevel           numeric(1,0) not null default 0 comment '复核级别，递增',
   checkdate            varchar(8) not null comment '复核日期',
   checktime            varchar(6) not null comment '复核时间',
   status               char(1) not null default '0' comment '复核状态（0-未复核，1-复核通过，2-复核不通过）',
   summary              varchar(256) comment '复核意见',
   primary key (logid)
);

/*==============================================================*/
/* Table: sys_confirm_datalog                                   */
/*==============================================================*/
create table sys_confirm_datalog
(
   logid                bigint not null auto_increment comment '数据流水号[identity]',
   unioncode            varchar(8) not null default '0000',
   confirmid            numeric(4,0) not null default 0 comment '复核类型ID',
   edittype             char(1) not null default '0' comment '行为（1-insert，2-update，3-delete）',
   dataid               varchar(256) comment '数据id，json',
   fulldata             varchar(2048) comment '要复核的完整数据，json字符串',
   extdata              varchar(2048) comment 'fulldata保存不下的，可以拆分存在这里',
   editer               bigint not null comment '编辑人',
   editdate             varchar(8) not null comment '编辑日期',
   edittime             varchar(6) not null comment '编辑时间',
   currentstatus        char(1) not null default '0' comment '当前复核状态（0-未复核，1-复核通过，2-复核不通过）',
   currentlevel         numeric(1,0) not null default 0 comment '当前复核级别',
   endflag              char(1) not null default '0' comment '完结标志（0-未结束，1-结束）',
   primary key (logid)
);

alter table sys_confirm_datalog comment '待复核数据流水表';

/*==============================================================*/
/* Table: sys_confirm_user                                      */
/*==============================================================*/
create table sys_confirm_user
(
   userid               bigint not null comment '复核用户ID',
   confirmid            numeric(4,0) not null default 0 comment '复核配置ID',
   checklevel           numeric(1,0) not null default 0 comment '复核级别',
   primary key (userid, confirmid)
);

alter table sys_confirm_user comment '[cache]';

/*==============================================================*/
/* Table: sys_dict_index                                        */
/*==============================================================*/
create table sys_dict_index
(
   unioncode            varchar(8) not null default '0000',
   dictcode             numeric(4,0) not null default 0 comment '字典代码',
   dictname             varchar(32) not null comment '字典名称',
   dictgroup            char(1) not null default '0' comment '所属分组',
   editflag             char(1) not null default '0' comment '是否可编辑（0-不可见，1-只读，2-读写）',
   primary key (dictcode, unioncode)
);

alter table sys_dict_index comment '[cache]';

/*==============================================================*/
/* Table: sys_dict_value                                        */
/*==============================================================*/
create table sys_dict_value
(
   unioncode            varchar(8) not null default '0000',
   dictcode             numeric(4,0) not null default 0 comment '字典代码',
   itemcode             varchar(8) not null comment '选项代码',
   itemname             varchar(32) not null comment '选项名称',
   primary key (dictcode, itemcode, unioncode)
);

alter table sys_dict_value comment '[cache]';

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu
(
   menuid               varchar(8) not null comment '菜单ID',
   sysid                numeric(1,0) not null default 0 comment '系统ID',
   menuname             varchar(16) not null comment '菜单名称',
   menuurl              varchar(32) comment '菜单地址',
   parentmenu           varchar(8) comment '上级菜单',
   menutype             char(1) not null default '0' comment '菜单类型0-目录，1-菜单，2-页面链接',
   accesstype           char(1) not null default '0' comment '访问权限：0-可任意访问，1-登录访问，2-需授权',
   status               char(1) not null default '0' comment '菜单状态，0-无效，1-有效',
   menucss              varchar(32) comment '菜单样式',
   primary key (menuid)
);

alter table sys_menu comment '[cache]';

/*==============================================================*/
/* Table: sys_org                                               */
/*==============================================================*/
create table sys_org
(
   orgid                bigint not null auto_increment comment '机构ID,内部自动生成[identity]',
   unioncode            varchar(8) not null default '0000',
   shortname            varchar(16) not null comment '机构简称',
   fullname             varchar(32) comment '机构全称',
   linkman              varchar(32) comment '联系人',
   linktel              varchar(16) comment '联系电话',
   faxno                varchar(16) comment '传真',
   address              varchar(64) comment '联系地址',
   postcode             varchar(8) comment '邮政编码',
   email                varchar(64) comment '电子邮件',
   parentorg            bigint comment '上级机构',
   orgtype              char(1) not null default '0' comment '机构类型(0-虚拟，可选，1-总，2-分，3-支)',
   remark               varchar(32) comment '备注',
   primary key (orgid)
);

/*==============================================================*/
/* Table: sys_param                                             */
/*==============================================================*/
create table sys_param
(
   unioncode            varchar(8) not null default '0000',
   paramid              numeric(4,0) not null default 0,
   paramvalue           varchar(32) not null,
   primary key (paramid, unioncode)
);

alter table sys_param comment '[cache]';

/*==============================================================*/
/* Table: sys_param_info                                        */
/*==============================================================*/
create table sys_param_info
(
   paramid              numeric(4,0) not null default 0 comment '参数ID',
   paramname            varchar(32) not null comment '参数名称',
   paramgroup           char(1) not null default '0' comment '所属分组，字典',
   edittype             char(1) not null default '0' comment '1 只读无法修改，2 input 修改，3 select 修改',
   initvalue            varchar(32) not null comment '初始值',
   valuelength          numeric(4,0) default 0 comment '输入值长度,0-不检查长度，其他值效验长度',
   texttitle            varchar(32) comment '描述头',
   texttail             varchar(32) comment '描述尾',
   valuelist            varchar(256) comment '控件显示的值列表，如“0|否;1|是”',
   primary key (paramid)
);

alter table sys_param_info comment '[cache]';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   roleid               bigint not null auto_increment comment '角色ID,内部自动生成[identity]',
   unioncode            varchar(8) not null default '0000',
   rolename             varchar(32) not null comment '角色名称',
   status               char(1) not null default '0' comment '角色状态，0-无效，1-有效',
   startdate            varchar(8) comment '角色生效日期',
   enddate              varchar(8) comment '角色失效日期',
   belong               varchar(16) comment '归属（预留，机构，角色组等）',
   creator              bigint not null comment '创建人',
   primary key (roleid)
);

alter table sys_role comment '[cache]
';

/*==============================================================*/
/* Table: sys_role_menu                                         */
/*==============================================================*/
create table sys_role_menu
(
   roleid               bigint not null,
   menuid               varchar(8) not null,
   primary key (roleid, menuid)
);

/*==============================================================*/
/* Table: sys_sno                                               */
/*==============================================================*/
create table sys_sno
(
   unioncode            varchar(8) not null default '0000',
   noid                 numeric(4,0) not null default 0 comment '流水号ID',
   noname               varchar(32) not null comment '流水号名称',
   initvalue            bigint not null comment '初始值',
   nextvalue            bigint not null comment '下个值',
   fixedflag            char(1) not null default '0' comment '定长标志(0-不固定，1-定长)',
   fixedlength          numeric(4,0) default 0 comment '定长长度，不包括前后缀',
   fillchar             char(1) default '0' comment '填充字符',
   notype               char(1) not null default '0' comment '类型（1-递增，2-递减）',
   cycletype            char(1) not null default '0' comment '循环周期（0-指定值重置，1-按天循环，2-按月循环，3-按年循环）',
   cycledate            varchar(8) comment '循环起始日期',
   endvalue             bigint not null comment '指定重置值',
   prefix               varchar(16) comment '前缀，支持日期/时间模板，如 ab{date}{time}cd',
   suffix               varchar(16) comment '后缀，支持日期/时间模板，如 ab{date}{time}cd',
   primary key (noid, unioncode)
);

alter table sys_sno comment '系统流水号';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   userid               bigint not null auto_increment comment '用户ID,内部自动生成[identity]',
   unioncode            varchar(8) not null default '0000',
   username             varchar(32) not null comment '用户名称',
   loginid              varchar(32) not null comment '登录名',
   loginpasswd          char(32) not null comment '登录密码',
   salt                 varchar(8) not null comment '密码盐',
   passwdvaliddate      varchar(8) not null comment '密码失效日期',
   status               char(1) not null default '0' comment '用户状态，1，正常；2，锁定；3，冻结',
   orgid                bigint not null comment '所属机构',
   sex                  char(1) not null default '0' comment '性别，0-女；1-男',
   mobileno             varchar(16) not null comment '手机号码',
   email                varchar(64) comment '电子邮件',
   idtype               char(1) default '0' comment '证件类型',
   idcode               varchar(32) comment '证件号码',
   idname               varchar(32) comment '证件姓名',
   postcode             varchar(8) comment '邮政编码',
   address              varchar(64) comment '联系地址',
   logindate            varchar(8) comment '上次登录日期',
   logintime            varchar(6) comment '上次登录时间',
   loginerror           numeric(4,0) not null default 0 comment '连续登录失败次数',
   opendate             varchar(8) comment '创建日期',
   primary key (userid)
);

/*==============================================================*/
/* Index: uk_sysuser_mobile                                     */
/*==============================================================*/
create unique index uk_sysuser_mobile on sys_user
(
   mobileno
);

/*==============================================================*/
/* Index: uk_sysuser_email                                      */
/*==============================================================*/
create unique index uk_sysuser_email on sys_user
(
   email
);

/*==============================================================*/
/* Index: uk_sysuser_idcode                                     */
/*==============================================================*/
create unique index uk_sysuser_idcode on sys_user
(
   idtype,
   idcode
);

/*==============================================================*/
/* Table: sys_user_actlog                                       */
/*==============================================================*/
create table sys_user_actlog
(
   logid                bigint not null auto_increment comment '[identity]',
   unioncode            varchar(8) not null default '0000',
   userid               bigint not null comment '用户ID',
   menuid               varchar(8) comment '菜单ID',
   requrl               varchar(32) comment '请求URL',
   reqmethod            varchar(32) comment '请求方法',
   reqdata              varchar(256) comment '请求数据，json',
   actdate              varchar(8) not null comment '行为日期',
   acttime              varchar(6) not null comment '行为时间',
   accesstype           char(1) not null default '0' comment '登录方式（0-pc，1-手机）',
   ipaddress            varchar(16),
   primary key (logid)
);

alter table sys_user_actlog comment '用户行为日志';

/*==============================================================*/
/* Table: sys_user_login                                        */
/*==============================================================*/
create table sys_user_login
(
   logid                bigint not null auto_increment comment '[identity]',
   unioncode            varchar(8) not null default '0000',
   userid               bigint not null default 0,
   logindate            varchar(8) comment '登录日期',
   logintime            varchar(6) comment '登录时间',
   loginpasswd          char(32) not null comment '登录密码',
   loginip              varchar(16) comment '登录IP',
   logintype            char(1) not null default '0' comment '登录方式（0-pc，1-手机）',
   loginresult          char(1) not null default '0' comment '登录是否成功 0-失败，1-成功',
   summary              varchar(32) comment '说明',
   primary key (logid)
);

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   userid               bigint not null,
   roleid               bigint not null,
   primary key (userid, roleid)
);

