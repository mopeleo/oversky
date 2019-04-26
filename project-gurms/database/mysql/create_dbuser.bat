@echo off

mysql -h127.0.0.1 -P3306 -uroot -p < create_dbuser.sql

pause