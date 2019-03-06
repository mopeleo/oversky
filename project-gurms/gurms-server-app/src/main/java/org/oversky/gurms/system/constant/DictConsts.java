package org.oversky.gurms.system.constant;

public final class DictConsts {

	private DictConsts() {}
	
	//dictcode = 1
	public static final Integer USER_STATUS_DEL = 0;
	public static final Integer USER_STATUS_NORMAL = 1;
	public static final Integer USER_STATUS_PASSWDLOCK = 2;
	
	
	
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
