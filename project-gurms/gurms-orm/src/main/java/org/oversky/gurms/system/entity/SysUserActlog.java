package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysUserActlog extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long logid;    //[identity]
	private String unioncode;    //unioncode
	private Long userid;    //用户ID
	private String menuid;    //菜单ID
	private String requrl;    //请求URL
	private String reqmethod;    //请求方法
	private String reqdata;    //请求数据，json
	private String actdate;    //行为日期
	private String acttime;    //行为时间
	private Integer accesstype;    //登录方式（0-pc，1-手机）
	private String ipaddress;    //ipaddress

	public Long getLogid() {
		return this.logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getMenuid() {
		return this.menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getRequrl() {
		return this.requrl;
	}

	public void setRequrl(String requrl) {
		this.requrl = requrl;
	}

	public String getReqmethod() {
		return this.reqmethod;
	}

	public void setReqmethod(String reqmethod) {
		this.reqmethod = reqmethod;
	}

	public String getReqdata() {
		return this.reqdata;
	}

	public void setReqdata(String reqdata) {
		this.reqdata = reqdata;
	}

	public String getActdate() {
		return this.actdate;
	}

	public void setActdate(String actdate) {
		this.actdate = actdate;
	}

	public String getActtime() {
		return this.acttime;
	}

	public void setActtime(String acttime) {
		this.acttime = acttime;
	}

	public Integer getAccesstype() {
		return this.accesstype;
	}

	public void setAccesstype(Integer accesstype) {
		this.accesstype = accesstype;
	}

	public String getIpaddress() {
		return this.ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysUserActlog");
		return build.append("#logid:").append(this.logid).toString();
	}

    public static String buildEntityKey(Long logid){
        StringBuilder build = new StringBuilder("SysUserActlog");
        return build.append("#logid:").append(logid).toString();
    }
    
    public void copyPrimaryKey(SysUserActlog entity){
		this.logid = entity.getLogid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", logid=").append(logid);
		sb.append(", unioncode=").append(unioncode);
		sb.append(", userid=").append(userid);
		sb.append(", menuid=").append(menuid);
		sb.append(", requrl=").append(requrl);
		sb.append(", reqmethod=").append(reqmethod);
		sb.append(", reqdata=").append(reqdata);
		sb.append(", actdate=").append(actdate);
		sb.append(", acttime=").append(acttime);
		sb.append(", accesstype=").append(accesstype);
		sb.append(", ipaddress=").append(ipaddress);
        sb.append("]");
        return sb.toString();
	}
}
