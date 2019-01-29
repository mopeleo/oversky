package org.oversky.gurms.entity.server;

import com.dl.server.entity.DLEntity;

public class ServerPlayerEquipAttribute extends DLEntity{

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

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayerEquipAttribute");
		return build.append(this.peid).append(this.attrid).toString();
	}

    public static String buildEntityKey(Long peid, String attrid){
        StringBuilder build = new StringBuilder("ServerPlayerEquipAttribute");
        return build.append(peid).append(attrid).toString();
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
