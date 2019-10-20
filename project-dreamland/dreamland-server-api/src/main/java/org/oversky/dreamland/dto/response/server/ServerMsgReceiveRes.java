package org.oversky.dreamland.dto.response.server;

import org.oversky.base.service.BaseResDto;

public class ServerMsgReceiveRes extends BaseResDto {

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
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", msgid=").append(msgid);
		sb.append(", serverid=").append(serverid);
		sb.append(", custno=").append(custno);
		sb.append(", isread=").append(isread);
        sb.append("]");
        return sb.toString();
	}
}
