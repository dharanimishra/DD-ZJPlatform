/**
 * 
 */
package com.ziksana.exception.assignment;

import com.ziksana.exception.ZiksanaException;

/**
 * @author bhashasp
 */
public class AssignmentException extends ZiksanaException {

	private static final long serialVersionUID = 6018692391685732502L;
	
	public AssignmentException(String code) {
		super(code);
	}
	
	public AssignmentException(Exception exp) {
		super(exp);
	}

	public AssignmentException(String code, Exception exp) {
		super(code, exp);
	}

	public AssignmentException(String code, String message) {
		super(code, message);
	}

	public AssignmentException(String code, String message, Exception exp) {
		super(code, message, exp);
	}

	

}
