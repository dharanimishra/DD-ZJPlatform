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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.ziksana.service.security.MediaService;
import com.ziksana.service.security.MemberService;

@Controller
@RequestMapping("/secure")
public class HomeController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MediaService mediaService;
	
	@RequestMapping(value = "/launcher", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getEducatorLouncher() {
		logger.info("Launcher Page");
		ModelAndView modelAndView = new ModelAndView("common/launcher");

		return modelAndView;

	}

	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public @ResponseBody ModelAndView homePage(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("masterhome");
		/*modelAndView.addObject("pageTitle", "Home");
		try{
			// Need to add the token to the session
			HttpSession session = request.getSession(true);
			logger.info("USER AUTHENTICATED");
			// create user session and put the secure token there..
			// create cookie and send it to the client

			// Constructing SecurityToken object
			Member member = memberService.getMemberByUser((String)session.getAttribute("userName"));

			ZID memberZID = new StringZID();
			memberZID.setStorageID(member.getMemberId().toString());

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

			SecurityToken token = new SecurityToken(memberZID,
					memberPersonaId, roleType);

			
			session.setAttribute("TOKEN", token);
			session.setAttribute("staticFileServer", mediaService.getMediaContents().getStaticFileServer());
			// Need to create cookie
			response.addCookie(newSessionCookie(request, member.getUserId()));
		
			session.setAttribute("member", member);
			modelAndView = new ModelAndView("masterhome");
			SecurityTokenUtil.unset();

		}
		catch(ZiksanaException exception){
			
		}*/
		return modelAndView;

	}
	
	@RequestMapping(value = "/extendsession", method = RequestMethod.GET)
	public @ResponseBody String extendSession(HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		
		session.setMaxInactiveInterval(30*60);
		String response = "success";
		
		return response;

	}
	@RequestMapping(value = "/troublelogginin", method = RequestMethod.GET)
	public @ResponseBody ModelAndView troubleLoginPage() {

		ModelAndView modelAndView = new ModelAndView("common/sampleTest");

		return modelAndView;

	}
	
	
}
