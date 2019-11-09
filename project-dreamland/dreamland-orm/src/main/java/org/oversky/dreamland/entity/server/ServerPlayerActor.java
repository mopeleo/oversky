package org.oversky.dreamland.entity.server;

import org.oversky.base.entity.BaseEntity;

public class ServerPlayerActor extends BaseEntity{

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayerActor");
		return build.append("#serverid:").append(this.serverid).append("#custno:").append(this.custno).append("#actorid:").append(this.actorid).toString();
	}

    public static String buildEntityKey(String serverid, Long custno, String actorid){
        StringBuilder build = new StringBuilder("ServerPlayerActor");
        return build.append("#serverid:").append(serverid).append("#custno:").append(custno).append("#actorid:").append(actorid).toString();
    }
    
    public void copyPrimaryKey(ServerPlayerActor entity){
		this.serverid = entity.getServerid();
		this.custno = entity.getCustno();
		this.actorid = entity.getActorid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", paid=").append(paid);
		sb.append(", serverid=").append(serverid);
		sb.append(", custno=").append(custno);
		sb.append(", actorid=").append(actorid);
		sb.append(", grade=").append(grade);
		sb.append(", actorlevel=").append(actorlevel);
		sb.append(", ratiostr=").append(ratiostr);
		sb.append(", ratioint=").append(ratioint);
		sb.append(", ratiohp=").append(ratiohp);
		sb.append(", ratiomp=").append(ratiomp);
		sb.append(", ratioagl=").append(ratioagl);
		sb.append(", ratioluck=").append(ratioluck);
        sb.append("]");
        return sb.toString();
	}
}
