package org.oversky.gurms.system.service;

import org.oversky.base.service.BaseService;
import org.oversky.gurms.system.dto.request.SysUserReq;
import org.oversky.gurms.system.dto.response.SysUserRes;

public interface SysUserService extends BaseService{

	public boolean insert(SysUserReq userReq);
	
	public boolean delete(Long userid);
	
	public boolean update(SysUserReq userReq);
	
	public SysUserRes query(SysUserReq userReq);
	
	public SysUserRes login(SysUserReq userReq);
}
