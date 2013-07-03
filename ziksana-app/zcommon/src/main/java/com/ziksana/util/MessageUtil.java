package com.ziksana.util;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

/**
 * Serves as a I18N component to resolve Locale messages
 */
public class MessageUtil implements MessageSourceAware {
	private static MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
		MessageUtil.messageSource = messageSource;
	}

	public static final String getMessage(String messageCode) {
		return getMessage(messageCode, (Locale) null);
	}

	public static final String getMessage(String messageCode, Object[] args) {
		return getMessage(messageCode, args, null);
	}

	public static final String getMessage(String messageCode, Locale locale) {
		return messageSource.getMessage(messageCode, null, messageCode
				+ " missing!!!", locale);
	}

	public static final String getMessage(String messageCode, Object[] args,
			Locale locale) {
		return messageSource.getMessage(messageCode, args, messageCode
				+ " missing!!!", locale);
	}
}
