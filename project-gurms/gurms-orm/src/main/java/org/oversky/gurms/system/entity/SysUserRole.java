package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysUserRole extends BaseEntity{

	private static final long serialVersionUID = 1L;

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

	public String getEntityKey(){
		StringBuilder build = new StringBuilder("SysUserRole");
		return build.append("#").append(this.userid).append("#").append(this.roleid).toString();
	}

    public static String buildEntityKey(Long userid, Integer roleid){
        StringBuilder build = new StringBuilder("SysUserRole");
        return build.append("#").append(userid).append("#").append(roleid).toString();
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
