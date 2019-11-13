package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GameEquipSkill extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long equipid;    //
	private Long skillid;    //
	private Integer proficiency;    //解锁熟练度
	private Integer sno;    //排序号，从上到下，从小到大，小在上

	public Long getEquipid() {
		return this.equipid;
	}

	public void setEquipid(Long equipid) {
		this.equipid = equipid;
	}

	public Long getSkillid() {
		return this.skillid;
	}

	public void setSkillid(Long skillid) {
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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GameEquipSkill");
		return build.append("#equipid:").append(this.equipid).append("#skillid:").append(this.skillid).toString();
	}

    public static String buildEntityKey(Long equipid, Long skillid){
        StringBuilder build = new StringBuilder("GameEquipSkill");
        return build.append("#equipid:").append(equipid).append("#skillid:").append(skillid).toString();
    }
    
    public void copyPrimaryKey(GameEquipSkill entity){
		this.equipid = entity.getEquipid();
		this.skillid = entity.getSkillid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("equipid=").append(equipid).append(", ");
		sb.append("skillid=").append(skillid).append(", ");
		sb.append("proficiency=").append(proficiency).append(", ");
		sb.append("sno=").append(sno).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
