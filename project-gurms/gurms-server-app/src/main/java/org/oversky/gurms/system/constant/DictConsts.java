package org.oversky.gurms.system.constant;

public final class DictConsts {

	private DictConsts() {}
	
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
