package org.oversky.gurms.system.ext.bo;

import org.oversky.gurms.system.entity.SysDictIndex;

public class SysDictBO extends SysDictIndex{

	private String itemcode;
	private String itemname;
	
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}	
	
}
