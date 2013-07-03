package com.ziksana.exception;

import com.ziksana.constants.ZiksanaConstants;

/**
 * @author Arvind
 *
 */
public class CookieNotCreatedException extends SystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8834473393750794275L;

	public CookieNotCreatedException(Throwable t) {
		super(ZiksanaConstants.COOKIE_NOT_CREATED_EXCEPTION, t);
	}

}
