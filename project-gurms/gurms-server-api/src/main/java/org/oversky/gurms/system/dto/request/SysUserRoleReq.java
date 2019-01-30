package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class SysUserRoleReq extends BaseReqDto {

	private Long userid;    //userid
	private Integer roleid;    //roleid

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}


	public void clear(){
		this.userid = null;
		this.roleid = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", userid=").append(userid);
		sb.append(", roleid=").append(roleid);
        sb.append("]");
        return sb.toString();
	}
}
