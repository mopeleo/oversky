package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysSno extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String unioncode;    //
	private Integer noid;    //流水号ID
	private String noname;    //流水号名称
	private Long initvalue;    //初始值
	private Long nextvalue;    //下个值
	private String fixedflag;    //定长标志(0-不固定，1-定长)
	private Integer fixedlength;    //定长长度，不包括前后缀
	private String fillchar;    //填充字符
	private String notype;    //类型（1-递增，2-递减）
	private String cycletype;    //循环周期（0-指定值重置，1-按天循环，2-按月循环，3-按年循环）
	private String cycledate;    //循环起始日期
	private Long endvalue;    //指定重置值
	private String prefix;    //前缀，支持日期/时间模板，如 ab{date}{time}cd
	private String suffix;    //后缀，支持日期/时间模板，如 ab{date}{time}cd

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Integer getNoid() {
		return this.noid;
	}

	public void setNoid(Integer noid) {
		this.noid = noid;
	}

	public String getNoname() {
		return this.noname;
	}

	public void setNoname(String noname) {
		this.noname = noname;
	}

	public Long getInitvalue() {
		return this.initvalue;
	}

	public void setInitvalue(Long initvalue) {
		this.initvalue = initvalue;
	}

	public Long getNextvalue() {
		return this.nextvalue;
	}

	public void setNextvalue(Long nextvalue) {
		this.nextvalue = nextvalue;
	}

	public String getFixedflag() {
		return this.fixedflag;
	}

	public void setFixedflag(String fixedflag) {
		this.fixedflag = fixedflag;
	}

	public Integer getFixedlength() {
		return this.fixedlength;
	}

	public void setFixedlength(Integer fixedlength) {
		this.fixedlength = fixedlength;
	}

	public String getFillchar() {
		return this.fillchar;
	}

	public void setFillchar(String fillchar) {
		this.fillchar = fillchar;
	}

	public String getNotype() {
		return this.notype;
	}

	public void setNotype(String notype) {
		this.notype = notype;
	}

	public String getCycletype() {
		return this.cycletype;
	}

	public void setCycletype(String cycletype) {
		this.cycletype = cycletype;
	}

	public String getCycledate() {
		return this.cycledate;
	}

	public void setCycledate(String cycledate) {
		this.cycledate = cycledate;
	}

	public Long getEndvalue() {
		return this.endvalue;
	}

	public void setEndvalue(Long endvalue) {
		this.endvalue = endvalue;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysSno");
		return build.append("#unioncode:").append(this.unioncode).append("#noid:").append(this.noid).toString();
	}

    public static String buildEntityKey(String unioncode, Integer noid){
        StringBuilder build = new StringBuilder("SysSno");
        return build.append("#unioncode:").append(unioncode).append("#noid:").append(noid).toString();
    }
    
    public void copyPrimaryKey(SysSno entity){
		this.unioncode = entity.getUnioncode();
		this.noid = entity.getNoid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("noid=").append(noid).append(", ");
		sb.append("noname=").append(noname).append(", ");
		sb.append("initvalue=").append(initvalue).append(", ");
		sb.append("nextvalue=").append(nextvalue).append(", ");
		sb.append("fixedflag=").append(fixedflag).append(", ");
		sb.append("fixedlength=").append(fixedlength).append(", ");
		sb.append("fillchar=").append(fillchar).append(", ");
		sb.append("notype=").append(notype).append(", ");
		sb.append("cycletype=").append(cycletype).append(", ");
		sb.append("cycledate=").append(cycledate).append(", ");
		sb.append("endvalue=").append(endvalue).append(", ");
		sb.append("prefix=").append(prefix).append(", ");
		sb.append("suffix=").append(suffix).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
