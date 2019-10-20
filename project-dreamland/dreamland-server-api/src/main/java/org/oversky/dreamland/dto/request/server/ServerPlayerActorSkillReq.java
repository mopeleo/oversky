package org.oversky.dreamland.dto.request.server;

import org.oversky.base.service.BaseReqDto;

public class ServerPlayerActorSkillReq extends BaseReqDto {

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
