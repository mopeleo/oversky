package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GameMeunInfo extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String menuid;    //
	private String menuname;    //
	private String icon;    //
	private String url;    //

	public String getMenuid() {
		return this.menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
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
		StringBuilder build = new StringBuilder("GameMeunInfo");
		return build.append("#menuid:").append(this.menuid).toString();
	}

    public static String buildEntityKey(String menuid){
        StringBuilder build = new StringBuilder("GameMeunInfo");
        return build.append("#menuid:").append(menuid).toString();
    }
    
    public void copyPrimaryKey(GameMeunInfo entity){
		this.menuid = entity.getMenuid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", menuid=").append(menuid);
		sb.append(", menuname=").append(menuname);
		sb.append(", icon=").append(icon);
		sb.append(", url=").append(url);
        sb.append("]");
        return sb.toString();
	}
}
