package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class SysUserRoleReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long userid;    //
	private Long roleid;    //

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
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
