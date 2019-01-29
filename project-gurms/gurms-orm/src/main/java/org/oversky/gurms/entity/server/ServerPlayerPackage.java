package org.oversky.gurms.entity.server;

import com.dl.server.entity.DLEntity;

public class ServerPlayerPackage extends DLEntity{

	private String serverid;    //serverid
	private Long custno;    //custno
	private Integer itemtype;    //物品类型，0-道具，1-装备，2-技能
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

	public Integer getItemtype() {
		return this.itemtype;
	}

	public void setItemtype(Integer itemtype) {
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

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayerPackage");
		return build.append(this.serverid).append(this.custno).append(this.itemid).toString();
	}

    public static String buildEntityKey(String serverid, Long custno, String itemid){
        StringBuilder build = new StringBuilder("ServerPlayerPackage");
        return build.append(serverid).append(custno).append(itemid).toString();
    }
	
	public void clear(){
		this.serverid = null;
		this.custno = null;
		this.itemtype = null;
		this.itemid = null;
		this.itemnum = null;
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
