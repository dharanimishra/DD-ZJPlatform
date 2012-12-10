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
@RequestMapping("/secure")
public class CourseTreeNodeController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CourseTreeNodeController.class);

	@RequestMapping(value = "/coursetreenode", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showCourseTreeNode() {
		LOGGER.info("Entering Class " + getClass() + " showCourseTreeNode()");
		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.info("Exiting Class " + getClass() + " showCourseTreeNode(): ");

		return mv;
	}

}
