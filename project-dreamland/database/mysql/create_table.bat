@echo off

mysql -h127.0.0.1 -P3306 -udreamland -pdreamland -Ddreamlanddb < create_table.sql
                                          
pause