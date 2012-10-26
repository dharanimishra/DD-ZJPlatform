package com.ziksana.security.util;

public class ThreadLocalUtil {

	private static final ThreadLocal<SecurityToken> threadLocal = new ThreadLocal<SecurityToken>();

	public static void setToken(SecurityToken token) {
		threadLocal.set(token);
	}

	public static void unset() {
		threadLocal.remove();
	}

	public static SecurityToken getToken() {
		return threadLocal.get();
	}

}
