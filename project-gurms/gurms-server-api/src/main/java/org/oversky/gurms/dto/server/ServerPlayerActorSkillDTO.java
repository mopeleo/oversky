package org.oversky.gurms.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPlayerActorSkillDTO extends BaseDTO {

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
