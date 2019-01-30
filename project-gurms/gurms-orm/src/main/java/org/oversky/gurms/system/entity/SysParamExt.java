package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysParamExt extends BaseEntity{

	private Integer paramid;    //参数ID
	private String paramname;    //参数名称
	private String texttitle;    //描述头
	private String texttail;    //描述尾
	private Integer distype;    //0 text 无法修改；1 input 可以修改；2 select 可以修改
	private Integer dictcode;    //字典代码，对应的值列表为已知数据字典，优先于valuelist
	private String valuelist;    //控件显示的值列表，如“0|否;1|是”
	private String initvalue;    //初始值
	private Integer valuelength;    //输入值长度

	public Integer getParamid() {
		return this.paramid;
	}

	public void setParamid(Integer paramid) {
		this.paramid = paramid;
	}

	public String getParamname() {
		return this.paramname;
	}

	public void setParamname(String paramname) {
		this.paramname = paramname;
	}

	public String getTexttitle() {
		return this.texttitle;
	}

	public void setTexttitle(String texttitle) {
		this.texttitle = texttitle;
	}

	public String getTexttail() {
		return this.texttail;
	}

	public void setTexttail(String texttail) {
		this.texttail = texttail;
	}

	public Integer getDistype() {
		return this.distype;
	}

	public void setDistype(Integer distype) {
		this.distype = distype;
	}

	public Integer getDictcode() {
		return this.dictcode;
	}

	public void setDictcode(Integer dictcode) {
		this.dictcode = dictcode;
	}

	public String getValuelist() {
		return this.valuelist;
	}

	public void setValuelist(String valuelist) {
		this.valuelist = valuelist;
	}

	public String getInitvalue() {
		return this.initvalue;
	}

	public void setInitvalue(String initvalue) {
		this.initvalue = initvalue;
	}

	public Integer getValuelength() {
		return this.valuelength;
	}

	public void setValuelength(Integer valuelength) {
		this.valuelength = valuelength;
	}

    public boolean existId(){
        return true;
    }
    
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("SysParamExt");
		return build.append(this.paramid).toString();
	}

    public static String buildEntityKey(Integer paramid){
        StringBuilder build = new StringBuilder("SysParamExt");
        return build.append(paramid).toString();
    }
	
	public void clear(){
		this.paramid = null;
		this.paramname = null;
		this.texttitle = null;
		this.texttail = null;
		this.distype = null;
		this.dictcode = null;
		this.valuelist = null;
		this.initvalue = null;
		this.valuelength = null;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", paramid=").append(paramid);
		sb.append(", paramname=").append(paramname);
		sb.append(", texttitle=").append(texttitle);
		sb.append(", texttail=").append(texttail);
		sb.append(", distype=").append(distype);
		sb.append(", dictcode=").append(dictcode);
		sb.append(", valuelist=").append(valuelist);
		sb.append(", initvalue=").append(initvalue);
		sb.append(", valuelength=").append(valuelength);
        sb.append("]");
        return sb.toString();
	}
}
