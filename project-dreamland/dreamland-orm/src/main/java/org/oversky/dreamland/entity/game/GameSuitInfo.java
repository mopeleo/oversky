package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GameSuitInfo extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long suitid;    //套装ID[identity]
	private String suitname;    //套装名称
	private String profession;    //适用职业，多个职业用逗号分隔
	private Integer unlocklevel;    //解锁等级
	private String summary;    //描述

	public Long getSuitid() {
		return this.suitid;
	}

	public void setSuitid(Long suitid) {
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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GameSuitInfo");
		return build.append("#suitid:").append(this.suitid).toString();
	}

    public static String buildEntityKey(Long suitid){
        StringBuilder build = new StringBuilder("GameSuitInfo");
        return build.append("#suitid:").append(suitid).toString();
    }
    
    public void copyPrimaryKey(GameSuitInfo entity){
		this.suitid = entity.getSuitid();
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
