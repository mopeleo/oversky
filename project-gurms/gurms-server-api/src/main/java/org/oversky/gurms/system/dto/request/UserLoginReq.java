package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class UserLoginReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String loginid;
	private String passwd;
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", loginid=").append(loginid);
		sb.append(", passwd=").append(passwd);
		sb.append(" ]");
		return sb.toString();
	}
}
