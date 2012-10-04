package com.ziksana.exception.polls;

import com.ziksana.exception.ZiksanaException;

public class PollException extends ZiksanaException {

	private static final long serialVersionUID = -4991510876967697718L;

	public PollException(String code) {
		super(code);
	}
	
	public PollException(Exception exp) {
		super(exp);
	}

	public PollException(String code, Exception exp) {
		super(code, exp);
	}

	public PollException(String code, String message) {
		super(code, message);
	}

	public PollException(String code, String message, Exception exp) {
		super(code, message, exp);
	}
}
