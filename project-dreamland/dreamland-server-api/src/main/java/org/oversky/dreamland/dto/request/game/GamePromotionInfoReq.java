package org.oversky.dreamland.dto.request.game;

import org.oversky.base.service.BaseReqDto;

public class GamePromotionInfoReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Integer promid;    //
	private String promname;    //
	private String remark;    //

	public Integer getPromid() {
		return this.promid;
	}

	public void setPromid(Integer promid) {
		this.promid = promid;
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
		sb.append("promname=").append(promname).append(", ");
		sb.append("remark=").append(remark).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
