package com.ziksana.exception;

import com.ziksana.constants.ZiksanaConstants;

public class SystemException extends ZiksanaException {
	
	
	public static final String SYSTEM_EXCEPTION = "SYSTEM";
	

	public SystemException(String errorCode, Throwable t) {
		super(errorCode, t);
		setErrorType(ZiksanaConstants.SYSTEM_EXCEPTION);
	}

	
	

}
