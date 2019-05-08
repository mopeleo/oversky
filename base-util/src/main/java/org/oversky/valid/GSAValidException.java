package org.oversky.valid;

/**
 * 公用的Exception.
 * 继承自RuntimeException,会触发Spring的事务管理引起事务回退.
 */
public class GSAValidException extends RuntimeException {
	public GSAValidException() {
		super();
	}

	public GSAValidException(String message, Throwable cause) {
		super(message, cause);
	}

	public GSAValidException(String message) {
		super(message);
	}

	public GSAValidException(Throwable cause) {
		super(cause);
	}
}
