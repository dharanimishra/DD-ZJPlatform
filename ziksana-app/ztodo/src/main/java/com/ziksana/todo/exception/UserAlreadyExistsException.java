/**
 * 
 */
package com.ziksana.todo.exception;

import org.apache.log4j.Logger;

/**
 * Exception thrown when trying to create an already existing user.
 * 
 * @author
 */
public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 4301449299714922447L;

	private static final Logger LOGGER = Logger
			.getLogger(UserAlreadyExistsException.class);

	public UserAlreadyExistsException(String message) {
		super(message);
		LOGGER.info("Class :" + getClass()
				+ "Method :UserAlreadyExistsException(String message):"
				+ message);
	}
}