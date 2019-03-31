package org.oversky.base.util;

import java.util.Random;

import org.oversky.base.exception.BaseUtilException;

public class CommonUtils {
	//大写I与小写L区别不出来，导致输入错误，屏蔽掉
	private final static char[] CHAR_CODES = {'A','B','C','D','E','F','G','H',
			'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X',
			'Y','Z','a','b','c','d','e','f','g','h','j','k','m','n','o',
			'p','q','r','s','t','u','v','w','x','y','z'};
	private final static char[] NUMBER_CODES = {'0','1','2','3','4','5','6','7','8','9'};
	
	private CommonUtils() {}
	
	public static Long getRandomNumber(int length) {
		if(length > 18 || length < 1) {
			throw new BaseUtilException("错误的数字长度");
		}
		String code = getRandomString(length, NUMBER_CODES);
		if(code.charAt(0) == '0') {
			code = "1" + code.substring(1);
		}
		return Long.parseLong(code);
	}
	
	public static String getRandomString(int length) {		
		return getRandomString(length, CHAR_CODES);
	}

	public static boolean existSuffix(String key, String[] suffix){
		return existSuffix(key, suffix, true);
	}
	
	/**
	 * 	//判断key是否是以suffix数组中的字符串结尾
	 * @param key
	 * @param suffix
	 * @param ignoreCase
	 * @return
	 */
	public static boolean existSuffix(String key, String[] suffix, boolean ignoreCase){
		if(suffix == null || suffix.length == 0){
			return true;
		}
		if(ignoreCase){
			String lowerKey = key.toLowerCase();
			for(String tmpSuffix : suffix){
				if(lowerKey.endsWith(tmpSuffix.toLowerCase())){
					return true;
				}
			}
		}else{
			for(String tmpSuffix : suffix){
				if(key.endsWith(tmpSuffix)){
					return true;
				}
			}
		}
		return false;
	}

	private static String getRandomString(int length, char[] source) {
		char[] codes = new char[length];
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			codes[i] = source[random.nextInt(source.length)];
		}
		String code = new String(codes);
		return code;
	}
}
