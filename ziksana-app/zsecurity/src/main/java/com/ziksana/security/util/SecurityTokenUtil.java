package com.ziksana.security.util;

public class SecurityTokenUtil {
	
private static final ThreadLocal<SecurityToken> THREADLOCAL = new ThreadLocal<SecurityToken>();
	
	
	public static void setToken(SecurityToken token) {
		THREADLOCAL.set(token);
	}

	public static void unset() {
		THREADLOCAL.remove();
	}

	public static SecurityToken getToken() {
		return THREADLOCAL.get();
	}
	

}
