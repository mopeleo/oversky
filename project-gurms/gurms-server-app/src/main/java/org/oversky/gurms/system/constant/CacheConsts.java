package org.oversky.gurms.system.constant;

import java.util.concurrent.ConcurrentHashMap;

import org.oversky.base.service.BaseServiceException;

public final class CacheConsts {
	
	private final static ConcurrentHashMap<String, String> CACHE = new ConcurrentHashMap<>();
	private final static String DEFUALT_UNIONCODE = "0000";   //默认的unioncode
	public final static Integer PK_SYS_MODE = 1;
	public final static Integer PK_PASSWD_ERROR_TIMES = 2;		//密码错误次数
	
	private CacheConsts() {}
	
	public static void put(Integer key, String unioncode, String value) {
		String mode = getSysMode();
		String paramKey = null;
		if("1".equals(mode)) {
			paramKey = getCacheKey(key, unioncode);
		}else {
			paramKey = getCacheKey(key, DEFUALT_UNIONCODE);
		}
		CACHE.put(paramKey, value);
	}
	
	public static String get(Integer key, String unioncode) {
		String mode = getSysMode();
		String paramKey = null;
		//如果是多法人模式
		if("1".equals(mode)) {
			//先取自己设置的参数
			paramKey = getCacheKey(key, unioncode);
			//若存在，则返回，不存在取公共的默认配置
			if(CACHE.containsKey(paramKey)) {
				return CACHE.get(paramKey);
			}
		}
		paramKey = getCacheKey(key, DEFUALT_UNIONCODE);
		return CACHE.get(paramKey);
	}
	
	private static String getSysMode() {
		String paramKey = getCacheKey(PK_SYS_MODE, DEFUALT_UNIONCODE);
		return CACHE.get(paramKey);
	}
	
	private static String getCacheKey(Integer key, String unioncode) {
		String paramKey = key.toString();
		if(unioncode != null && !"".equals(unioncode.trim())) {
			paramKey += "_" + unioncode.trim();
		}else {
			throw new BaseServiceException("unioncode不能为空");
		}
		
		return paramKey;
	}
}
