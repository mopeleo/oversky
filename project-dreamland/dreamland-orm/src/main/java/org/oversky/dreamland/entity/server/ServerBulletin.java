package org.oversky.dreamland.entity.server;

import org.oversky.base.entity.BaseEntity;

public class ServerBulletin extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long id;    //
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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("ServerBulletin");
		return build.append("#id:").append(this.id).toString();
	}

    public static String buildEntityKey(Long id){
        StringBuilder build = new StringBuilder("ServerBulletin");
        return build.append("#id:").append(id).toString();
    }
    
    public void copyPrimaryKey(ServerBulletin entity){
		this.id = entity.getId();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", serverid=").append(serverid);
		sb.append(", title=").append(title);
		sb.append(", content=").append(content);
		sb.append(", startdate=").append(startdate);
		sb.append(", enddate=").append(enddate);
		sb.append(", issuer=").append(issuer);
        sb.append("]");
        return sb.toString();
	}
}
