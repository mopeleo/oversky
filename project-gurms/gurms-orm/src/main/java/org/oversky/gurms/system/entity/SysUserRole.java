package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysUserRole extends BaseEntity{

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysUserRole");
		return build.append("#userid:").append(this.userid).append("#roleid:").append(this.roleid).toString();
	}

    public static String buildEntityKey(Long userid, Long roleid){
        StringBuilder build = new StringBuilder("SysUserRole");
        return build.append("#userid:").append(userid).append("#roleid:").append(roleid).toString();
    }
    
    public void copyPrimaryKey(SysUserRole entity){
		this.userid = entity.getUserid();
		this.roleid = entity.getRoleid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("userid=").append(userid).append(", ");
		sb.append("roleid=").append(roleid).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
