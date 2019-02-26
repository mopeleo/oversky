package org.oversky.base.service;

import java.io.Serializable;

/**
 * 服务请求对象基类
 * @author Blue
 *
 */
public abstract class BaseReqDto implements Serializable{

	//当前第几页，从第1页开始，若为0则表示不分页
	protected int pageNum;
	//每页数量
	protected int pageSize;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}	
}
