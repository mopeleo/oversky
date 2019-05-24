package org.oversky.gurms.system.component;

import org.oversky.gurms.system.constant.ParamConsts;
import org.oversky.util.common.CommonUtils;

public class BizFunc {

	private BizFunc() {}
	
	public static String getPasswdSalt() {
		return CommonUtils.getRandomString(8);
	}
	
	/**
	 *	 是否超级管理员，超级管理员不允许编辑
	 * @param unioncode
	 * @param userid
	 * @return
	 */
	public static boolean isRootUser(Long userid) {
		String rootUser = ParamConsts.getParam(ParamConsts.DEFAULT_UNIONCODE, ParamConsts.PARAM1001_SYS_ROOTUSER);
		if((","+rootUser+",").indexOf("," + userid + ",") != -1) {
			return true;
		}

		return false;
	}
	
	/**
	 * 是否根机构，根机构不允许编辑
	 * @param orgid
	 * @return
	 */
	public static boolean isRootOrg(Long orgid) {
		if(orgid != null && orgid == ParamConsts.DEFAULT_ROOTORG) {
			return true;
		}
		return false;
	}
}
