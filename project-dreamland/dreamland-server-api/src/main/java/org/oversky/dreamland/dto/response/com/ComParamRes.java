package org.oversky.dreamland.dto.response.com;

import org.oversky.base.service.BaseResDto;

public class ComParamRes extends BaseResDto {

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
