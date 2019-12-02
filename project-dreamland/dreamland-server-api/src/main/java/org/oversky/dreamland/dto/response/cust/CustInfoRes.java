package org.oversky.dreamland.dto.response.cust;

import org.oversky.base.service.BaseResDto;

public class CustInfoRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private Long custno;    //客户号，自动生成[identity]
	private String unioncode;    //
	private String custname;    //客户名称
	private String custtype;    //客户类型，0，机构；1，个人
	private String loginid;    //登录名
	private String loginpasswd;    //登录密码
	private String salt;    //密码盐，随机生成
	private String passwdvaliddate;    //密码失效日期
	private String mobileno;    //手机号码
	private String email;    //电子邮件
	private String custlevel;    //客户级别
	private String idtype;    //证件类型
	private String idcode;    //证件号码
	private String idname;    //证件姓名
	private String lastlogindate;    //上次登录日期
	private String lastlogintime;    //上次登录时间
	private String status;    //客户状态，0，已注销；1，正常；2，锁定；3，冻结
	private Integer loginerror;    //连续登录失败次数
	private String regdate;    //注册日期
	private String canceldate;    //注销日期
	private Integer channelid;    //客户渠道

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

	public String getCustname() {
		return this.custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCusttype() {
		return this.custtype;
	}

	public void setCusttype(String custtype) {
		this.custtype = custtype;
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

	public String getCustlevel() {
		return this.custlevel;
	}

	public void setCustlevel(String custlevel) {
		this.custlevel = custlevel;
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

	public Integer getChannelid() {
		return this.channelid;
	}

	public void setChannelid(Integer channelid) {
		this.channelid = channelid;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("custno=").append(custno).append(", ");
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("custname=").append(custname).append(", ");
		sb.append("custtype=").append(custtype).append(", ");
		sb.append("loginid=").append(loginid).append(", ");
		sb.append("loginpasswd=").append(loginpasswd).append(", ");
		sb.append("salt=").append(salt).append(", ");
		sb.append("passwdvaliddate=").append(passwdvaliddate).append(", ");
		sb.append("mobileno=").append(mobileno).append(", ");
		sb.append("email=").append(email).append(", ");
		sb.append("custlevel=").append(custlevel).append(", ");
		sb.append("idtype=").append(idtype).append(", ");
		sb.append("idcode=").append(idcode).append(", ");
		sb.append("idname=").append(idname).append(", ");
		sb.append("lastlogindate=").append(lastlogindate).append(", ");
		sb.append("lastlogintime=").append(lastlogintime).append(", ");
		sb.append("status=").append(status).append(", ");
		sb.append("loginerror=").append(loginerror).append(", ");
		sb.append("regdate=").append(regdate).append(", ");
		sb.append("canceldate=").append(canceldate).append(", ");
		sb.append("channelid=").append(channelid).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
