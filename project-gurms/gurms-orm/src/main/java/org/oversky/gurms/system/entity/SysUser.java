package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysUser extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long userid;    //用户ID,内部自动生成[identity]
	private String unioncode;    //
	private String username;    //用户名称
	private String loginid;    //登录名
	private String loginpasswd;    //登录密码
	private String salt;    //密码盐
	private String passwdvaliddate;    //密码失效日期
	private String status;    //用户状态，1，正常；2，锁定；3，冻结
	private Long orgid;    //所属机构
	private String sex;    //性别，0-女；1-男
	private String mobileno;    //手机号码
	private String email;    //电子邮件
	private String idtype;    //证件类型
	private String idcode;    //证件号码
	private String idname;    //证件姓名
	private String postcode;    //邮政编码
	private String address;    //联系地址
	private String logindate;    //上次登录日期
	private String logintime;    //上次登录时间
	private Integer loginerror;    //连续登录失败次数
	private String opendate;    //创建日期

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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getOrgid() {
		return this.orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Integer getLoginerror() {
		return this.loginerror;
	}

	public void setLoginerror(Integer loginerror) {
		this.loginerror = loginerror;
	}

	public String getOpendate() {
		return this.opendate;
	}

	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysUser");
		return build.append("#userid:").append(this.userid).toString();
	}

    public static String buildEntityKey(Long userid){
        StringBuilder build = new StringBuilder("SysUser");
        return build.append("#userid:").append(userid).toString();
    }
    
    public void copyPrimaryKey(SysUser entity){
		this.userid = entity.getUserid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("userid=").append(userid).append(", ");
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("username=").append(username).append(", ");
		sb.append("loginid=").append(loginid).append(", ");
		sb.append("loginpasswd=").append(loginpasswd).append(", ");
		sb.append("salt=").append(salt).append(", ");
		sb.append("passwdvaliddate=").append(passwdvaliddate).append(", ");
		sb.append("status=").append(status).append(", ");
		sb.append("orgid=").append(orgid).append(", ");
		sb.append("sex=").append(sex).append(", ");
		sb.append("mobileno=").append(mobileno).append(", ");
		sb.append("email=").append(email).append(", ");
		sb.append("idtype=").append(idtype).append(", ");
		sb.append("idcode=").append(idcode).append(", ");
		sb.append("idname=").append(idname).append(", ");
		sb.append("postcode=").append(postcode).append(", ");
		sb.append("address=").append(address).append(", ");
		sb.append("logindate=").append(logindate).append(", ");
		sb.append("logintime=").append(logintime).append(", ");
		sb.append("loginerror=").append(loginerror).append(", ");
		sb.append("opendate=").append(opendate).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
