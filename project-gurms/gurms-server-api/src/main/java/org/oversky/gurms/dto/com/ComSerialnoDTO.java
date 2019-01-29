package org.oversky.gurms.dto.com;

import com.dl.server.dto.BaseDTO;

public class ComSerialnoDTO extends BaseDTO {

	private Integer id;    //id
	private Integer prevalue;    //prevalue

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPrevalue() {
		return this.prevalue;
	}

	public void setPrevalue(Integer prevalue) {
		this.prevalue = prevalue;
	}


	public void clear(){
		this.id = null;
		this.prevalue = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", prevalue=").append(prevalue);
        sb.append("]");
        return sb.toString();
	}
}
