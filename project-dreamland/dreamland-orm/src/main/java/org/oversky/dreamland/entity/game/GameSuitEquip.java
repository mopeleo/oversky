package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GameSuitEquip extends BaseEntity{

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GameSuitEquip");
		return build.append("#suitid:").append(this.suitid).append("#equipid:").append(this.equipid).toString();
	}

    public static String buildEntityKey(String suitid, String equipid){
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
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", suitid=").append(suitid);
		sb.append(", equipid=").append(equipid);
        sb.append("]");
        return sb.toString();
	}
}
