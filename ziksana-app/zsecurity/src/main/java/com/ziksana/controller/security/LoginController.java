package com.ziksana.controller.security;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.member.Member;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.member.MemberRoleType;
import com.ziksana.exception.CookieNotCreatedException;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.filters.AuthenticationFilter;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.security.AuthenticationService;
import com.ziksana.service.security.MemberService;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@Autowired
	AuthenticationService authService;

	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {

		logger.debug(" Entering to LoginController.login");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		logger.debug(" Username is " + username);
		// System.out.println(" password is  "+username);
		ModelAndView mv = null;
		try {
			if (username == null && password == null) {

				mv = new ModelAndView("login");
				return mv;
				// mv.addObject("applicationTitle", applicationTitle);
			} else {

				logger.debug(" going to auth service");

				boolean userAuthenticated = authService.authenticateUser(
						username, password);

				if (userAuthenticated) {
					logger.info("USER AUTHENTICATED");
					// create user session and put the secure token there..
					// create cookie and send it to the client

					// Constructing SecurityToken object
					Member member = memberService.getMemberByUser(username);

					ZID memberId = new StringZID();
					memberId.setStorageID(member.getMemberId().toString());

					ZID memberPersonaId = new StringZID();

					// Determining the educator memberpersona of the user
					List<MemberPersona> memberPersonas = member
							.getMemberPersonas();
					MemberRoleType roleType = null;

					for (MemberPersona memberPersona : memberPersonas) {
						if (memberPersona.getRoleType() == MemberRoleType.EDUCATOR) {
							memberPersonaId.setStorageID(memberPersona
									.getMemberRoleId().toString());
							roleType = MemberRoleType.EDUCATOR;
							break;

						} else {
							memberPersonaId.setStorageID(memberPersona
									.getMemberRoleId().toString());
							roleType = MemberRoleType.LEARNER;
							break;

						}

					}

					logger.info("login() MemberRoleType is " + roleType);

					SecurityToken token = new SecurityToken(memberId,
							memberPersonaId, roleType);

					// Need to add the token to the session
					HttpSession session = request.getSession(true);
					session.setAttribute("TOKEN", token);

					// Need to create cookie
					response.addCookie(newSessionCookie(request, username));

					mv = new ModelAndView("common/pre_launch");
					session.setAttribute("member", member);

					ThreadLocalUtil.unset();

				} else {

					// redirect to the login page with error message
					logger.info(" User is not authenticated");
					request.setAttribute("loginResult", "true");
					mv = new ModelAndView("login");
					ThreadLocalUtil.unset();
					return mv;
				}
			}
		} catch (ZiksanaException exception) {
			logger.error(exception.getMessage(), exception);
		}

		// If the user is authenticated, create a session and put the secure
		// token there
		return mv;

	}

	private Cookie newSessionCookie(HttpServletRequest request, String userId)
			throws ZiksanaException {

		Cookie cookie = new Cookie(AuthenticationFilter.COOKIE_NAME, "");
		try {
			cookie.setMaxAge(-1);
			cookie.setPath("/");

			cookie.setDomain(new URL(request.getRequestURL().toString())
					.getHost());
		} catch (MalformedURLException e) {
			logger.error("Exception occured while creatig a new Session Cookie "
					+ e.getMessage());
			throw new CookieNotCreatedException(e);
		}

		return cookie;

	}

}
