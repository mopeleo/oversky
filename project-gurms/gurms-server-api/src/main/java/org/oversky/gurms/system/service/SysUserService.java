package org.oversky.gurms.system.service;

import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseService;
import org.oversky.gurms.system.dto.request.SysUserReq;
import org.oversky.gurms.system.dto.response.SysUserRes;

public interface SysUserService extends BaseService{

	SysUserRes insert(SysUserReq userReq);
	
	SysUserRes delete(Long userid);
	
	SysUserRes update(SysUserReq userReq);
	
	SysUserRes getById(Long userid);
	
	BaseResListDto<SysUserRes> pageSysUser(SysUserReq userReq);
}
