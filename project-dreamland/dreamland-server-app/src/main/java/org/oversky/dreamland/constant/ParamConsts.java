package org.oversky.dreamland.constant;

import org.oversky.common.spring.SpringBeanUtils;
import org.oversky.dreamland.dao.com.ComParamDao;

public final class ParamConsts {
	
	private static ComParamDao comParamDao = SpringBeanUtils.getBean(ComParamDao.class);

	public final static Integer PARAM2002_PASSWD_INIT = 2002;			//初始化密码
	public final static Integer PARAM2003_PASSWD_ERROR_TIMES = 2003;	//密码错误次数
	public final static Integer PARAM2004_PASSWD_INVAILD_DAYS = 2004;	//密码失效天数
	

	public static String getParam(String unioncode, Integer paramid) {		
		return comParamDao.getById(unioncode, paramid).getParamvalue();
	}	
	
}
