package com.ziksana.exception.course;

import com.ziksana.exception.BusinessException;

public class CourseException extends BusinessException {

	public CourseException(Throwable t) {
		super(null);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 7818682938541074212L;

	
	//TODO **********we need to delete this constructor once we re-factor the code for exception handling there will be only one constructor with arguments
	public CourseException(String code) {
		super(null);
	}
	
	
	
}
