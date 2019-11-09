package org.oversky.base.service;

import java.io.Serializable;

/**
 * 服务请求对象基类
 * @author Blue
 *
 */
public abstract class BaseReqDto implements Serializable{

	private static final long serialVersionUID = 1L;

	//当前第几页，从第1页开始，若为0则表示不分页
	private int pageNum;
	//每页数量
	private int pageSize;
	//排序字段，可选
	private String orderBy;
	//排序方向，0-asc，1-desc
	private String orderType;
	//效验token
	private String token;
	//资源ID(如菜单ID，API接口ID等)
	private String resourceId;
	//操作员ID或usersession的userid
	private Long operator;
	//渠道类型
	private String channelType;
	//渠道流水号
	private String channelSno;
	//客户端IP
	private String clientIp;
	
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Long getOperator() {
		return operator;
	}
	public void setOperator(Long operator) {
		this.operator = operator;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	public String getChannelSno() {
		return channelSno;
	}
	public void setChannelSno(String channelSno) {
		this.channelSno = channelSno;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
}

