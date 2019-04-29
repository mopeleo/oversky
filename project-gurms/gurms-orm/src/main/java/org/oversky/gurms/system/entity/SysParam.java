package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysParam extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String unioncode;    //
	private Integer paramid;    //
	private String paramvalue;    //

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Integer getParamid() {
		return this.paramid;
	}

	public void setParamid(Integer paramid) {
		this.paramid = paramid;
	}

	public String getParamvalue() {
		return this.paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysParam");
		return build.append("#unioncode:").append(this.unioncode).append("#paramid:").append(this.paramid).toString();
	}

    public static String buildEntityKey(String unioncode, Integer paramid){
        StringBuilder build = new StringBuilder("SysParam");
        return build.append("#unioncode:").append(unioncode).append("#paramid:").append(paramid).toString();
    }
    
    public void copyPrimaryKey(SysParam entity){
		this.unioncode = entity.getUnioncode();
		this.paramid = entity.getParamid();
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
