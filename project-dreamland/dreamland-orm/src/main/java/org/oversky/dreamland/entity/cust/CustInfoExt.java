package org.oversky.dreamland.entity.cust;

import org.oversky.base.entity.BaseEntity;

public class CustInfoExt extends BaseEntity{

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("CustInfoExt");
		return build.append("#custno:").append(this.custno).toString();
	}

    public static String buildEntityKey(Long custno){
        StringBuilder build = new StringBuilder("CustInfoExt");
        return build.append("#custno:").append(custno).toString();
    }
    
    public void copyPrimaryKey(CustInfoExt entity){
		this.custno = entity.getCustno();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("custno=").append(custno).append(", ");
		sb.append("sex=").append(sex).append(", ");
		sb.append("birthday=").append(birthday).append(", ");
		sb.append("address=").append(address).append(", ");
		sb.append("postcode=").append(postcode).append(", ");
		sb.append("phone=").append(phone).append(", ");
		sb.append("nationality=").append(nationality).append(", ");
		sb.append("province=").append(province).append(", ");
		sb.append("city=").append(city).append(", ");
		sb.append("education=").append(education).append(", ");
		sb.append("ethnicity=").append(ethnicity).append(", ");
		sb.append("profession=").append(profession).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
