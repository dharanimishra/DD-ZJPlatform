package com.ziksana.controller.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningComponentContent;

/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/secure")
public class CourseContentController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FileUploadController.class);

	@RequestMapping(value = "/saveOrUpdateContent", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveOrUpdateContent(@RequestParam Course course,
			@RequestParam LearningComponentContent learningComponentContent) {
		LOGGER.info("Entering Class " + getClass() + " saveOrUpdateContent()");
		ModelAndView mv = new ModelAndView("courses/associatecontent");
		LOGGER.info("Exiting Class " + getClass() + " saveOrUpdateContent(): ");

		return mv;
	}

	@RequestMapping(value = "/getComponentContent", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView getComponentContent(@RequestParam Course course) {
		LOGGER.info("Entering Class " + getClass() + " getComponentContent()");
		ModelAndView mv = new ModelAndView("courses/associatecontent");
		LOGGER.info("Exiting Class " + getClass() + " getComponentContent(): ");

		return mv;
	}

	@RequestMapping(value = "/deleteContent", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView deleteContent(
			@RequestParam LearningComponentContent learningComponentContent) {
		LOGGER.info("Entering Class " + getClass() + " deleteContent()");
		ModelAndView mv = new ModelAndView("courses/associatecontent");
		LOGGER.info("Exiting Class " + getClass() + " deleteContent(): ");

		return mv;
	}

}
