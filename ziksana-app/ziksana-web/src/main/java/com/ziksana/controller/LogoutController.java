package com.ziksana.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.security.filters.AuthenticationFilter;

@Controller
@RequestMapping("/secure")
public class LogoutController {

	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			System.out.println(" SESSION IS INVALIDATED");
			//session.invalidate();
			
			Cookie[] cookies = request.getCookies();

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

				if (cookie.getName().equals(AuthenticationFilter.COOKIE_NAME)) {
                     
					System.out.println("CLEARING COOKIE" +cookie.getName());
					response.addCookie(eraseCookie(AuthenticationFilter.COOKIE_NAME, "/"));
				}

			}
			
			
			
		}
		
		ModelAndView modelAndView = new ModelAndView("login");
		
		
		return modelAndView;

	}
	
	
	public static Cookie eraseCookie(String strCookieName, String strPath) {
	    Cookie cookie = new Cookie(strCookieName, "");
	    cookie.setMaxAge(0);
	    cookie.setPath(strPath);

	    return cookie;
	}

}
