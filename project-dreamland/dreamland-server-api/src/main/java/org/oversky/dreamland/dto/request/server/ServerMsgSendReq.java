package org.oversky.dreamland.dto.request.server;

import org.oversky.base.service.BaseReqDto;

public class ServerMsgSendReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long msgid;    //消息ID[identity]
	private String serverid;    //
	private Long custno;    //作者
	private String content;    //消息内容
	private String msgtype;    //类型，0-所有人可见，1，公会可见，2，指定人可见
	private Long receiver;    //
	private String senddate;    //发送日期
	private String sendtime;    //发送时间

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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgtype() {
		return this.msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public Long getReceiver() {
		return this.receiver;
	}

	public void setReceiver(Long receiver) {
		this.receiver = receiver;
	}

	public String getSenddate() {
		return this.senddate;
	}

	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}

	public String getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("msgid=").append(msgid).append(", ");
		sb.append("serverid=").append(serverid).append(", ");
		sb.append("custno=").append(custno).append(", ");
		sb.append("content=").append(content).append(", ");
		sb.append("msgtype=").append(msgtype).append(", ");
		sb.append("receiver=").append(receiver).append(", ");
		sb.append("senddate=").append(senddate).append(", ");
		sb.append("sendtime=").append(sendtime).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
