package com.ziksana.common.exception;

public class PollException extends Exception {

	private static final long serialVersionUID = -4991510876967697718L;

	public PollException() {
		super();
	}
	
	public PollException(Exception exp) {
		super(exp);
	}
	
	public PollException(String message) {
		super(message);
	}
	
	public PollException(String message, Exception exp) {
		super(message, exp);
	}
}
