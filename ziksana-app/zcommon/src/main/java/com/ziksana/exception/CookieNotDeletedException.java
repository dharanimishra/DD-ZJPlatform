package com.ziksana.exception;

import com.ziksana.constants.ZiksanaConstants;

/**
 * @author Arvind
 *
 */
public class CookieNotDeletedException extends SystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8834473393750794275L;

	public CookieNotDeletedException(Throwable t) {
		super(ZiksanaConstants.COOKIE_NOT_DELETED_EXCEPTION, t);
	}

}
