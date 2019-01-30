package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class SysDictValueReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String unioncode;    //unioncode
	private Long dictcode;    //字典代码
	private String itemcode;    //选项代码
	private String itemname;    //选项名称

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Long getDictcode() {
		return this.dictcode;
	}

	public void setDictcode(Long dictcode) {
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
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", unioncode=").append(unioncode);
		sb.append(", dictcode=").append(dictcode);
		sb.append(", itemcode=").append(itemcode);
		sb.append(", itemname=").append(itemname);
        sb.append("]");
        return sb.toString();
	}
}
