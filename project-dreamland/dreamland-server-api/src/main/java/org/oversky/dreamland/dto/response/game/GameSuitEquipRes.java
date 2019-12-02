package org.oversky.dreamland.dto.response.game;

import org.oversky.base.service.BaseResDto;

public class GameSuitEquipRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private Long suitid;    //
	private Long equipid;    //

	public Long getSuitid() {
		return this.suitid;
	}

	public void setSuitid(Long suitid) {
		this.suitid = suitid;
	}

	public Long getEquipid() {
		return this.equipid;
	}

	public void setEquipid(Long equipid) {
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
