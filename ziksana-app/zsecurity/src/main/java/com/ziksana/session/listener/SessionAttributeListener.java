package com.ziksana.session.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A session attribute listener receives notifications when a session is added
 * or changed.
 * 
 */
public class SessionAttributeListener implements HttpSessionAttributeListener {

	private static final Logger logger = LoggerFactory
			.getLogger(SessionAttributeListener.class);

	public void attributeAdded(HttpSessionBindingEvent sessionEvent) {

		logger.info("Session Attribute Added :" + sessionEvent.getName()
				+ " : " + sessionEvent.getValue());
	}

	public void attributeRemoved(HttpSessionBindingEvent sessionEvent) {

		logger.info("Session Attribute Removed :" + sessionEvent.getName()
				+ " : " + sessionEvent.getValue());

	}

	public void attributeReplaced(HttpSessionBindingEvent sessionEvent) {

		logger.info("Session Attribute Replaced :" + sessionEvent.getName()
				+ " : " + sessionEvent.getValue());

	}

}
