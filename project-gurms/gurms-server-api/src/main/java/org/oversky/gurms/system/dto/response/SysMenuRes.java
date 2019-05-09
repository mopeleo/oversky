package org.oversky.gurms.system.dto.response;

import java.util.List;

import org.oversky.base.service.BaseResDto;

public class SysMenuRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private String menuid;    //菜单ID
	private String menuname;    //菜单名称
	private String menuurl;    //菜单地址
	private String parentmenu;    //上级菜单
	private String menutype;    //菜单类型0-目录，1-菜单，2-页面链接
	private String accesstype;    //访问权限：0-可任意访问，1-登录访问，2-需授权
	private String menucss;
	private boolean tree;
	private List<SysMenuRes> subMenus;

	public String getMenuid() {
		return this.menuid;
	}

	public boolean isTree() {
		return tree;
	}

	public List<SysMenuRes> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SysMenuRes> subMenus) {
		this.subMenus = subMenus;
	}

	public void setTree(boolean tree) {
		this.tree = tree;
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
		return menutype;
	}

	public void setMenutype(String menutype) {
		this.menutype = menutype;
	}

	public String getAccesstype() {
		return accesstype;
	}

	public void setAccesstype(String accesstype) {
		this.accesstype = accesstype;
	}

	public String getMenucss() {
		return menucss;
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
        sb.append("]");
        return sb.toString();
	}
}
