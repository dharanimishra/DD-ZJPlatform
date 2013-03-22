package com.ziksana.controller.security;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.exception.CookieNotDeletedException;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.security.filters.AuthenticationFilter;

@Controller
@RequestMapping("/secure")
public class LogoutController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LogoutController.class);

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			HttpSession session = request.getSession(false);
			if (session != null) {
				LOGGER.info(" SESSION IS INVALIDATED");
				// session.invalidate();

				Cookie[] cookies = request.getCookies();

				if (cookies == null) {
					return null;
				}
				LOGGER.debug(" number of cookies " + cookies.length);
				for (Cookie cookie : cookies) {
					String path = cookie.getPath();
					LOGGER.debug("path is " + path);
					LOGGER.debug("name of the cookie is  " + cookie.getName());
					LOGGER.debug("domain of the cookie is  "
							+ cookie.getDomain());
					LOGGER.debug("value  of the cookie is  "
							+ cookie.getValue());

					if (cookie.getName().equals(AuthenticationFilter.COOKIE_NAME)) {

						LOGGER.info("CLEARING COOKIE" + cookie.getName());
							response.addCookie(eraseCookie(request,
									AuthenticationFilter.COOKIE_NAME, "/"
									));
						break;
					}

				}

			}
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		ModelAndView modelAndView = new ModelAndView("redirect:/secure/home2");

		return modelAndView;

	}

	private static Cookie eraseCookie(HttpServletRequest request, String strCookieName, String strPath
			) throws ZiksanaException {
		
		Cookie cookie = new Cookie(strCookieName, "");
		cookie.setMaxAge(0);
		cookie.setPath(strPath);
		
		try {
			cookie.setDomain(new URL(request.getRequestURL().toString())
					.getHost());
		} catch (MalformedURLException e) {
			throw new CookieNotDeletedException(e);
		}
		
		return cookie;
	}

}
