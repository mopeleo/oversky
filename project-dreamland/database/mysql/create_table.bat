@echo off

mysql -h127.0.0.1 -P3306 -ugurms -pgurms -Dgurmstest < create_table.sql
                                          
pause