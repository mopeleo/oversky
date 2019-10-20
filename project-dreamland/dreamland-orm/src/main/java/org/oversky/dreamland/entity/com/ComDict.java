package org.oversky.dreamland.entity.com;

import org.oversky.base.entity.BaseEntity;

public class ComDict extends BaseEntity{

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

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("ComDict");
		return build.append("#unioncode:").append(this.unioncode).append("#dictcode:").append(this.dictcode).append("#itemcode:").append(this.itemcode).toString();
	}

    public static String buildEntityKey(String unioncode, Integer dictcode, String itemcode){
        StringBuilder build = new StringBuilder("ComDict");
        return build.append("#unioncode:").append(unioncode).append("#dictcode:").append(dictcode).append("#itemcode:").append(itemcode).toString();
    }
    
    public void copyPrimaryKey(ComDict entity){
		this.unioncode = entity.getUnioncode();
		this.dictcode = entity.getDictcode();
		this.itemcode = entity.getItemcode();
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
