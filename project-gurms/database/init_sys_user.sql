delete from sys_user;

INSERT INTO sys_user (unioncode, userid, username, loginid, loginpasswd, salt, mobileno, email, orgid, idtype, idcode, logindate, logintime, status, loginerror, passwdvaliddate) 
VALUES ('0000', 1, 'admin', 'admin', '42284f3438cd11991349951a036eec09', '123', '13800000000', 'admin@126.com', 1, '', '', '', '', 1, 0, '20990909');

commit;

