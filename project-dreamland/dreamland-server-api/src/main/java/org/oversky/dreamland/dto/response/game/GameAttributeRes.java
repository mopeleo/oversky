package org.oversky.dreamland.dto.response.game;

import org.oversky.base.service.BaseResDto;

public class GameAttributeRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private Long attrid;    //属性ID[identity]
	private String unioncode;    //
	private Long gameid;    //游戏ID
	private String attrtype;    //属性类型（0-基本属性，1-附加属性，2-套装属性）
	private Integer attrfield;    //属性附加字段（0-力量，1-智力，2-hp,3-mp,4-敏捷，5-幸运，6-物攻，7-魔攻，8-物防，9-法防，10-攻速，11-闪避，12-暴击，13-技能等级）
	private String unlockflag;    //解锁条件，套装属性用
	private String extralact;    //附加动作（0-减少，1-增加）
	private String extraltype;    //附加值类型（0-固定值，1-比例）
	private Double extralmin;    //附加值下限
	private Double extralmax;    //附加值上限
	private Double initval;    //初始值，升级增加，适用基本属性
	private Double upval;    //升级每级增加值
	private String position;    //部位（1-武器，2-头饰，3-衣服，4-裤子，5-腰带，6-鞋子，7-项链，8-戒指）

	public Long getAttrid() {
		return this.attrid;
	}

	public void setAttrid(Long attrid) {
		this.attrid = attrid;
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

	public String getAttrtype() {
		return this.attrtype;
	}

	public void setAttrtype(String attrtype) {
		this.attrtype = attrtype;
	}

	public Integer getAttrfield() {
		return this.attrfield;
	}

	public void setAttrfield(Integer attrfield) {
		this.attrfield = attrfield;
	}

	public String getUnlockflag() {
		return this.unlockflag;
	}

	public void setUnlockflag(String unlockflag) {
		this.unlockflag = unlockflag;
	}

	public String getExtralact() {
		return this.extralact;
	}

	public void setExtralact(String extralact) {
		this.extralact = extralact;
	}

	public String getExtraltype() {
		return this.extraltype;
	}

	public void setExtraltype(String extraltype) {
		this.extraltype = extraltype;
	}

	public Double getExtralmin() {
		return this.extralmin;
	}

	public void setExtralmin(Double extralmin) {
		this.extralmin = extralmin;
	}

	public Double getExtralmax() {
		return this.extralmax;
	}

	public void setExtralmax(Double extralmax) {
		this.extralmax = extralmax;
	}

	public Double getInitval() {
		return this.initval;
	}

	public void setInitval(Double initval) {
		this.initval = initval;
	}

	public Double getUpval() {
		return this.upval;
	}

	public void setUpval(Double upval) {
		this.upval = upval;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("attrid=").append(attrid).append(", ");
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("gameid=").append(gameid).append(", ");
		sb.append("attrtype=").append(attrtype).append(", ");
		sb.append("attrfield=").append(attrfield).append(", ");
		sb.append("unlockflag=").append(unlockflag).append(", ");
		sb.append("extralact=").append(extralact).append(", ");
		sb.append("extraltype=").append(extraltype).append(", ");
		sb.append("extralmin=").append(extralmin).append(", ");
		sb.append("extralmax=").append(extralmax).append(", ");
		sb.append("initval=").append(initval).append(", ");
		sb.append("upval=").append(upval).append(", ");
		sb.append("position=").append(position).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
