package org.oversky.util.exception;

/**
 * 公用的Exception.
 * 继承自RuntimeException,会触发Spring的事务管理引起事务回退.
 */
public class BaseUtilException extends RuntimeException {
	public BaseUtilException() {
		super();
	}

	public BaseUtilException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseUtilException(String message) {
		super(message);
	}

	public BaseUtilException(Throwable cause) {
		super(cause);
	}
}
