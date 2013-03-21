package com.ziksana.exception;

import com.ziksana.util.MessageUtil;

public abstract class ZiksanaException extends RuntimeException {

	private static final long serialVersionUID = -8021176035004246465L;

	private String errorCode;
	/**
	 * This attribute will define the type of the exception. e.g. APPLICATION,
	 * SYSTEM
	 * 
	 */
	private String errorType;

	private Throwable error;

	private String exceptionDescription;

	public ZiksanaException(String errorCode) {
		setErrorCode(errorCode);
		setExceptionDescription(MessageUtil.getMessage(errorCode));
	}

	public ZiksanaException(String errorCode, Throwable error) {
		this(errorCode);
		setError(error);
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	private void setErrorCode(String errorCode) {

		this.errorCode = errorCode;
	}

	public String getErrorType() {
		return errorType;
	}

	protected void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getExceptionDescription() {
		return exceptionDescription;
	}

	private void setExceptionDescription(String description) {
		this.exceptionDescription = description;
	}

	public Throwable getError() {
		return error;
	}

	private void setError(Throwable error) {
		this.error = error;
	}

}
