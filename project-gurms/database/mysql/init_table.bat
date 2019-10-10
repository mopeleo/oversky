@echo off

mysql -h127.0.0.1 -P3306 -ugurms -pgurms -Dgurmstest < ..\clear_data.sql
mysql -h127.0.0.1 -P3306 -ugurms -pgurms -Dgurmstest < ..\init_sys_dict.sql
mysql -h127.0.0.1 -P3306 -ugurms -pgurms -Dgurmstest < ..\init_sys_menu.sql
mysql -h127.0.0.1 -P3306 -ugurms -pgurms -Dgurmstest < ..\init_sys_org.sql
mysql -h127.0.0.1 -P3306 -ugurms -pgurms -Dgurmstest < ..\init_sys_param.sql
mysql -h127.0.0.1 -P3306 -ugurms -pgurms -Dgurmstest < ..\init_sys_sno.sql
mysql -h127.0.0.1 -P3306 -ugurms -pgurms -Dgurmstest < ..\init_sys_user.sql

echo ...........data init success.............

pause
