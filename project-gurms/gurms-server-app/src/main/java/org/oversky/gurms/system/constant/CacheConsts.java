package org.oversky.gurms.system.constant;

import org.oversky.base.service.BaseServiceException;
import org.oversky.gurms.common.spring.SpringBeanUtils;
import org.oversky.gurms.system.dao.SysParamDao;
import org.oversky.gurms.system.entity.SysParam;

public final class CacheConsts {
	
	private static SysParamDao paramDao = SpringBeanUtils.getBean(SysParamDao.class);

	public final static String DEFUALT_UNIONCODE = "0000";   	//默认的unioncode
	public final static Integer PK_SYS_ROOTUSER = 0;			//超级用户
	public final static Integer PK_SYS_MODE = 1;				//模式 1-单用户，2-多法人
	public final static Integer PK_PASSWD_ERROR_TIMES = 2;		//密码错误次数
	
	public static String getParam(String unioncode, Integer paramid) {
		SysParam value = paramDao.getById(unioncode, paramid);
		if(value == null) {
			value = paramDao.getById(DEFUALT_UNIONCODE, paramid);
			if(value == null) {
				throw new BaseServiceException("错误的系统参数 : " + paramid);
			}			
		}
		
		return value.getParamvalue();
	}
	
}
