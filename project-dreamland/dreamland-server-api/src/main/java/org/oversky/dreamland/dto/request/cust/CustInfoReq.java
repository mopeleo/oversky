package org.oversky.dreamland.dto.request.cust;

import org.oversky.base.service.BaseReqDto;

public class CustInfoReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long custno;    //客户号，自动生成
	private String unioncode;    //
	private String nickname;    //用户昵称
	private String loginid;    //登录名
	private String loginpasswd;    //登录密码
	private String salt;    //密码盐，随机生成
	private String passwdvaliddate;    //密码失效日期
	private String mobileno;    //手机号码
	private String email;    //电子邮件
	private String level;    //客户级别
	private String idtype;    //证件类型
	private String idcode;    //证件号码
	private String idname;    //证件姓名
	private String lastlogindate;    //上次登录日期
	private String lastlogintime;    //上次登录时间
	private String status;    //客户状态，0，已注销；1，正常；2，锁定；3，冻结
	private Integer loginerror;    //连续登录失败次数
	private String regdate;    //注册日期
	private String canceldate;    //注销日期

	public Long getCustno() {
		return this.custno;
	}

	public void setCustno(Long custno) {
		this.custno = custno;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
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

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
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

	public String getLastlogindate() {
		return this.lastlogindate;
	}

	public void setLastlogindate(String lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

	public String getLastlogintime() {
		return this.lastlogintime;
	}

	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getLoginerror() {
		return this.loginerror;
	}

	public void setLoginerror(Integer loginerror) {
		this.loginerror = loginerror;
	}

	public String getRegdate() {
		return this.regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
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
		sb.append(", custno=").append(custno);
		sb.append(", unioncode=").append(unioncode);
		sb.append(", nickname=").append(nickname);
		sb.append(", loginid=").append(loginid);
		sb.append(", loginpasswd=").append(loginpasswd);
		sb.append(", salt=").append(salt);
		sb.append(", passwdvaliddate=").append(passwdvaliddate);
		sb.append(", mobileno=").append(mobileno);
		sb.append(", email=").append(email);
		sb.append(", level=").append(level);
		sb.append(", idtype=").append(idtype);
		sb.append(", idcode=").append(idcode);
		sb.append(", idname=").append(idname);
		sb.append(", lastlogindate=").append(lastlogindate);
		sb.append(", lastlogintime=").append(lastlogintime);
		sb.append(", status=").append(status);
		sb.append(", loginerror=").append(loginerror);
		sb.append(", regdate=").append(regdate);
		sb.append(", canceldate=").append(canceldate);
        sb.append("]");
        return sb.toString();
	}
}
