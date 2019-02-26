package org.oversky.base.service;

import java.io.Serializable;
import java.util.List;

import org.oversky.base.constant.PubDefine;

public class BaseResListDto<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String returncode;
	private String returnmsg;
	private boolean success;
	private List<T> results;
	
	//分页相关
	private boolean enablePage = false;
	private BasePage page;
	
	public String getReturncode() {
		return returncode;
	}
	public void setReturncode(String returncode) {
		this.returncode = returncode;
	}
	public String getReturnmsg() {
		return returnmsg;
	}
	public void setReturnmsg(String returnmsg) {
		this.returnmsg = returnmsg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}
	public void success(String msg) {
		this.success = true;
		this.returncode = PubDefine.RETCODE_SUCCESS;
		this.returnmsg = msg;
	}
	
	public void failure(String msg) {
		this.success = false;
		this.returncode = PubDefine.RETCODE_FAILURE;
		this.returnmsg = msg;
	}
	
	public void failure(String code, String msg) {
		this.success = false;
		this.returncode = code;
		this.returnmsg = msg;
	}
	
	public boolean isEnablePage() {
		return enablePage;
	}
	public void setEnablePage(boolean enablePage) {
		this.enablePage = enablePage;
	}
	public BasePage getPage() {
		return page;
	}
	public void setPage(BasePage page) {
		this.page = page;
	}
	
	/**
	 * 启用分页结果，初始化分页参数
	 * @param index 当前页索引
	 * @param pageSize 每页大小
	 * @param total 总记录条数
	 */
	public void initPage(int index, int pageSize, int total) {
		//分页插件pageSize设置为0默认不分页查询
		if(pageSize <= 0) {
			this.enablePage = false;
		}else {
			this.enablePage = true;
			this.page = new BasePage(index, pageSize, total);
		}
	}
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", returncode=").append(returncode);
		sb.append(", returnmsg=").append(returnmsg);
		sb.append(", success=").append(success);
		sb.append(", enablePage=").append(enablePage);
		sb.append(", Page=").append(page == null ? "null" : page.toString());
        sb.append("]");
        return sb.toString();
	}
}
