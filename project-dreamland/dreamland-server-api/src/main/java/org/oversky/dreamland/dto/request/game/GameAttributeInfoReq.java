package org.oversky.dreamland.dto.request.game;

import org.oversky.base.service.BaseReqDto;

public class GameAttributeInfoReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long attrid;    //属性ID
	private String attrtype;    //属性类型（0-基本属性，1-附加属性，2-套装属性）
	private Integer attrfield;    //属性附加字段（0-力量，1-智力，2-hp,3-mp,4-敏捷，5-幸运，6-物攻，7-魔攻，8-物防，9-法防，10-攻速，11-闪避，12-暴击，13-技能等级）
	private String unlock;    //解锁条件，套装属性用
	private String act;    //附加动作（0-减少，1-增加）
	private String valtype;    //附加值类型（0-固定值，1-比例）
	private Double valmin;    //附加值下限
	private Double valmax;    //附加值上限
	private Double initval;    //初始值，升级增加，适用基本属性
	private Double upval;    //升级每级增加值
	private String position;    //部位（1-武器，2-头饰，3-衣服，4-裤子，5-腰带，6-鞋子，7-项链，8-戒指）

	public Long getAttrid() {
		return this.attrid;
	}

	public void setAttrid(Long attrid) {
		this.attrid = attrid;
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

	public String getUnlock() {
		return this.unlock;
	}

	public void setUnlock(String unlock) {
		this.unlock = unlock;
	}

	public String getAct() {
		return this.act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public String getValtype() {
		return this.valtype;
	}

	public void setValtype(String valtype) {
		this.valtype = valtype;
	}

	public Double getValmin() {
		return this.valmin;
	}

	public void setValmin(Double valmin) {
		this.valmin = valmin;
	}

	public Double getValmax() {
		return this.valmax;
	}

	public void setValmax(Double valmax) {
		this.valmax = valmax;
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
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", attrid=").append(attrid);
		sb.append(", attrtype=").append(attrtype);
		sb.append(", attrfield=").append(attrfield);
		sb.append(", unlock=").append(unlock);
		sb.append(", act=").append(act);
		sb.append(", valtype=").append(valtype);
		sb.append(", valmin=").append(valmin);
		sb.append(", valmax=").append(valmax);
		sb.append(", initval=").append(initval);
		sb.append(", upval=").append(upval);
		sb.append(", position=").append(position);
        sb.append("]");
        return sb.toString();
	}
}
