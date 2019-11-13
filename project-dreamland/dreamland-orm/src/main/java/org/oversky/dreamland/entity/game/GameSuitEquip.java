package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GameSuitEquip extends BaseEntity{

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GameSuitEquip");
		return build.append("#suitid:").append(this.suitid).append("#equipid:").append(this.equipid).toString();
	}

    public static String buildEntityKey(Long suitid, Long equipid){
        StringBuilder build = new StringBuilder("GameSuitEquip");
        return build.append("#suitid:").append(suitid).append("#equipid:").append(equipid).toString();
    }
    
    public void copyPrimaryKey(GameSuitEquip entity){
		this.suitid = entity.getSuitid();
		this.equipid = entity.getEquipid();
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
