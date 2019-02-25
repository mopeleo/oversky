package org.oversky.gurms.system.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.oversky.base.util.BeanCopyUtils;
import org.oversky.base.util.EncryptUtils;
import org.oversky.gurms.system.dao.SysUserDao;
import org.oversky.gurms.system.dto.request.UserLoginReq;
import org.oversky.gurms.system.dto.response.UserLoginRes;
import org.oversky.gurms.system.entity.SysUser;
import org.oversky.gurms.system.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IndexServiceImpl implements IndexService{

	private static final Logger logger = LoggerFactory.getLogger(IndexServiceImpl.class);
	
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public void home() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserLoginRes login(UserLoginReq loginReq) {
		logger.debug("=== begin login(UserLoginReq loginReq => {})", loginReq);
		UserLoginRes res = new UserLoginRes();
		if(loginReq == null) {
			res.failure("请求对象为空");
			logger.warn("请求对象为空");
			return res;
		}
		if(StringUtils.isEmpty(loginReq.getLoginid())) {
			res.failure("用户名不能为空");
			logger.warn("用户名为空 [{}]", loginReq.getLoginid());
			return res;
		}
		if(StringUtils.isEmpty(loginReq.getPasswd())) {
			res.failure("密码不能为空");
			logger.warn("密码为空 [{}]", loginReq.getPasswd());
			return res;
		}
		SysUser where = new SysUser();
		where.setLoginid(loginReq.getLoginid());
		List<SysUser> userList = sysUserDao.selectWhere(where);
		if(userList == null || userList.size() != 1) {
			res.failure("用户名不存在");
			return res;
		}
		SysUser user = userList.get(0);
//		String md5Passwd = EncryptUtil.md5Encode(loginReq.getPasswd() + user.getSalt());
		String md5Passwd = loginReq.getPasswd();
		if(!md5Passwd.equals(user.getLoginpasswd())) {
			res.failure("密码错误");
		}
		
		BeanCopyUtils.copy(user, res);
		res.success("登陆成功");
		return res;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

}
