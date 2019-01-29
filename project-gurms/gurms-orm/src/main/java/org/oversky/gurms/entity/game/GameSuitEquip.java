package org.oversky.gurms.entity.game;

import com.dl.server.entity.DLEntity;

public class GameSuitEquip extends DLEntity{

	private String suitid;    //suitid
	private String equipid;    //equipid

	public String getSuitid() {
		return this.suitid;
	}

	public void setSuitid(String suitid) {
		this.suitid = suitid;
	}

	public String getEquipid() {
		return this.equipid;
	}

	public void setEquipid(String equipid) {
		this.equipid = equipid;
	}

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("GameSuitEquip");
		return build.append(this.suitid).append(this.equipid).toString();
	}

    public static String buildEntityKey(String suitid, String equipid){
        StringBuilder build = new StringBuilder("GameSuitEquip");
        return build.append(suitid).append(equipid).toString();
    }
	
	public void clear(){
		this.suitid = null;
		this.equipid = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", suitid=").append(suitid);
		sb.append(", equipid=").append(equipid);
        sb.append("]");
        return sb.toString();
	}
}
