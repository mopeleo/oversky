/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2019/11/22 22:43:50                          */
/*==============================================================*/


drop table sys_confirm cascade constraints;

drop table sys_confirm_checklog cascade constraints;

drop table sys_confirm_datalog cascade constraints;

drop table sys_confirm_user cascade constraints;

drop table sys_dict_index cascade constraints;

drop table sys_dict_value cascade constraints;

drop table sys_menu cascade constraints;

drop table sys_org cascade constraints;

drop table sys_param cascade constraints;

drop table sys_param_info cascade constraints;

drop table sys_role cascade constraints;

drop table sys_role_menu cascade constraints;

drop table sys_sno cascade constraints;

drop table sys_user cascade constraints;

drop table sys_user_actlog cascade constraints;

drop table sys_user_login cascade constraints;

drop table sys_user_role cascade constraints;

drop sequence seq_sys_logid;

drop sequence seq_sys_orgid;

drop sequence seq_sys_roleid;

drop sequence seq_sys_userid;

create sequence seq_sys_logid
increment by 1
start with 1
 maxvalue 9999999999999999
 minvalue 1;

create sequence seq_sys_orgid
increment by 1
start with 1
 maxvalue 99999999;

create sequence seq_sys_roleid
increment by 1
start with 1
 maxvalue 99999999;

create sequence seq_sys_userid
increment by 1
start with 1
 maxvalue 9999999999
 minvalue 1;

/*==============================================================*/
/* Table: sys_confirm                                           */
/*==============================================================*/
create table sys_confirm 
(
   confirmid            NUMBER(4)            default 0 not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   tablename            VARCHAR2(32)         not null,
   checklevel           NUMBER(1)            default 0 not null,
   constraint PK_SYS_CONFIRM primary key (unioncode, tablename)
);

comment on table sys_confirm is
'复核配置表[cache]';

comment on column sys_confirm.tablename is
'复核数据表名';

comment on column sys_confirm.checklevel is
'复核级别,递增';

/*==============================================================*/
/* Table: sys_confirm_checklog                                  */
/*==============================================================*/
create table sys_confirm_checklog 
(
   logid                INTEGER              not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   datalog              INTEGER              not null,
   checker              INTEGER              not null,
   checklevel           NUMBER(1)            default 0 not null,
   checkdate            VARCHAR2(8)          not null,
   checktime            VARCHAR2(6)          not null,
   status               CHAR(1)              default '0' not null,
   summary              VARCHAR2(256),
   constraint PK_SYS_CONFIRM_CHECKLOG primary key (logid)
);

comment on column sys_confirm_checklog.logid is
'复核流水号[identity]';

comment on column sys_confirm_checklog.datalog is
'复核数据流水号';

comment on column sys_confirm_checklog.checker is
'复核人';

comment on column sys_confirm_checklog.checklevel is
'复核级别，递增';

comment on column sys_confirm_checklog.checkdate is
'复核日期';

comment on column sys_confirm_checklog.checktime is
'复核时间';

comment on column sys_confirm_checklog.status is
'复核状态（0-未复核，1-复核通过，2-复核不通过）';

comment on column sys_confirm_checklog.summary is
'复核意见';

/*==============================================================*/
/* Table: sys_confirm_datalog                                   */
/*==============================================================*/
create table sys_confirm_datalog 
(
   logid                INTEGER              not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   confirmid            NUMBER(4)            default 0 not null,
   edittype             CHAR(1)              default '0' not null,
   dataid               VARCHAR2(256),
   fulldata             VARCHAR2(2048),
   extdata              VARCHAR2(2048),
   editer               INTEGER              not null,
   editdate             VARCHAR2(8)          not null,
   edittime             VARCHAR2(6)          not null,
   currentstatus        CHAR(1)              default '0' not null,
   currentlevel         NUMBER(1)            default 0 not null,
   endflag              CHAR(1)              default '0' not null,
   constraint PK_SYS_CONFIRM_DATALOG primary key (logid)
);

comment on table sys_confirm_datalog is
'待复核数据流水表';

comment on column sys_confirm_datalog.logid is
'数据流水号[identity]';

comment on column sys_confirm_datalog.confirmid is
'复核类型ID';

comment on column sys_confirm_datalog.edittype is
'行为（1-insert，2-update，3-delete）';

comment on column sys_confirm_datalog.dataid is
'数据id，json';

comment on column sys_confirm_datalog.fulldata is
'要复核的完整数据，json字符串';

comment on column sys_confirm_datalog.extdata is
'fulldata保存不下的，可以拆分存在这里';

comment on column sys_confirm_datalog.editer is
'编辑人';

comment on column sys_confirm_datalog.editdate is
'编辑日期';

comment on column sys_confirm_datalog.edittime is
'编辑时间';

comment on column sys_confirm_datalog.currentstatus is
'当前复核状态（0-未复核，1-复核通过，2-复核不通过）';

comment on column sys_confirm_datalog.currentlevel is
'当前复核级别';

comment on column sys_confirm_datalog.endflag is
'完结标志（0-未结束，1-结束）';

/*==============================================================*/
/* Table: sys_confirm_user                                      */
/*==============================================================*/
create table sys_confirm_user 
(
   userid               INTEGER              not null,
   confirmid            NUMBER(4)            default 0 not null,
   checklevel           NUMBER(1)            default 0 not null,
   constraint PK_SYS_CONFIRM_USER primary key (userid, confirmid)
);

comment on table sys_confirm_user is
'[cache]';

comment on column sys_confirm_user.userid is
'复核用户ID';

comment on column sys_confirm_user.confirmid is
'复核配置ID';

comment on column sys_confirm_user.checklevel is
'复核级别';

/*==============================================================*/
/* Table: sys_dict_index                                        */
/*==============================================================*/
create table sys_dict_index 
(
   unioncode            VARCHAR2(8)          default '0000' not null,
   dictcode             NUMBER(4)            default 0 not null,
   dictname             VARCHAR2(32)         not null,
   dictgroup            CHAR(1)              default '0' not null,
   editflag             CHAR(1)              default '0' not null,
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
   unioncode            VARCHAR2(8)          default '0000' not null,
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
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu 
(
   menuid               VARCHAR2(8)          not null,
   sysid                NUMBER(1)            default 0 not null,
   menuname             VARCHAR2(16)         not null,
   menuurl              VARCHAR2(32),
   parentmenu           VARCHAR2(8),
   menutype             CHAR(1)              default '0' not null,
   accesstype           CHAR(1)              default '0' not null,
   status               CHAR(1)              default '0' not null,
   menucss              VARCHAR2(32),
   constraint PK_SYS_MENU primary key (menuid)
);

comment on table sys_menu is
'[cache]';

comment on column sys_menu.menuid is
'菜单ID';

comment on column sys_menu.sysid is
'系统ID';

comment on column sys_menu.menuname is
'菜单名称';

comment on column sys_menu.menuurl is
'菜单地址';

comment on column sys_menu.parentmenu is
'上级菜单';

comment on column sys_menu.menutype is
'菜单类型0-目录，1-菜单，2-页面链接';

comment on column sys_menu.accesstype is
'访问权限：0-可任意访问，1-登录访问，2-需授权';

comment on column sys_menu.status is
'菜单状态，0-无效，1-有效';

comment on column sys_menu.menucss is
'菜单样式';

/*==============================================================*/
/* Table: sys_org                                               */
/*==============================================================*/
create table sys_org 
(
   orgid                INTEGER              not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   shortname            VARCHAR2(16)         not null,
   fullname             VARCHAR2(32),
   linkman              VARCHAR2(32),
   linktel              VARCHAR2(16),
   faxno                VARCHAR2(16),
   address              VARCHAR2(64),
   postcode             VARCHAR2(8),
   email                VARCHAR2(64),
   parentorg            INTEGER,
   orgtype              CHAR(1)              default '0' not null,
   remark               VARCHAR2(32),
   constraint PK_SYS_ORG primary key (orgid)
);

comment on column sys_org.orgid is
'机构ID,内部自动生成[identity]';

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
   unioncode            VARCHAR2(8)          default '0000' not null,
   paramid              NUMBER(4)            default 0 not null,
   paramvalue           VARCHAR2(32)         not null,
   constraint PK_SYS_PARAM primary key (paramid, unioncode)
);

comment on table sys_param is
'[cache]';

/*==============================================================*/
/* Table: sys_param_info                                        */
/*==============================================================*/
create table sys_param_info 
(
   paramid              NUMBER(4)            default 0 not null,
   paramname            VARCHAR2(32)         not null,
   paramgroup           CHAR(1)              default '0' not null,
   edittype             CHAR(1)              default '0' not null,
   initvalue            VARCHAR2(32)         not null,
   valuelength          NUMBER(4)            default 0,
   texttitle            VARCHAR2(32),
   texttail             VARCHAR2(32),
   valuelist            VARCHAR2(256),
   constraint PK_SYS_PARAM_INFO primary key (paramid)
);

comment on table sys_param_info is
'[cache]';

comment on column sys_param_info.paramid is
'参数ID';

comment on column sys_param_info.paramname is
'参数名称';

comment on column sys_param_info.paramgroup is
'所属分组，字典';

comment on column sys_param_info.edittype is
'1 只读无法修改，2 input 修改，3 select 修改';

comment on column sys_param_info.initvalue is
'初始值';

comment on column sys_param_info.valuelength is
'输入值长度,0-不检查长度，其他值效验长度';

comment on column sys_param_info.texttitle is
'描述头';

comment on column sys_param_info.texttail is
'描述尾';

comment on column sys_param_info.valuelist is
'控件显示的值列表，如“0|否;1|是”';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role 
(
   roleid               INTEGER              not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   rolename             VARCHAR2(32)         not null,
   status               CHAR(1)              default '0' not null,
   startdate            VARCHAR2(8),
   enddate              VARCHAR2(8),
   belong               VARCHAR2(16),
   creator              INTEGER              not null,
   constraint PK_SYS_ROLE primary key (roleid)
);

comment on table sys_role is
'[cache]';

comment on column sys_role.roleid is
'角色ID,内部自动生成[identity]';

comment on column sys_role.rolename is
'角色名称';

comment on column sys_role.status is
'角色状态，0-无效，1-有效';

comment on column sys_role.startdate is
'角色生效日期';

comment on column sys_role.enddate is
'角色失效日期';

comment on column sys_role.belong is
'归属（预留，机构，角色组等）';

comment on column sys_role.creator is
'创建人';

/*==============================================================*/
/* Table: sys_role_menu                                         */
/*==============================================================*/
create table sys_role_menu 
(
   roleid               INTEGER              not null,
   menuid               VARCHAR2(8)          not null,
   constraint PK_SYS_ROLE_MENU primary key (roleid, menuid)
);

/*==============================================================*/
/* Table: sys_sno                                               */
/*==============================================================*/
create table sys_sno 
(
   unioncode            VARCHAR2(8)          default '0000' not null,
   noid                 NUMBER(4)            default 0 not null,
   noname               VARCHAR2(32)         not null,
   initvalue            INTEGER              not null,
   nextvalue            INTEGER              not null,
   fixedflag            CHAR(1)              default '0' not null,
   fixedlength          NUMBER(4)            default 0,
   fillchar             CHAR(1)              default '0',
   notype               CHAR(1)              default '0' not null,
   cycletype            CHAR(1)              default '0' not null,
   cycledate            VARCHAR2(8),
   endvalue             INTEGER              not null,
   prefix               VARCHAR2(16),
   suffix               VARCHAR2(16),
   constraint PK_SYS_SNO primary key (noid, unioncode)
);

comment on table sys_sno is
'系统流水号';

comment on column sys_sno.noid is
'流水号ID';

comment on column sys_sno.noname is
'流水号名称';

comment on column sys_sno.initvalue is
'初始值';

comment on column sys_sno.nextvalue is
'下个值';

comment on column sys_sno.fixedflag is
'定长标志(0-不固定，1-定长)';

comment on column sys_sno.fixedlength is
'定长长度，不包括前后缀';

comment on column sys_sno.fillchar is
'填充字符';

comment on column sys_sno.notype is
'类型（1-递增，2-递减）';

comment on column sys_sno.cycletype is
'循环周期（0-指定值重置，1-按天循环，2-按月循环，3-按年循环）';

comment on column sys_sno.cycledate is
'循环起始日期';

comment on column sys_sno.endvalue is
'指定重置值';

comment on column sys_sno.prefix is
'前缀，支持日期/时间模板，如 ab{date}{time}cd';

comment on column sys_sno.suffix is
'后缀，支持日期/时间模板，如 ab{date}{time}cd';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user 
(
   userid               INTEGER              not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   username             VARCHAR2(32)         not null,
   loginid              VARCHAR2(32)         not null,
   loginpasswd          CHAR(32)             not null,
   salt                 VARCHAR2(8)          not null,
   passwdvaliddate      VARCHAR2(8)          not null,
   sex                  CHAR(1)              default '0' not null,
   mobileno             VARCHAR2(16)         not null,
   email                VARCHAR2(64),
   orgid                INTEGER              not null,
   idtype               CHAR(1)              default '0',
   idcode               VARCHAR2(32),
   idname               VARCHAR2(32),
   postcode             VARCHAR2(8),
   address              VARCHAR2(64),
   logindate            VARCHAR2(8),
   logintime            VARCHAR2(6),
   status               CHAR(1)              default '0' not null,
   loginerror           NUMBER(4)            default 0 not null,
   opendate             VARCHAR2(8),
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

comment on column sys_user.passwdvaliddate is
'密码失效日期';

comment on column sys_user.sex is
'性别，0-女；1-男';

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

comment on column sys_user.idname is
'证件姓名';

comment on column sys_user.postcode is
'邮政编码';

comment on column sys_user.address is
'联系地址';

comment on column sys_user.logindate is
'上次登录日期';

comment on column sys_user.logintime is
'上次登录时间';

comment on column sys_user.status is
'用户状态，1，正常；2，锁定；3，冻结';

comment on column sys_user.loginerror is
'连续登录失败次数';

comment on column sys_user.opendate is
'创建日期';

/*==============================================================*/
/* Table: sys_user_actlog                                       */
/*==============================================================*/
create table sys_user_actlog 
(
   logid                INTEGER              not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   userid               INTEGER              not null,
   menuid               VARCHAR2(8),
   requrl               VARCHAR2(32),
   reqmethod            VARCHAR2(32),
   reqdata              VARCHAR2(256),
   actdate              VARCHAR2(8)          not null,
   acttime              VARCHAR2(6)          not null,
   accesstype           CHAR(1)              default '0' not null,
   ipaddress            VARCHAR2(16),
   constraint PK_SYS_USER_ACTLOG primary key (logid)
);

comment on table sys_user_actlog is
'用户行为日志';

comment on column sys_user_actlog.logid is
'[identity]';

comment on column sys_user_actlog.userid is
'用户ID';

comment on column sys_user_actlog.menuid is
'菜单ID';

comment on column sys_user_actlog.requrl is
'请求URL';

comment on column sys_user_actlog.reqmethod is
'请求方法';

comment on column sys_user_actlog.reqdata is
'请求数据，json';

comment on column sys_user_actlog.actdate is
'行为日期';

comment on column sys_user_actlog.acttime is
'行为时间';

comment on column sys_user_actlog.accesstype is
'登录方式（0-pc，1-手机）';

/*==============================================================*/
/* Table: sys_user_login                                        */
/*==============================================================*/
create table sys_user_login 
(
   logid                INTEGER              not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   userid               INTEGER              default 0 not null,
   logindate            VARCHAR2(8),
   logintime            VARCHAR2(6),
   loginpasswd          CHAR(32)             not null,
   loginip              VARCHAR2(16),
   logintype            CHAR(1)              default '0' not null,
   loginresult          CHAR(1)              default '0' not null,
   summary              VARCHAR2(32),
   constraint PK_SYS_USER_LOGIN primary key (logid)
);

comment on column sys_user_login.logid is
'[identity]';

comment on column sys_user_login.logindate is
'登录日期';

comment on column sys_user_login.logintime is
'登录时间';

comment on column sys_user_login.loginpasswd is
'登录密码';

comment on column sys_user_login.loginip is
'登录IP';

comment on column sys_user_login.logintype is
'登录方式（0-pc，1-手机）';

comment on column sys_user_login.loginresult is
'登录是否成功 0-失败，1-成功';

comment on column sys_user_login.summary is
'说明';

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role 
(
   userid               INTEGER              not null,
   roleid               INTEGER              not null,
   constraint PK_SYS_USER_ROLE primary key (userid, roleid)
);

