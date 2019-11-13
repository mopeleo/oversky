package org.oversky.dreamland.entity.server;

import org.oversky.base.entity.BaseEntity;

public class ServerPromotion extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String serverid;    //
	private Long promid;    //
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

	public Long getPromid() {
		return this.promid;
	}

	public void setPromid(Long promid) {
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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("ServerPromotion");
		return build.append("#serverid:").append(this.serverid).append("#promid:").append(this.promid).toString();
	}

    public static String buildEntityKey(String serverid, Long promid){
        StringBuilder build = new StringBuilder("ServerPromotion");
        return build.append("#serverid:").append(serverid).append("#promid:").append(promid).toString();
    }
    
    public void copyPrimaryKey(ServerPromotion entity){
		this.serverid = entity.getServerid();
		this.promid = entity.getPromid();
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
