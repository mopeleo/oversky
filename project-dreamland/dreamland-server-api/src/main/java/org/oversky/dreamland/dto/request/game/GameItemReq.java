package org.oversky.dreamland.dto.request.game;

import org.oversky.base.service.BaseReqDto;

public class GameItemReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long itemid;    //道具ID[identity]
	private String unioncode;    //
	private Long gameid;    //游戏ID
	private String itemname;    //道具名称
	private String icon;    //图标
	private String itemtype;    //道具类型（0-加经验，1-加血，2-加mp，3-剧情道具）
	private String grade;    //等级（0-白色，1-蓝色，2-金色，3-暗金）
	private String remark;    //描述

	public Long getItemid() {
		return this.itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Long getGameid() {
		return this.gameid;
	}

	public void setGameid(Long gameid) {
		this.gameid = gameid;
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
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("gameid=").append(gameid).append(", ");
		sb.append("itemname=").append(itemname).append(", ");
		sb.append("icon=").append(icon).append(", ");
		sb.append("itemtype=").append(itemtype).append(", ");
		sb.append("grade=").append(grade).append(", ");
		sb.append("remark=").append(remark).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
