package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysRoleMenu extends BaseEntity{

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysRoleMenu");
		return build.append("#roleid:").append(this.roleid).append("#menuid:").append(this.menuid).toString();
	}

    public static String buildEntityKey(Long roleid, String menuid){
        StringBuilder build = new StringBuilder("SysRoleMenu");
        return build.append("#roleid:").append(roleid).append("#menuid:").append(menuid).toString();
    }
    
    public void copyPrimaryKey(SysRoleMenu entity){
		this.roleid = entity.getRoleid();
		this.menuid = entity.getMenuid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("roleid=").append(roleid).append(", ");
		sb.append("menuid=").append(menuid).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
