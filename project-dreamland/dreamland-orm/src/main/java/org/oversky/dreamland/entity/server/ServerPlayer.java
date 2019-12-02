package org.oversky.dreamland.entity.server;

import org.oversky.base.entity.BaseEntity;

public class ServerPlayer extends BaseEntity{

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayer");
		return build.append("#serverid:").append(this.serverid).append("#custno:").append(this.custno).toString();
	}

    public static String buildEntityKey(String serverid, Long custno){
        StringBuilder build = new StringBuilder("ServerPlayer");
        return build.append("#serverid:").append(serverid).append("#custno:").append(custno).toString();
    }
    
    public void copyPrimaryKey(ServerPlayer entity){
		this.serverid = entity.getServerid();
		this.custno = entity.getCustno();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("serverid=").append(serverid).append(", ");
		sb.append("custno=").append(custno).append(", ");
		sb.append("nickname=").append(nickname).append(", ");
		sb.append("logindate=").append(logindate).append(", ");
		sb.append("logintime=").append(logintime).append(", ");
		sb.append("playerlevel=").append(playerlevel).append(", ");
		sb.append("viplevel=").append(viplevel).append(", ");
		sb.append("crystal=").append(crystal).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
