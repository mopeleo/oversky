package org.oversky.dreamland.dto.response.cust;

import org.oversky.base.service.BaseResDto;

public class CustPayAcctRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private Long acctno;    //账户编号
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", acctno=").append(acctno);
		sb.append(", custno=").append(custno);
		sb.append(", paytype=").append(paytype);
		sb.append(", payno=").append(payno);
        sb.append("]");
        return sb.toString();
	}
}
