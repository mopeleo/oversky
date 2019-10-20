package org.oversky.dreamland.dto.request.server;

import org.oversky.base.service.BaseReqDto;

public class ServerPlayerInfoReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String serverid;    //
	private Long custno;    //
	private String nickname;    //
	private String logindate;    //
	private String logintime;    //
	private Integer playerlevel;    //玩家等级
	private Integer viplevel;    //会员等级
	private Integer crystal;    //水晶数量，游戏货币

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

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLogindate() {
		return this.logindate;
	}

	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}

	public String getLogintime() {
		return this.logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public Integer getPlayerlevel() {
		return this.playerlevel;
	}

	public void setPlayerlevel(Integer playerlevel) {
		this.playerlevel = playerlevel;
	}

	public Integer getViplevel() {
		return this.viplevel;
	}

	public void setViplevel(Integer viplevel) {
		this.viplevel = viplevel;
	}

	public Integer getCrystal() {
		return this.crystal;
	}

	public void setCrystal(Integer crystal) {
		this.crystal = crystal;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", serverid=").append(serverid);
		sb.append(", custno=").append(custno);
		sb.append(", nickname=").append(nickname);
		sb.append(", logindate=").append(logindate);
		sb.append(", logintime=").append(logintime);
		sb.append(", playerlevel=").append(playerlevel);
		sb.append(", viplevel=").append(viplevel);
		sb.append(", crystal=").append(crystal);
        sb.append("]");
        return sb.toString();
	}
}
