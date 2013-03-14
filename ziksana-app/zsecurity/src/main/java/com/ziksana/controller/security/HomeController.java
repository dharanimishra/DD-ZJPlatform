package com.ziksana.controller.security;

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
		ModelAndView modelAndView = new ModelAndView("common/educator_louncher");

		return modelAndView;

	}

	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView redirectEducatorLauncherPage() {
		logger.info("Popup window");
		ModelAndView modelAndView = new ModelAndView("dashboard-div");

		return modelAndView;

	}
}
