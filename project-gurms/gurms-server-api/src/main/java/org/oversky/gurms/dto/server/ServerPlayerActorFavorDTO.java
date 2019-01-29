package org.oversky.gurms.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPlayerActorFavorDTO extends BaseDTO {

	private String serverid;    //serverid
	private Long custno;    //custno
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


	public void clear(){
		this.serverid = null;
		this.custno = null;
		this.maleid = null;
		this.femaleid = null;
		this.degree = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", serverid=").append(serverid);
		sb.append(", custno=").append(custno);
		sb.append(", maleid=").append(maleid);
		sb.append(", femaleid=").append(femaleid);
		sb.append(", degree=").append(degree);
        sb.append("]");
        return sb.toString();
	}
}
