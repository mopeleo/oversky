package org.oversky.gurms.entity.sys;

import com.dl.server.entity.DLEntity;

public class SysUserRole extends DLEntity{

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

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("SysUserRole");
		return build.append(this.userid).append(this.roleid).toString();
	}

    public static String buildEntityKey(Long userid, Integer roleid){
        StringBuilder build = new StringBuilder("SysUserRole");
        return build.append(userid).append(roleid).toString();
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
