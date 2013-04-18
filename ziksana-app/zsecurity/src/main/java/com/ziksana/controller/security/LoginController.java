package com.ziksana.controller.security;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
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
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.security.AuthenticationService;
import com.ziksana.service.security.MediaService;
import com.ziksana.service.security.MemberService;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@Autowired
	private AuthenticationService authService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private MediaService mediaService;

	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {

		logger.debug(" Entering to LoginController.login");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		logger.debug(" Username is " + username);

		ModelAndView mv = null;
		try {
			if (username == null && password == null) {

				mv = new ModelAndView("masterlogin");
				mv.addObject("pageTitle", "Login");
				return mv;
				// mv.addObject("applicationTitle", applicationTitle);
			} else {
				HttpSession session = request.getSession(true);
				logger.debug(" going to auth service");

				boolean userAuthenticated = authService.authenticateUser(
						username, password);

				if (userAuthenticated) {
					/*
					 * Member member = memberService.getMemberByUser(username);
					 * int isUserProfileUpdated =
					 * profileService.isProfileCompleted(member.getMemberId());
					 * if(isUserProfileUpdated == 1){
					 * session.setAttribute("userName", username); mv = new
					 * ModelAndView("redirect:/secure/homepage"); }else{ mv =
					 * new ModelAndView("redirect:/profile/profilepage"+member.
					 * getMemberId()+""); }
					 */
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
					// HttpSession session = request.getSession(true);
					session.setAttribute("TOKEN", token);
					session.setAttribute("staticFileServer", mediaService
							.getMediaContents().getStaticFileServer());
					// Need to create cookie
					response.addCookie(newSessionCookie(request, username));

					session.setAttribute("member", member);
					mv = new ModelAndView("redirect:/secure/homepage");
					SecurityTokenUtil.unset();

				} else {

					// redirect to the login page with error message
					logger.info(" User is not authenticated");
					request.setAttribute("loginResult", "true");
					mv = new ModelAndView("masterlogin");
					mv.addObject("pageTitle", "Login");
					int loginAttempt;
					if (session.getAttribute("loginCount") == null) {
						session.setAttribute("loginCount", 0);
						loginAttempt = 0;
					} else {
						loginAttempt = (Integer) session
								.getAttribute("loginCount");
					}
					// this is 3 attempt counting from 0,1,2
					if (loginAttempt >= 2) {
						long lastAccessedTime = session.getLastAccessedTime();
						Date date = new Date();
						long currentTime = date.getTime();
						long timeDiff = currentTime - lastAccessedTime;
						// 20 minutes in milliseconds
						if (timeDiff >= 1200000) {
							// invalidate user session, so they can try again
							session.invalidate();
						} else {

							mv.addObject(
									"accountLocked",
									"Your account has temprorily locked ,please contact <a href=\"register.jsp\">Administrator</a>");
						}

					} else {
						loginAttempt++;
						int allowLogin = 3 - loginAttempt;
						mv.addObject("accountLocked", "loginAttempt="
								+ loginAttempt
								+ ". Invalid username or password.");
					}
					session.setAttribute("loginCount", loginAttempt);
					return mv;
				}
			}
		} catch (ZiksanaException exception) {
			logger.error(exception.getMessage(), exception);
		}
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
