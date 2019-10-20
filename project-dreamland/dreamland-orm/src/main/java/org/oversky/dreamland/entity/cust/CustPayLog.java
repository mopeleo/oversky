package org.oversky.dreamland.entity.cust;

import org.oversky.base.entity.BaseEntity;

public class CustPayLog extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long logid;    //
	private Long custno;    //
	private String serverid;    //
	private String direction;    //方向，0 支付，1，退款
	private Double amt;    //金额
	private String inacct;    //入款账号
	private String outacct;    //出款账号
	private String busitype;    //业务类型：1，充值，2，购买XX
	private String status;    //状态，0，支付中，1，成功，2，失败
	private String paydate;    //支付日期
	private String paytime;    //支付时间
	private String summary;    //备注

	public Long getLogid() {
		return this.logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public Long getCustno() {
		return this.custno;
	}

	public void setCustno(Long custno) {
		this.custno = custno;
	}

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Double getAmt() {
		return this.amt;
	}

	public void setAmt(Double amt) {
		this.amt = amt;
	}

	public String getInacct() {
		return this.inacct;
	}

	public void setInacct(String inacct) {
		this.inacct = inacct;
	}

	public String getOutacct() {
		return this.outacct;
	}

	public void setOutacct(String outacct) {
		this.outacct = outacct;
	}

	public String getBusitype() {
		return this.busitype;
	}

	public void setBusitype(String busitype) {
		this.busitype = busitype;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaydate() {
		return this.paydate;
	}

	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}

	public String getPaytime() {
		return this.paytime;
	}

	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("CustPayLog");
		return build.append("#logid:").append(this.logid).toString();
	}

    public static String buildEntityKey(Long logid){
        StringBuilder build = new StringBuilder("CustPayLog");
        return build.append("#logid:").append(logid).toString();
    }
    
    public void copyPrimaryKey(CustPayLog entity){
		this.logid = entity.getLogid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", logid=").append(logid);
		sb.append(", custno=").append(custno);
		sb.append(", serverid=").append(serverid);
		sb.append(", direction=").append(direction);
		sb.append(", amt=").append(amt);
		sb.append(", inacct=").append(inacct);
		sb.append(", outacct=").append(outacct);
		sb.append(", busitype=").append(busitype);
		sb.append(", status=").append(status);
		sb.append(", paydate=").append(paydate);
		sb.append(", paytime=").append(paytime);
		sb.append(", summary=").append(summary);
        sb.append("]");
        return sb.toString();
	}
}
