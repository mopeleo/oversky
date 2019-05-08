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

	protected String returncode = PubDefine.RETCODE_SUCCESS;
	protected String returnmsg = PubDefine.RETMSG_SUCCESS;;
	protected boolean success = true;

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
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", returncode=").append(returncode);
		sb.append(", returnmsg=").append(returnmsg);
		sb.append(", success=").append(success);
        sb.append("]");
        return sb.toString();
	}
}
