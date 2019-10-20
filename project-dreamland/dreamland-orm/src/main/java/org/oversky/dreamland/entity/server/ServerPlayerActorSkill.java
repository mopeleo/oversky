package org.oversky.dreamland.entity.server;

import org.oversky.base.entity.BaseEntity;

public class ServerPlayerActorSkill extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long paid;    //player actor id
	private String skillid;    //
	private Integer level;    //

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayerActorSkill");
		return build.append("#paid:").append(this.paid).append("#skillid:").append(this.skillid).toString();
	}

    public static String buildEntityKey(Long paid, String skillid){
        StringBuilder build = new StringBuilder("ServerPlayerActorSkill");
        return build.append("#paid:").append(paid).append("#skillid:").append(skillid).toString();
    }
    
    public void copyPrimaryKey(ServerPlayerActorSkill entity){
		this.paid = entity.getPaid();
		this.skillid = entity.getSkillid();
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
