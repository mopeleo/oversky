package org.oversky.dreamland.dto.request.game;

import org.oversky.base.service.BaseReqDto;

public class GameChannelReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Integer channelid;    //
	private String unioncode;    //
	private Long gameid;    //
	private String channelname;    //

	public Integer getChannelid() {
		return this.channelid;
	}

	public void setChannelid(Integer channelid) {
		this.channelid = channelid;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Long getGameid() {
		return this.gameid;
	}

	public void setGameid(Long gameid) {
		this.gameid = gameid;
	}

	public String getChannelname() {
		return this.channelname;
	}

	public void setChannelname(String channelname) {
		this.channelname = channelname;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("channelid=").append(channelid).append(", ");
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("gameid=").append(gameid).append(", ");
		sb.append("channelname=").append(channelname).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
