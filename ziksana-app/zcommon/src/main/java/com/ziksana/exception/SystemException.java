package com.ziksana.exception;

import com.ziksana.constants.ZiksanaConstants;

public abstract class SystemException extends ZiksanaException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1409448603793034811L;
	public static final String SYSTEM_EXCEPTION = "SYSTEM";
	

	public SystemException(String errorCode, Throwable t) {
		super(errorCode, t);
		setErrorType(ZiksanaConstants.SYSTEM_EXCEPTION);
	}

	
	

}
