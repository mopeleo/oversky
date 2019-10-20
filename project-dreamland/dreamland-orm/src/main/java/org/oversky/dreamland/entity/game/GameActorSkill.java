package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GameActorSkill extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String actorid;    //角色ID
	private String skillid;    //技能ID
	private Integer unlocklevel;    //解锁等级
	private String extendflag;    //是否可继承(0-否，1-是）
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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GameActorSkill");
		return build.append("#actorid:").append(this.actorid).append("#skillid:").append(this.skillid).toString();
	}

    public static String buildEntityKey(String actorid, String skillid){
        StringBuilder build = new StringBuilder("GameActorSkill");
        return build.append("#actorid:").append(actorid).append("#skillid:").append(skillid).toString();
    }
    
    public void copyPrimaryKey(GameActorSkill entity){
		this.actorid = entity.getActorid();
		this.skillid = entity.getSkillid();
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
