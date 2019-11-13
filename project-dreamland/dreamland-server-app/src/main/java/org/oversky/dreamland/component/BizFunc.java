package org.oversky.dreamland.component;

import org.oversky.dreamland.constant.ParamConsts;
import org.oversky.util.common.CommonUtils;
import org.oversky.util.date.DateUtils;
import org.oversky.util.encode.EncryptUtils;

public class BizFunc {

	private BizFunc() {}
	
	public static String createPasswdSalt() {
		return CommonUtils.getRandomString(8);
	}
	
	public static String encryptPassword(String password, String salt) {
		return EncryptUtils.md5Encode(password + salt);
	}
	
	public static String passwordInvalidDate(String unioncode) {
		String days = ParamConsts.getParam(unioncode, ParamConsts.PARAM1004_PASSWD_INVAILD_DAYS);
		String date = DateUtils.addDays(DateUtils.getNowDate(), Integer.parseInt(days));
		return date;
	}
}
