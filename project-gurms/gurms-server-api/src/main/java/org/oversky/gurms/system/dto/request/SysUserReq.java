package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class SysUserReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long userid;    //用户ID,内部自动生成[identity]
	private String unioncode;    //
	private String username;    //用户名称
	private String loginid;    //登录名
	private String loginpasswd;    //登录密码
	private String mobileno;    //手机号码
	private String email;    //电子邮件
	private Long orgid;    //所属机构
	private String idtype;    //证件类型
	private String idcode;    //证件号码
	private String idname;    //证件姓名
	private String status;    //用户状态，0，已注销；1，正常；2，锁定

	private String roleList;
	
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLoginid() {
		return this.loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getLoginpasswd() {
		return this.loginpasswd;
	}

	public void setLoginpasswd(String loginpasswd) {
		this.loginpasswd = loginpasswd;
	}

	public String getMobileno() {
		return this.mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getOrgid() {
		return this.orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public String getIdtype() {
		return this.idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public String getIdcode() {
		return this.idcode;
	}

	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}

	public String getIdname() {
		return this.idname;
	}

	public void setIdname(String idname) {
		this.idname = idname;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    public String getRoleList() {
		return roleList;
	}

	public void setRoleList(String roleList) {
		this.roleList = roleList;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", userid=").append(userid);
		sb.append(", unioncode=").append(unioncode);
		sb.append(", username=").append(username);
		sb.append(", loginid=").append(loginid);
		sb.append(", loginpasswd=").append(loginpasswd);
		sb.append(", mobileno=").append(mobileno);
		sb.append(", email=").append(email);
		sb.append(", orgid=").append(orgid);
		sb.append(", idtype=").append(idtype);
		sb.append(", idcode=").append(idcode);
		sb.append(", idname=").append(idname);
		sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
	}
}
