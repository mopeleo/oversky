@ECHO off
@ECHO 初始化数据库类型为[Oracle]
@ECHO 创建Oracle中表结构

sqlplus dreamland/dreamland@orcl @create_table.sql

