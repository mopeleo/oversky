package org.oversky.dreamland.dto.response.game;

import org.oversky.base.service.BaseResDto;

public class GameItemInfoRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private String itemid;    //道具ID
	private String itemname;    //道具名称
	private String icon;    //图标
	private String itemtype;    //道具类型（0-加经验，1-加血，2-加mp，3-剧情道具）
	private String grade;    //等级（0-白色，1-蓝色，2-金色，3-暗金）
	private String remark;    //描述

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getItemtype() {
		return this.itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("itemid=").append(itemid).append(", ");
		sb.append("itemname=").append(itemname).append(", ");
		sb.append("icon=").append(icon).append(", ");
		sb.append("itemtype=").append(itemtype).append(", ");
		sb.append("grade=").append(grade).append(", ");
		sb.append("remark=").append(remark).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
