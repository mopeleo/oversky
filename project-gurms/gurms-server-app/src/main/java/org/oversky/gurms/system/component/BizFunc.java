package org.oversky.gurms.system.component;

import org.oversky.gurms.system.constant.ParamConsts;
import org.oversky.util.common.CommonUtils;
import org.oversky.util.date.DateUtils;
import org.oversky.util.encode.EncryptUtils;

public class BizFunc {

	private BizFunc() {}
	
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
	
	public static String createPasswdSalt() {
		return CommonUtils.getRandomString(8);
	}
	
	public static String encryptPassword(String password, String salt) {
		return EncryptUtils.md5Encode(password + salt);
	}
	
	public static String passwordInvalidDate() {
		String days = ParamConsts.getParam(ParamConsts.DEFAULT_UNIONCODE, ParamConsts.PARAM1004_PASSWD_INVAILD_DAYS);
		String date = DateUtils.addDays(DateUtils.getNowDate(), Integer.parseInt(days));
		return date;
	}
}
