package com.vtg.controller;

import org.apache.log4j.Logger;

import com.vtg.controller.ExampleService;
import junit.framework.TestCase;

public class ExampleServiceTests extends TestCase {

	private ExampleService service = new ExampleService();

	private static final Logger logger = Logger
			.getLogger(ExampleServiceTests.class);

	public void testReadOnce() throws Exception {
		logger.debug("Hello world! service.getMessage()");
		System.out.println("Hello world! service.getMessage()");
		assertEquals("Hello world!", service.getMessage());
	}

}
