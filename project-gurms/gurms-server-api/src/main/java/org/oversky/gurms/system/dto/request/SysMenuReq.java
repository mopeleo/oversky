package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class SysMenuReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String menuid;    //菜单ID
	private Integer sysid;
	private String menuname;    //菜单名称
	private String menuurl;    //菜单地址
	private String parentmenu;    //上级菜单
	private String menutype;    //菜单类型0-目录，1-菜单，2-页面链接
	private String accesstype;    //访问权限：0-可任意访问，1-登录访问，2-需授权
	private String status;    //菜单状态，0-无效，1-有效
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

	public String getMenutype() {
		return this.menutype;
	}

	public void setMenutype(String menutype) {
		this.menutype = menutype;
	}

	public String getAccesstype() {
		return this.accesstype;
	}

	public void setAccesstype(String accesstype) {
		this.accesstype = accesstype;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMenucss() {
		return this.menucss;
	}

	public void setMenucss(String menucss) {
		this.menucss = menucss;
	}

    public Integer getSysid() {
		return sysid;
	}

	public void setSysid(Integer sysid) {
		this.sysid = sysid;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("menuid=").append(menuid);
		sb.append(", sysid=").append(sysid);
		sb.append(", menuname=").append(menuname);
		sb.append(", menuurl=").append(menuurl);
		sb.append(", parentmenu=").append(parentmenu);
		sb.append(", menutype=").append(menutype);
		sb.append(", accesstype=").append(accesstype);
		sb.append(", status=").append(status);
		sb.append(", menucss=").append(menucss);
        sb.append("," + super.toString());
        return sb.toString();
	}
}
