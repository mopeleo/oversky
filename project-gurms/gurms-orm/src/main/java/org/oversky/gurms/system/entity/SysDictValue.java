package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysDictValue extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String unioncode;    //
	private Integer dictcode;    //字典代码
	private String itemcode;    //选项代码
	private String itemname;    //选项名称

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysDictValue");
		return build.append("#unioncode:").append(this.unioncode).append("#dictcode:").append(this.dictcode).append("#itemcode:").append(this.itemcode).toString();
	}

    public static String buildEntityKey(String unioncode, Integer dictcode, String itemcode){
        StringBuilder build = new StringBuilder("SysDictValue");
        return build.append("#unioncode:").append(unioncode).append("#dictcode:").append(dictcode).append("#itemcode:").append(itemcode).toString();
    }
    
    public void copyPrimaryKey(SysDictValue entity){
		this.unioncode = entity.getUnioncode();
		this.dictcode = entity.getDictcode();
		this.itemcode = entity.getItemcode();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("dictcode=").append(dictcode).append(", ");
		sb.append("itemcode=").append(itemcode).append(", ");
		sb.append("itemname=").append(itemname).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
