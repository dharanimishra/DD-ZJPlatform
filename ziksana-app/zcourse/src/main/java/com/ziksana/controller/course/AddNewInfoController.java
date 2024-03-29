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
import com.ziksana.exception.ZiksanaException;
import com.ziksana.exception.course.CourseException;
import com.ziksana.service.course.CourseService;

/**
 * @author ratneshkumar
 */

@RequestMapping("/zcourse")
public class AddNewInfoController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AddNewInfoController.class);

	CourseService courseService;

	@RequestMapping(value = "/getaddnlinfo", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView getAddnlInfo() {
		LOGGER.debug("Entering Class " + getClass() + " getAddnlInfo()");
		ModelAndView mv = new ModelAndView("courses/AddNewInformation");
		LOGGER.debug("Exiting Class " + getClass() + " getAddnlInfo(): ");

		return mv;
	}

	@RequestMapping(value = "/saveaddnlinfo", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView saveAddnlInfo(
			@RequestParam(value = "new_Info", required = true) String new_Info,
			@RequestParam(value = "info_Description", required = false) String info_Description,
			@RequestParam(value = "info_Descriptiondate", required = false) String info_Descriptiondate,
			@RequestParam(value = "info_Descriptiontext", required = false) String info_Descriptiontext) {
		ModelAndView mv = new ModelAndView("courses/AddNewInformation");

		CourseAdditionalProperty courseAdditionalProperty = new CourseAdditionalProperty(
				null, info_Description, null, info_Descriptiontext);

		LOGGER.debug("Entering Class " + getClass() + " showCourse()");
		try {
			courseService
					.saveAdditionalCourseProperty(courseAdditionalProperty);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Exiting Class " + getClass() + " showCourse(): ");

		return mv;
	}

	@RequestMapping(value = "/updateaddnlinfo", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView updateAddnlInfo(
			@RequestParam(value = "new_Info", required = true) String new_Info,
			@RequestParam(value = "info_Description", required = false) String info_Description,
			@RequestParam(value = "info_Descriptiondate", required = false) String info_Descriptiondate,
			@RequestParam(value = "info_Descriptiontext", required = false) String info_Descriptiontext)
			throws CourseException {
		ModelAndView mv = new ModelAndView("courses/AddNewInformation");
		CourseAdditionalProperty courseAdditionalProperty = new CourseAdditionalProperty(
				null, info_Description, null, info_Descriptiontext);
		LOGGER.debug("Entering Class " + getClass() + " showCourse()");
		try {
			courseService
					.saveAdditionalCourseProperty(courseAdditionalProperty);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Exiting Class " + getClass() + " showCourse(): ");

		return mv;
	}

	@RequestMapping(value = "/deleteaddnlinfo", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView deleteAddnlInfo(
			@RequestParam CourseAdditionalProperty courseAdditionalProperty) {
		LOGGER.debug("Entering Class " + getClass() + " deleteAddnlInfo()");
		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.debug("Exiting Class " + getClass() + " deleteAddnlInfo(): ");

		return mv;
	}
}
