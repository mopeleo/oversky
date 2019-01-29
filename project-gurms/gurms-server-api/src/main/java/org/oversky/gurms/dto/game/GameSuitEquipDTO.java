package org.oversky.gurms.dto.game;

import com.dl.server.dto.BaseDTO;

public class GameSuitEquipDTO extends BaseDTO {

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
