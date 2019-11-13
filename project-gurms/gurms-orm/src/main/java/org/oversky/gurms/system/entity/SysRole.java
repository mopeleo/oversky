package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysRole extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long roleid;    //角色ID,内部自动生成[identity]
	private String unioncode;    //
	private String rolename;    //角色名称
	private String status;    //角色状态，0-无效，1-有效
	private String roletype;    //角色类型，0-公共，1-私有
	private String startdate;    //角色生效日期
	private String enddate;    //角色失效日期
	private String belong;    //归属（预留，机构，角色组等）
	private Long creator;    //创建人

	public Long getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoletype() {
		return this.roletype;
	}

	public void setRoletype(String roletype) {
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

	public String getBelong() {
		return this.belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public Long getCreator() {
		return this.creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysRole");
		return build.append("#roleid:").append(this.roleid).toString();
	}

    public static String buildEntityKey(Long roleid){
        StringBuilder build = new StringBuilder("SysRole");
        return build.append("#roleid:").append(roleid).toString();
    }
    
    public void copyPrimaryKey(SysRole entity){
		this.roleid = entity.getRoleid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("roleid=").append(roleid).append(", ");
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("rolename=").append(rolename).append(", ");
		sb.append("status=").append(status).append(", ");
		sb.append("roletype=").append(roletype).append(", ");
		sb.append("startdate=").append(startdate).append(", ");
		sb.append("enddate=").append(enddate).append(", ");
		sb.append("belong=").append(belong).append(", ");
		sb.append("creator=").append(creator).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
