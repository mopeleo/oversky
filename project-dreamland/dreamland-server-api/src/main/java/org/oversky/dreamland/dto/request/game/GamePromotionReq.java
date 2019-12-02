package org.oversky.dreamland.dto.request.game;

import org.oversky.base.service.BaseReqDto;

public class GamePromotionReq extends BaseReqDto {

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
