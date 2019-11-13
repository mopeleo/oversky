package org.oversky.dreamland.entity.com;

import org.oversky.base.entity.BaseEntity;

public class ComParam extends BaseEntity{

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
		StringBuilder build = new StringBuilder("ComParam");
		return build.append("#unioncode:").append(this.unioncode).append("#paramid:").append(this.paramid).toString();
	}

    public static String buildEntityKey(String unioncode, Integer paramid){
        StringBuilder build = new StringBuilder("ComParam");
        return build.append("#unioncode:").append(unioncode).append("#paramid:").append(paramid).toString();
    }
    
    public void copyPrimaryKey(ComParam entity){
		this.unioncode = entity.getUnioncode();
		this.paramid = entity.getParamid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("paramid=").append(paramid).append(", ");
		sb.append("paramvalue=").append(paramvalue).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
