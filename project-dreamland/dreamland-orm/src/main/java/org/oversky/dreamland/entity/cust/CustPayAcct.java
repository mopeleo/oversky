package org.oversky.dreamland.entity.cust;

import org.oversky.base.entity.BaseEntity;

public class CustPayAcct extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long acctno;    //账户编号[identity]
	private Long custno;    //
	private String paytype;    //支付方式，0，银行卡，1微信，2，支付宝
	private String payno;    //支付账号

	public Long getAcctno() {
		return this.acctno;
	}

	public void setAcctno(Long acctno) {
		this.acctno = acctno;
	}

	public Long getCustno() {
		return this.custno;
	}

	public void setCustno(Long custno) {
		this.custno = custno;
	}

	public String getPaytype() {
		return this.paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getPayno() {
		return this.payno;
	}

	public void setPayno(String payno) {
		this.payno = payno;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("CustPayAcct");
		return build.append("#acctno:").append(this.acctno).toString();
	}

    public static String buildEntityKey(Long acctno){
        StringBuilder build = new StringBuilder("CustPayAcct");
        return build.append("#acctno:").append(acctno).toString();
    }
    
    public void copyPrimaryKey(CustPayAcct entity){
		this.acctno = entity.getAcctno();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("acctno=").append(acctno).append(", ");
		sb.append("custno=").append(custno).append(", ");
		sb.append("paytype=").append(paytype).append(", ");
		sb.append("payno=").append(payno).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
