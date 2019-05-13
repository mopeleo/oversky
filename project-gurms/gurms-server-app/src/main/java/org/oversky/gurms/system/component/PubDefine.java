package org.oversky.gurms.system.component;

import org.oversky.gurms.system.constant.ParamConsts;

public class PubDefine {

	private PubDefine() {}
	
	/**
	 *	 是否超级管理员
	 * @param unioncode
	 * @param userid
	 * @return
	 */
	public static boolean isRootUser(String unioncode, Long userid) {
		String rootUser = ParamConsts.getParam(unioncode, ParamConsts.PK_SYS_ROOTUSER);
		if((","+rootUser+",").indexOf("," + userid + ",") != -1) {
			return true;
		}

		return false;
	}
}
