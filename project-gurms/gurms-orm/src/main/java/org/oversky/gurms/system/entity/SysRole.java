package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysRole extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String unioncode;    //unioncode
	private Long roleid;    //角色ID
	private String rolename;    //角色名称
	private int status;    //角色状态，0-无效，1-有效
	private int roletype;    //角色类型，0-公共，1-私有
	private String startdate;    //角色生效日期
	private String enddate;    //角色失效日期
	private long creator;    //创建人

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Long getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRoletype() {
		return this.roletype;
	}

	public void setRoletype(int roletype) {
		this.roletype = roletype;
	}

	public String getStartdate() {
		return this.startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return this.enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public long getCreator() {
		return this.creator;
	}

	public void setCreator(long creator) {
		this.creator = creator;
	}

	public String getEntityKey(){
		StringBuilder build = new StringBuilder("SysRole");
		return build.append(this.roleid).toString();
	}

    public static String buildEntityKey(Long roleid){
        StringBuilder build = new StringBuilder("SysRole");
        return build.append(roleid).toString();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", unioncode=").append(unioncode);
		sb.append(", roleid=").append(roleid);
		sb.append(", rolename=").append(rolename);
		sb.append(", status=").append(status);
		sb.append(", roletype=").append(roletype);
		sb.append(", startdate=").append(startdate);
		sb.append(", enddate=").append(enddate);
		sb.append(", creator=").append(creator);
        sb.append("]");
        return sb.toString();
	}
}
