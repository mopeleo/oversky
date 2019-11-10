package org.oversky.dreamland.dto.request.game;

import org.oversky.base.service.BaseReqDto;

public class GameEquipInfoReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String equipid;    //装备ID
	private String equipname;    //装备名称
	private String icon;    //图标
	private String position;    //部位（1-武器，2-头饰，3-衣服，4-裤子，5-腰带，6-鞋子，7-项链，8-戒指）
	private String grade;    //等级（0-白色，1-蓝色，2-金色，3-暗金，4-绿色套装）
	private String profession;    //适用职业，多个职业用逗号分隔
	private String remark;    //描述

	public String getEquipid() {
		return this.equipid;
	}

	public void setEquipid(String equipid) {
		this.equipid = equipid;
	}

	public String getEquipname() {
		return this.equipname;
	}

	public void setEquipname(String equipname) {
		this.equipname = equipname;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
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
		sb.append(", equipid=").append(equipid);
		sb.append(", equipname=").append(equipname);
		sb.append(", icon=").append(icon);
		sb.append(", position=").append(position);
		sb.append(", grade=").append(grade);
		sb.append(", profession=").append(profession);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
	}
}
