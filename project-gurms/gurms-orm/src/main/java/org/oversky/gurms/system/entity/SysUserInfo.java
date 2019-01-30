package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysUserInfo extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long userid;    //用户ID,内部自动生成
	private String unioncode;    //unioncode
	private String sex;    //性别（0-女，1-男）
	private String birthday;    //生日
	private String address;    //联系地址
	private String postcode;    //邮政编码
	private String province;    //所在省份
	private String city;    //所在城市
	private String education;    //教育程度

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

	public String getEntityKey(){
		StringBuilder build = new StringBuilder("SysUserInfo");
		return build.append(this.userid).toString();
	}

    public static String buildEntityKey(Long userid){
        StringBuilder build = new StringBuilder("SysUserInfo");
        return build.append(userid).toString();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", userid=").append(userid);
		sb.append(", unioncode=").append(unioncode);
		sb.append(", sex=").append(sex);
		sb.append(", birthday=").append(birthday);
		sb.append(", address=").append(address);
		sb.append(", postcode=").append(postcode);
		sb.append(", province=").append(province);
		sb.append(", city=").append(city);
		sb.append(", education=").append(education);
        sb.append("]");
        return sb.toString();
	}
}
