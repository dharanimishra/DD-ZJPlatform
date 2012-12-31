/**
 * 
 */
package com.ziksana.exception.subjectclassification;

import com.ziksana.exception.ZiksanaException;

/**
 * @author rajan
 *
 */
public class SubjectClassificationException extends ZiksanaException{

	private static final long serialVersionUID = 7818682938541074212L;

	public SubjectClassificationException(String code) {
		super(code);
	}
	
	public SubjectClassificationException(Exception exp) {
		super(exp);
	}

	public SubjectClassificationException(String code, Exception exp) {
		super(code, exp);
	}

	public SubjectClassificationException(String code, String message) {
		super(code, message);
	}

	public SubjectClassificationException(String code, String message, Exception exp) {
		super(code, message, exp);
	}

}
