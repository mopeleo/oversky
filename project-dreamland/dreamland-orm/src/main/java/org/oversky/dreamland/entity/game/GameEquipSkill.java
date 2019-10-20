package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GameEquipSkill extends BaseEntity{

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GameEquipSkill");
		return build.append("#equipid:").append(this.equipid).append("#skillid:").append(this.skillid).toString();
	}

    public static String buildEntityKey(String equipid, String skillid){
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
