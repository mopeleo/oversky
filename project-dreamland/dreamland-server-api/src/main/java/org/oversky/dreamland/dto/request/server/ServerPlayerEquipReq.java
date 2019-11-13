package org.oversky.dreamland.dto.request.server;

import org.oversky.base.service.BaseReqDto;

public class ServerPlayerEquipReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private Long peid;    //自动生产的流水ID
	private String serverid;    //
	private Long custno;    //
	private String equipid;    //
	private String actorid;    //若actorid为空，则放在背包，不为空，则装备在角色身上
	private Integer equiplevel;    //武器等级
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

	public Integer getEquiplevel() {
		return this.equiplevel;
	}

	public void setEquiplevel(Integer equiplevel) {
		this.equiplevel = equiplevel;
	}

	public Integer getProficiency() {
		return this.proficiency;
	}

	public void setProficiency(Integer proficiency) {
		this.proficiency = proficiency;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("peid=").append(peid).append(", ");
		sb.append("serverid=").append(serverid).append(", ");
		sb.append("custno=").append(custno).append(", ");
		sb.append("equipid=").append(equipid).append(", ");
		sb.append("actorid=").append(actorid).append(", ");
		sb.append("equiplevel=").append(equiplevel).append(", ");
		sb.append("proficiency=").append(proficiency).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
