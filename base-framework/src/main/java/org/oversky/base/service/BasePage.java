package org.oversky.base.service;

import java.io.Serializable;

public class BasePage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static final int PAGESIZE_DEFALUT = 10;
	private static final int PAGESIZE_MAX = 100;
	private static final int PAGESIZE_MIN = 5;
    //当前页序号
    private int index;
    //当前页的数量
    private int size;
    //每页的数量
    private int pageSize;
    //总页数
    private int pageTotal;
    //总记录数
    private int total;
    //前一页
    private int prePage;
    //下一页
    private int nextPage;
    //是否为第一页
    private boolean firstPage = false;
    //是否为最后一页
    private boolean lastPage = false;
    //是否有前一页
    private boolean hasPrePage = false;
    //是否有下一页
    private boolean hasNextPage = false;
    
    public BasePage(int index, int pageSize, int total) {
    	this.total = total;
    	if(pageSize < PAGESIZE_MIN) {
    		this.pageSize = PAGESIZE_DEFALUT;
    	}else if(pageSize > PAGESIZE_MAX) {
    		this.pageSize = PAGESIZE_DEFALUT;
    	}else {
    		this.pageSize = pageSize;
    	}
		int pt = this.total/this.pageSize;
		int lastPageSize = this.total%this.pageSize;
		if(lastPageSize > 0) {
			pt = pt + 1;
		}
		this.pageTotal = pt;
    	if(index <= 1) {
    		this.index = 1;
    	}else if(index > this.pageTotal){
    		this.index = this.pageTotal;
    	}else {
    		this.index = index;
    	}
    	
    	if(this.index == 1) {
    		this.firstPage = true;
    	}
    	if(this.index == this.pageTotal) {
    		this.lastPage = true;
    	}
    	if(this.index > 1 && this.index < this.pageTotal) {
    		this.hasNextPage = true;
    		this.nextPage = this.index + 1;
    		this.hasPrePage = true;
    		this.prePage = this.index - 1;
    	}
    	if(this.hasNextPage) {
    		this.size = this.pageSize;
    	}else {
    		this.size = lastPageSize;
    	}
    }
    
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public boolean isFirstPage() {
		return firstPage;
	}
	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	public boolean isHasPrePage() {
		return hasPrePage;
	}
	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", index=").append(index);
		sb.append(", size=").append(size);
		sb.append(", pageSize=").append(pageSize);
		sb.append(", pageTotal=").append(pageTotal);
		sb.append(", total=").append(total);
		sb.append(", prePage=").append(prePage);
		sb.append(", nextPage=").append(nextPage);
		sb.append(", firstPage=").append(firstPage);
		sb.append(", lastPage=").append(lastPage);
		sb.append(", hasPrePage=").append(hasPrePage);
		sb.append(", hasNextPage=").append(hasNextPage);
        sb.append("]");
        return sb.toString();
	}
}
