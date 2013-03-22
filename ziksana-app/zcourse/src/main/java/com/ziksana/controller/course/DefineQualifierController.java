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

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.service.course.DefineQualifierService;

/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/zcourse")
public class DefineQualifierController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DefineQualifierController.class);
	
	@Autowired
	DefineQualifierService defineQualifierService;

	@RequestMapping(value = "/getdefinedqualifiers", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView getDefinedQualifiers(@RequestParam Course course) {
		LOGGER.debug("Entering Class " + getClass() + " getDefinedQualifiers()");
		ModelAndView mv = new ModelAndView("courses/createcourses");
		try {
			//TODO add code here
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Exiting Class " + getClass() + " getDefinedQualifiers(): ");

		return mv;
	}

	@RequestMapping(value = "/updatequalifier", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView updateQualifier(
			@RequestParam LearningComponent learningComponent) {

		LOGGER.debug("Entering Class " + getClass() + " updateQualifier()");
		ModelAndView mv = new ModelAndView("courses/createcourses");
		try {
			//TODO add code here
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Exiting Class " + getClass() + " updateQualifier(): ");
		return mv;
	}

	@RequestMapping(value = "/deletequalifier", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView deleteQualifier(
			@RequestParam LearningComponent learningComponent) {
		LOGGER.debug("Entering Class " + getClass() + " deleteQualifier()");
		ModelAndView mv = new ModelAndView("courses/createcourses");
		try {
			//TODO add code here
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Exiting Class " + getClass() + " deleteAddnlInfo(): ");

		return mv;
	}

}
