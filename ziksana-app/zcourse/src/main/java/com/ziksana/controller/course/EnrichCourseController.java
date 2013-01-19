package com.ziksana.controller.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ratneshkumar
 */
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

	@RequestMapping(value = "/enrichcontent/{contentId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showEnrichMyCourse(@PathVariable String contentId) {
		LOGGER.info("Entering showEnrichCourse(): ");

		Integer courseid = 0, contentTypeId = 0;
		try {
			courseid = Integer.parseInt(contentId.split("_")[1]);
		} catch (NumberFormatException nfe) {
			LOGGER.error("NumberFormatException courseid:" + nfe);
		}
		ModelAndView mv = new ModelAndView("courses/enrichcontent");
		mv.addObject("courseid", courseid);

		return mv;
	}
}
