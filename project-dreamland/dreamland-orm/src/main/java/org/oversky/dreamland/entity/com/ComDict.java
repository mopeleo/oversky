package org.oversky.dreamland.entity.com;

import org.oversky.base.entity.BaseEntity;

public class ComDict extends BaseEntity{

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("ComDict");
		return build.append("#dictcode:").append(this.dictcode).append("#itemcode:").append(this.itemcode).toString();
	}

    public static String buildEntityKey(Integer dictcode, String itemcode){
        StringBuilder build = new StringBuilder("ComDict");
        return build.append("#dictcode:").append(dictcode).append("#itemcode:").append(itemcode).toString();
    }
    
    public void copyPrimaryKey(ComDict entity){
		this.dictcode = entity.getDictcode();
		this.itemcode = entity.getItemcode();
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
