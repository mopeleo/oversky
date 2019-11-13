package org.oversky.dreamland.dto.response.com;

import org.oversky.base.service.BaseResDto;

public class ComDictRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private Integer dictcode;    //字典代码
	private String itemcode;    //选项代码
	private String itemname;    //选项值

	public Integer getDictcode() {
		return this.dictcode;
	}

	public void setDictcode(Integer dictcode) {
		this.dictcode = dictcode;
	}

	public String getItemcode() {
		return this.itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("dictcode=").append(dictcode).append(", ");
		sb.append("itemcode=").append(itemcode).append(", ");
		sb.append("itemname=").append(itemname).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
