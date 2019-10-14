package org.oversky.gurms.system.constant;

import org.oversky.gurms.common.spring.SpringBeanUtils;
import org.oversky.gurms.system.service.SysParamService;

public final class ParamConsts {
	
	private static SysParamService paramService = SpringBeanUtils.getBean(SysParamService.class);

	//系统初始化默认值
	public final static String DEFAULT_UNIONCODE = "0000";   			//默认的unioncode
	public final static Long DEFAULT_ROOTORG = 1L;						//默认的系统虚拟顶级机构
//	public final static Long DEFAULT_NULLORG = -1L;						//默认的系统虚拟不存在机构
	
	
	//sys_param表定义的参数
	public final static Integer PARAM1000_SYS_MODE = 1000;				//模式 1-单用户，2-多法人
	public final static String PARAM1000_SYS_MODE_SINGLE = "1";			//模式 1-单用户
	public final static String PARAM1000_SYS_MODE_MULTI = "2";			//模式 2-多法人
	
	public final static Integer PARAM1001_SYS_ROOTUSER = 1001;			//超级用户
	public final static Integer PARAM1002_PASSWD_INIT = 1002;			//初始化密码
	public final static Integer PARAM1003_PASSWD_ERROR_TIMES = 1003;	//密码错误次数
	public final static Integer PARAM1004_PASSWD_INVAILD_DAYS = 1004;	//密码失效天数
	
	public final static Integer PARAM1005_DELORG_DEALCHILD = 1005;		//删除机构处理子机构
	public final static String PARAM1005_CANT_DEL = "0";				//不能删除
	public final static String PARAM1005_MOVE_PARENT = "1";				//删除后子机构变为父机构
	public final static String PARAM1005_DEL_CHILDREN = "2";			//删除子机构
	
	public final static Integer PARAM1006_DELORG_DEALUSER = 1006;		//删除机构处理用户
	public final static String PARAM1006_CANT_DEL = "0";				//不能删除
	public final static String PARAM1006_MOVE_PARENT = "1";				//删除后移到父机构
	
	//常用常量
	public final static Integer SEQUENCE_TEST = 1;						//测试序列主键
	
	public static String getParam(String unioncode, Integer paramid) {		
		return paramService.getParam(unioncode, paramid).getParamvalue();
	}
	
	
	/**
	 * 是否根机构，根机构不允许编辑
	 * @param orgid
	 * @return
	 */
	public static boolean isRootOrg(Long orgid) {
		return orgid == DEFAULT_ROOTORG;
	}
	
	/**
	 * 是否根法人
	 * @param unioncode
	 * @return
	 */
	public static boolean isRootUnioncode(String unioncode) {
		return DEFAULT_UNIONCODE.equals(unioncode);
	}
	
	/**
	 * 是否多法人模式
	 * @return
	 */
	public static boolean isMultiLegal() {
		return PARAM1000_SYS_MODE_MULTI.equals(paramService.getSysMode());
	}
	
}
