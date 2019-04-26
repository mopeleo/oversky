/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2019/4/27 0:42:37                            */
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

drop table sys_user_info cascade constraints;

drop table sys_user_login cascade constraints;

drop table sys_user_role cascade constraints;

drop sequence seq_sys_logid;

drop sequence seq_sys_user;

create sequence seq_sys_logid
increment by 1
start with 1
 maxvalue 9999999999999999
 minvalue 1;

create sequence seq_sys_user
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
   unioncode            CHAR(4)              default '0000' not null,
   tablename            VARCHAR2(32)         not null,
   checklevel           NUMBER(1)            default 0 not null,
   constraint PK_SYS_CONFIRM primary key (unioncode, tablename)
);

comment on table sys_confirm is
'�������ñ�[cache]';

comment on column sys_confirm.tablename is
'�������ݱ���';

comment on column sys_confirm.checklevel is
'���˼���';

/*==============================================================*/
/* Table: sys_confirm_checklog                                  */
/*==============================================================*/
create table sys_confirm_checklog 
(
   logid                INTEGER              not null,
   datalog              INTEGER              not null,
   checker              INTEGER              not null,
   checklevel           NUMBER(1)            default 0 not null,
   checkdate            CHAR(8)              not null,
   checktime            CHAR(6)              not null,
   status               NUMBER(1)            default 0 not null,
   summary              VARCHAR2(256),
   constraint PK_SYS_CONFIRM_CHECKLOG primary key (logid)
);

comment on column sys_confirm_checklog.logid is
'������ˮ��[identity]';

comment on column sys_confirm_checklog.datalog is
'����������ˮ��';

comment on column sys_confirm_checklog.checker is
'������';

comment on column sys_confirm_checklog.checklevel is
'���˼���';

comment on column sys_confirm_checklog.checkdate is
'��������';

comment on column sys_confirm_checklog.checktime is
'����ʱ��';

comment on column sys_confirm_checklog.status is
'����״̬��0-δ���ˣ�1-����ͨ����2-���˲�ͨ����';

comment on column sys_confirm_checklog.summary is
'�������';

/*==============================================================*/
/* Table: sys_confirm_datalog                                   */
/*==============================================================*/
create table sys_confirm_datalog 
(
   logid                INTEGER              not null,
   confirmid            NUMBER(4)            default 0 not null,
   edittype             NUMBER(1)            default 0 not null,
   dataid               VARCHAR2(256),
   fulldata             VARCHAR2(2048),
   extdata              VARCHAR2(2048),
   editer               INTEGER              not null,
   editdate             CHAR(8)              not null,
   edittime             CHAR(6)              not null,
   currentstatus        NUMBER(1)            default 0 not null,
   currentlevel         NUMBER(1)            default 0 not null,
   endflag              NUMBER(1)            default 0 not null,
   constraint PK_SYS_CONFIRM_DATALOG primary key (logid)
);

comment on table sys_confirm_datalog is
'������������ˮ��';

comment on column sys_confirm_datalog.logid is
'������ˮ��[identity]';

comment on column sys_confirm_datalog.confirmid is
'��������ID';

comment on column sys_confirm_datalog.edittype is
'��Ϊ��1-insert��2-update��3-delete��';

comment on column sys_confirm_datalog.dataid is
'����id��json';

comment on column sys_confirm_datalog.fulldata is
'Ҫ���˵��������ݣ�json�ַ���';

comment on column sys_confirm_datalog.extdata is
'fulldata���治�µģ����Բ�ִ�������';

comment on column sys_confirm_datalog.editer is
'�༭��';

comment on column sys_confirm_datalog.editdate is
'�༭����';

comment on column sys_confirm_datalog.edittime is
'�༭ʱ��';

comment on column sys_confirm_datalog.currentstatus is
'��ǰ����״̬��0-δ���ˣ�1-����ͨ����2-���˲�ͨ����';

comment on column sys_confirm_datalog.currentlevel is
'��ǰ���˼���';

comment on column sys_confirm_datalog.endflag is
'����־��0-δ������1-������';

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
'�����û�ID';

comment on column sys_confirm_user.confirmid is
'��������ID';

comment on column sys_confirm_user.checklevel is
'���˼���';

/*==============================================================*/
/* Table: sys_dict_index                                        */
/*==============================================================*/
create table sys_dict_index 
(
   unioncode            CHAR(4)              default '0000' not null,
   dictcode             NUMBER(4)            default 0 not null,
   dictname             VARCHAR2(32)         not null,
   dictgroup            CHAR(1)              default '0' not null,
   editflag             NUMBER(1)            default 0 not null,
   constraint PK_SYS_DICT_INDEX primary key (dictcode, unioncode)
);

comment on table sys_dict_index is
'[cache]';

comment on column sys_dict_index.dictcode is
'�ֵ����';

comment on column sys_dict_index.dictname is
'�ֵ�����';

comment on column sys_dict_index.dictgroup is
'��������';

comment on column sys_dict_index.editflag is
'�Ƿ�ɱ༭��0-���ɼ���1-ֻ����2-��д��';

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
'�ֵ����';

comment on column sys_dict_value.itemcode is
'ѡ�����';

comment on column sys_dict_value.itemname is
'ѡ������';

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu 
(
   menuid               VARCHAR2(8)          not null,
   menuname             VARCHAR2(16)         not null,
   menuurl              VARCHAR2(32),
   parentmenu           VARCHAR2(8),
   menutype             NUMBER(1)            default 0 not null,
   accesstype           NUMBER(1)            default 0 not null,
   status               NUMBER(1)            default 0 not null,
   menucss              VARCHAR2(32),
   constraint PK_SYS_MENU primary key (menuid)
);

comment on table sys_menu is
'[cache]';

comment on column sys_menu.menuid is
'�˵�ID';

comment on column sys_menu.menuname is
'�˵�����';

comment on column sys_menu.menuurl is
'�˵���ַ';

comment on column sys_menu.parentmenu is
'�ϼ��˵�';

comment on column sys_menu.menutype is
'�˵�����0-Ŀ¼��1-�˵���2-ҳ������';

comment on column sys_menu.accesstype is
'����Ȩ�ޣ�0-��������ʣ�1-��¼���ʣ�2-����Ȩ';

comment on column sys_menu.status is
'�˵�״̬��0-��Ч��1-��Ч';

comment on column sys_menu.menucss is
'�˵���ʽ';

/*==============================================================*/
/* Table: sys_org                                               */
/*==============================================================*/
create table sys_org 
(
   orgid                NUMBER(8)            not null,
   unioncode            CHAR(4)              default '0000' not null,
   shortname            VARCHAR2(16)         not null,
   fullname             VARCHAR2(32),
   linkman              VARCHAR2(32),
   linktel              VARCHAR2(16),
   faxno                VARCHAR2(16),
   address              VARCHAR2(64),
   postcode             VARCHAR2(8),
   email                VARCHAR2(64),
   parentorg            NUMBER(8),
   orgtype              NUMBER(1)            default 0 not null,
   remark               VARCHAR2(32),
   constraint PK_SYS_ORG primary key (orgid)
);

comment on table sys_org is
'[cache]';

comment on column sys_org.orgid is
'����ID';

comment on column sys_org.shortname is
'�������';

comment on column sys_org.fullname is
'����ȫ��';

comment on column sys_org.linkman is
'��ϵ��';

comment on column sys_org.linktel is
'��ϵ�绰';

comment on column sys_org.faxno is
'����';

comment on column sys_org.address is
'��ϵ��ַ';

comment on column sys_org.postcode is
'��������';

comment on column sys_org.email is
'�����ʼ�';

comment on column sys_org.parentorg is
'�ϼ�����';

comment on column sys_org.orgtype is
'��������(0-���⣬��ѡ��1-�ܣ�2-�֣�3-֧)';

comment on column sys_org.remark is
'��ע';

/*==============================================================*/
/* Table: sys_param                                             */
/*==============================================================*/
create table sys_param 
(
   unioncode            CHAR(4)              default '0000' not null,
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
   edittype             NUMBER(1)            default 0 not null,
   initvalue            VARCHAR2(32)         not null,
   valuelength          NUMBER(4)            default 0,
   texttitle            VARCHAR2(32),
   texttail             VARCHAR2(32),
   dictcode             NUMBER(4),
   valuelist            VARCHAR2(64),
   constraint PK_SYS_PARAM_INFO primary key (paramid)
);

comment on table sys_param_info is
'[cache]';

comment on column sys_param_info.paramid is
'����ID';

comment on column sys_param_info.paramname is
'��������';

comment on column sys_param_info.paramgroup is
'�������飬�ֵ�';

comment on column sys_param_info.edittype is
'0 ���ɼ���1 text �޷��޸ģ�2 input �����޸ģ�3 select �����޸�';

comment on column sys_param_info.initvalue is
'��ʼֵ';

comment on column sys_param_info.valuelength is
'����ֵ����,0-����鳤�ȣ�����ֵЧ�鳤��';

comment on column sys_param_info.texttitle is
'����ͷ';

comment on column sys_param_info.texttail is
'����β';

comment on column sys_param_info.dictcode is
'�ֵ���룬��Ӧ��ֵ�б�Ϊ��֪�����ֵ䣬������valuelist';

comment on column sys_param_info.valuelist is
'�ؼ���ʾ��ֵ�б����硰0|��;1|�ǡ�';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role 
(
   unioncode            CHAR(4)              default '0000' not null,
   roleid               NUMBER(4)            default 0 not null,
   rolename             VARCHAR2(32)         not null,
   status               NUMBER(1)            default 0 not null,
   roletype             NUMBER(1)            default 0 not null,
   startdate            CHAR(8)              not null,
   enddate              CHAR(8)              not null,
   creator              INTEGER              not null,
   constraint PK_SYS_ROLE primary key (roleid)
);

comment on table sys_role is
'[cache]';

comment on column sys_role.roleid is
'��ɫID';

comment on column sys_role.rolename is
'��ɫ����';

comment on column sys_role.status is
'��ɫ״̬��0-��Ч��1-��Ч';

comment on column sys_role.roletype is
'��ɫ���ͣ�0-������1-˽��';

comment on column sys_role.startdate is
'��ɫ��Ч����';

comment on column sys_role.enddate is
'��ɫʧЧ����';

comment on column sys_role.creator is
'������';

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
/* Table: sys_sno                                               */
/*==============================================================*/
create table sys_sno 
(
   unioncode            CHAR(4)              default '0000' not null,
   noid                 NUMBER(4)            default 0 not null,
   noname               VARCHAR2(32)         not null,
   initvalue            INTEGER              not null,
   nextvalue            INTEGER              not null,
   fixedflag            NUMBER(1)            default 0 not null,
   fixedlength          NUMBER(4)            default 0,
   fillchar             CHAR(1)              default '0',
   notype               NUMBER(1)            default 0 not null,
   nodate               CHAR(8),
   prefix               VARCHAR2(8),
   suffix               VARCHAR2(8),
   constraint PK_SYS_SNO primary key (noid, unioncode)
);

comment on table sys_sno is
'ϵͳ��ˮ��';

comment on column sys_sno.noid is
'��ˮ��ID';

comment on column sys_sno.noname is
'��ˮ������';

comment on column sys_sno.initvalue is
'��ʼֵ';

comment on column sys_sno.nextvalue is
'�¸�ֵ';

comment on column sys_sno.fixedflag is
'������־(0-���̶���1-����)';

comment on column sys_sno.fixedlength is
'�������ȣ�������ǰ��׺';

comment on column sys_sno.fillchar is
'����ַ�';

comment on column sys_sno.notype is
'���ͣ�1-������2-���츴λ��';

comment on column sys_sno.nodate is
'ʹ������';

comment on column sys_sno.prefix is
'ǰ׺';

comment on column sys_sno.suffix is
'��׺';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user 
(
   userid               INTEGER              not null,
   unioncode            CHAR(4)              default '0000' not null,
   username             VARCHAR2(32)         not null,
   loginid              VARCHAR2(32)         not null,
   loginpasswd          CHAR(32)             not null,
   salt                 VARCHAR2(8)          not null,
   passwdvaliddate      CHAR(8)              not null,
   mobileno             VARCHAR2(16)         not null,
   email                VARCHAR2(64),
   orgid                NUMBER(8)            not null,
   idtype               CHAR(1)              default '0',
   idcode               VARCHAR2(32),
   idname               VARCHAR2(32),
   logindate            CHAR(8),
   logintime            CHAR(6),
   status               NUMBER(1)            default 0 not null,
   loginerror           NUMBER(4)            default 0 not null,
   opendate             CHAR(8),
   canceldate           CHAR(8),
   constraint PK_SYS_USER primary key (userid)
);

comment on column sys_user.userid is
'�û�ID,�ڲ��Զ�����[identity]';

comment on column sys_user.username is
'�û�����';

comment on column sys_user.loginid is
'��¼��';

comment on column sys_user.loginpasswd is
'��¼����';

comment on column sys_user.salt is
'������';

comment on column sys_user.passwdvaliddate is
'����ʧЧ����';

comment on column sys_user.mobileno is
'�ֻ�����';

comment on column sys_user.email is
'�����ʼ�';

comment on column sys_user.orgid is
'��������';

comment on column sys_user.idtype is
'֤������';

comment on column sys_user.idcode is
'֤������';

comment on column sys_user.idname is
'֤������';

comment on column sys_user.logindate is
'�ϴε�¼����';

comment on column sys_user.logintime is
'�ϴε�¼ʱ��';

comment on column sys_user.status is
'�û�״̬��0����ע����1��������2������';

comment on column sys_user.loginerror is
'������¼ʧ�ܴ���';

comment on column sys_user.opendate is
'��������';

comment on column sys_user.canceldate is
'ע������';

/*==============================================================*/
/* Table: sys_user_actlog                                       */
/*==============================================================*/
create table sys_user_actlog 
(
   logid                INTEGER              not null,
   unioncode            CHAR(4)              default '0000' not null,
   userid               INTEGER              not null,
   menuid               VARCHAR2(8),
   requrl               VARCHAR2(32),
   reqmethod            VARCHAR2(32),
   reqdata              VARCHAR2(256),
   actdate              CHAR(8)              not null,
   acttime              CHAR(6)              not null,
   accesstype           NUMBER(1)            default 0 not null,
   ipaddress            VARCHAR2(16),
   constraint PK_SYS_USER_ACTLOG primary key (logid)
);

comment on table sys_user_actlog is
'�û���Ϊ��־';

comment on column sys_user_actlog.logid is
'[identity]';

comment on column sys_user_actlog.userid is
'�û�ID';

comment on column sys_user_actlog.menuid is
'�˵�ID';

comment on column sys_user_actlog.requrl is
'����URL';

comment on column sys_user_actlog.reqmethod is
'���󷽷�';

comment on column sys_user_actlog.reqdata is
'�������ݣ�json';

comment on column sys_user_actlog.actdate is
'��Ϊ����';

comment on column sys_user_actlog.acttime is
'��Ϊʱ��';

comment on column sys_user_actlog.accesstype is
'��¼��ʽ��0-pc��1-�ֻ���';

/*==============================================================*/
/* Table: sys_user_info                                         */
/*==============================================================*/
create table sys_user_info 
(
   userid               INTEGER              not null,
   sex                  CHAR(1)              default '0' not null,
   birthday             CHAR(8),
   address              VARCHAR2(64),
   postcode             VARCHAR2(8),
   phone                VARCHAR2(16),
   nationality          VARCHAR2(8),
   province             VARCHAR2(8),
   city                 VARCHAR2(8),
   education            CHAR(1)              default '0',
   constraint PK_SYS_USER_INFO primary key (userid)
);

comment on column sys_user_info.userid is
'�û�ID,�ڲ��Զ�����';

comment on column sys_user_info.sex is
'�Ա�0-Ů��1-�У�';

comment on column sys_user_info.birthday is
'����';

comment on column sys_user_info.address is
'��ϵ��ַ';

comment on column sys_user_info.postcode is
'��������';

comment on column sys_user_info.phone is
'���õ绰';

comment on column sys_user_info.nationality is
'����';

comment on column sys_user_info.province is
'����ʡ��';

comment on column sys_user_info.city is
'���ڳ���';

comment on column sys_user_info.education is
'�����̶�';

/*==============================================================*/
/* Table: sys_user_login                                        */
/*==============================================================*/
create table sys_user_login 
(
   logid                INTEGER              not null,
   unioncode            CHAR(4)              default '0000' not null,
   userid               INTEGER              default 0 not null,
   logindate            CHAR(8),
   logintime            CHAR(6),
   loginpasswd          CHAR(32)             not null,
   loginip              VARCHAR2(16),
   logintype            NUMBER(1)            default 0 not null,
   loginresult          NUMBER(1)            default 0 not null,
   summary              VARCHAR2(32),
   constraint PK_SYS_USER_LOGIN primary key (logid)
);

comment on column sys_user_login.logid is
'[identity]';

comment on column sys_user_login.logindate is
'��¼����';

comment on column sys_user_login.logintime is
'��¼ʱ��';

comment on column sys_user_login.loginpasswd is
'��¼����';

comment on column sys_user_login.loginip is
'��¼IP';

comment on column sys_user_login.logintype is
'��¼��ʽ��0-pc��1-�ֻ���';

comment on column sys_user_login.loginresult is
'��¼�Ƿ�ɹ� 0-ʧ�ܣ�1-�ɹ�';

comment on column sys_user_login.summary is
'˵��';

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role 
(
   userid               INTEGER              not null,
   roleid               NUMBER(8)            not null,
   constraint PK_SYS_USER_ROLE primary key (userid, roleid)
);
