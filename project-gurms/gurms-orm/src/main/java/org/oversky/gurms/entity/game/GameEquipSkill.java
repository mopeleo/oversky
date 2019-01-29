package org.oversky.gurms.entity.game;

import com.dl.server.entity.DLEntity;

public class GameEquipSkill extends DLEntity{

	private String equipid;    //equipid
	private String skillid;    //skillid
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

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameEquipSkill");
		return build.append(this.equipid).append(this.skillid).toString();
	}

    public static String buildEntityKey(String equipid, String skillid){
        StringBuilder build = new StringBuilder("GameEquipSkill");
        return build.append(equipid).append(skillid).toString();
    }
	
	public void clear(){
		this.equipid = null;
		this.skillid = null;
		this.proficiency = null;
		this.sno = null;
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
