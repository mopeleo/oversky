package org.oversky.gurms.entity.com;

import com.dl.server.entity.DLEntity;

public class ComSerialno extends DLEntity{

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

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("ComSerialno");
		return build.append(this.id).toString();
	}

    public static String buildEntityKey(Integer id){
        StringBuilder build = new StringBuilder("ComSerialno");
        return build.append(id).toString();
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
