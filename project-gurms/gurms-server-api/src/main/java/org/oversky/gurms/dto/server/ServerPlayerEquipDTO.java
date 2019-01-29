package org.oversky.gurms.dto.server;

import com.dl.server.dto.BaseDTO;

public class ServerPlayerEquipDTO extends BaseDTO {

	private Long peid;    //自动生产的流水ID
	private String serverid;    //serverid
	private Long custno;    //custno
	private String equipid;    //equipid
	private String actorid;    //若actorid为空，则放在背包，不为空，则装备在角色身上
	private Integer level;    //武器等级
	private Integer proficiency;    //武器熟练度

	public Long getPeid() {
		return this.peid;
	}

	public void setPeid(Long peid) {
		this.peid = peid;
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

	public String getEquipid() {
		return this.equipid;
	}

	public void setEquipid(String equipid) {
		this.equipid = equipid;
	}

	public String getActorid() {
		return this.actorid;
	}

	public void setActorid(String actorid) {
		this.actorid = actorid;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getProficiency() {
		return this.proficiency;
	}

	public void setProficiency(Integer proficiency) {
		this.proficiency = proficiency;
	}


	public void clear(){
		this.peid = null;
		this.serverid = null;
		this.custno = null;
		this.equipid = null;
		this.actorid = null;
		this.level = null;
		this.proficiency = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", peid=").append(peid);
		sb.append(", serverid=").append(serverid);
		sb.append(", custno=").append(custno);
		sb.append(", equipid=").append(equipid);
		sb.append(", actorid=").append(actorid);
		sb.append(", level=").append(level);
		sb.append(", proficiency=").append(proficiency);
        sb.append("]");
        return sb.toString();
	}
}
