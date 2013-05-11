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



	public ZiksanaException(String errorCode) {
		super(MessageUtil.getMessage(errorCode));
		setErrorCode(errorCode);
	}

	public ZiksanaException(String errorCode, Throwable error) {
		super(MessageUtil.getMessage(errorCode),error);
		setErrorCode(errorCode);
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



}
