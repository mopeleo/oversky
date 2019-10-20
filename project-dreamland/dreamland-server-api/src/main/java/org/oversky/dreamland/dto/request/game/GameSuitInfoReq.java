package org.oversky.dreamland.dto.request.game;

import org.oversky.base.service.BaseReqDto;

public class GameSuitInfoReq extends BaseReqDto {

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
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", suitid=").append(suitid);
		sb.append(", suitname=").append(suitname);
		sb.append(", profession=").append(profession);
		sb.append(", unlocklevel=").append(unlocklevel);
		sb.append(", summary=").append(summary);
        sb.append("]");
        return sb.toString();
	}
}
