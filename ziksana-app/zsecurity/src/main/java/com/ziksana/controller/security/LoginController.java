package com.ziksana.controller.security;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

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
import com.ziksana.exception.CookieNotCreatedException;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.security.filters.AuthenticationFilter;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.security.AuthenticationService;
import com.ziksana.service.security.MediaService;
import com.ziksana.service.security.MemberService;
import com.ziksana.service.security.ProfileService;

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

	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {

		logger.debug(" Entering to LoginController.login");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		logger.debug(" Username is " + username);
		
		String userIdValidationResponse = null;
		String passwordValidationResponse = null;
		int loginAttempt;
		
		ModelAndView mv = null;
		try {
			if (username == null && password == null) {

				mv = new ModelAndView("masterlogin");
				mv.addObject("applicationTitle", "Login");
				return mv;

			} else {
					HttpSession session = request.getSession(true);
					boolean userAuthenticated = false;
					logger.debug(" going to auth service");
					
					if(!memberService.isUserNameExists(username)){
						
						userAuthenticated = false;
						userIdValidationResponse = "User ID entered is incorrect";
						
						
					}else if(!memberService.isPasswordExists(password)){
						
						userAuthenticated = false;
						passwordValidationResponse = "Password entered is incorrect";
						
					}else if(memberService.isUserNameExists(username) && memberService.isPasswordExists(password)){
						
						
						userAuthenticated= authService.authenticateUser(username, password);
						
					}
					
					if (userAuthenticated) {
								loginAttempt = 0;
								Member member = memberService.getMemberByUser(username);
								session.setAttribute("userName", username);
								session.setAttribute("staticFileServer", mediaService.getMediaContents().getStaticFileServer());
								int isUserAccountLocked = memberService
										.isMemberAccountLocked(username);
								if (isUserAccountLocked == 1) {
									// your Account was Locked Redirect the login page.
									request.setAttribute("loginResult", "true");
									mv = new ModelAndView("masterlogin");
									
									mv.addObject("accountLocked","Your account has been temporarily locked ,please contact");
								} else {
									int isUserProfileUpdated = profileService.isProfileCompleted(username);
									logger.info("isUserProfileUpdated = " + isUserProfileUpdated);
									if (isUserProfileUpdated == 1) {
										
										// Need to create cookie
										response.addCookie(newSessionCookie(request, member.getUserId()));
										mv = new ModelAndView("redirect:/secure/homepage");
										SecurityTokenUtil.unset();
									} else {
										// Need to create cookie
										response.addCookie(newSessionCookie(request, member.getUserId()));
										mv = new ModelAndView("redirect:/profile/profilepage/"+ member.getMemberId() + "");
									}
								}

							} else {

								// redirect to the login page with error message
								logger.info(" User is not authenticated");
								request.setAttribute("loginResult", "true");
								mv = new ModelAndView("masterlogin");
								mv.addObject("userIdValidationResponse", userIdValidationResponse);
								mv.addObject("passwordValidationResponse", passwordValidationResponse);
								
								
								
								if (session.getAttribute("loginCount") == null) {
									session.setAttribute("loginCount", 0);
									loginAttempt = 0;
								} else {
									loginAttempt = (Integer) session.getAttribute("loginCount");
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
										int accountLockConfirmation = memberService.lockMemberAccountByUserId(username);
										if(accountLockConfirmation == 1){	
										mv.addObject("accountLocked","Your account has been temporarily locked ,please contact ");
										}
									}

								} else {
									if(memberService.isUserNameExists(username)){
									loginAttempt++;
									}
									int allowLogin = 3 - loginAttempt;
									//mv.addObject("accountLocked", "loginAttempt="+ loginAttempt+ ". Invalid username or password.");
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
