/**
 * 
 */
package com.vtg.exception;

import org.apache.log4j.Logger;

/**
 * Exception thrown when trying to create an already existing user.
 * 
 * @author
 */
public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 4301449299714922447L;

	private static final Logger logger = Logger
			.getLogger(UserAlreadyExistsException.class);

	public UserAlreadyExistsException(String message) {
		super(message);
		logger.info("Class :" + getClass()
				+ "Method :UserAlreadyExistsException(String message):"
				+ message);
	}
}