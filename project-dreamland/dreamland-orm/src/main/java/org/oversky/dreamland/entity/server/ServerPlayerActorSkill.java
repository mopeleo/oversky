package org.oversky.dreamland.entity.server;

import org.oversky.base.entity.BaseEntity;

public class ServerPlayerActorSkill extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long paid;    //[identity]
	private Long skillid;    //
	private Integer skilllevel;    //

	public Long getPaid() {
		return this.paid;
	}

	public void setPaid(Long paid) {
		this.paid = paid;
	}

	public Long getSkillid() {
		return this.skillid;
	}

	public void setSkillid(Long skillid) {
		this.skillid = skillid;
	}

	public Integer getSkilllevel() {
		return this.skilllevel;
	}

	public void setSkilllevel(Integer skilllevel) {
		this.skilllevel = skilllevel;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayerActorSkill");
		return build.append("#paid:").append(this.paid).append("#skillid:").append(this.skillid).toString();
	}

    public static String buildEntityKey(Long paid, Long skillid){
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
		sb.append("paid=").append(paid).append(", ");
		sb.append("skillid=").append(skillid).append(", ");
		sb.append("skilllevel=").append(skilllevel).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
