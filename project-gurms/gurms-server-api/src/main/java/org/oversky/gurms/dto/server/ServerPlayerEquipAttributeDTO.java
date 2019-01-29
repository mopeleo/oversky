package org.oversky.gurms.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPlayerEquipAttributeDTO extends BaseDTO {

	private Long peid;    //玩家装备ID
	private String attrid;    //属性ID
	private Double attrval;    //属性值

	public Long getPeid() {
		return this.peid;
	}

	public void setPeid(Long peid) {
		this.peid = peid;
	}

	public String getAttrid() {
		return this.attrid;
	}

	public void setAttrid(String attrid) {
		this.attrid = attrid;
	}

	public Double getAttrval() {
		return this.attrval;
	}

	public void setAttrval(Double attrval) {
		this.attrval = attrval;
	}


	public void clear(){
		this.peid = null;
		this.attrid = null;
		this.attrval = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", peid=").append(peid);
		sb.append(", attrid=").append(attrid);
		sb.append(", attrval=").append(attrval);
        sb.append("]");
        return sb.toString();
	}
}
