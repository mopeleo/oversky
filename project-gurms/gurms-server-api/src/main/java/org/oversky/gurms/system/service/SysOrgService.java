package org.oversky.gurms.system.service;

import org.oversky.base.service.BaseService;
import org.oversky.gurms.system.dto.request.SysOrgReq;
import org.oversky.gurms.system.dto.response.SysOrgRes;

public interface SysOrgService extends BaseService{

	SysOrgRes insert(SysOrgReq roleReq);
	
	SysOrgRes delete(SysOrgReq roleReq);
	
	SysOrgRes update(SysOrgReq roleReq);
	
	SysOrgRes getById(Long roleid);
	
	SysOrgRes orgTree(SysOrgReq roleReq);
}
