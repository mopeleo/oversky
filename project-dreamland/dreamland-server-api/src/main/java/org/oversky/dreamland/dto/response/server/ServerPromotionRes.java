package org.oversky.dreamland.dto.response.server;

import org.oversky.base.service.BaseResDto;

public class ServerPromotionRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private String serverid;    //
	private Integer promid;    //
	private String startdate;    //
	private String starttime;    //
	private String enddate;    //
	private String endtime;    //

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public Integer getPromid() {
		return this.promid;
	}

	public void setPromid(Integer promid) {
		this.promid = promid;
	}

	public String getStartdate() {
		return this.startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEnddate() {
		return this.enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("serverid=").append(serverid).append(", ");
		sb.append("promid=").append(promid).append(", ");
		sb.append("startdate=").append(startdate).append(", ");
		sb.append("starttime=").append(starttime).append(", ");
		sb.append("enddate=").append(enddate).append(", ");
		sb.append("endtime=").append(endtime).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
