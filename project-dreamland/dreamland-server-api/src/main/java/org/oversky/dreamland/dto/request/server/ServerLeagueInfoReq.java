package org.oversky.dreamland.dto.request.server;

import org.oversky.base.service.BaseReqDto;

public class ServerLeagueInfoReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String leagueid;    //
	private String serverid;    //
	private String leaguename;    //联盟名称
	private Integer maxleaguer;    //最大成员数
	private Integer level;    //联盟等级
	private Long creator;    //盟主
	private String createdate;    //
	private String createtime;    //
	private String remark;    //

	public String getLeagueid() {
		return this.leagueid;
	}

	public void setLeagueid(String leagueid) {
		this.leagueid = leagueid;
	}

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public String getLeaguename() {
		return this.leaguename;
	}

	public void setLeaguename(String leaguename) {
		this.leaguename = leaguename;
	}

	public Integer getMaxleaguer() {
		return this.maxleaguer;
	}

	public void setMaxleaguer(Integer maxleaguer) {
		this.maxleaguer = maxleaguer;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Long getCreator() {
		return this.creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public String getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", leagueid=").append(leagueid);
		sb.append(", serverid=").append(serverid);
		sb.append(", leaguename=").append(leaguename);
		sb.append(", maxleaguer=").append(maxleaguer);
		sb.append(", level=").append(level);
		sb.append(", creator=").append(creator);
		sb.append(", createdate=").append(createdate);
		sb.append(", createtime=").append(createtime);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
	}
}
