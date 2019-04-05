package org.oversky.gurms.system.service;

import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseService;
import org.oversky.gurms.system.dto.request.SysRoleReq;
import org.oversky.gurms.system.dto.response.SysRoleRes;

public interface SysRoleService extends BaseService{

	SysRoleRes insert(SysRoleReq roleReq);
	
	boolean delete(Integer roleid);
	
	SysRoleRes update(SysRoleReq roleReq);
	
	SysRoleRes getById(Integer roleid);
	
	BaseResListDto<SysRoleRes> pageSysRole(SysRoleReq roleReq);
}
