package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GameInfo extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long gameid;    //
	private String unioncode;    //
	private String gamename;    //游戏名称
	private String fullname;    //游戏全称
	private String gamecode;    //游戏代码

	public Long getGameid() {
		return this.gameid;
	}

	public void setGameid(Long gameid) {
		this.gameid = gameid;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public String getGamename() {
		return this.gamename;
	}

	public void setGamename(String gamename) {
		this.gamename = gamename;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getGamecode() {
		return this.gamecode;
	}

	public void setGamecode(String gamecode) {
		this.gamecode = gamecode;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GameInfo");
		return build.append("#gameid:").append(this.gameid).toString();
	}

    public static String buildEntityKey(Long gameid){
        StringBuilder build = new StringBuilder("GameInfo");
        return build.append("#gameid:").append(gameid).toString();
    }
    
    public void copyPrimaryKey(GameInfo entity){
		this.gameid = entity.getGameid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", gameid=").append(gameid);
		sb.append(", unioncode=").append(unioncode);
		sb.append(", gamename=").append(gamename);
		sb.append(", fullname=").append(fullname);
		sb.append(", gamecode=").append(gamecode);
        sb.append("]");
        return sb.toString();
	}
}