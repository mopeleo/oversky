package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class SysConfirmUserReq extends BaseReqDto {

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
