package org.oversky.dreamland.dto.request.game;

import org.oversky.base.service.BaseReqDto;

public class GameSuitEquipReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String suitid;    //
	private String equipid;    //

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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("suitid=").append(suitid).append(", ");
		sb.append("equipid=").append(equipid).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
