package org.oversky.dreamland.dto.request.game;

import org.oversky.base.service.BaseReqDto;

public class GameMeunInfoReq extends BaseReqDto {

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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("menuid=").append(menuid).append(", ");
		sb.append("menuname=").append(menuname).append(", ");
		sb.append("icon=").append(icon).append(", ");
		sb.append("url=").append(url).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
