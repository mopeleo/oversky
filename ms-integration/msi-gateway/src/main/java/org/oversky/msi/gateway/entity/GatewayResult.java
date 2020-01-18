package org.oversky.msi.gateway.entity;

import java.io.Serializable;

public class GatewayResult<T> implements Serializable{

	private static final long serialVersionUID = 1L;

	private String returncode;
	private String returnmsg;
	private T data;
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}	
	
}
