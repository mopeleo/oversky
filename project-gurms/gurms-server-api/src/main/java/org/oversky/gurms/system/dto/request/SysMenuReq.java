package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class SysMenuReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String menuid;    //菜单ID
	private String menuname;    //菜单名称
	private String menuurl;    //菜单地址
	private String parentmenu;    //上级菜单
	private Integer menutype;    //菜单类型0-目录，1-菜单，2-页面链接
	private Integer accesstype;    //访问权限：0-可任意访问，1-登录访问，2-需授权
	private Integer status;    //菜单状态，0-无效，1-有效
	private String menucss;    //菜单样式

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

	public Integer getAccesstype() {
		return this.accesstype;
	}

	public void setAccesstype(Integer accesstype) {
		this.accesstype = accesstype;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMenucss() {
		return this.menucss;
	}

	public void setMenucss(String menucss) {
		this.menucss = menucss;
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
		sb.append(", accesstype=").append(accesstype);
		sb.append(", status=").append(status);
		sb.append(", menucss=").append(menucss);
        sb.append("]");
        return sb.toString();
	}
}
