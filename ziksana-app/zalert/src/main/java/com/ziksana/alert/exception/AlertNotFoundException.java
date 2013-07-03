package com.ziksana.alert.exception;

import com.ziksana.constants.ZiksanaConstants;
import com.ziksana.exception.BusinessException;

public class AlertNotFoundException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3672677191699099445L;


	public AlertNotFoundException() {
		super(ZiksanaConstants.ALERT_NOT_FOUND);
	}
	
	/**
	 *  Constructor to wrap the original exception
	 * @param t
	 */
	public AlertNotFoundException(Throwable t) {
		super(ZiksanaConstants.ALERT_NOT_FOUND, t);

	}

}
