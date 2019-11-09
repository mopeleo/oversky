package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GameItemInfo extends BaseEntity{

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GameItemInfo");
		return build.append("#itemid:").append(this.itemid).toString();
	}

    public static String buildEntityKey(String itemid){
        StringBuilder build = new StringBuilder("GameItemInfo");
        return build.append("#itemid:").append(itemid).toString();
    }
    
    public void copyPrimaryKey(GameItemInfo entity){
		this.itemid = entity.getItemid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", itemid=").append(itemid);
		sb.append(", itemname=").append(itemname);
		sb.append(", icon=").append(icon);
		sb.append(", itemtype=").append(itemtype);
		sb.append(", grade=").append(grade);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
	}
}
