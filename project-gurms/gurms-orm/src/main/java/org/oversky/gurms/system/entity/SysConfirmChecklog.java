package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysConfirmChecklog extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long logid;    //复核流水号[identity]
	private Long datalog;    //复核数据流水号
	private Long checker;    //复核人
	private Integer checklevel;    //复核级别
	private String checkdate;    //复核日期
	private String checktime;    //复核时间
	private Integer status;    //复核状态（0-未复核，1-复核通过，2-复核不通过）
	private String summary;    //复核意见

	public Long getLogid() {
		return this.logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public Long getDatalog() {
		return this.datalog;
	}

	public void setDatalog(Long datalog) {
		this.datalog = datalog;
	}

	public Long getChecker() {
		return this.checker;
	}

	public void setChecker(Long checker) {
		this.checker = checker;
	}

	public Integer getChecklevel() {
		return this.checklevel;
	}

	public void setChecklevel(Integer checklevel) {
		this.checklevel = checklevel;
	}

	public String getCheckdate() {
		return this.checkdate;
	}

	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}

	public String getChecktime() {
		return this.checktime;
	}

	public void setChecktime(String checktime) {
		this.checktime = checktime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysConfirmChecklog");
		return build.append("#logid:").append(this.logid).toString();
	}

    public static String buildEntityKey(Long logid){
        StringBuilder build = new StringBuilder("SysConfirmChecklog");
        return build.append("#logid:").append(logid).toString();
    }
    
    public void copyPrimaryKey(SysConfirmChecklog entity){
		this.logid = entity.getLogid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", logid=").append(logid);
		sb.append(", datalog=").append(datalog);
		sb.append(", checker=").append(checker);
		sb.append(", checklevel=").append(checklevel);
		sb.append(", checkdate=").append(checkdate);
		sb.append(", checktime=").append(checktime);
		sb.append(", status=").append(status);
		sb.append(", summary=").append(summary);
        sb.append("]");
        return sb.toString();
	}
}
