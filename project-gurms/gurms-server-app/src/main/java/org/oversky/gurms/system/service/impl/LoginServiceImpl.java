package org.oversky.gurms.system.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.oversky.gurms.system.component.BizFunc;
import org.oversky.gurms.system.constant.DictConsts;
import org.oversky.gurms.system.constant.ParamConsts;
import org.oversky.gurms.system.dao.SysUserDao;
import org.oversky.gurms.system.dao.SysUserLoginDao;
import org.oversky.gurms.system.dto.request.UserLoginReq;
import org.oversky.gurms.system.dto.response.UserLoginRes;
import org.oversky.gurms.system.entity.SysUser;
import org.oversky.gurms.system.entity.SysUserLogin;
import org.oversky.gurms.system.service.LoginService;
import org.oversky.gurms.system.service.SysMenuService;
import org.oversky.util.bean.BeanCopyUtils;
import org.oversky.util.date.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LoginServiceImpl implements LoginService{

	private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	private SysUserLoginDao sysUserLoginDao;

	@Autowired
	private SysMenuService menuService;
	
	@Override
	public void home() {
		
	}

	@Override
	@Transactional
	public UserLoginRes login(UserLoginReq loginReq) {
		log.info("开始 login(UserLoginReq loginReq => {})", loginReq);
		UserLoginRes res = new UserLoginRes();
		if(StringUtils.isEmpty(loginReq.getLoginid())) {
			res.failure("用户名不能为空");
			log.info(res.getReturnmsg());
			return res;
		}
		if(StringUtils.isEmpty(loginReq.getPasswd())) {
			res.failure("密码不能为空");
			log.info(res.getReturnmsg());
			return res;
		}
		
		SysUser where = new SysUser();
		where.setLoginid(loginReq.getLoginid());
		List<SysUser> userList = sysUserDao.selectWhere(where);
		if(userList == null || userList.size() != 1) {
			res.failure("用户名["+loginReq.getLoginid()+"]不存在");
			log.info(res.getReturnmsg());
			return res;
		}
		SysUser user = userList.get(0);
		loginReq.setUserid(user.getUserid());
		loginReq.setUnioncode(user.getUnioncode());
		
		String md5Passwd = BizFunc.getEncryptPassword(loginReq.getPasswd(), user.getSalt());
		boolean login = md5Passwd.equals(user.getLoginpasswd());
		this.updateUserStatus(user, login);
		this.writeLoginLog(loginReq, login);
		if(!login) {
			res.failure("用户名或密码错误");
			log.info(res.getReturnmsg());
			return res;
		}
		
		if(!DictConsts.DICT2001_USER_STATUS_NORMAL.equals(user.getStatus())) {
			res.failure("用户状态异常:" + user.getStatus());
			log.info(res.getReturnmsg());
			return res;
		}
		
		BeanCopyUtils.copy(user, res);		
		//是超级用户
		if(BizFunc.isRootUser(user.getUserid())) {
			res.setMenuTree(menuService.getFullMenuTree());
		}else {
			res.setMenuTree(menuService.getUserMenuTree(user.getUserid()));
		}
		res.success("登录成功");
		log.info("登录结束：{}", res.getReturnmsg());
		return res;
	}

	@Override
	public void logout() {
		
	}
	
	private void writeLoginLog(UserLoginReq user, boolean loginSuccess) {
		log.info("开始写登录日志");
		SysUserLogin log = new SysUserLogin();
		log.setLogindate(DateUtils.getNowDate());
		log.setLogintime(DateUtils.getNowTime());
		log.setLoginpasswd(user.getPasswd());
		log.setLogintype(user.getChannel());
		log.setUnioncode(user.getUnioncode());
		log.setLoginip(user.getClientIp());
		log.setUserid(user.getUserid());
		if(loginSuccess) {
			log.setLoginresult(DictConsts.DICT1017_SUCCESS);
			log.setSummary("登录成功");
		}else {
			log.setLoginresult(DictConsts.DICT1017_FAILURE);
			log.setSummary("登录失败");
		}
		sysUserLoginDao.insert(log);
	}
	
	private void updateUserStatus(SysUser user, boolean loginSuccess) {
		log.info("重置用户登录时间及密码错误次数");
		SysUser upUser = new SysUser();
		upUser.copyPrimaryKey(user);
		upUser.setLogindate(DateUtils.getNowDate());
		upUser.setLogintime(DateUtils.getNowTime());
		//登录成功清除累计错误次数
		if(loginSuccess) {
			upUser.setLoginerror(0);
		}else {
			upUser.setLoginerror(user.getLoginerror() + 1);
			String maxPasswdErr = ParamConsts.getParam(user.getUnioncode(), ParamConsts.PARAM1003_PASSWD_ERROR_TIMES);
			if(upUser.getLoginerror() >= Integer.parseInt(maxPasswdErr)) {
				upUser.setStatus(DictConsts.DICT2001_USER_STATUS_PASSWDLOCK);
			}
		}
		sysUserDao.dynamicUpdateById(upUser);
	}
}
