package org.oversky.dreamland.dto.request.game;

import org.oversky.base.service.BaseReqDto;

public class GameItemInfoReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String itemid;    //道具ID
	private String itemname;    //道具名称
	private String icon;    //图标
	private String type;    //道具类型（0-加经验，1-加血，2-加mp，3-剧情道具）
	private String rank;    //等级（0-白色，1-蓝色，2-金色，3-暗金）
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRank() {
		return this.rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
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
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", itemid=").append(itemid);
		sb.append(", itemname=").append(itemname);
		sb.append(", icon=").append(icon);
		sb.append(", type=").append(type);
		sb.append(", rank=").append(rank);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
	}
}
