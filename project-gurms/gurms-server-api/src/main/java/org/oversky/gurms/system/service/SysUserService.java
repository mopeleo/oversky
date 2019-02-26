package org.oversky.gurms.system.service;

import java.util.List;

import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseService;
import org.oversky.gurms.system.dto.request.SysUserReq;
import org.oversky.gurms.system.dto.response.SysUserRes;

public interface SysUserService extends BaseService{

	boolean insert(SysUserReq userReq);
	
	boolean delete(Long userid);
	
	boolean update(SysUserReq userReq);
	
	SysUserRes getById(Long userid);
	
	List<SysUserRes> find(SysUserReq userReq);
	
	BaseResListDto<SysUserRes> pageSysUser(SysUserReq userReq);
}
