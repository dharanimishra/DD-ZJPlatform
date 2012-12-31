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
import com.ziksana.security.util.ThreadLocalUtil;

/**
 * @author prabu
 * 
 */
public class AuthenticationFilter implements Filter {

	public static final String COOKIE_NAME = "SessionCookieToken";
	private static final String LOGIN_URL = "login";

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

		String url = httpRequest.getRequestURL().toString();

		String sessionToken = getSessionTokenCookie(httpRequest);

		if (sessionToken != null) {
			System.out.println("Session toke IS THERE");
			HttpSession httpSession = httpRequest.getSession(false);

			if (httpSession != null) {
				SecurityToken token = (SecurityToken) httpSession
						.getAttribute("TOKEN");

				System.out.println(" THE TOKEN IS " + token);

				ThreadLocalUtil.setToken(token);
			}

			// filterChain.doFilter(servletRequest, servletResponse);

			// return;

		}
		
		
		

		else if (sessionToken == null) {

			// Need to redirect to login page
			System.out.println(" Entering session token null check if block");
			System.out.println(" URL value is " + url);
			if (!url.endsWith(LOGIN_URL)) {
				System.out.println("going to login URL");
				System.out.println("httpRequest.getContextPath() "
						+ httpRequest.getContextPath());

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
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
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
		System.out.println(" number of cookies " + cookies.length);
		for (Cookie cookie : cookies) {
			String path = cookie.getPath();
			System.out.println("path is " + path);
			System.out.println("name of the cookie is  " + cookie.getName());
			System.out
					.println("domain of the cookie is  " + cookie.getDomain());
			System.out.println("value  of the cookie is  " + cookie.getValue());

			if (cookie.getName().equals(COOKIE_NAME) ) {

				System.out.println(" COOKIE IS THERE");
				return cookie.getValue();

			}

		}
		return null;
	}

}
