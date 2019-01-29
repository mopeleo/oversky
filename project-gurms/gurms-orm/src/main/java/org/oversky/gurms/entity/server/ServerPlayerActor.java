package org.oversky.gurms.entity.server;

import com.dl.server.entity.DLEntity;

public class ServerPlayerActor extends DLEntity{

	private Long paid;    //自动生成，客户角色ID
	private String serverid;    //serverid
	private Long custno;    //custno
	private String actorid;    //角色ID
	private Integer rank;    //星级
	private Integer level;    //等级
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

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayerActor");
		return build.append(this.serverid).append(this.custno).append(this.actorid).toString();
	}

    public static String buildEntityKey(String serverid, Long custno, String actorid){
        StringBuilder build = new StringBuilder("ServerPlayerActor");
        return build.append(serverid).append(custno).append(actorid).toString();
    }
	
	public void clear(){
		this.paid = null;
		this.serverid = null;
		this.custno = null;
		this.actorid = null;
		this.rank = null;
		this.level = null;
		this.ratiostr = null;
		this.ratioint = null;
		this.ratiohp = null;
		this.ratiomp = null;
		this.ratioagl = null;
		this.ratioluck = null;
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
		sb.append(", rank=").append(rank);
		sb.append(", level=").append(level);
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
