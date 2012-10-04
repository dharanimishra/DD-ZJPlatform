package com.ziksana.exception;

public class ZiksanaException extends Exception {

	private static final long serialVersionUID = 1701707074934264938L;
	
	private String code = null;
	
	public ZiksanaException(String code) {
		super();
		this.code = code;
	}
	
	public ZiksanaException(Exception exp) {
		super(exp);
	}

	public ZiksanaException(String code, Exception exp) {
		super(exp);
		this.code = code;
	}

	public ZiksanaException(String code, String message) {
		super(message);
		this.code = code;
	}

	public ZiksanaException(String code, String message, Exception exp) {
		super(message, exp);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return super.getMessage();
	}
	
	// TODO: The below logic is not perfect. Needs to be tested and fixed as the
	//       output seems to be getting repeated strings.
	public String toString() {
		StringBuffer msg = new StringBuffer();
		if (getCode() != null) {
			msg.append(this.getClass().getName() + ":ERR_CODE [" + getCode() + "] MSG [" + super.toString() + "]");
		} else {
			msg.append(super.toString());
		}
		
		Throwable cause = getCause();
		if (cause != null && cause instanceof ZiksanaException) {
			msg.append("CAUSE [" + cause.toString() + "]");
		} else if (cause != null) {
			// A Throwable cause
			while (cause != null) {
				msg.append("CAUSE [" + cause.toString() + "]");
				cause = cause.getCause();
			}
		}
		
		return msg.toString();
	}
}
