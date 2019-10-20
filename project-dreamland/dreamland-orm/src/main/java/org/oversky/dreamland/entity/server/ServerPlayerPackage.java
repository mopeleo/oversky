package org.oversky.dreamland.entity.server;

import org.oversky.base.entity.BaseEntity;

public class ServerPlayerPackage extends BaseEntity{

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayerPackage");
		return build.append("#serverid:").append(this.serverid).append("#custno:").append(this.custno).append("#itemid:").append(this.itemid).toString();
	}

    public static String buildEntityKey(String serverid, Long custno, String itemid){
        StringBuilder build = new StringBuilder("ServerPlayerPackage");
        return build.append("#serverid:").append(serverid).append("#custno:").append(custno).append("#itemid:").append(itemid).toString();
    }
    
    public void copyPrimaryKey(ServerPlayerPackage entity){
		this.serverid = entity.getServerid();
		this.custno = entity.getCustno();
		this.itemid = entity.getItemid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", serverid=").append(serverid);
		sb.append(", custno=").append(custno);
		sb.append(", itemtype=").append(itemtype);
		sb.append(", itemid=").append(itemid);
		sb.append(", itemnum=").append(itemnum);
        sb.append("]");
        return sb.toString();
	}
}
