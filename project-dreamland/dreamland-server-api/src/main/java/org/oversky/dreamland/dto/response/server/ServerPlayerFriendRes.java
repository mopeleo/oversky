package org.oversky.dreamland.dto.response.server;

import org.oversky.base.service.BaseResDto;

public class ServerPlayerFriendRes extends BaseResDto {

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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", serverid=").append(serverid);
		sb.append(", custno=").append(custno);
		sb.append(", friendlist=").append(friendlist);
		sb.append(", friendnum=").append(friendnum);
        sb.append("]");
        return sb.toString();
	}
}
