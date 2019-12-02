package org.oversky.dreamland.entity.game;

import org.oversky.base.entity.BaseEntity;

public class GamePromotion extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long promid;    //
	private String unioncode;    //
	private Long gameid;    //游戏ID
	private String promname;    //
	private String remark;    //

	public Long getPromid() {
		return this.promid;
	}

	public void setPromid(Long promid) {
		this.promid = promid;
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

	public String getPromname() {
		return this.promname;
	}

	public void setPromname(String promname) {
		this.promname = promname;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("GamePromotion");
		return build.append("#promid:").append(this.promid).toString();
	}

    public static String buildEntityKey(Long promid){
        StringBuilder build = new StringBuilder("GamePromotion");
        return build.append("#promid:").append(promid).toString();
    }
    
    public void copyPrimaryKey(GamePromotion entity){
		this.promid = entity.getPromid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("promid=").append(promid).append(", ");
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("gameid=").append(gameid).append(", ");
		sb.append("promname=").append(promname).append(", ");
		sb.append("remark=").append(remark).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
