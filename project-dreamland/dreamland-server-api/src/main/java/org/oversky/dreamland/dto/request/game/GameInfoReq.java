package org.oversky.dreamland.dto.request.game;

import org.oversky.base.service.BaseReqDto;

public class GameInfoReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long gameid;    //
	private String unioncode;    //
	private String gamecode;    //游戏代码
	private String gamename;    //游戏名称
	private String fullname;    //游戏全称

	public Long getGameid() {
		return this.gameid;
	}

	public void setGameid(Long gameid) {
		this.gameid = gameid;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public String getGamecode() {
		return this.gamecode;
	}

	public void setGamecode(String gamecode) {
		this.gamecode = gamecode;
	}

	public String getGamename() {
		return this.gamename;
	}

	public void setGamename(String gamename) {
		this.gamename = gamename;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("gameid=").append(gameid).append(", ");
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("gamecode=").append(gamecode).append(", ");
		sb.append("gamename=").append(gamename).append(", ");
		sb.append("fullname=").append(fullname).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
