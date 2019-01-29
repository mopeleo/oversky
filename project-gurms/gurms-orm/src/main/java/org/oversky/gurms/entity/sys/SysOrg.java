package org.oversky.gurms.entity.sys;

import org.oversky.base.entity.BaseEntity;

public class SysOrg extends BaseEntity{

	private String orgid;    //机构ID
	private String unioncode;    //unioncode
	private String shortname;    //机构简称
	private String fullname;    //机构全称
	private String linkman;    //联系人
	private String linktel;    //联系电话
	private String faxno;    //传真
	private String address;    //联系地址
	private String postcode;    //邮政编码
	private String email;    //电子邮件
	private String parentorg;    //上级机构
	private Integer orgtype;    //机构类型(0-虚拟，可选，1-总，2-分，3-支)
	private String remark;    //备注

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinktel() {
		return this.linktel;
	}

	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}

	public String getFaxno() {
		return this.faxno;
	}

	public void setFaxno(String faxno) {
		this.faxno = faxno;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParentorg() {
		return this.parentorg;
	}

	public void setParentorg(String parentorg) {
		this.parentorg = parentorg;
	}

	public Integer getOrgtype() {
		return this.orgtype;
	}

	public void setOrgtype(Integer orgtype) {
		this.orgtype = orgtype;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("SysOrg");
		return build.append(this.orgid).toString();
	}

    public static String buildEntityKey(String orgid){
        StringBuilder build = new StringBuilder("SysOrg");
        return build.append(orgid).toString();
    }
	
	public void clear(){
		this.orgid = null;
		this.unioncode = null;
		this.shortname = null;
		this.fullname = null;
		this.linkman = null;
		this.linktel = null;
		this.faxno = null;
		this.address = null;
		this.postcode = null;
		this.email = null;
		this.parentorg = null;
		this.orgtype = null;
		this.remark = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", orgid=").append(orgid);
		sb.append(", unioncode=").append(unioncode);
		sb.append(", shortname=").append(shortname);
		sb.append(", fullname=").append(fullname);
		sb.append(", linkman=").append(linkman);
		sb.append(", linktel=").append(linktel);
		sb.append(", faxno=").append(faxno);
		sb.append(", address=").append(address);
		sb.append(", postcode=").append(postcode);
		sb.append(", email=").append(email);
		sb.append(", parentorg=").append(parentorg);
		sb.append(", orgtype=").append(orgtype);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
	}
}
