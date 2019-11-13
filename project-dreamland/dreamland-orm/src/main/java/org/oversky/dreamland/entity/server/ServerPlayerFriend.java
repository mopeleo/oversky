package org.oversky.dreamland.entity.server;

import org.oversky.base.entity.BaseEntity;

public class ServerPlayerFriend extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String serverid;    //
	private Long custno;    //
	private String friendlist;    //好友列表逗号分隔
	private Integer friendnum;    //好友数量，上限60

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

	public String getFriendlist() {
		return this.friendlist;
	}

	public void setFriendlist(String friendlist) {
		this.friendlist = friendlist;
	}

	public Integer getFriendnum() {
		return this.friendnum;
	}

	public void setFriendnum(Integer friendnum) {
		this.friendnum = friendnum;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayerFriend");
		return build.append("#serverid:").append(this.serverid).toString();
	}

    public static String buildEntityKey(String serverid){
        StringBuilder build = new StringBuilder("ServerPlayerFriend");
        return build.append("#serverid:").append(serverid).toString();
    }
    
    public void copyPrimaryKey(ServerPlayerFriend entity){
		this.serverid = entity.getServerid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("serverid=").append(serverid).append(", ");
		sb.append("custno=").append(custno).append(", ");
		sb.append("friendlist=").append(friendlist).append(", ");
		sb.append("friendnum=").append(friendnum).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
