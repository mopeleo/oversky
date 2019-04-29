package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysConfirm extends BaseEntity{

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysConfirm");
		return build.append("#unioncode:").append(this.unioncode).append("#tablename:").append(this.tablename).toString();
	}

    public static String buildEntityKey(String unioncode, String tablename){
        StringBuilder build = new StringBuilder("SysConfirm");
        return build.append("#unioncode:").append(unioncode).append("#tablename:").append(tablename).toString();
    }
    
    public void copyPrimaryKey(SysConfirm entity){
		this.unioncode = entity.getUnioncode();
		this.tablename = entity.getTablename();
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
