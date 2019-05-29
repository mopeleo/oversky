package org.oversky.gurms.system.service;

import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseService;
import org.oversky.gurms.system.dto.request.SysUserReq;
import org.oversky.gurms.system.dto.response.SysUserRes;

public interface SysUserService extends BaseService{

	SysUserRes insert(SysUserReq userReq);
	
	SysUserRes delete(SysUserReq userReq);
	
	SysUserRes update(SysUserReq userReq);
	
	SysUserRes getById(Long userid);
	
	SysUserRes grantRole(SysUserReq userReq);
	
	SysUserRes resetPassword(SysUserReq userReq);
	
	SysUserRes updatePassword(SysUserReq userReq);
	
	SysUserRes freezeUser(SysUserReq userReq);
	
	SysUserRes unfreezeUser(SysUserReq userReq);
	
	BaseResListDto<SysUserRes> pageSysUser(SysUserReq userReq);
}
