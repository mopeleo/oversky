package org.oversky.dreamland.dto.request.server;

import org.oversky.base.service.BaseReqDto;

public class ServerLeagueReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long leagueid;    //[identity]
	private String serverid;    //
	private String leaguename;    //联盟名称
	private Integer maxleaguer;    //最大成员数
	private Integer leaguelevel;    //联盟等级
	private Long creator;    //盟主
	private String createdate;    //
	private String createtime;    //
	private String remark;    //

	public Long getLeagueid() {
		return this.leagueid;
	}

	public void setLeagueid(Long leagueid) {
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

	public Integer getLeaguelevel() {
		return this.leaguelevel;
	}

	public void setLeaguelevel(Integer leaguelevel) {
		this.leaguelevel = leaguelevel;
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
		sb.append("leagueid=").append(leagueid).append(", ");
		sb.append("serverid=").append(serverid).append(", ");
		sb.append("leaguename=").append(leaguename).append(", ");
		sb.append("maxleaguer=").append(maxleaguer).append(", ");
		sb.append("leaguelevel=").append(leaguelevel).append(", ");
		sb.append("creator=").append(creator).append(", ");
		sb.append("createdate=").append(createdate).append(", ");
		sb.append("createtime=").append(createtime).append(", ");
		sb.append("remark=").append(remark).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
