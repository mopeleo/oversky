package org.oversky.gurms.system.constant;

public final class DictConsts {

	private DictConsts() {}
	
	//dictgroup = 1
	public static final String DICT1000_YES = "1";	//是
	public static final String DICT1000_NO = "0";	//否

	public static final String DICT1001_FORBIT = "1";	//禁止
	public static final String DICT1001_ALLOW = "0";	//允许

	public static final String DICT1002_STOP = "0";		//停止
	public static final String DICT1002_START = "1";	//启动

	public static final String DICT1003_INVALID = "0";	//无效
	public static final String DICT1003_VALID = "1";	//有效	
	
	public static final String DICT1016_SUCCESS = "1";	//成功
	public static final String DICT1016_FAILURE = "0";	//失败	
	

	//dictgroup = 2
	public static final String DICT2001_USER_STATUS_DEL = "0";
	public static final String DICT2001_USER_STATUS_NORMAL = "1";
	public static final String DICT2001_USER_STATUS_PASSWDLOCK = "2";
	
	public static final String DICT2010_MENYTYPE_DIRECTORY = "0";	//目录
	public static final String DICT2010_MENYTYPE_MENU = "1";			//菜单
	public static final String DICT2010_MENYTYPE_ELEMENT = "2";		//页面元素
	
	public static final String DICT2011_ACCESSTYPE_ANY = "0";     //任意访问
	public static final String DICT2011_ACCESSTYPE_LOGIN = "1";	 //登陆访问
	public static final String DICT2011_ACCESSTYPE_AUTH = "2";	 //授权访问
	
	
	public enum SexEnum{
		MALE(1), FEMALE(0);
		private int sex;
		SexEnum(int sex){
			this.sex=sex;
		}
		
		public int value() {
			return this.sex;
		}
	}
}
