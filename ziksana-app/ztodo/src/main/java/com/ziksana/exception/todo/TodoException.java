package com.ziksana.exception.todo;

import com.ziksana.exception.ZiksanaException;
import com.ziksana.util.MessageUtil;

public class TodoException extends ZiksanaException {

	private static final long serialVersionUID = 646467735128522871L;

	public TodoException(String errorCode, Throwable error) {
		super(errorCode, error);
		
	}
	
	public TodoException(String errorCode) {
		super(errorCode);
		
	}
	//TODO Exception Error Code with Dyanamic Message
	public TodoException(String errorCode, Object[] args) {
		
		super(MessageUtil.getMessage(errorCode, args));
		
	}
	

}
