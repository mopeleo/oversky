package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class SysRoleMenuReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long roleid;    //
	private String menuid;    //

	public Long getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public String getMenuid() {
		return this.menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", roleid=").append(roleid);
		sb.append(", menuid=").append(menuid);
        sb.append("]");
        return sb.toString();
	}
}
