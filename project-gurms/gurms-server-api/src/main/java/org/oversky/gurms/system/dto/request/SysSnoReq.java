package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class SysSnoReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String unioncode;    //
	private Integer noid;    //流水号ID
	private String noname;    //流水号名称
	private Long initvalue;    //初始值
	private Long nextvalue;    //下个值
	private Integer fixedflag;    //定长标志(0-不固定，1-定长)
	private Integer fixedlength;    //定长长度，不包括前后缀
	private String fillchar;    //填充字符
	private Integer notype;    //类型（1-递增，2-按天复位）
	private String nodate;    //使用日期
	private String prefix;    //前缀
	private String suffix;    //后缀

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

	public Integer getFixedflag() {
		return this.fixedflag;
	}

	public void setFixedflag(Integer fixedflag) {
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

	public Integer getNotype() {
		return this.notype;
	}

	public void setNotype(Integer notype) {
		this.notype = notype;
	}

	public String getNodate() {
		return this.nodate;
	}

	public void setNodate(String nodate) {
		this.nodate = nodate;
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", unioncode=").append(unioncode);
		sb.append(", noid=").append(noid);
		sb.append(", noname=").append(noname);
		sb.append(", initvalue=").append(initvalue);
		sb.append(", nextvalue=").append(nextvalue);
		sb.append(", fixedflag=").append(fixedflag);
		sb.append(", fixedlength=").append(fixedlength);
		sb.append(", fillchar=").append(fillchar);
		sb.append(", notype=").append(notype);
		sb.append(", nodate=").append(nodate);
		sb.append(", prefix=").append(prefix);
		sb.append(", suffix=").append(suffix);
        sb.append("]");
        return sb.toString();
	}
}
