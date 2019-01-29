package org.oversky.gurms.entity.game;

import com.dl.server.entity.DLEntity;

public class GameActorSkill extends DLEntity{

	private String actorid;    //角色ID
	private String skillid;    //技能ID
	private Integer unlocklevel;    //解锁等级
	private Integer extendflag;    //是否可继承(0-否，1-是）
	private Integer sno;    //排序号，从上到下，从小到大，小在上

	public String getActorid() {
		return this.actorid;
	}

	public void setActorid(String actorid) {
		this.actorid = actorid;
	}

	public String getSkillid() {
		return this.skillid;
	}

	public void setSkillid(String skillid) {
		this.skillid = skillid;
	}

	public Integer getUnlocklevel() {
		return this.unlocklevel;
	}

	public void setUnlocklevel(Integer unlocklevel) {
		this.unlocklevel = unlocklevel;
	}

	public Integer getExtendflag() {
		return this.extendflag;
	}

	public void setExtendflag(Integer extendflag) {
		this.extendflag = extendflag;
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
		StringBuilder build = new StringBuilder("GameActorSkill");
		return build.append(this.actorid).append(this.skillid).toString();
	}

    public static String buildEntityKey(String actorid, String skillid){
        StringBuilder build = new StringBuilder("GameActorSkill");
        return build.append(actorid).append(skillid).toString();
    }
	
	public void clear(){
		this.actorid = null;
		this.skillid = null;
		this.unlocklevel = null;
		this.extendflag = null;
		this.sno = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", actorid=").append(actorid);
		sb.append(", skillid=").append(skillid);
		sb.append(", unlocklevel=").append(unlocklevel);
		sb.append(", extendflag=").append(extendflag);
		sb.append(", sno=").append(sno);
        sb.append("]");
        return sb.toString();
	}
}
