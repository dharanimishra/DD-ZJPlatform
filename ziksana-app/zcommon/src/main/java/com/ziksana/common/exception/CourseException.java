package com.ziksana.common.exception;

public class CourseException extends Exception {

	private static final long serialVersionUID = 7818682938541074212L;

	public CourseException() {
		super();
	}

	public CourseException(Exception exp) {
		super(exp);
	}

	public CourseException(String message) {
		super(message);
	}

	public CourseException(String message, Exception exp) {
		super(message, exp);
	}

}
