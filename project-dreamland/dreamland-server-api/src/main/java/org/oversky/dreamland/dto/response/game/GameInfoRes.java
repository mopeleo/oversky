package org.oversky.dreamland.dto.response.game;

import org.oversky.base.service.BaseResDto;

public class GameInfoRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private Long gameid;    //[identity]
	private String unioncode;    //
	private String gamecode;    //游戏代码
	private String gamename;    //游戏名称
	private String fullname;    //游戏全称
	private String englishname;    //
	private String alphatest;    //
	private String betatest;    //
	private String status;    //游戏状态，0-开发中，1-内测，2-公测，3-发行，4-终止
	private String summary;    //

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

	public String getEnglishname() {
		return this.englishname;
	}

	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}

	public String getAlphatest() {
		return this.alphatest;
	}

	public void setAlphatest(String alphatest) {
		this.alphatest = alphatest;
	}

	public String getBetatest() {
		return this.betatest;
	}

	public void setBetatest(String betatest) {
		this.betatest = betatest;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("gameid=").append(gameid).append(", ");
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("gamecode=").append(gamecode).append(", ");
		sb.append("gamename=").append(gamename).append(", ");
		sb.append("fullname=").append(fullname).append(", ");
		sb.append("englishname=").append(englishname).append(", ");
		sb.append("alphatest=").append(alphatest).append(", ");
		sb.append("betatest=").append(betatest).append(", ");
		sb.append("status=").append(status).append(", ");
		sb.append("summary=").append(summary).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
