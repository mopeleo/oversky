package org.oversky.dreamland.dto.response.com;

import org.oversky.base.service.BaseResDto;

public class ComMqTransactionLogRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private Long logid;    //流水ID[identity]
	private String transactionId;    //事务ID,唯一索引
	private String busiType;    //业务类型（0-测试，1-转账）
	private String busiId;    //业务ID(JSON)
	private String sender;    //发送方
	private String receiver;    //接受方

	public Long getLogid() {
		return this.logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getBusiType() {
		return this.busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getBusiId() {
		return this.busiId;
	}

	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("logid=").append(logid).append(", ");
		sb.append("transactionId=").append(transactionId).append(", ");
		sb.append("busiType=").append(busiType).append(", ");
		sb.append("busiId=").append(busiId).append(", ");
		sb.append("sender=").append(sender).append(", ");
		sb.append("receiver=").append(receiver).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
