package org.oversky.gurms.entity.game;

import com.dl.server.entity.DLEntity;

public class GameSuitInfo extends DLEntity{

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

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameSuitInfo");
		return build.append(this.suitid).toString();
	}

    public static String buildEntityKey(String suitid){
        StringBuilder build = new StringBuilder("GameSuitInfo");
        return build.append(suitid).toString();
    }
	
	public void clear(){
		this.suitid = null;
		this.suitname = null;
		this.profession = null;
		this.unlocklevel = null;
		this.summary = null;
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
