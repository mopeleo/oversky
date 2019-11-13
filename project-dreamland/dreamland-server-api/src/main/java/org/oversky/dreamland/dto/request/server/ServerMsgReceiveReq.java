package org.oversky.dreamland.dto.request.server;

import org.oversky.base.service.BaseReqDto;

public class ServerMsgReceiveReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long msgid;    //消息ID
	private String serverid;    //
	private Long custno;    //客户号
	private String isread;    //已读标志

	public Long getMsgid() {
		return this.msgid;
	}

	public void setMsgid(Long msgid) {
		this.msgid = msgid;
	}

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public Long getCustno() {
		return this.custno;
	}

	public void setCustno(Long custno) {
		this.custno = custno;
	}

	public String getIsread() {
		return this.isread;
	}

	public void setIsread(String isread) {
		this.isread = isread;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("msgid=").append(msgid).append(", ");
		sb.append("serverid=").append(serverid).append(", ");
		sb.append("custno=").append(custno).append(", ");
		sb.append("isread=").append(isread).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
