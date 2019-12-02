package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GameMeun extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long menuid;    //[identity]
	private String unioncode;    //
	private Long gameid;    //游戏ID
	private String menuname;    //
	private String icon;    //
	private String url;    //

	public Long getMenuid() {
		return this.menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Long getGameid() {
		return this.gameid;
	}

	public void setGameid(Long gameid) {
		this.gameid = gameid;
	}

	public String getMenuname() {
		return this.menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GameMeun");
		return build.append("#menuid:").append(this.menuid).toString();
	}

    public static String buildEntityKey(Long menuid){
        StringBuilder build = new StringBuilder("GameMeun");
        return build.append("#menuid:").append(menuid).toString();
    }
    
    public void copyPrimaryKey(GameMeun entity){
		this.menuid = entity.getMenuid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("menuid=").append(menuid).append(", ");
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("gameid=").append(gameid).append(", ");
		sb.append("menuname=").append(menuname).append(", ");
		sb.append("icon=").append(icon).append(", ");
		sb.append("url=").append(url).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
