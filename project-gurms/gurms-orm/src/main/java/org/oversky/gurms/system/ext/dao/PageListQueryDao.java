package org.oversky.gurms.system.ext.dao;

import java.util.List;

import org.oversky.gurms.system.entity.SysParamInfo;
import org.oversky.gurms.system.entity.SysRole;
import org.oversky.gurms.system.entity.SysSno;
import org.oversky.gurms.system.entity.SysUser;
import org.oversky.gurms.system.ext.bo.SysDictBO;

public interface PageListQueryDao {

	List<SysUser> findUsers(SysUser user);
	
	List<SysRole> findRoles(SysRole role);
	
	List<SysDictBO> findDicts(SysDictBO dict);
	
	List<SysParamInfo> findParams(String unioncode);
	
	List<SysSno> findSnos(SysSno sno);
}
