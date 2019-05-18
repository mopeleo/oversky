delete from sys_org;

INSERT INTO sys_org (orgid, unioncode, shortname, fullname, linkman, linktel, faxno, address, postcode, email, parentorg, orgtype, remark) 
VALUES (1, '0000', '总部机构', '总部机构', null, null, null, null, null, null, null, 0, null);

commit;

