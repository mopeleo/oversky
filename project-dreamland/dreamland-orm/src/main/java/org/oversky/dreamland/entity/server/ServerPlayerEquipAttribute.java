package org.oversky.dreamland.entity.server;

import org.oversky.base.entity.BaseEntity;

public class ServerPlayerEquipAttribute extends BaseEntity{

	private static final long serialVersionUID = 1L;

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayerEquipAttribute");
		return build.append("#peid:").append(this.peid).append("#attrid:").append(this.attrid).toString();
	}

    public static String buildEntityKey(Long peid, String attrid){
        StringBuilder build = new StringBuilder("ServerPlayerEquipAttribute");
        return build.append("#peid:").append(peid).append("#attrid:").append(attrid).toString();
    }
    
    public void copyPrimaryKey(ServerPlayerEquipAttribute entity){
		this.peid = entity.getPeid();
		this.attrid = entity.getAttrid();
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
