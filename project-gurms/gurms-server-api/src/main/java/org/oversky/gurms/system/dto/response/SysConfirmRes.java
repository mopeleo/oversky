package org.oversky.gurms.system.dto.response;

import org.oversky.base.service.BaseResDto;

public class SysConfirmRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private Integer confirmid;    //
	private String unioncode;    //
	private String tablename;    //复核数据表名
	private Integer checklevel;    //复核级别

	public Integer getConfirmid() {
		return this.confirmid;
	}

	public void setConfirmid(Integer confirmid) {
		this.confirmid = confirmid;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public String getTablename() {
		return this.tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public Integer getChecklevel() {
		return this.checklevel;
	}

	public void setChecklevel(Integer checklevel) {
		this.checklevel = checklevel;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", confirmid=").append(confirmid);
		sb.append(", unioncode=").append(unioncode);
		sb.append(", tablename=").append(tablename);
		sb.append(", checklevel=").append(checklevel);
        sb.append("]");
        return sb.toString();
	}
}
