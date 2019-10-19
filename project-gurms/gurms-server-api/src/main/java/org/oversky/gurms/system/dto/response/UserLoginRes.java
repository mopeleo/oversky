package org.oversky.gurms.system.dto.response;

import org.oversky.base.service.BaseResDto;

public class UserLoginRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private Long userid;    //用户ID,内部自动生成
	private String unioncode;    //unioncode
	private String username;    //用户名称
	private String loginid;    //登录名
	private Long orgid;    //所属机构
	private String orgname;
	private Integer status;    //用户状态，0，已删除；1，正常；2，锁定
	private String token;
	
	private SysMenuRes menuTree;
	
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
	public Long getOrgid() {
		return orgid;
	}
	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public SysMenuRes getMenuTree() {
		return menuTree;
	}
	public void setMenuTree(SysMenuRes menuTree) {
		this.menuTree = menuTree;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
