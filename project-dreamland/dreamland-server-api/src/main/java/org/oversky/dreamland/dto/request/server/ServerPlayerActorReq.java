package org.oversky.dreamland.dto.request.server;

import org.oversky.base.service.BaseReqDto;

public class ServerPlayerActorReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long paid;    //自动生成，客户角色ID
	private String serverid;    //
	private Long custno;    //
	private String actorid;    //角色ID
	private Integer grade;    //星级
	private Integer actorlevel;    //等级
	private Double ratiostr;    //默认力量成长率
	private Double ratioint;    //默认智力成长率
	private Double ratiohp;    //默认HP成长率
	private Double ratiomp;    //默认MP成长率
	private Double ratioagl;    //默认敏捷成长率
	private Double ratioluck;    //默认幸运成长率

	public Long getPaid() {
		return this.paid;
	}

	public void setPaid(Long paid) {
		this.paid = paid;
	}

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

	public String getActorid() {
		return this.actorid;
	}

	public void setActorid(String actorid) {
		this.actorid = actorid;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getActorlevel() {
		return this.actorlevel;
	}

	public void setActorlevel(Integer actorlevel) {
		this.actorlevel = actorlevel;
	}

	public Double getRatiostr() {
		return this.ratiostr;
	}

	public void setRatiostr(Double ratiostr) {
		this.ratiostr = ratiostr;
	}

	public Double getRatioint() {
		return this.ratioint;
	}

	public void setRatioint(Double ratioint) {
		this.ratioint = ratioint;
	}

	public Double getRatiohp() {
		return this.ratiohp;
	}

	public void setRatiohp(Double ratiohp) {
		this.ratiohp = ratiohp;
	}

	public Double getRatiomp() {
		return this.ratiomp;
	}

	public void setRatiomp(Double ratiomp) {
		this.ratiomp = ratiomp;
	}

	public Double getRatioagl() {
		return this.ratioagl;
	}

	public void setRatioagl(Double ratioagl) {
		this.ratioagl = ratioagl;
	}

	public Double getRatioluck() {
		return this.ratioluck;
	}

	public void setRatioluck(Double ratioluck) {
		this.ratioluck = ratioluck;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("paid=").append(paid).append(", ");
		sb.append("serverid=").append(serverid).append(", ");
		sb.append("custno=").append(custno).append(", ");
		sb.append("actorid=").append(actorid).append(", ");
		sb.append("grade=").append(grade).append(", ");
		sb.append("actorlevel=").append(actorlevel).append(", ");
		sb.append("ratiostr=").append(ratiostr).append(", ");
		sb.append("ratioint=").append(ratioint).append(", ");
		sb.append("ratiohp=").append(ratiohp).append(", ");
		sb.append("ratiomp=").append(ratiomp).append(", ");
		sb.append("ratioagl=").append(ratioagl).append(", ");
		sb.append("ratioluck=").append(ratioluck).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
