package org.oversky.gurms.system.ext.bo;

import org.oversky.gurms.system.entity.SysDictIndex;

public class SysDictBO extends SysDictIndex{

	private static final long serialVersionUID = 1L;
	
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
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("itemcode=").append(itemcode);
		sb.append(", itemname=").append(itemname);
		sb.append(", ").append(super.toString());
        return sb.toString();
	}
}
