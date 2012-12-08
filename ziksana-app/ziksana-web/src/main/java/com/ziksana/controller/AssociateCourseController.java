package com.ziksana.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/secure")
public class AssociateCourseController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AssociateCourseController.class);

	@RequestMapping(value = "/associatecontent", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showAssociateCourse() {
		LOGGER.info("Entering showAssociateCourse(): ");
		ModelAndView mv = new ModelAndView("courses/associatecontent");

		return mv;
	}

}
