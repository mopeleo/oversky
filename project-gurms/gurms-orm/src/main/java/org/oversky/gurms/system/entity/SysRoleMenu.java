package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysRoleMenu extends BaseEntity{

	private Integer roleid;    //roleid
	private String menuid;    //menuid

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getMenuid() {
		return this.menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("SysRoleMenu");
		return build.append(this.roleid).append(this.menuid).toString();
	}

    public static String buildEntityKey(Integer roleid, String menuid){
        StringBuilder build = new StringBuilder("SysRoleMenu");
        return build.append(roleid).append(menuid).toString();
    }
	
	public void clear(){
		this.roleid = null;
		this.menuid = null;
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
