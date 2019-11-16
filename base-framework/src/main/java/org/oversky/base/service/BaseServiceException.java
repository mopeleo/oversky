package org.oversky.base.service;

/**
 * 公用的Exception.
 * 继承自RuntimeException,会触发Spring的事务管理引起事务回退.
 */
public class BaseServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BaseServiceException() {
		super();
	}

	public BaseServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseServiceException(String message) {
		super(message);
	}

	public BaseServiceException(Throwable cause) {
		super(cause);
	}
}
