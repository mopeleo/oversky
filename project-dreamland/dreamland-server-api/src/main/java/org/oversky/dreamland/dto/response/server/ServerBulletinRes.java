package org.oversky.dreamland.dto.response.server;

import org.oversky.base.service.BaseResDto;

public class ServerBulletinRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private Long id;    //[identity]
	private String serverid;    //服务器ID
	private String title;    //公告标题
	private String content;    //公告内容
	private String startdate;    //开始日期
	private String enddate;    //结束日期
	private String issuer;    //发布者

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getIssuer() {
		return this.issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("id=").append(id).append(", ");
		sb.append("serverid=").append(serverid).append(", ");
		sb.append("title=").append(title).append(", ");
		sb.append("content=").append(content).append(", ");
		sb.append("startdate=").append(startdate).append(", ");
		sb.append("enddate=").append(enddate).append(", ");
		sb.append("issuer=").append(issuer).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
