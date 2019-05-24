package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class SysRoleReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long roleid;    //角色ID,内部自动生成[identity]
	private String unioncode;    //
	private String rolename;    //角色名称
	private String status;    //角色状态，0-无效，1-有效
	private String roletype;    //角色类型，0-公共，1-私有
	private String startdate;    //角色生效日期
	private String enddate;    //角色失效日期
	private Long creator;    //创建人
	private String menulist;
	private String userList;

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

	public Long getCreator() {
		return this.creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public String getMenulist() {
		return menulist;
	}

	public void setMenulist(String menulist) {
		this.menulist = menulist;
	}

	public String getUserList() {
		return userList;
	}

	public void setUserList(String userList) {
		this.userList = userList;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", roleid=").append(roleid);
		sb.append(", unioncode=").append(unioncode);
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
