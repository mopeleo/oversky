package org.oversky.dreamland.dto.request.server;

import org.oversky.base.service.BaseReqDto;

public class ServerPlayerActorFavorReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String serverid;    //
	private Long custno;    //
	private String maleid;    //男性角色ID
	private String femaleid;    //女性角色ID
	private Integer degree;    //好感度

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

	public String getMaleid() {
		return this.maleid;
	}

	public void setMaleid(String maleid) {
		this.maleid = maleid;
	}

	public String getFemaleid() {
		return this.femaleid;
	}

	public void setFemaleid(String femaleid) {
		this.femaleid = femaleid;
	}

	public Integer getDegree() {
		return this.degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("serverid=").append(serverid).append(", ");
		sb.append("custno=").append(custno).append(", ");
		sb.append("maleid=").append(maleid).append(", ");
		sb.append("femaleid=").append(femaleid).append(", ");
		sb.append("degree=").append(degree).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
