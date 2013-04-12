package com.ziksana.controller.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/secure")
public class HomeController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(value = "/launcher", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getEducatorLouncher() {
		logger.info("Launcher Page");
		ModelAndView modelAndView = new ModelAndView("common/launcher");

		return modelAndView;

	}

	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public @ResponseBody ModelAndView homePage() {

		ModelAndView modelAndView = new ModelAndView("homepagelayout");

		return modelAndView;

	}
	@RequestMapping(value = "/extendsession", method = RequestMethod.GET)
	public @ResponseBody String extendSession(HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		
		session.setMaxInactiveInterval(30*60);
		String response = "success";
		
		return response;

	}
}
