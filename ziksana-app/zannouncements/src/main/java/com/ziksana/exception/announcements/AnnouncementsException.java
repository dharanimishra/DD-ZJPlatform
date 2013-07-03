package com.ziksana.exception.announcements;

import com.ziksana.exception.ZiksanaException;

/**
 * @author vtg-p13
 * 
 */
public class AnnouncementsException extends ZiksanaException {

	private static final long serialVersionUID = -4009095533253271102L;

	public AnnouncementsException(String errorCode, Throwable error) {
		super(errorCode, error);
	}

	public AnnouncementsException(String errorCode) {
		super(errorCode);
	}
}
