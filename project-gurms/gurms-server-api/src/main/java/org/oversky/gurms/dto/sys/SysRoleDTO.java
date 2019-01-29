package org.oversky.gurms.dto.sys;

import com.dl.server.dto.BaseDTO;

public class SysRoleDTO extends BaseDTO {

	private String unioncode;    //unioncode
	private Integer roleid;    //角色ID
	private String rolename;    //角色名称
	private Integer status;    //角色状态，0-无效，1-有效
	private Integer roletype;    //角色类型，0-公共，1-私有
	private String startdate;    //角色生效日期
	private String enddate;    //角色失效日期
	private Long creator;    //创建人

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRoletype() {
		return this.roletype;
	}

	public void setRoletype(Integer roletype) {
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

	public Long getCreator() {
		return this.creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}


	public void clear(){
		this.unioncode = null;
		this.roleid = null;
		this.rolename = null;
		this.status = null;
		this.roletype = null;
		this.startdate = null;
		this.enddate = null;
		this.creator = null;
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
