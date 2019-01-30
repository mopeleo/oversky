package org.oversky.gurms.system.service;

import org.oversky.base.service.BaseService;
import org.oversky.gurms.system.dto.request.SysUserReq;
import org.oversky.gurms.system.dto.response.SysUserRes;

public interface SysUserService extends BaseService{

	public SysUserRes login(SysUserReq userDto);
}
