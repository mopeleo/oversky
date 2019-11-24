/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/11/24 21:39:27                          */
/*==============================================================*/


drop table if exists com_dict;

drop table if exists com_param;

drop table if exists com_param_info;

drop table if exists cust_info;

drop table if exists cust_info_ext;

drop table if exists cust_log_login;

drop table if exists cust_log_trans;

drop table if exists game_actor_info;

drop table if exists game_actor_skill;

drop table if exists game_attribute_info;

drop table if exists game_equip_info;

drop table if exists game_equip_skill;

drop table if exists game_info;

drop table if exists game_item_info;

drop table if exists game_level_info;

drop table if exists game_meun_info;

drop table if exists game_promotion_info;

drop table if exists game_scene_info;

drop table if exists game_scene_menu;

drop table if exists game_skill_info;

drop table if exists game_suit_equip;

drop table if exists game_suit_info;

drop table if exists server_bulletin;

drop table if exists server_info;

drop table if exists server_league_info;

drop table if exists server_msg_receive;

drop table if exists server_msg_send;

drop table if exists server_param;

drop table if exists server_player_actor;

drop table if exists server_player_actor_favor;

drop table if exists server_player_actor_skill;

drop table if exists server_player_equip;

drop table if exists server_player_equip_attribute;

drop table if exists server_player_friend;

drop table if exists server_player_info;

drop table if exists server_player_package;

drop table if exists server_promotion;

/*==============================================================*/
/* Table: com_dict                                              */
/*==============================================================*/
create table com_dict
(
   dictcode             numeric(8,0) not null default 0 comment '字典代码',
   itemcode             varchar(8) not null comment '选项代码',
   itemname             varchar(64) not null comment '选项值',
   primary key (dictcode, itemcode)
);

alter table com_dict comment '[cache]';

/*==============================================================*/
/* Table: com_param                                             */
/*==============================================================*/
create table com_param
(
   unioncode            varchar(8) not null default '0000',
   paramid              numeric(4,0) not null,
   paramvalue           varchar(32) not null,
   primary key (paramid, unioncode)
);

alter table com_param comment '系统参数表[cache]';

/*==============================================================*/
/* Table: com_param_info                                        */
/*==============================================================*/
create table com_param_info
(
   paramid              numeric(4,0) not null default 0 comment '参数ID',
   paramname            varchar(32) not null comment '参数名称',
   edittype             char(1) not null default '0' comment '1 只读无法修改，2 input 修改，3 select 修改',
   initvalue            varchar(32) not null comment '初始值',
   valuelength          numeric(4,0) default 0 comment '输入值长度,0-不检查长度，其他值效验长度',
   texttitle            varchar(32) comment '描述头',
   texttail             varchar(32) comment '描述尾',
   valuelist            varchar(256) comment '控件显示的值列表，如“0|否;1|是”',
   primary key (paramid)
);

alter table com_param_info comment '[cache]';

/*==============================================================*/
/* Table: cust_info                                             */
/*==============================================================*/
create table cust_info
(
   custno               bigint not null auto_increment comment '客户号，自动生成[identity]',
   unioncode            varchar(8) not null default '0000',
   custname             varchar(32) not null comment '客户名称',
   custtype             char(1) not null comment '客户类型，0，机构；1，个人',
   loginid              varchar(32) not null comment '登录名',
   loginpasswd          char(32) not null comment '登录密码',
   salt                 varchar(32) not null comment '密码盐，随机生成',
   passwdvaliddate      varchar(8) not null comment '密码失效日期',
   mobileno             varchar(16) not null comment '手机号码',
   email                varchar(64) not null comment '电子邮件',
   custlevel            char(1) not null default '0' comment '客户级别',
   idtype               varchar(2) comment '证件类型',
   idcode               varchar(32) comment '证件号码',
   idname               varchar(32) comment '证件姓名',
   lastlogindate        varchar(8) comment '上次登录日期',
   lastlogintime        varchar(6) comment '上次登录时间',
   status               char(1) not null default '0' comment '客户状态，0，已注销；1，正常；2，锁定；3，冻结',
   loginerror           numeric(4,0) not null default 0 comment '连续登录失败次数',
   regdate              varchar(8) comment '注册日期',
   canceldate           varchar(8) comment '注销日期',
   primary key (custno)
);

/*==============================================================*/
/* Table: cust_info_ext                                         */
/*==============================================================*/
create table cust_info_ext
(
   custno               bigint not null default 0,
   sex                  char(1) not null default '0' comment '性别（0-女，1-男）',
   birthday             varchar(8) comment '生日',
   address              varchar(64) comment '联系地址',
   postcode             varchar(8) comment '邮政编码',
   phone                varchar(16) comment '备用电话',
   nationality          varchar(8) comment '国籍',
   province             varchar(8) comment '所在省份',
   city                 varchar(8) comment '所在城市',
   education            char(1) default '0' comment '教育程度',
   ethnicity            varchar(4) comment '民族',
   profession           varchar(4) comment '职业',
   primary key (custno)
);

alter table cust_info_ext comment ' 客户信息扩展表';

/*==============================================================*/
/* Table: cust_log_login                                        */
/*==============================================================*/
create table cust_log_login
(
   logid                bigint not null comment '[identity]',
   unioncode            varchar(8) not null default '0000',
   custno               bigint not null,
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
/* Table: cust_log_trans                                        */
/*==============================================================*/
create table cust_log_trans
(
   logid                bigint not null auto_increment comment '[identity]',
   custno               bigint not null default 0,
   serverid             char(8) not null,
   direction            char(1) not null default '0' comment '方向，0 支付，1，退款',
   amt                  decimal(16,2) not null default 0.00 comment '金额',
   inacct               varchar(32) not null comment '入款账号',
   outacct              varchar(32) not null comment '出款账号',
   busitype             char(1) not null default '0' comment '业务类型：1，充值，2，购买XX',
   status               char(1) not null default '0' comment '状态，0，支付中，1，成功，2，失败',
   paydate              varchar(8) not null comment '支付日期',
   paytime              varchar(6) not null comment '支付时间',
   summary              varchar(32) comment '备注',
   primary key (logid)
);

alter table cust_log_trans comment '客户交易流水';

/*==============================================================*/
/* Table: game_actor_info                                       */
/*==============================================================*/
create table game_actor_info
(
   actorid              bigint not null auto_increment comment '角色ID[identity]',
   actorname            varchar(32) not null comment '角色名称',
   sex                  numeric(8,0) not null default 0 comment '性别',
   race                 char(1) not null default '0' comment '种族1-人类，2-兽人，3-精灵，4-影，5-机械，6-恶魔',
   profession           char(1) not null default '0' comment '职业1-战士，2-剑客，3-猎人，4-盗贼，5-刺客，6-牧师，7-魔导士，8-召唤师，9-',
   actorscene           numeric(1,0) not null default 0 comment '角色存在场景(1- 第一场景，2-第二场景)',
   str                  numeric(8,0) not null default 0 comment '初始力量',
   intelligence         numeric(8,0) not null default 0 comment '初始智力',
   hp                   numeric(8,0) not null default 0 comment '初始生命值',
   mp                   numeric(8,0) not null default 0 comment '初始魔法值',
   agl                  numeric(8,0) not null default 0 comment '初始敏捷',
   luck                 numeric(8,0) not null default 0 comment '初始幸运',
   initrank             numeric(8,0) not null default 1 comment '初始星级',
   maxrank              numeric(8,0) not null default 0 comment '最大星级',
   ratiotype            char(1) not null default '0' comment '成长系数类型(0-固定，1-动态)',
   ratiostr             numeric(6,4) not null default 0.00 comment '默认力量成长率',
   ratioint             numeric(6,4) not null default 0.00 comment '默认智力成长率',
   ratiohp              numeric(6,4) not null default 0.00 comment '默认HP成长率',
   ratiomp              numeric(6,4) not null default 0.00 comment '默认MP成长率',
   ratioagl             numeric(6,4) not null default 0.00 comment '默认敏捷成长率',
   ratioluck            numeric(6,4) not null default 0.00 comment '默认幸运成长率',
   father               varchar(16) comment '父角色ID',
   mother               varchar(16) comment '母角色ID',
   primary key (actorid)
);

alter table game_actor_info comment '角色基本信息表';

/*==============================================================*/
/* Table: game_actor_skill                                      */
/*==============================================================*/
create table game_actor_skill
(
   actorid              bigint not null comment '角色ID',
   skillid              bigint not null comment '技能ID',
   unlocklevel          numeric(4,0) not null default 0 comment '解锁等级',
   extendflag           char(1) not null default '0' comment '是否可继承(0-否，1-是）',
   sno                  numeric(4,0) not null default 0 comment '排序号，从上到下，从小到大，小在上',
   primary key (actorid, skillid)
);

alter table game_actor_skill comment '角色技能表';

/*==============================================================*/
/* Table: game_attribute_info                                   */
/*==============================================================*/
create table game_attribute_info
(
   attrid               bigint not null auto_increment comment '属性ID[identity]',
   attrtype             char(1) not null default '0' comment '属性类型（0-基本属性，1-附加属性，2-套装属性）',
   attrfield            numeric(4,0) not null default 0 comment '属性附加字段（0-力量，1-智力，2-hp,3-mp,4-敏捷，5-幸运，6-物攻，7-魔攻，8-物防，9-法防，10-攻速，11-闪避，12-暴击，13-技能等级）',
   unlockflag           char(1) not null default '0' comment '解锁条件，套装属性用',
   extralact            char(1) not null default '0' comment '附加动作（0-减少，1-增加）',
   extraltype           char(1) not null default '0' comment '附加值类型（0-固定值，1-比例）',
   extralmin            decimal(16,2) default 0.00 comment '附加值下限',
   extralmax            decimal(16,2) default 0.00 comment '附加值上限',
   initval              decimal(16,2) not null default 0.00 comment '初始值，升级增加，适用基本属性',
   upval                decimal(16,2) not null default 0.00 comment '升级每级增加值',
   position             char(1) not null default '0' comment '部位（1-武器，2-头饰，3-衣服，4-裤子，5-腰带，6-鞋子，7-项链，8-戒指）',
   primary key (attrid)
);

alter table game_attribute_info comment '附加属性信息';

/*==============================================================*/
/* Table: game_equip_info                                       */
/*==============================================================*/
create table game_equip_info
(
   equipid              bigint not null auto_increment comment '装备ID[identity]',
   equipname            varchar(32) not null comment '装备名称',
   icon                 varchar(32) not null comment '图标',
   position             char(1) not null default '0' comment '部位（1-武器，2-头饰，3-衣服，4-裤子，5-腰带，6-鞋子，7-项链，8-戒指）',
   grade                char(1) not null default '0' comment '等级（0-白色，1-蓝色，2-金色，3-暗金，4-绿色套装）',
   profession           varchar(32) not null comment '适用职业，多个职业用逗号分隔',
   remark               varchar(256) not null comment '描述',
   primary key (equipid)
);

alter table game_equip_info comment '装备信息表';

/*==============================================================*/
/* Table: game_equip_skill                                      */
/*==============================================================*/
create table game_equip_skill
(
   equipid              bigint not null,
   skillid              bigint not null,
   proficiency          numeric(4,0) not null default 0 comment '解锁熟练度',
   sno                  numeric(4,0) not null default 0 comment '排序号，从上到下，从小到大，小在上',
   primary key (equipid, skillid)
);

alter table game_equip_skill comment '装备技能表';

/*==============================================================*/
/* Table: game_info                                             */
/*==============================================================*/
create table game_info
(
   gameid               bigint not null auto_increment comment '[identity]',
   unioncode            varchar(8) not null default '0000',
   gamecode             varchar(16) not null comment '游戏代码',
   gamename             varchar(32) not null comment '游戏名称',
   fullname             varchar(64) comment '游戏全称',
   englishname          varchar(32),
   alphatest            varchar(8),
   betatest             varchar(8),
   status               char(1) not null default '0' comment '游戏状态，0-开发中，1-内测，2-公测，3-发行，4-终止',
   summary              varchar(256),
   primary key (gameid)
);

alter table game_info comment '游戏信息表';

/*==============================================================*/
/* Table: game_item_info                                        */
/*==============================================================*/
create table game_item_info
(
   itemid               bigint not null auto_increment comment '道具ID[identity]',
   itemname             varchar(32) not null comment '道具名称',
   icon                 varchar(32) not null comment '图标',
   itemtype             char(1) not null default '0' comment '道具类型（0-加经验，1-加血，2-加mp，3-剧情道具）',
   grade                char(1) not null default '0' comment '等级（0-白色，1-蓝色，2-金色，3-暗金）',
   remark               varchar(256) not null comment '描述',
   primary key (itemid)
);

/*==============================================================*/
/* Table: game_level_info                                       */
/*==============================================================*/
create table game_level_info
(
   levelid              bigint not null auto_increment comment '等级ID[identity]',
   levelname            varchar(32) not null comment '等级名称',
   nextlevel            numeric(8,0) not null default 0 comment '下一等级',
   icon                 varchar(32) not null comment '等级图标',
   minpoint             numeric(8,0) not null default 0 comment '经验下限（包含）',
   maxpoint             numeric(8,0) not null default 0 comment '等级上限（不包含）',
   leveltype            char(1) not null default '0' comment '0，会员等级，1角色等级，2工会等级，3装备等级，4技能等级',
   remark               varchar(256),
   primary key (levelid)
);

/*==============================================================*/
/* Table: game_meun_info                                        */
/*==============================================================*/
create table game_meun_info
(
   menuid               bigint not null auto_increment comment '[identity]',
   menuname             varchar(32) not null,
   icon                 varchar(32) not null,
   url                  varchar(32) not null,
   primary key (menuid)
);

alter table game_meun_info comment '功能点菜单表';

/*==============================================================*/
/* Table: game_promotion_info                                   */
/*==============================================================*/
create table game_promotion_info
(
   promid               bigint not null auto_increment,
   promname             varchar(32) not null,
   remark               varchar(256),
   primary key (promid)
);

alter table game_promotion_info comment '促销活动';

/*==============================================================*/
/* Table: game_scene_info                                       */
/*==============================================================*/
create table game_scene_info
(
   sceneid              bigint not null auto_increment comment '场景ID[identity]',
   scenename            varchar(32) not null comment '场景名称',
   primary key (sceneid)
);

/*==============================================================*/
/* Table: game_scene_menu                                       */
/*==============================================================*/
create table game_scene_menu
(
   sceneid              bigint not null,
   menuid               bigint not null,
   primary key (sceneid, menuid)
);

/*==============================================================*/
/* Table: game_skill_info                                       */
/*==============================================================*/
create table game_skill_info
(
   skillid              bigint not null auto_increment comment '技能ID[identity]',
   skillname            varchar(32) not null comment '技能名称',
   icon                 varchar(32) not null comment '技能图标',
   skilltype            char(1) not null default '0' comment '技能类型（0-角色，1-装备）',
   skillflag            char(1) not null default '0' comment '技能标志（0-被动，1-主动）',
   skillfrom            char(1) not null default '0' comment '技能出处（0-自带，1-商店，2-掉落, 3-隐藏）',
   initlevel            numeric(8,0) not null default 1 comment '初始等级',
   maxlevel             numeric(8,0) not null default 0 comment '最大等级',
   remark               varchar(256) not null comment '技能描述',
   prop                 char(1) not null default '0' comment '技能附加属性（0-防御，1-攻击，2-暴击，3-伤害）',
   target               char(1) not null default '0' comment '作用目标（0- 敌方，1-我方）',
   direct               char(1) not null default '0' comment '作用方向（0-减少，1-增加）',
   mode                 char(1) not null default '0' comment '作用类型（0-物理，1- 魔法）',
   valtype              char(1) not null default '0' comment '作用类型（0-固定值，1-比例）',
   initvalue            decimal(16,2) not null default 0.00 comment '附加属性初始值',
   upvalue              decimal(16,2) not null default 0.00 comment '每级增加属性值',
   princetype           char(1) not null default '0' comment '定价类型（0-金币，1-钻石）',
   prince               numeric(4,0) default 0 comment '价格（购买时才有）',
   primary key (skillid)
);

alter table game_skill_info comment '技能信息表';

/*==============================================================*/
/* Table: game_suit_equip                                       */
/*==============================================================*/
create table game_suit_equip
(
   suitid               bigint not null,
   equipid              bigint not null,
   primary key (suitid, equipid)
);

alter table game_suit_equip comment '套装装备关联表';

/*==============================================================*/
/* Table: game_suit_info                                        */
/*==============================================================*/
create table game_suit_info
(
   suitid               bigint not null auto_increment comment '套装ID[identity]',
   suitname             varchar(32) not null comment '套装名称',
   profession           varchar(32) not null comment '适用职业，多个职业用逗号分隔',
   unlocklevel          numeric(4,0) not null default 0 comment '解锁等级',
   summary              varchar(256) comment '描述',
   primary key (suitid)
);

alter table game_suit_info comment '套装信息表';

/*==============================================================*/
/* Table: server_bulletin                                       */
/*==============================================================*/
create table server_bulletin
(
   id                   bigint not null auto_increment comment '[identity]',
   serverid             char(8) not null comment '服务器ID',
   title                varchar(32) not null comment '公告标题',
   content              varchar(1024) not null comment '公告内容',
   startdate            varchar(8) not null comment '开始日期',
   enddate              varchar(8) not null comment '结束日期',
   issuer               varchar(32) not null comment '发布者',
   primary key (id)
);

alter table server_bulletin comment '公告板';

/*==============================================================*/
/* Table: server_info                                           */
/*==============================================================*/
create table server_info
(
   serverid             char(8) not null comment '服务器ID',
   servername           varchar(32) not null comment '服务器名称',
   opendate             varchar(8) not null comment '开服日期',
   opentime             varchar(6) not null comment '开服时间',
   maxplayer            numeric(8,0) not null default 0 comment '最大玩家数',
   regplayer            numeric(8,0) not null default 0 comment '注册玩家数',
   onlineplayer         numeric(8,0) not null default 0 comment '在线玩家数',
   status               char(1) not null default '0' comment '服务器状态0，未开，1，已开，2，维护中',
   primary key (serverid)
);

/*==============================================================*/
/* Table: server_league_info                                    */
/*==============================================================*/
create table server_league_info
(
   leagueid             bigint not null auto_increment comment '[identity]',
   serverid             char(8) not null,
   leaguename           varchar(32) not null comment '联盟名称',
   maxleaguer           numeric(8,0) not null default 0 comment '最大成员数',
   leaguelevel          numeric(8,0) not null default 0 comment '联盟等级',
   creator              bigint not null default 0 comment '盟主',
   createdate           varchar(8),
   createtime           varchar(6),
   remark               varchar(256) not null,
   primary key (leagueid)
);

alter table server_league_info comment '联盟';

/*==============================================================*/
/* Table: server_msg_receive                                    */
/*==============================================================*/
create table server_msg_receive
(
   msgid                bigint not null auto_increment comment '消息ID[identity]',
   serverid             char(8) not null,
   custno               bigint not null default 0 comment '客户号',
   isread               char(1) not null default '0' comment '已读标志',
   primary key (msgid)
);

alter table server_msg_receive comment '收到消息表';

/*==============================================================*/
/* Table: server_msg_send                                       */
/*==============================================================*/
create table server_msg_send
(
   msgid                bigint not null auto_increment comment '消息ID[identity]',
   serverid             char(8) not null,
   custno               bigint not null default 0 comment '作者',
   content              varchar(1024) not null comment '消息内容',
   msgtype              char(1) not null default '0' comment '类型，0-所有人可见，1，公会可见，2，指定人可见',
   receiver             bigint default 0,
   senddate             varchar(8) comment '发送日期',
   sendtime             varchar(6) comment '发送时间',
   primary key (msgid)
);

alter table server_msg_send comment '消息发送表';

/*==============================================================*/
/* Table: server_param                                          */
/*==============================================================*/
create table server_param
(
   serverid             char(8) not null,
   paramid              varchar(8) not null,
   paramvalue           varchar(8) not null,
   primary key (serverid, paramid)
);

alter table server_param comment '服务器系统参数表';

/*==============================================================*/
/* Table: server_player_actor                                   */
/*==============================================================*/
create table server_player_actor
(
   paid                 bigint not null auto_increment comment '自动生成，客户角色ID[identity]',
   serverid             char(8) not null,
   custno               bigint not null default 0,
   actorid              varchar(16) not null comment '角色ID',
   grade                numeric(8,0) not null default 0 comment '星级',
   actorlevel           numeric(4,0) not null default 0 comment '等级',
   ratiostr             numeric(6,4) default 0.00 comment '默认力量成长率',
   ratioint             numeric(6,4) default 0.00 comment '默认智力成长率',
   ratiohp              numeric(6,4) default 0.00 comment '默认HP成长率',
   ratiomp              numeric(6,4) default 0.00 comment '默认MP成长率',
   ratioagl             numeric(6,4) default 0.00 comment '默认敏捷成长率',
   ratioluck            numeric(6,4) default 0.00 comment '默认幸运成长率',
   primary key (actorid, serverid, custno)
);

/*==============================================================*/
/* Table: server_player_actor_favor                             */
/*==============================================================*/
create table server_player_actor_favor
(
   serverid             char(8) not null,
   custno               bigint not null default 0,
   maleid               varchar(16) not null comment '男性角色ID',
   femaleid             varchar(16) not null comment '女性角色ID',
   degree               numeric(4,0) not null default 0 comment '好感度',
   primary key (serverid, maleid, femaleid)
);

alter table server_player_actor_favor comment '角色间好感度';

/*==============================================================*/
/* Table: server_player_actor_skill                             */
/*==============================================================*/
create table server_player_actor_skill
(
   paid                 bigint not null default 0 comment '[identity]',
   skillid              bigint not null,
   skilllevel           numeric(4,0) not null default 0,
   primary key (paid, skillid)
);

/*==============================================================*/
/* Table: server_player_equip                                   */
/*==============================================================*/
create table server_player_equip
(
   peid                 bigint not null default 0 comment '自动生产的流水ID[identity]',
   serverid             char(8) not null,
   custno               bigint not null default 0,
   equipid              bigint not null,
   actorid              bigint not null comment '若actorid为空，则放在背包，不为空，则装备在角色身上',
   equiplevel           numeric(4,0) not null default 0 comment '武器等级',
   proficiency          numeric(4,0) not null default 0 comment '武器熟练度',
   primary key (peid)
);

alter table server_player_equip comment '服务器玩家装备表';

/*==============================================================*/
/* Table: server_player_equip_attribute                         */
/*==============================================================*/
create table server_player_equip_attribute
(
   peid                 bigint not null default 0 comment '玩家装备ID',
   attrid               bigint not null comment '属性ID',
   attrval              decimal(16,2) default 0.00 comment '属性值',
   primary key (peid, attrid)
);

alter table server_player_equip_attribute comment '玩家装备表，随机生成';

/*==============================================================*/
/* Table: server_player_friend                                  */
/*==============================================================*/
create table server_player_friend
(
   serverid             char(8) not null,
   custno               bigint not null default 0,
   friendlist           varchar(2048) not null comment '好友列表逗号分隔',
   friendnum            numeric(8,0) not null default 0 comment '好友数量，上限60',
   primary key (serverid)
);

/*==============================================================*/
/* Table: server_player_info                                    */
/*==============================================================*/
create table server_player_info
(
   serverid             char(8) not null,
   custno               bigint not null default 0,
   nickname             varchar(32) not null,
   logindate            varchar(8) not null,
   logintime            varchar(6) not null,
   playerlevel          numeric(8,0) not null default 0 comment '玩家等级',
   viplevel             numeric(8,0) not null default 0 comment '会员等级',
   crystal              numeric(8,0) not null default 0 comment '水晶数量，游戏货币',
   primary key (serverid, custno)
);

/*==============================================================*/
/* Table: server_player_package                                 */
/*==============================================================*/
create table server_player_package
(
   serverid             char(8) not null,
   custno               bigint not null default 0,
   itemtype             char(1) not null default '0' comment '物品类型，0-道具，1-装备，2-技能',
   itemid               bigint not null comment '物品ID',
   itemnum              numeric(4,0) not null default 0 comment '物品数量',
   primary key (serverid, custno, itemid)
);

alter table server_player_package comment '玩家包裹';

/*==============================================================*/
/* Table: server_promotion                                      */
/*==============================================================*/
create table server_promotion
(
   serverid             char(8) not null,
   promid               bigint not null,
   startdate            varchar(8) not null,
   starttime            varchar(6) not null,
   enddate              varchar(8) not null,
   endtime              varchar(6) not null,
   primary key (serverid, promid)
);

alter table server_promotion comment '服务器活动';

