/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2019/3/27 23:18:39                           */
/*==============================================================*/


drop table sys_dict_index cascade constraints;

drop table sys_dict_value cascade constraints;

drop table sys_log_login cascade constraints;

drop table sys_menu cascade constraints;

drop table sys_org cascade constraints;

drop table sys_param cascade constraints;

drop table sys_param_ext cascade constraints;

drop table sys_role cascade constraints;

drop table sys_role_menu cascade constraints;

drop table sys_user cascade constraints;

drop table sys_user_info cascade constraints;

drop table sys_user_role cascade constraints;

drop sequence seq_sys_log_login;

drop sequence seq_sys_user;

create sequence seq_sys_log_login
increment by 1
start with 1
 maxvalue 9999999999
 minvalue 1;

create sequence seq_sys_user
increment by 1
start with 1
 maxvalue 99999999
 minvalue 1;

/*==============================================================*/
/* Table: sys_dict_index                                        */
/*==============================================================*/
create table sys_dict_index 
(
   unioncode            CHAR(4)              default '0000' not null,
   dictcode             NUMBER(4)            default 0 not null,
   dictname             VARCHAR2(32)         not null,
   dictgroup            CHAR(1)              default '0' not null,
   editflag             SMALLINT             default 0 not null,
   constraint PK_SYS_DICT_INDEX primary key (dictcode, unioncode)
);

comment on table sys_dict_index is
'[cache]';

comment on column sys_dict_index.dictcode is
'字典代码';

comment on column sys_dict_index.dictname is
'字典名称';

comment on column sys_dict_index.dictgroup is
'所属分组';

comment on column sys_dict_index.editflag is
'是否可编辑（0-不可见，1-只读，2-读写）';

/*==============================================================*/
/* Table: sys_dict_value                                        */
/*==============================================================*/
create table sys_dict_value 
(
   unioncode            CHAR(4)              default '0000' not null,
   dictcode             NUMBER(4)            default 0 not null,
   itemcode             VARCHAR2(8)          not null,
   itemname             VARCHAR2(32)         not null,
   constraint PK_SYS_DICT_VALUE primary key (dictcode, itemcode, unioncode)
);

comment on table sys_dict_value is
'[cache]';

comment on column sys_dict_value.dictcode is
'字典代码';

comment on column sys_dict_value.itemcode is
'选项代码';

comment on column sys_dict_value.itemname is
'选项名称';

/*==============================================================*/
/* Table: sys_log_login                                         */
/*==============================================================*/
create table sys_log_login 
(
   logid                INTEGER              not null,
   userid               INTEGER              default 0 not null,
   logindate            CHAR(8),
   logintime            CHAR(6),
   loginpasswd          CHAR(32)             not null,
   loginip              VARCHAR2(16),
   logintype            SMALLINT             default 0 not null,
   loginresult          SMALLINT             default 0 not null,
   constraint PK_SYS_LOG_LOGIN primary key (logid)
);

comment on column sys_log_login.logid is
'[identity]';

comment on column sys_log_login.logindate is
'登录日期';

comment on column sys_log_login.logintime is
'登录时间';

comment on column sys_log_login.loginpasswd is
'登录密码';

comment on column sys_log_login.loginip is
'登录IP';

comment on column sys_log_login.logintype is
'登录方式（1-pc，2-手机）';

comment on column sys_log_login.loginresult is
'登录是否成功 0-失败，1-成功';

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu 
(
   menuid               VARCHAR2(8)          not null,
   menuname             VARCHAR2(16)         not null,
   menuurl              VARCHAR2(32)         not null,
   parentmenu           VARCHAR2(8),
   menutype             SMALLINT             default 0 not null,
   opentype             SMALLINT             default 0 not null,
   status               SMALLINT             default 0 not null,
   constraint PK_SYS_MENU primary key (menuid)
);

comment on table sys_menu is
'[cache]';

comment on column sys_menu.menuid is
'菜单ID';

comment on column sys_menu.menuname is
'菜单名称';

comment on column sys_menu.menuurl is
'菜单地址';

comment on column sys_menu.parentmenu is
'上级菜单';

comment on column sys_menu.menutype is
'菜单类型0-目录，1-菜单，2-页面链接';

comment on column sys_menu.opentype is
'打开方式，0-本页刷新，1-打开新页，2-弹出窗口';

comment on column sys_menu.status is
'菜单状态，0-无效，1-有效';

/*==============================================================*/
/* Table: sys_org                                               */
/*==============================================================*/
create table sys_org 
(
   orgid                INTEGER              not null,
   unioncode            CHAR(4)              default '0000' not null,
   shortname            VARCHAR2(16)         not null,
   fullname             VARCHAR2(32),
   linkman              VARCHAR2(32),
   linktel              VARCHAR2(16),
   faxno                VARCHAR2(16),
   address              VARCHAR2(64),
   postcode             VARCHAR2(8),
   email                VARCHAR2(64),
   parentorg            INTEGER,
   orgtype              SMALLINT             default 0 not null,
   remark               VARCHAR2(32),
   constraint PK_SYS_ORG primary key (orgid)
);

comment on table sys_org is
'[cache]';

comment on column sys_org.orgid is
'机构ID';

comment on column sys_org.shortname is
'机构简称';

comment on column sys_org.fullname is
'机构全称';

comment on column sys_org.linkman is
'联系人';

comment on column sys_org.linktel is
'联系电话';

comment on column sys_org.faxno is
'传真';

comment on column sys_org.address is
'联系地址';

comment on column sys_org.postcode is
'邮政编码';

comment on column sys_org.email is
'电子邮件';

comment on column sys_org.parentorg is
'上级机构';

comment on column sys_org.orgtype is
'机构类型(0-虚拟，可选，1-总，2-分，3-支)';

comment on column sys_org.remark is
'备注';

/*==============================================================*/
/* Table: sys_param                                             */
/*==============================================================*/
create table sys_param 
(
   unioncode            CHAR(4)              default '0000' not null,
   paramid              NUMBER(4)            default 0 not null,
   paramvalue           VARCHAR2(16)         not null,
   constraint PK_SYS_PARAM primary key (paramid, unioncode)
);

comment on table sys_param is
'[cache]';

/*==============================================================*/
/* Table: sys_param_ext                                         */
/*==============================================================*/
create table sys_param_ext 
(
   paramid              NUMBER(4)            default 0 not null,
   paramname            VARCHAR2(16)         not null,
   texttitle            VARCHAR2(16),
   texttail             VARCHAR2(16),
   distype              SMALLINT             default 0 not null,
   dictcode             NUMBER(4)            default 0 not null,
   valuelist            VARCHAR2(32),
   initvalue            VARCHAR2(16)         not null,
   valuelength          NUMBER(4)            default 0 not null,
   constraint PK_SYS_PARAM_EXT primary key (paramid)
);

comment on table sys_param_ext is
'[cache]';

comment on column sys_param_ext.paramid is
'参数ID';

comment on column sys_param_ext.paramname is
'参数名称';

comment on column sys_param_ext.texttitle is
'描述头';

comment on column sys_param_ext.texttail is
'描述尾';

comment on column sys_param_ext.distype is
'0 不可见，1 text 无法修改；2 input 可以修改；3 select 可以修改';

comment on column sys_param_ext.dictcode is
'字典代码，对应的值列表为已知数据字典，优先于valuelist';

comment on column sys_param_ext.valuelist is
'控件显示的值列表，如“0|否;1|是”';

comment on column sys_param_ext.initvalue is
'初始值';

comment on column sys_param_ext.valuelength is
'输入值长度';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role 
(
   unioncode            CHAR(4)              default '0000' not null,
   roleid               NUMBER(4)            default 0 not null,
   rolename             VARCHAR2(16)         not null,
   status               SMALLINT             default 0 not null,
   roletype             SMALLINT             default 0 not null,
   startdate            CHAR(8)              not null,
   enddate              CHAR(8)              not null,
   creator              INTEGER              default 0 not null,
   constraint PK_SYS_ROLE primary key (roleid)
);

comment on table sys_role is
'[cache]';

comment on column sys_role.roleid is
'角色ID';

comment on column sys_role.rolename is
'角色名称';

comment on column sys_role.status is
'角色状态，0-无效，1-有效';

comment on column sys_role.roletype is
'角色类型，0-公共，1-私有';

comment on column sys_role.startdate is
'角色生效日期';

comment on column sys_role.enddate is
'角色失效日期';

comment on column sys_role.creator is
'创建人';

/*==============================================================*/
/* Table: sys_role_menu                                         */
/*==============================================================*/
create table sys_role_menu 
(
   roleid               NUMBER(8)            default 0 not null,
   menuid               VARCHAR2(8)          not null,
   constraint PK_SYS_ROLE_MENU primary key (roleid, menuid)
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user 
(
   userid               INTEGER              not null,
   unioncode            CHAR(4)              default '0000' not null,
   username             VARCHAR2(32)         not null,
   loginid              VARCHAR2(16),
   loginpasswd          CHAR(32)             not null,
   salt                 VARCHAR2(8)          not null,
   mobileno             VARCHAR2(16)         not null,
   email                VARCHAR2(64),
   orgid                INTEGER              not null,
   idtype               CHAR(1)              default '0' not null,
   idcode               VARCHAR2(32),
   logindate            CHAR(8),
   logintime            CHAR(6),
   status               SMALLINT             default 0 not null,
   loginerror           NUMBER(4)            default 0 not null,
   passwdvaliddate      CHAR(8)              not null,
   constraint PK_SYS_USER primary key (userid)
);

comment on column sys_user.userid is
'用户ID,内部自动生成[identity]';

comment on column sys_user.username is
'用户名称';

comment on column sys_user.loginid is
'登录名';

comment on column sys_user.loginpasswd is
'登录密码';

comment on column sys_user.salt is
'密码盐';

comment on column sys_user.mobileno is
'手机号码';

comment on column sys_user.email is
'电子邮件';

comment on column sys_user.orgid is
'所属机构';

comment on column sys_user.idtype is
'证件类型';

comment on column sys_user.idcode is
'证件号码';

comment on column sys_user.logindate is
'登录日期';

comment on column sys_user.logintime is
'登录时间';

comment on column sys_user.status is
'用户状态，0，已删除；1，正常；2，锁定';

comment on column sys_user.loginerror is
'连续登录失败次数';

comment on column sys_user.passwdvaliddate is
'密码失效日期';

/*==============================================================*/
/* Table: sys_user_info                                         */
/*==============================================================*/
create table sys_user_info 
(
   userid               INTEGER              not null,
   unioncode            CHAR(4)              default '0000' not null,
   sex                  CHAR(1)              default '0' not null,
   birthday             CHAR(8),
   address              VARCHAR2(64),
   postcode             VARCHAR2(8),
   province             VARCHAR2(8),
   city                 VARCHAR2(8),
   education            CHAR(1)              default '0',
   constraint PK_SYS_USER_INFO primary key (userid)
);

comment on column sys_user_info.userid is
'用户ID,内部自动生成';

comment on column sys_user_info.sex is
'性别（0-女，1-男）';

comment on column sys_user_info.birthday is
'生日';

comment on column sys_user_info.address is
'联系地址';

comment on column sys_user_info.postcode is
'邮政编码';

comment on column sys_user_info.province is
'所在省份';

comment on column sys_user_info.city is
'所在城市';

comment on column sys_user_info.education is
'教育程度';

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role 
(
   userid               INTEGER              not null,
   roleid               NUMBER(8)            default 0 not null,
   constraint PK_SYS_USER_ROLE primary key (userid, roleid)
);

