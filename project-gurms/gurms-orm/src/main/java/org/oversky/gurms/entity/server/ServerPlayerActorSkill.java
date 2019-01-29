package org.oversky.gurms.entity.server;

import com.dl.server.entity.DLEntity;

public class ServerPlayerActorSkill extends DLEntity{

	private Long paid;    //player actor id
	private String skillid;    //skillid
	private Integer level;    //level

	public Long getPaid() {
		return this.paid;
	}

	public void setPaid(Long paid) {
		this.paid = paid;
	}

	public String getSkillid() {
		return this.skillid;
	}

	public void setSkillid(String skillid) {
		this.skillid = skillid;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayerActorSkill");
		return build.append(this.paid).append(this.skillid).toString();
	}

    public static String buildEntityKey(Long paid, String skillid){
        StringBuilder build = new StringBuilder("ServerPlayerActorSkill");
        return build.append(paid).append(skillid).toString();
    }
	
	public void clear(){
		this.paid = null;
		this.skillid = null;
		this.level = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", paid=").append(paid);
		sb.append(", skillid=").append(skillid);
		sb.append(", level=").append(level);
        sb.append("]");
        return sb.toString();
	}
}
