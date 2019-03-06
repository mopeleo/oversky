package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class UserLoginReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String loginid;
	private String passwd;
	private Integer logintype;
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
	
	public Integer getLogintype() {
		return logintype;
	}
	public void setLogintype(Integer logintype) {
		this.logintype = logintype;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", loginid=").append(loginid);
		sb.append(", passwd=").append(passwd);
		sb.append(", logintype=").append(logintype);
		sb.append(" ]");
		return sb.toString();
	}
}
