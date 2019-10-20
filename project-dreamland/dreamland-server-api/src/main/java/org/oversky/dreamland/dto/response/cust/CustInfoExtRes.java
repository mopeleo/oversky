package org.oversky.dreamland.dto.response.cust;

import org.oversky.base.service.BaseResDto;

public class CustInfoExtRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private Long custno;    //
	private String sex;    //性别（0-女，1-男）
	private String birthday;    //生日
	private String address;    //联系地址
	private String postcode;    //邮政编码
	private String phone;    //备用电话
	private String nationality;    //国籍
	private String province;    //所在省份
	private String city;    //所在城市
	private String education;    //教育程度
	private String ethnicity;    //民族
	private String profession;    //职业

	public Long getCustno() {
		return this.custno;
	}

	public void setCustno(Long custno) {
		this.custno = custno;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEthnicity() {
		return this.ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", custno=").append(custno);
		sb.append(", sex=").append(sex);
		sb.append(", birthday=").append(birthday);
		sb.append(", address=").append(address);
		sb.append(", postcode=").append(postcode);
		sb.append(", phone=").append(phone);
		sb.append(", nationality=").append(nationality);
		sb.append(", province=").append(province);
		sb.append(", city=").append(city);
		sb.append(", education=").append(education);
		sb.append(", ethnicity=").append(ethnicity);
		sb.append(", profession=").append(profession);
        sb.append("]");
        return sb.toString();
	}
}
