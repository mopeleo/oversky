@ECHO off
@ECHO 初始化数据库类型为[Oracle]
@ECHO 创建Oracle用户

sqlplus sys/1@orcl as sysdba  @create_dbuser.sql

