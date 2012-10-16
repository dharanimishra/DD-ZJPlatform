package com.ziksana.tester.exception;

import com.ziksana.exception.*;

public class ZiksanaExceptionTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ZiksanaException exp1 = new ZiksanaException("test.inner", new IllegalArgumentException("Wrong arguments."));
		
		ZiksanaException exp2 = new ZiksanaException("test.outer", exp1);
		
		System.out.println(exp2);
	}

}
