package com.ziksana.controller.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/zcourse")
public class AssignmentController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AssignmentController.class);

	@RequestMapping(value = "/createassignment", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showAssociateCourse() {
		LOGGER.debug("Entering showAssociateCourse(): ");
		ModelAndView mv = new ModelAndView("courses/assignment");

		return mv;
	}

}
