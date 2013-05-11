package com.ziksana.exception;

import com.ziksana.constants.ZiksanaConstants;
import com.ziksana.util.MessageUtil;

public class DataBaseException extends SystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707644546730801000L;

	public DataBaseException(Throwable t) {
		super(MessageUtil.getMessage(ZiksanaConstants.DATABASE_CONNECTION_PROBLEM), t);
		// TODO Auto-generated constructor stub
	}


}
