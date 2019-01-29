package org.oversky.gurms.entity.game;

import com.dl.server.entity.DLEntity;

public class GameAttributeInfo extends DLEntity{

	private Long attrid;    //属性ID
	private Integer attrtype;    //属性类型（0-基本属性，1-附加属性，2-套装属性）
	private Integer attrfield;    //属性附加字段（0-力量，1-智力，2-hp,3-mp,4-敏捷，5-幸运，6-物攻，7-魔攻，8-物防，9-法防，10-攻速，11-闪避，12-暴击，13-技能等级）
	private Integer unlock;    //解锁条件，套装属性用
	private Integer act;    //附加动作（0-减少，1-增加）
	private Integer valtype;    //附加值类型（0-固定值，1-比例）
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

	public Integer getAttrtype() {
		return this.attrtype;
	}

	public void setAttrtype(Integer attrtype) {
		this.attrtype = attrtype;
	}

	public Integer getAttrfield() {
		return this.attrfield;
	}

	public void setAttrfield(Integer attrfield) {
		this.attrfield = attrfield;
	}

	public Integer getUnlock() {
		return this.unlock;
	}

	public void setUnlock(Integer unlock) {
		this.unlock = unlock;
	}

	public Integer getAct() {
		return this.act;
	}

	public void setAct(Integer act) {
		this.act = act;
	}

	public Integer getValtype() {
		return this.valtype;
	}

	public void setValtype(Integer valtype) {
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

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameAttributeInfo");
		return build.append(this.attrid).toString();
	}

    public static String buildEntityKey(Long attrid){
        StringBuilder build = new StringBuilder("GameAttributeInfo");
        return build.append(attrid).toString();
    }
	
	public void clear(){
		this.attrid = null;
		this.attrtype = null;
		this.attrfield = null;
		this.unlock = null;
		this.act = null;
		this.valtype = null;
		this.valmin = null;
		this.valmax = null;
		this.initval = null;
		this.upval = null;
		this.position = null;
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
