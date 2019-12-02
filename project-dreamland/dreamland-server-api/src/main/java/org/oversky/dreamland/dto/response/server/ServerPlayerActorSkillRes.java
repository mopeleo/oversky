package org.oversky.dreamland.dto.response.server;

import org.oversky.base.service.BaseResDto;

public class ServerPlayerActorSkillRes extends BaseResDto {

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
