package org.oversky.gurms.dto.sys;

import com.dl.server.dto.BaseDTO;

public class SysMenuDTO extends BaseDTO {

	private String menuid;    //菜单ID
	private String menuname;    //菜单名称
	private String menuurl;    //菜单地址
	private String parentmenu;    //上级菜单
	private Integer menutype;    //菜单类型0-目录，1-菜单，2-页面链接
	private Integer opentype;    //打开方式，0-本页刷新，1-打开新页，2-弹出窗口
	private Integer status;    //菜单状态，0-无效，1-有效

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

	public Integer getMenutype() {
		return this.menutype;
	}

	public void setMenutype(Integer menutype) {
		this.menutype = menutype;
	}

	public Integer getOpentype() {
		return this.opentype;
	}

	public void setOpentype(Integer opentype) {
		this.opentype = opentype;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	public void clear(){
		this.menuid = null;
		this.menuname = null;
		this.menuurl = null;
		this.parentmenu = null;
		this.menutype = null;
		this.opentype = null;
		this.status = null;
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
