delete from sys_sno;

INSERT INTO sys_sno (unioncode, noid, noname, initvalue, nextvalue, fixedflag, fixedlength, fillchar, notype, cycletype, cycledate, endvalue, prefix, suffix) 
VALUES ('0000', 1, '测试序列', 0, 0, '1', 8, '0', '1', '0', '', 99999999, 'Test', '');

commit;
