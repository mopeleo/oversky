package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysConfirmUser extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long userid;    //复核用户ID
	private Integer confirmid;    //复核配置ID
	private Integer checklevel;    //复核级别

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Integer getConfirmid() {
		return this.confirmid;
	}

	public void setConfirmid(Integer confirmid) {
		this.confirmid = confirmid;
	}

	public Integer getChecklevel() {
		return this.checklevel;
	}

	public void setChecklevel(Integer checklevel) {
		this.checklevel = checklevel;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysConfirmUser");
		return build.append("#userid:").append(this.userid).append("#confirmid:").append(this.confirmid).toString();
	}

    public static String buildEntityKey(Long userid, Integer confirmid){
        StringBuilder build = new StringBuilder("SysConfirmUser");
        return build.append("#userid:").append(userid).append("#confirmid:").append(confirmid).toString();
    }
    
    public void copyPrimaryKey(SysConfirmUser entity){
		this.userid = entity.getUserid();
		this.confirmid = entity.getConfirmid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", userid=").append(userid);
		sb.append(", confirmid=").append(confirmid);
		sb.append(", checklevel=").append(checklevel);
        sb.append("]");
        return sb.toString();
	}
}
