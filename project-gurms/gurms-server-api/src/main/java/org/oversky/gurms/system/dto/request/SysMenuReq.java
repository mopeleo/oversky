package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class SysMenuReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String menuid;    //菜单ID
	private String menuname;    //菜单名称
	private String menuurl;    //菜单地址
	private String parentmenu;    //上级菜单
	private int menutype;    //菜单类型0-目录，1-菜单，2-页面链接
	private int opentype;    //打开方式，0-本页刷新，1-打开新页，2-弹出窗口
	private int status;    //菜单状态，0-无效，1-有效

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

	public String getMenuurl() {
		return this.menuurl;
	}

	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}

	public String getParentmenu() {
		return this.parentmenu;
	}

	public void setParentmenu(String parentmenu) {
		this.parentmenu = parentmenu;
	}

	public int getMenutype() {
		return this.menutype;
	}

	public void setMenutype(int menutype) {
		this.menutype = menutype;
	}

	public int getOpentype() {
		return this.opentype;
	}

	public void setOpentype(int opentype) {
		this.opentype = opentype;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", menuid=").append(menuid);
		sb.append(", menuname=").append(menuname);
		sb.append(", menuurl=").append(menuurl);
		sb.append(", parentmenu=").append(parentmenu);
		sb.append(", menutype=").append(menutype);
		sb.append(", opentype=").append(opentype);
		sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
	}
}
