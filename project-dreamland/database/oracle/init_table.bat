@ECHO off
@ECHO 初始化数据库类型为[Oracle]
@ECHO 初始化数据
sqlplus oversky/oversky@orcl @list_table.lst
pause
