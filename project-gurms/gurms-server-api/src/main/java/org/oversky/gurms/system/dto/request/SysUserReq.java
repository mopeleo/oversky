package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class SysUserReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	//----user
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

	//----userinfo
	private String sex;    //性别（0-女，1-男）
	private String birthday;    //生日
	private String address;    //联系地址
	private String postcode;    //邮政编码
	private String phone;    //备用电话
	private String nationality;    //国籍
	private String province;    //所在省份
	private String city;    //所在城市
	private String education;    //教育程度
	private String profession; //职业
	private String ethnicity; 	//民族

	//----
	private String newpassword;
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

    public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getRoleList() {
		return roleList;
	}

	public void setRoleList(String roleList) {
		this.roleList = roleList;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
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
		sb.append(", sex=").append(sex);
		sb.append(", birthday=").append(birthday);
		sb.append(", address=").append(address);
		sb.append(", postcode=").append(postcode);
		sb.append(", phone=").append(phone);
		sb.append(", nationality=").append(nationality);
		sb.append(", province=").append(province);
		sb.append(", city=").append(city);
		sb.append(", education=").append(education);
		sb.append(", profession=").append(profession);
		sb.append(", ethnicity=").append(ethnicity);
		sb.append(", newpassword=").append(newpassword);
		sb.append(", roleList=").append(roleList);
        sb.append("]");
        return sb.toString();
	}
}
