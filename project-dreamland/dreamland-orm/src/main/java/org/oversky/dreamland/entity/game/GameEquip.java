package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GameEquip extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long equipid;    //装备ID[identity]
	private String unioncode;    //
	private Long gameid;    //游戏ID
	private String equipname;    //装备名称
	private String icon;    //图标
	private String position;    //部位（1-武器，2-头饰，3-衣服，4-裤子，5-腰带，6-鞋子，7-项链，8-戒指）
	private String grade;    //等级（0-白色，1-蓝色，2-金色，3-暗金，4-绿色套装）
	private String profession;    //适用职业，多个职业用逗号分隔
	private String remark;    //描述

	public Long getEquipid() {
		return this.equipid;
	}

	public void setEquipid(Long equipid) {
		this.equipid = equipid;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Long getGameid() {
		return this.gameid;
	}

	public void setGameid(Long gameid) {
		this.gameid = gameid;
	}

	public String getEquipname() {
		return this.equipname;
	}

	public void setEquipname(String equipname) {
		this.equipname = equipname;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GameEquip");
		return build.append("#equipid:").append(this.equipid).toString();
	}

    public static String buildEntityKey(Long equipid){
        StringBuilder build = new StringBuilder("GameEquip");
        return build.append("#equipid:").append(equipid).toString();
    }
    
    public void copyPrimaryKey(GameEquip entity){
		this.equipid = entity.getEquipid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("equipid=").append(equipid).append(", ");
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("gameid=").append(gameid).append(", ");
		sb.append("equipname=").append(equipname).append(", ");
		sb.append("icon=").append(icon).append(", ");
		sb.append("position=").append(position).append(", ");
		sb.append("grade=").append(grade).append(", ");
		sb.append("profession=").append(profession).append(", ");
		sb.append("remark=").append(remark).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
