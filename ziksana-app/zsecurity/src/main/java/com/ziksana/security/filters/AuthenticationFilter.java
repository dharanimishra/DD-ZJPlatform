/**
 * 
 */
package com.ziksana.security.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.SecurityTokenUtil;

/**
 * @author prabu
 * 
 */
public class AuthenticationFilter implements Filter {

	public static final String COOKIE_NAME = "SessionCookieToken";
	private static final String LOGIN_URL = "login";

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

		String url = httpRequest.getRequestURL().toString();

		String sessionToken = getSessionTokenCookie(httpRequest);

		if (sessionToken != null) {

			HttpSession httpSession = httpRequest.getSession(false);

			if (httpSession != null) {
				SecurityToken token = (SecurityToken) httpSession
						.getAttribute("TOKEN");

				SecurityTokenUtil.setToken(token);
			}

			// filterChain.doFilter(servletRequest, servletResponse);

			// return;

		}

		else if (sessionToken == null) {

			// Need to redirect to login page
			if (!url.endsWith(LOGIN_URL)) {

				httpResponse.sendRedirect(httpRequest.getScheme() + "://"
						+ httpRequest.getServerName() + ":"
						+ httpRequest.getServerPort()
						+ httpRequest.getContextPath() + "/" + LOGIN_URL);
				return;
			}

			// return;

		}

		filterChain.doFilter(servletRequest, servletResponse);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets the AuthSub session token from a cookie.
	 * 
	 * @param httpRequest
	 * @return session token or null
	 */
	private String getSessionTokenCookie(HttpServletRequest httpRequest) {
		Cookie[] cookies = httpRequest.getCookies();

		if (cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			String path = cookie.getPath();
			if (cookie.getName().equals(COOKIE_NAME)) {
				return cookie.getValue();

			}

		}
		return null;
	}

}
