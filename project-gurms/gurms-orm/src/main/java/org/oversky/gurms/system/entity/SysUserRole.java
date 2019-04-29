package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysUserRole extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long userid;    //
	private Integer roleid;    //

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysUserRole");
		return build.append("#userid:").append(this.userid).append("#roleid:").append(this.roleid).toString();
	}

    public static String buildEntityKey(Long userid, Integer roleid){
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
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", userid=").append(userid);
		sb.append(", roleid=").append(roleid);
        sb.append("]");
        return sb.toString();
	}
}
