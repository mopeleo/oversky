package org.oversky.gurms.system.dto.response;

import org.oversky.base.service.BaseResDto;

public class SysUserRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private Long userid; // 用户ID,内部自动生成
	private String unioncode; // unioncode
	private String username; // 用户名称
	private String loginid; // 登录名
	private String loginpasswd; // 登录密码
	private String salt; // 密码盐
	private String mobileno; // 手机号码
	private String email; // 电子邮件
	private Integer orgid; // 所属机构
	private String idtype; // 证件类型
	private String idcode; // 证件号码
	private String logindate; // 登录日期
	private String logintime; // 登录时间
	private Integer status; // 用户状态，0，已删除；1，正常；2，锁定
	private Integer loginerror; // 连续登录失败次数
	private String passwdvaliddate; // 密码失效日期

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

	public String getLoginpasswd() {
		return loginpasswd;
	}

	public void setLoginpasswd(String loginpasswd) {
		this.loginpasswd = loginpasswd;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getOrgid() {
		return orgid;
	}

	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}

	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public String getIdcode() {
		return idcode;
	}

	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}

	public String getLogindate() {
		return logindate;
	}

	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getLoginerror() {
		return loginerror;
	}

	public void setLoginerror(Integer loginerror) {
		this.loginerror = loginerror;
	}

	public String getPasswdvaliddate() {
		return passwdvaliddate;
	}

	public void setPasswdvaliddate(String passwdvaliddate) {
		this.passwdvaliddate = passwdvaliddate;
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
		sb.append(", salt=").append(salt);
		sb.append(", mobileno=").append(mobileno);
		sb.append(", email=").append(email);
		sb.append(", orgid=").append(orgid);
		sb.append(", idtype=").append(idtype);
		sb.append(", idcode=").append(idcode);
		sb.append(", logindate=").append(logindate);
		sb.append(", logintime=").append(logintime);
		sb.append(", status=").append(status);
		sb.append(", loginerror=").append(loginerror);
		sb.append(", passwdvaliddate=").append(passwdvaliddate);
		sb.append("]");
		return sb.toString();
	}
}
