package org.oversky.base.service;

import java.io.Serializable;
import java.util.List;

public class BaseResult<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected String returncode;
	protected String returnmsg;
	protected boolean success;
	protected List<T> results;
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
	
}
