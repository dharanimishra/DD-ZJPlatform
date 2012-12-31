/**
 * 
 */
package com.ziksana.exception.program;

import com.ziksana.exception.ZiksanaException;

/**
 * @author bhashasp
 */
public class ProgramsException extends ZiksanaException {

	private static final long serialVersionUID = 7175049583769825353L;

	public ProgramsException(String code) {
		super(code);
	}
	
	public ProgramsException(Exception exp) {
		super(exp);
	}

	public ProgramsException(String code, Exception exp) {
		super(code, exp);
	}

	public ProgramsException(String code, String message) {
		super(code, message);
	}

	public ProgramsException(String code, String message, Exception exp) {
		super(code, message, exp);
	}


}
