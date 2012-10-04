package com.ziksana.exception.course;

import com.ziksana.exception.ZiksanaException;

public class CourseException extends ZiksanaException {

	private static final long serialVersionUID = 7818682938541074212L;

	public CourseException(String code) {
		super(code);
	}
	
	public CourseException(Exception exp) {
		super(exp);
	}

	public CourseException(String code, Exception exp) {
		super(code, exp);
	}

	public CourseException(String code, String message) {
		super(code, message);
	}

	public CourseException(String code, String message, Exception exp) {
		super(code, message, exp);
	}
}
