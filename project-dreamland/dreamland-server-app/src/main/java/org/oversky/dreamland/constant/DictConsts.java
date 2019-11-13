package org.oversky.dreamland.constant;

public final class DictConsts {

	private DictConsts() {}
	
	//dictgroup = 1
	public static final String DICT1000_YES = "1";		//是
	public static final String DICT1000_NO = "0";		//否

	public static final String DICT1001_FORBIT = "0";	//禁止
	public static final String DICT1001_ALLOW = "1";	//允许

	public static final String DICT1002_STOP = "0";		//停止
	public static final String DICT1002_START = "1";	//启动

	public static final String DICT1003_INVALID = "0";	//无效
	public static final String DICT1003_VALID = "1";	//有效	
	
	public static final String DICT1014_UNFIXED = "0";	//不定长
	public static final String DICT1014_FIXED = "1";	//定长
	
	public static final String DICT1015_RESET_VALUE = "0";	//固定值复位
	public static final String DICT1015_RESET_DAY = "1";	//按天复位
	public static final String DICT1015_RESET_MONTH = "2";	//按月复位
	public static final String DICT1015_RESET_YEAR = "3";	//按年复位
	
	public static final String DICT1016_INCREASE = "1";	//递增
	public static final String DICT1016_DECREASE = "2";	//递减
	
	public static final String DICT1017_FAILURE = "0";	//失败	
	public static final String DICT1017_SUCCESS = "1";	//成功
	

	//dictgroup = 2
	public static final String DICT2001_USER_STATUS_NORMAL = "1";		//正常
	public static final String DICT2001_USER_STATUS_PASSWDLOCK = "2";	//密码锁定
	public static final String DICT2001_USER_STATUS_FROZEN = "3";		//冻结
	
	public static final String DICT2010_MENYTYPE_DIRECTORY = "0";		//目录
	public static final String DICT2010_MENYTYPE_MENU = "1";			//菜单
	public static final String DICT2010_MENYTYPE_ELEMENT = "2";			//页面元素
	
	public static final String DICT2011_ACCESSTYPE_ANY = "0";     		//任意访问
	public static final String DICT2011_ACCESSTYPE_LOGIN = "1";	 		//登陆访问
	public static final String DICT2011_ACCESSTYPE_AUTH = "2";	 		//授权访问
	
	public static final String DICT2013_CUSTLEVE_0 = "0";     		//初级
	public static final String DICT2013_CUSTLEVE_1 = "1";	 		//中级
	public static final String DICT2013_CUSTLEVE_2 = "2";	 		//高级
	
}
