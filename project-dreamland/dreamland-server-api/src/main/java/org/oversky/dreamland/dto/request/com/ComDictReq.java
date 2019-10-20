package org.oversky.dreamland.dto.request.com;

import org.oversky.base.service.BaseReqDto;

public class ComDictReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String unioncode;    //
	private Integer dictcode;    //字典代码
	private String dictname;    //字典名称
	private String itemcode;    //选项代码
	private String itemvalue;    //选项值

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Integer getDictcode() {
		return this.dictcode;
	}

	public void setDictcode(Integer dictcode) {
		this.dictcode = dictcode;
	}

	public String getDictname() {
		return this.dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname;
	}

	public String getItemcode() {
		return this.itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getItemvalue() {
		return this.itemvalue;
	}

	public void setItemvalue(String itemvalue) {
		this.itemvalue = itemvalue;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", unioncode=").append(unioncode);
		sb.append(", dictcode=").append(dictcode);
		sb.append(", dictname=").append(dictname);
		sb.append(", itemcode=").append(itemcode);
		sb.append(", itemvalue=").append(itemvalue);
        sb.append("]");
        return sb.toString();
	}
}
