package com.ziksana.exception;

import com.ziksana.constants.ZiksanaConstants;

public abstract class BusinessException extends ZiksanaException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5852386426734981827L;
	//public static final String SYSTEM_EXCEPTION = "BUSINESS";
	

	public BusinessException(String errorCode, Throwable t) {
		super(errorCode, t);
		setErrorType(ZiksanaConstants.APPLICATION_EXCEPTION);
	}

	public BusinessException(String errorCode){
		super(errorCode);
		setErrorType(ZiksanaConstants.APPLICATION_EXCEPTION);
	}
	

}
