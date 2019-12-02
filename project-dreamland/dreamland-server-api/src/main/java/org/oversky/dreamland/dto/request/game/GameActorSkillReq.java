package org.oversky.dreamland.dto.request.game;

import org.oversky.base.service.BaseReqDto;

public class GameActorSkillReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long actorid;    //角色ID
	private Long skillid;    //技能ID
	private Integer unlocklevel;    //解锁等级
	private String extendflag;    //是否可继承(0-否，1-是）
	private Integer sno;    //排序号，从上到下，从小到大，小在上

	public Long getActorid() {
		return this.actorid;
	}

	public void setActorid(Long actorid) {
		this.actorid = actorid;
	}

	public Long getSkillid() {
		return this.skillid;
	}

	public void setSkillid(Long skillid) {
		this.skillid = skillid;
	}

	public Integer getUnlocklevel() {
		return this.unlocklevel;
	}

	public void setUnlocklevel(Integer unlocklevel) {
		this.unlocklevel = unlocklevel;
	}

	public String getExtendflag() {
		return this.extendflag;
	}

	public void setExtendflag(String extendflag) {
		this.extendflag = extendflag;
	}

	public Integer getSno() {
		return this.sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("actorid=").append(actorid).append(", ");
		sb.append("skillid=").append(skillid).append(", ");
		sb.append("unlocklevel=").append(unlocklevel).append(", ");
		sb.append("extendflag=").append(extendflag).append(", ");
		sb.append("sno=").append(sno).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
