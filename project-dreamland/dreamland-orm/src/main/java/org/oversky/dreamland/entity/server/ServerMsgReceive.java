package org.oversky.dreamland.entity.server;

import org.oversky.base.entity.BaseEntity;

public class ServerMsgReceive extends BaseEntity{

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("ServerMsgReceive");
		return build.append("#msgid:").append(this.msgid).toString();
	}

    public static String buildEntityKey(Long msgid){
        StringBuilder build = new StringBuilder("ServerMsgReceive");
        return build.append("#msgid:").append(msgid).toString();
    }
    
    public void copyPrimaryKey(ServerMsgReceive entity){
		this.msgid = entity.getMsgid();
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
