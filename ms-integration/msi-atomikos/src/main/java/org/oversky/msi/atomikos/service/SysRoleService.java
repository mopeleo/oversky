package org.oversky.msi.atomikos.service;

import org.oversky.gurms.system.entity.SysRole;

public interface SysRoleService {

	void save(SysRole role);
	
	void delete(Long roleId);
}
