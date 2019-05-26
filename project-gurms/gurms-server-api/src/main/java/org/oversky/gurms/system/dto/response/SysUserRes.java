package org.oversky.gurms.system.dto.response;

import org.oversky.base.service.BaseResDto;

public class SysUserRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private Long userid;    //用户ID,内部自动生成[identity]
	private String unioncode;    //
	private String username;    //用户名称
	private String loginid;    //登录名
	private String passwdvaliddate;    //密码失效日期
	private String mobileno;    //手机号码
	private String email;    //电子邮件
	private Long orgid;    //所属机构
	private String idtype;    //证件类型
	private String idcode;    //证件号码
	private String idname;    //证件姓名
	private String logindate;    //上次登录日期
	private String logintime;    //上次登录时间
	private String status;    //用户状态，0，已注销；1，正常；2，锁定
	private String opendate;    //创建日期
	private String canceldate;    //注销日期

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

	public String getPasswdvaliddate() {
		return this.passwdvaliddate;
	}

	public void setPasswdvaliddate(String passwdvaliddate) {
		this.passwdvaliddate = passwdvaliddate;
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

	public String getLogindate() {
		return this.logindate;
	}

	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}

	public String getLogintime() {
		return this.logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOpendate() {
		return this.opendate;
	}

	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}

	public String getCanceldate() {
		return this.canceldate;
	}

	public void setCanceldate(String canceldate) {
		this.canceldate = canceldate;
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
		sb.append(", passwdvaliddate=").append(passwdvaliddate);
		sb.append(", mobileno=").append(mobileno);
		sb.append(", email=").append(email);
		sb.append(", orgid=").append(orgid);
		sb.append(", idtype=").append(idtype);
		sb.append(", idcode=").append(idcode);
		sb.append(", idname=").append(idname);
		sb.append(", logindate=").append(logindate);
		sb.append(", logintime=").append(logintime);
		sb.append(", status=").append(status);
		sb.append(", opendate=").append(opendate);
		sb.append(", canceldate=").append(canceldate);
        sb.append("]");
        return sb.toString();
	}
}
