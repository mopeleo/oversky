package org.oversky.gurms.entity.game;

import com.dl.server.entity.DLEntity;

public class GameSkillInfo extends DLEntity{

	private String skillid;    //技能ID
	private String skillname;    //技能名称
	private String icon;    //技能图标
	private Integer skilltype;    //技能类型（0-角色，1-装备）
	private Integer skillflag;    //技能标志（0-被动，1-主动）
	private Integer skillfrom;    //技能出处（0-自带，1-商店，2-掉落, 3-隐藏）
	private Integer initlevel;    //初始等级
	private Integer maxlevel;    //最大等级
	private String remark;    //技能描述
	private Integer prop;    //技能附加属性（0-防御，1-攻击，2-暴击，3-伤害）
	private Integer target;    //作用目标（0- 敌方，1-我方）
	private Integer direct;    //作用方向（0-减少，1-增加）
	private Integer mode;    //作用类型（0-物理，1- 魔法）
	private Integer valtype;    //作用类型（0-固定值，1-比例）
	private Double initvalue;    //附加属性初始值
	private Double upvalue;    //每级增加属性值
	private Integer princetype;    //定价类型（0-金币，1-钻石）
	private Integer prince;    //价格（购买时才有）

	public String getSkillid() {
		return this.skillid;
	}

	public void setSkillid(String skillid) {
		this.skillid = skillid;
	}

	public String getSkillname() {
		return this.skillname;
	}

	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getSkilltype() {
		return this.skilltype;
	}

	public void setSkilltype(Integer skilltype) {
		this.skilltype = skilltype;
	}

	public Integer getSkillflag() {
		return this.skillflag;
	}

	public void setSkillflag(Integer skillflag) {
		this.skillflag = skillflag;
	}

	public Integer getSkillfrom() {
		return this.skillfrom;
	}

	public void setSkillfrom(Integer skillfrom) {
		this.skillfrom = skillfrom;
	}

	public Integer getInitlevel() {
		return this.initlevel;
	}

	public void setInitlevel(Integer initlevel) {
		this.initlevel = initlevel;
	}

	public Integer getMaxlevel() {
		return this.maxlevel;
	}

	public void setMaxlevel(Integer maxlevel) {
		this.maxlevel = maxlevel;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getProp() {
		return this.prop;
	}

	public void setProp(Integer prop) {
		this.prop = prop;
	}

	public Integer getTarget() {
		return this.target;
	}

	public void setTarget(Integer target) {
		this.target = target;
	}

	public Integer getDirect() {
		return this.direct;
	}

	public void setDirect(Integer direct) {
		this.direct = direct;
	}

	public Integer getMode() {
		return this.mode;
	}

	public void setMode(Integer mode) {
		this.mode = mode;
	}

	public Integer getValtype() {
		return this.valtype;
	}

	public void setValtype(Integer valtype) {
		this.valtype = valtype;
	}

	public Double getInitvalue() {
		return this.initvalue;
	}

	public void setInitvalue(Double initvalue) {
		this.initvalue = initvalue;
	}

	public Double getUpvalue() {
		return this.upvalue;
	}

	public void setUpvalue(Double upvalue) {
		this.upvalue = upvalue;
	}

	public Integer getPrincetype() {
		return this.princetype;
	}

	public void setPrincetype(Integer princetype) {
		this.princetype = princetype;
	}

	public Integer getPrince() {
		return this.prince;
	}

	public void setPrince(Integer prince) {
		this.prince = prince;
	}

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameSkillInfo");
		return build.append(this.skillid).toString();
	}

    public static String buildEntityKey(String skillid){
        StringBuilder build = new StringBuilder("GameSkillInfo");
        return build.append(skillid).toString();
    }
	
	public void clear(){
		this.skillid = null;
		this.skillname = null;
		this.icon = null;
		this.skilltype = null;
		this.skillflag = null;
		this.skillfrom = null;
		this.initlevel = null;
		this.maxlevel = null;
		this.remark = null;
		this.prop = null;
		this.target = null;
		this.direct = null;
		this.mode = null;
		this.valtype = null;
		this.initvalue = null;
		this.upvalue = null;
		this.princetype = null;
		this.prince = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", skillid=").append(skillid);
		sb.append(", skillname=").append(skillname);
		sb.append(", icon=").append(icon);
		sb.append(", skilltype=").append(skilltype);
		sb.append(", skillflag=").append(skillflag);
		sb.append(", skillfrom=").append(skillfrom);
		sb.append(", initlevel=").append(initlevel);
		sb.append(", maxlevel=").append(maxlevel);
		sb.append(", remark=").append(remark);
		sb.append(", prop=").append(prop);
		sb.append(", target=").append(target);
		sb.append(", direct=").append(direct);
		sb.append(", mode=").append(mode);
		sb.append(", valtype=").append(valtype);
		sb.append(", initvalue=").append(initvalue);
		sb.append(", upvalue=").append(upvalue);
		sb.append(", princetype=").append(princetype);
		sb.append(", prince=").append(prince);
        sb.append("]");
        return sb.toString();
	}
}
