package org.oversky.gurms.system.dao.ext;

import java.util.List;

import org.oversky.gurms.system.entity.SysRole;
import org.oversky.gurms.system.entity.SysUser;

public interface ListQueryDao {

	List<SysUser> findUsers(SysUser user);
	
	List<SysRole> findRoles(SysRole role);
}
