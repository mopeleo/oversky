package org.oversky.dreamland.web.config;


public class WebException extends RuntimeException {

	private int httpStatus;

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public WebException(int httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}

}
