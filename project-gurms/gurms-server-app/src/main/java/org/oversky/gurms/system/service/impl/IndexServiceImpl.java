package org.oversky.gurms.system.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.oversky.base.service.BaseServiceException;
import org.oversky.base.util.BeanCopyUtils;
import org.oversky.base.util.DateUtils;
import org.oversky.base.util.EncryptUtils;
import org.oversky.gurms.system.constant.CacheConsts;
import org.oversky.gurms.system.constant.DictConsts;
import org.oversky.gurms.system.dao.SysLogLoginDao;
import org.oversky.gurms.system.dao.SysUserDao;
import org.oversky.gurms.system.dao.ext.UserRightDao;
import org.oversky.gurms.system.dao.ext.bo.SysUserBO;
import org.oversky.gurms.system.dto.request.UserLoginReq;
import org.oversky.gurms.system.dto.response.UserLoginRes;
import org.oversky.gurms.system.entity.SysLogLogin;
import org.oversky.gurms.system.entity.SysUser;
import org.oversky.gurms.system.service.IndexService;
import org.oversky.gurms.system.service.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IndexServiceImpl implements IndexService{

	private static final Logger log = LoggerFactory.getLogger(IndexServiceImpl.class);
	
	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	private UserRightDao userDaoExt;
	
	@Autowired
	private SysLogLoginDao sysLogLoginDao;
	
	@Autowired
	private SysMenuService menuService;
	
	@Override
	public void home() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserLoginRes login(UserLoginReq loginReq) {
		log.debug("=== begin login(UserLoginReq loginReq => {})", loginReq);
		UserLoginRes res = new UserLoginRes();
		if(loginReq == null) {
			res.failure("请求对象为空");
			log.warn("请求对象为空");
			return res;
		}
		if(StringUtils.isEmpty(loginReq.getLoginid())) {
			res.failure("用户名不能为空");
			log.warn("用户名为空 [{}]", loginReq.getLoginid());
			return res;
		}
		if(StringUtils.isEmpty(loginReq.getPasswd())) {
			res.failure("密码不能为空");
			log.warn("密码为空 [{}]", loginReq.getPasswd());
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
		if(user.getStatus() != DictConsts.USER_STATUS_NORMAL) {
			res.failure("用户状态异常:" + user.getStatus());
			return res;
		}
		String md5Passwd = EncryptUtils.md5Encode(loginReq.getPasswd() + user.getSalt());
		System.out.println(md5Passwd);
		if(!md5Passwd.equals(user.getLoginpasswd())) {
			res.failure("用户名或密码错误");
			this.processPasswd(user, false);
		}else {
			res.success("登陆成功");
			this.processPasswd(user, true);
			BeanCopyUtils.copy(user, res);
		}
		
		SysUserBO userBo = userDaoExt.getUserRolesAndMenus(user.getUserid());
		res.setOrgid(userBo.getSysorg().getOrgid());
		res.setOrgname(userBo.getSysorg().getShortname());		
		res.setMenuTree(menuService.getUserMenuTree(user.getUserid()));
		
		return res;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}
	
	private void writeLoginLog(UserLoginReq user) {
		SysLogLogin log = new SysLogLogin();
		log.setLogindate(DateUtils.getNowDate());
		log.setLogintime(DateUtils.getNowTime());
		log.setLoginpasswd(user.getPasswd());
		log.setLogintype(user.getLogintype());
		sysLogLoginDao.insert(log);
	}
	
	private void processPasswd(SysUser user, boolean loginSuccess) {
		SysUser upUser = new SysUser();
		upUser.copyPrimaryKey(user);
		upUser.setLogindate(DateUtils.getNowDate());
		upUser.setLogintime(DateUtils.getNowTime());
		//登陆成功清除累计错误次数
		if(loginSuccess) {
			upUser.setLoginerror(0);
		}else {
			upUser.setLoginerror(user.getLoginerror() + 1);
			String maxPasswdErr = CacheConsts.get(CacheConsts.PK_PASSWD_ERROR_TIMES, user.getUnioncode());
			if(upUser.getLoginerror() >= Integer.parseInt(maxPasswdErr)) {
				upUser.setStatus(DictConsts.USER_STATUS_PASSWDLOCK);
			}
		}
		int count = sysUserDao.dynamicUpdateById(upUser);
		if(count != 1) {
			log.error("登陆更新用户状态失败，更新条数：{}", count);
			throw new BaseServiceException("登陆更新用户状态失败");
		}
	}
}
