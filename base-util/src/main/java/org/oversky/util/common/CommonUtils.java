package org.oversky.util.common;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;

public class CommonUtils {
	
	//大写I与小写L区别不出来，导致输入错误，屏蔽掉
	private final static char[] CHAR_CODES = {'A','B','C','D','E','F','G','H',
			'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X',
			'Y','Z','a','b','c','d','e','f','g','h','j','k','m','n','o',
			'p','q','r','s','t','u','v','w','x','y','z'};

	private CommonUtils() {}
	
	public static String getRandomString(int length) {		
		char[] codes = new char[length];
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			codes[i] = CHAR_CODES[random.nextInt(CHAR_CODES.length)];
		}
		return new String(codes);
	}

	public static boolean isEmpty(String str) {
		return StringUtils.isBlank(str);
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
	
	public static boolean isTrue(Boolean flag) {
		return flag == null ? false : flag;
	}

}
