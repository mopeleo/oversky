package org.oversky.dreamland.dto.response.game;

import org.oversky.base.service.BaseResDto;

public class GameSuitInfoRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private String suitid;    //套装ID
	private String suitname;    //套装名称
	private String profession;    //适用职业，多个职业用逗号分隔
	private Integer unlocklevel;    //解锁等级
	private String summary;    //描述

	public String getSuitid() {
		return this.suitid;
	}

	public void setSuitid(String suitid) {
		this.suitid = suitid;
	}

	public String getSuitname() {
		return this.suitname;
	}

	public void setSuitname(String suitname) {
		this.suitname = suitname;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Integer getUnlocklevel() {
		return this.unlocklevel;
	}

	public void setUnlocklevel(Integer unlocklevel) {
		this.unlocklevel = unlocklevel;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("suitid=").append(suitid).append(", ");
		sb.append("suitname=").append(suitname).append(", ");
		sb.append("profession=").append(profession).append(", ");
		sb.append("unlocklevel=").append(unlocklevel).append(", ");
		sb.append("summary=").append(summary).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
