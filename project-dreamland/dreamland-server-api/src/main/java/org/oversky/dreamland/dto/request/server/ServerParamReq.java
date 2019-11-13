package org.oversky.dreamland.dto.request.server;

import org.oversky.base.service.BaseReqDto;

public class ServerParamReq extends BaseReqDto {

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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("serverid=").append(serverid).append(", ");
		sb.append("paramid=").append(paramid).append(", ");
		sb.append("paramvalue=").append(paramvalue).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
