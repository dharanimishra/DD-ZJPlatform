package com.vtg.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * {@link Service} with hard-coded input data.
 */
@Component
public class ExampleService implements Service {

	private static final Logger logger = Logger.getLogger(ExampleService.class);

	public String getMessage() {
		logger.debug("Hello Services logger");
		return "Hello world!";
	}
}
