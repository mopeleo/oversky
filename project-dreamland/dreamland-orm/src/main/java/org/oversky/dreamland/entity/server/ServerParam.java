package org.oversky.dreamland.entity.server;

import org.oversky.base.entity.BaseEntity;

public class ServerParam extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String serverid;    //
	private String paramid;    //
	private String paramvalue;    //

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public String getParamid() {
		return this.paramid;
	}

	public void setParamid(String paramid) {
		this.paramid = paramid;
	}

	public String getParamvalue() {
		return this.paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("ServerParam");
		return build.append("#serverid:").append(this.serverid).append("#paramid:").append(this.paramid).toString();
	}

    public static String buildEntityKey(String serverid, String paramid){
        StringBuilder build = new StringBuilder("ServerParam");
        return build.append("#serverid:").append(serverid).append("#paramid:").append(paramid).toString();
    }
    
    public void copyPrimaryKey(ServerParam entity){
		this.serverid = entity.getServerid();
		this.paramid = entity.getParamid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", serverid=").append(serverid);
		sb.append(", paramid=").append(paramid);
		sb.append(", paramvalue=").append(paramvalue);
        sb.append("]");
        return sb.toString();
	}
}
