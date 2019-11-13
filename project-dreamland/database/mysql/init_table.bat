@echo off

mysql -h127.0.0.1 -P3306 -udreamland -pdreamland -Ddreamlanddb < ..\clear_data.sql
mysql -h127.0.0.1 -P3306 -udreamland -pdreamland -Ddreamlanddb < ..\init_com_dict.sql
mysql -h127.0.0.1 -P3306 -udreamland -pdreamland -Ddreamlanddb < ..\init_com_param.sql

echo ...........data init success.............

pause
