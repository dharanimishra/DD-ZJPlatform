package com.ziksana.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/secure")
public class EnrichCourseController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EnrichCourseController.class);

	@RequestMapping(value = "/enrichcontent", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showEnrichCourse() {
		LOGGER.info("Entering showEnrichCourse(): ");
		ModelAndView mv = new ModelAndView("courses/enrichcontent");

		return mv;
	}

}
