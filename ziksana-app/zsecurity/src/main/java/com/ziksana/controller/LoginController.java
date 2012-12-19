package com.ziksana.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
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
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.filters.AuthenticationFilter;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.security.MemberService;

import com.ziksana.service.security.AuthenticationService;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	

	@Autowired
	AuthenticationService authService;

	@Autowired
	MemberService memberService;
	
	

	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println(" Entering to LoginController.login");
		String userId = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(" Username is "+userId);
		System.out.println(" password is  "+password);
		
		if (userId == null && password == null) {
			
			ModelAndView mv = new ModelAndView("login");
			//mv.addObject("applicationTitle", applicationTitle);
			return mv;
			
		}
		
		
		System.out.println(" going to auth service");
		
		boolean userAuthenticated = authService.authenticateUser(userId,
				password);

		if (userAuthenticated) {
			System.out.println("USER AUTHENTICATED");
			// create user session and put the secure token there..
			// create cookie and send it to the client

			// Constructing SecurityToken object
			Member member = memberService.getMemberByUser(userId);

			ZID memberId = new StringZID();
			memberId.setStorageID(member.getMemberId().toString());

			ZID memberPersonaId = new StringZID();
			
			//Determining the educator memberpersona  of the user
			List<MemberPersona> memberPersonas = member.getMemberPersonas();
			
			for (MemberPersona memberPersona: memberPersonas)
			{
				if (memberPersona.getRoleType() == MemberRoleType.EDUCATOR)
				{
					memberPersonaId.setStorageID(memberPersona.getMemberRoleId().toString());
				}
					
				
			}
			
			
			

			SecurityToken token = new SecurityToken(memberId, memberPersonaId,
					null);

			// Need to add the token to the session
			HttpSession session = request.getSession(true);
			session.setAttribute("TOKEN", token);

			// Need to create cookie
			try {
				response.addCookie(newSessionCookie(request, userId));
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				System.out.println(" THE EXCEPTION IS "+e.getMessage());
				e.printStackTrace();
			}
			
			ModelAndView mvHome = new ModelAndView("dashboard-div");
			mvHome.addObject("firstname", member.getFirstName());
			mvHome.addObject("lastname", member.getLastName());
			mvHome.addObject("membertype", member.getMemberType());
			mvHome.addObject("memberId",member.getMemberId());
			
			ThreadLocalUtil.unset();
		     return mvHome;

		} else {
            
			// redirect to the login page with error message
			System.out.println(" User is not authenticated");
			request.setAttribute("loginResult", "true");
			ModelAndView mvLogin = new ModelAndView("login");
			ThreadLocalUtil.unset();
			return mvLogin;
			//response.sendRedirect("/login");
			

		}
		

		// If the user is authenticated, create a session and put the secure
		// token there

	}

	
	
	
	
	
	
	Cookie newSessionCookie(HttpServletRequest request, String userId)
			throws ServletException {

		Cookie cookie = new Cookie(AuthenticationFilter.COOKIE_NAME, "");
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		
		try {
			cookie.setDomain(new URL(request.getRequestURL().toString())
					.getHost());
		} catch (MalformedURLException e) {
			throw new ServletException(e);
		}

		
		return cookie;

	}

}
