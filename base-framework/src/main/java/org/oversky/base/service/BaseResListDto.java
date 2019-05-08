package org.oversky.base.service;

import java.util.List;

public class BaseResListDto<T> extends BaseResDto{

	private static final long serialVersionUID = 1L;
	
	private List<T> results;
	
	//分页相关
	private boolean enablePage = false;
	private BasePage page;
	
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
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
