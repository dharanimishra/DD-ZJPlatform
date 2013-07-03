/**
 * 
 */
package com.ziksana.alert.exception;

import com.ziksana.exception.ZiksanaException;

/**
 * @author vtg-p13
 * 
 */
public class AlertException extends ZiksanaException {

	private static final long serialVersionUID = -2971355431405857422L;

	public AlertException(String errorCode, Throwable error) {
		super(errorCode, error);
	}

	public AlertException(String errorCode) {
		super(errorCode);
	}

}
