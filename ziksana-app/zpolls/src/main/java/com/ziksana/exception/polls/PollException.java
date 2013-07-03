package com.ziksana.exception.polls;

import com.ziksana.exception.ZiksanaException;


public class PollException extends ZiksanaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6395765406452016520L;

	public PollException(String errorCode, Throwable error) {
		super(errorCode, error);
	}

	public PollException(String errorCode) {
		super(errorCode);
	}

	
	
}
