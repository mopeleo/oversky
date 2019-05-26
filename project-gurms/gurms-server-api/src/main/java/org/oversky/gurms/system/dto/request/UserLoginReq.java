package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class UserLoginReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long userid;
	private String loginid;
	private String passwd;
	private String logintype;
	private String unioncode;
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getLogintype() {
		return logintype;
	}
	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}
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
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", loginid=").append(loginid);
		sb.append(", passwd=").append(passwd);
		sb.append(", logintype=").append(logintype);
		sb.append(", unioncode=").append(unioncode);
		sb.append(" ]");
		return sb.toString();
	}
}
