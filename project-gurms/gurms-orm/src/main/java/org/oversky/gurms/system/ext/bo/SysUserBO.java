package org.oversky.gurms.system.ext.bo;

import java.io.Serializable;
import java.util.List;

import org.oversky.gurms.system.entity.SysMenu;
import org.oversky.gurms.system.entity.SysOrg;
import org.oversky.gurms.system.entity.SysRole;

public class SysUserBO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long userid;    //用户ID,内部自动生成
	private String unioncode;    //unioncode
	private String username;    //用户名称
	private String loginid;    //登录名

	private SysOrg sysorg;
	private List<SysMenu> menus;
	private List<SysRole> roles;
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUnioncode() {
		return unioncode;
	}
	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public SysOrg getSysorg() {
		return sysorg;
	}
	public void setSysorg(SysOrg sysorg) {
		this.sysorg = sysorg;
	}
	public List<SysMenu> getMenus() {
		return menus;
	}
	public void setMenus(List<SysMenu> menus) {
		this.menus = menus;
	}
	public List<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("userid=").append(userid);
		sb.append(", unioncode=").append(unioncode);
		sb.append(", username=").append(username);
		sb.append(", loginid=").append(loginid);
		sb.append(", sysorg=").append(sysorg == null ? "null" : sysorg.toString());
        return sb.toString();
	}
}
