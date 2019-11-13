package org.oversky.dreamland.dto.request.server;

import org.oversky.base.service.BaseReqDto;

public class ServerPlayerPackageReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String serverid;    //
	private Long custno;    //
	private String itemtype;    //物品类型，0-道具，1-装备，2-技能
	private String itemid;    //物品ID
	private Integer itemnum;    //物品数量

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

	public String getItemtype() {
		return this.itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public Integer getItemnum() {
		return this.itemnum;
	}

	public void setItemnum(Integer itemnum) {
		this.itemnum = itemnum;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("serverid=").append(serverid).append(", ");
		sb.append("custno=").append(custno).append(", ");
		sb.append("itemtype=").append(itemtype).append(", ");
		sb.append("itemid=").append(itemid).append(", ");
		sb.append("itemnum=").append(itemnum).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
