package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class SysLogLoginReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long logid;    //logid
	private Long userid;    //userid
	private String logindate;    //登录日期
	private String logintime;    //登录时间
	private String loginpasswd;    //登录密码
	private String loginip;    //登录IP
	private Integer logintype;    //登录方式（1-pc，2-手机）
	private Integer loginresult;    //登录是否成功 0-失败，1-成功

	public Long getLogid() {
		return this.logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
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

	public String getLoginpasswd() {
		return this.loginpasswd;
	}

	public void setLoginpasswd(String loginpasswd) {
		this.loginpasswd = loginpasswd;
	}

	public String getLoginip() {
		return this.loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	public Integer getLogintype() {
		return this.logintype;
	}

	public void setLogintype(Integer logintype) {
		this.logintype = logintype;
	}

	public Integer getLoginresult() {
		return this.loginresult;
	}

	public void setLoginresult(Integer loginresult) {
		this.loginresult = loginresult;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", logid=").append(logid);
		sb.append(", userid=").append(userid);
		sb.append(", logindate=").append(logindate);
		sb.append(", logintime=").append(logintime);
		sb.append(", loginpasswd=").append(loginpasswd);
		sb.append(", loginip=").append(loginip);
		sb.append(", logintype=").append(logintype);
		sb.append(", loginresult=").append(loginresult);
        sb.append("]");
        return sb.toString();
	}
}
