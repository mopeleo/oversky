package org.oversky.dreamland.dto.response.game;

import org.oversky.base.service.BaseResDto;

public class GameEquipSkillRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private String equipid;    //
	private String skillid;    //
	private Integer proficiency;    //解锁熟练度
	private Integer sno;    //排序号，从上到下，从小到大，小在上

	public String getEquipid() {
		return this.equipid;
	}

	public void setEquipid(String equipid) {
		this.equipid = equipid;
	}

	public String getSkillid() {
		return this.skillid;
	}

	public void setSkillid(String skillid) {
		this.skillid = skillid;
	}

	public Integer getProficiency() {
		return this.proficiency;
	}

	public void setProficiency(Integer proficiency) {
		this.proficiency = proficiency;
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
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", equipid=").append(equipid);
		sb.append(", skillid=").append(skillid);
		sb.append(", proficiency=").append(proficiency);
		sb.append(", sno=").append(sno);
        sb.append("]");
        return sb.toString();
	}
}
