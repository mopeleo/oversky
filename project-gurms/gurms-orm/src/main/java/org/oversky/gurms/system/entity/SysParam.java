package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysParam extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String unioncode;    //unioncode
	private Long paramid;    //paramid
	private String paramvalue;    //paramvalue

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Long getParamid() {
		return this.paramid;
	}

	public void setParamid(Long paramid) {
		this.paramid = paramid;
	}

	public String getParamvalue() {
		return this.paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}

	public String getEntityKey(){
		StringBuilder build = new StringBuilder("SysParam");
		return build.append(this.unioncode).append(this.paramid).toString();
	}

    public static String buildEntityKey(String unioncode, Long paramid){
        StringBuilder build = new StringBuilder("SysParam");
        return build.append(unioncode).append(paramid).toString();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", unioncode=").append(unioncode);
		sb.append(", paramid=").append(paramid);
		sb.append(", paramvalue=").append(paramvalue);
        sb.append("]");
        return sb.toString();
	}
}
