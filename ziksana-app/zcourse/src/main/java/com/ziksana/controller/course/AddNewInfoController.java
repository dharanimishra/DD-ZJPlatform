package com.ziksana.controller.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.course.CourseAdditionalProperty;
import com.ziksana.exception.course.CourseException;
import com.ziksana.service.course.CourseService;

/**
 * @author ratneshkumar
 */

@Controller
@RequestMapping("/secure")
public class AddNewInfoController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AddNewInfoController.class);

	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/saveAddnlInfo", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveAddnlInfo(
			@RequestParam CourseAdditionalProperty courseAdditionalProperty)
			throws CourseException {
		LOGGER.info("Entering Class " + getClass() + " showCourse()");
		courseService.saveAdditionalCourseProperty(courseAdditionalProperty);

		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.info("Exiting Class " + getClass() + " showCourse(): ");

		return mv;
	}

	@RequestMapping(value = "/updateAddnlInfo", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView updateAddnlInfo(
			@RequestParam CourseAdditionalProperty courseAdditionalProperty)
			throws CourseException {
		LOGGER.info("Entering Class " + getClass() + " showCourse()");
		courseService.saveAdditionalCourseProperty(courseAdditionalProperty);
		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.info("Exiting Class " + getClass() + " showCourse(): ");

		return mv;
	}

	@RequestMapping(value = "/deleteAddnlInfo", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView deleteAddnlInfo(
			@RequestParam CourseAdditionalProperty courseAdditionalProperty) {
		LOGGER.info("Entering Class " + getClass() + " deleteAddnlInfo()");
		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.info("Exiting Class " + getClass() + " deleteAddnlInfo(): ");

		return mv;
	}

}
