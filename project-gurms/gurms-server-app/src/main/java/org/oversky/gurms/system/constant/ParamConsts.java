package org.oversky.gurms.system.constant;

import org.oversky.base.service.BaseServiceException;
import org.oversky.gurms.common.spring.SpringBeanUtils;
import org.oversky.gurms.system.dao.SysParamDao;
import org.oversky.gurms.system.entity.SysParam;

public final class ParamConsts {
	
	private static SysParamDao paramDao = SpringBeanUtils.getBean(SysParamDao.class);

	//系统初始化默认值
	public final static String DEFAULT_UNIONCODE = "0000";   			//默认的unioncode
	public final static Long DEFAULT_ROOTORG = 1L;						//默认的系统虚拟顶级机构
	
	
	//sys_param表定义的参数
	public final static Integer PARAM1000_SYS_MODE = 1000;				//模式 1-单用户，2-多法人
	public final static Integer PARAM1001_SYS_ROOTUSER = 1001;			//超级用户
	public final static Integer PARAM1002_PASSWD_MIN_LENGTH = 1002;		//密码最小长度
	public final static Integer PARAM1003_PASSWD_ERROR_TIMES = 1003;	//密码错误次数
	
	public final static Integer PARAM1004_DELORG_DEALUSER = 1004;		//删除机构处理用户
	public final static String PARAM1004_CANT_DEL = "0";				//不能删除
	public final static String PARAM1004_MOVE_PARENT = "1";				//删除后移到父机构
	
	public final static Integer PARAM1005_DELORG_DEALCHILD = 1005;		//删除机构处理子机构
	public final static String PARAM1005_CANT_DEL = "0";				//不能删除
	public final static String PARAM1005_MOVE_PARENT = "1";				//删除后子机构变为父机构
	public final static String PARAM1005_DEL_CHILDREN = "2";			//删除子机构
	
	
	public static String getParam(String unioncode, Integer paramid) {
		SysParam value = paramDao.getById(unioncode, paramid);
		if(value == null) {
			value = paramDao.getById(DEFAULT_UNIONCODE, paramid);
			if(value == null) {
				throw new BaseServiceException("错误的系统参数 : " + paramid);
			}			
		}
		
		return value.getParamvalue();
	}
	
}
