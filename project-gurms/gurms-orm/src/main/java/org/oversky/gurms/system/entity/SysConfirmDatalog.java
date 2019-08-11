package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysConfirmDatalog extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long logid;    //数据流水号[identity]
	private String unioncode;    //
	private Integer confirmid;    //复核类型ID
	private String edittype;    //行为（1-insert，2-update，3-delete）
	private String dataid;    //数据id，json
	private String fulldata;    //要复核的完整数据，json字符串
	private String extdata;    //fulldata保存不下的，可以拆分存在这里
	private Long editer;    //编辑人
	private String editdate;    //编辑日期
	private String edittime;    //编辑时间
	private String currentstatus;    //当前复核状态（0-未复核，1-复核通过，2-复核不通过）
	private Integer currentlevel;    //当前复核级别
	private String endflag;    //完结标志（0-未结束，1-结束）

	public Long getLogid() {
		return this.logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Integer getConfirmid() {
		return this.confirmid;
	}

	public void setConfirmid(Integer confirmid) {
		this.confirmid = confirmid;
	}

	public String getEdittype() {
		return this.edittype;
	}

	public void setEdittype(String edittype) {
		this.edittype = edittype;
	}

	public String getDataid() {
		return this.dataid;
	}

	public void setDataid(String dataid) {
		this.dataid = dataid;
	}

	public String getFulldata() {
		return this.fulldata;
	}

	public void setFulldata(String fulldata) {
		this.fulldata = fulldata;
	}

	public String getExtdata() {
		return this.extdata;
	}

	public void setExtdata(String extdata) {
		this.extdata = extdata;
	}

	public Long getEditer() {
		return this.editer;
	}

	public void setEditer(Long editer) {
		this.editer = editer;
	}

	public String getEditdate() {
		return this.editdate;
	}

	public void setEditdate(String editdate) {
		this.editdate = editdate;
	}

	public String getEdittime() {
		return this.edittime;
	}

	public void setEdittime(String edittime) {
		this.edittime = edittime;
	}

	public String getCurrentstatus() {
		return this.currentstatus;
	}

	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}

	public Integer getCurrentlevel() {
		return this.currentlevel;
	}

	public void setCurrentlevel(Integer currentlevel) {
		this.currentlevel = currentlevel;
	}

	public String getEndflag() {
		return this.endflag;
	}

	public void setEndflag(String endflag) {
		this.endflag = endflag;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysConfirmDatalog");
		return build.append("#logid:").append(this.logid).toString();
	}

    public static String buildEntityKey(Long logid){
        StringBuilder build = new StringBuilder("SysConfirmDatalog");
        return build.append("#logid:").append(logid).toString();
    }
    
    public void copyPrimaryKey(SysConfirmDatalog entity){
		this.logid = entity.getLogid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", logid=").append(logid);
		sb.append(", unioncode=").append(unioncode);
		sb.append(", confirmid=").append(confirmid);
		sb.append(", edittype=").append(edittype);
		sb.append(", dataid=").append(dataid);
		sb.append(", fulldata=").append(fulldata);
		sb.append(", extdata=").append(extdata);
		sb.append(", editer=").append(editer);
		sb.append(", editdate=").append(editdate);
		sb.append(", edittime=").append(edittime);
		sb.append(", currentstatus=").append(currentstatus);
		sb.append(", currentlevel=").append(currentlevel);
		sb.append(", endflag=").append(endflag);
        sb.append("]");
        return sb.toString();
	}
}
