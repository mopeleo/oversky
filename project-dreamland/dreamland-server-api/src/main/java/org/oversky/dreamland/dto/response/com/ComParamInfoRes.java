package org.oversky.dreamland.dto.response.com;

import org.oversky.base.service.BaseResDto;

public class ComParamInfoRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private Integer paramid;    //参数ID
	private String paramname;    //参数名称
	private String paramgroup;    //所属分组，字典
	private String edittype;    //1 只读无法修改，2 input 修改，3 select 修改
	private String initvalue;    //初始值
	private Integer valuelength;    //输入值长度,0-不检查长度，其他值效验长度
	private String texttitle;    //描述头
	private String texttail;    //描述尾
	private String valuelist;    //控件显示的值列表，如“0|否;1|是”

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

	public String getParamgroup() {
		return this.paramgroup;
	}

	public void setParamgroup(String paramgroup) {
		this.paramgroup = paramgroup;
	}

	public String getEdittype() {
		return this.edittype;
	}

	public void setEdittype(String edittype) {
		this.edittype = edittype;
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

	public String getValuelist() {
		return this.valuelist;
	}

	public void setValuelist(String valuelist) {
		this.valuelist = valuelist;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("paramid=").append(paramid).append(", ");
		sb.append("paramname=").append(paramname).append(", ");
		sb.append("paramgroup=").append(paramgroup).append(", ");
		sb.append("edittype=").append(edittype).append(", ");
		sb.append("initvalue=").append(initvalue).append(", ");
		sb.append("valuelength=").append(valuelength).append(", ");
		sb.append("texttitle=").append(texttitle).append(", ");
		sb.append("texttail=").append(texttail).append(", ");
		sb.append("valuelist=").append(valuelist).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
