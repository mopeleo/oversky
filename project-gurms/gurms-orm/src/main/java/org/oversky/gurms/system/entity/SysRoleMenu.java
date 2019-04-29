package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysRoleMenu extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Integer roleid;    //
	private String menuid;    //

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysRoleMenu");
		return build.append("#roleid:").append(this.roleid).append("#menuid:").append(this.menuid).toString();
	}

    public static String buildEntityKey(Integer roleid, String menuid){
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
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", roleid=").append(roleid);
		sb.append(", menuid=").append(menuid);
        sb.append("]");
        return sb.toString();
	}
}
