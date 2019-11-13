package org.oversky.dreamland.dto.response.server;

import org.oversky.base.service.BaseResDto;

public class ServerInfoRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private String serverid;    //服务器ID
	private String servername;    //服务器名称
	private String opendate;    //开服日期
	private String opentime;    //开服时间
	private Integer maxplayer;    //最大玩家数
	private Integer regplayer;    //注册玩家数
	private Integer onlineplayer;    //在线玩家数
	private String status;    //服务器状态0，未开，1，已开，2，维护中

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public String getServername() {
		return this.servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	public String getOpendate() {
		return this.opendate;
	}

	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}

	public String getOpentime() {
		return this.opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public Integer getMaxplayer() {
		return this.maxplayer;
	}

	public void setMaxplayer(Integer maxplayer) {
		this.maxplayer = maxplayer;
	}

	public Integer getRegplayer() {
		return this.regplayer;
	}

	public void setRegplayer(Integer regplayer) {
		this.regplayer = regplayer;
	}

	public Integer getOnlineplayer() {
		return this.onlineplayer;
	}

	public void setOnlineplayer(Integer onlineplayer) {
		this.onlineplayer = onlineplayer;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("serverid=").append(serverid).append(", ");
		sb.append("servername=").append(servername).append(", ");
		sb.append("opendate=").append(opendate).append(", ");
		sb.append("opentime=").append(opentime).append(", ");
		sb.append("maxplayer=").append(maxplayer).append(", ");
		sb.append("regplayer=").append(regplayer).append(", ");
		sb.append("onlineplayer=").append(onlineplayer).append(", ");
		sb.append("status=").append(status).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
