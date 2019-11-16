package org.oversky.base.service;

import java.io.Serializable;

import org.oversky.base.constant.PubDefine;

/**
 * 服务响应对象基类
 * 
 * @author Blue
 *
 */
public class BaseResDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String returncode;
	private String returnmsg;

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
	
	public void success() {
		this.returncode = PubDefine.RETCODE_SUCCESS;
		this.returnmsg = PubDefine.RETMSG_SUCCESS;
	}
	
	public void success(String msg) {
		this.returncode = PubDefine.RETCODE_SUCCESS;
		this.returnmsg = msg;
	}
	
	public void failure() {
		this.returncode = PubDefine.RETCODE_FAILURE;
		this.returnmsg = PubDefine.RETMSG_FAILURE;
	}
	
	public void failure(String msg) {
		this.returncode = PubDefine.RETCODE_FAILURE;
		this.returnmsg = msg;
	}
	
	public void failure(String code, String msg) {
		this.returncode = code;
		this.returnmsg = msg;
	}
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("returncode=").append(returncode);
		sb.append(", returnmsg=").append(returnmsg);
        return sb.toString();
	}
}
