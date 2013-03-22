package com.ziksana.controller.sample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.sample.Course;
import com.ziksana.domain.sample.CourseAddlInfo;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.service.sample.SampleService;

@Controller
@RequestMapping(value="/sample")
public class SampleController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	SampleService sampleService;

	/**
	 * Method that renders a tiles template 
	 */
	@RequestMapping(value="/home")
	public String home() {
		LOGGER.debug("SampleController::home()...");
		return "dashboard";
	}
	
	/**
	 * Method serving ajax request. JSP has hard coded XML schema.
	 */
	@RequestMapping(value="/course/list")
	public String getCoursesAvailableXML(Model model) {
		
		LOGGER.debug("SampleController::getCoursesAvailableXML()...");
		try {
			List<Course> courseList = sampleService.getAvailableCourses();
			model.addAttribute("courseList", courseList);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return "courses/course-list";
	}

	/**
	 * Method serving ajax request. JSP has hard coded JSON format.
	 */
	@RequestMapping(value="/course/list-json")
	public ModelAndView getCoursesAvailableJSON() {
		
		LOGGER.debug("SampleController::getCoursesAvailableJSON()...");
		ModelAndView modelView = new ModelAndView("courses/course-list-json");
		try {
			List<Course> courseList = sampleService.getAvailableCourses();
			
			modelView.addObject("courseList", courseList);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return modelView;
	}
	
	/**
	 * Method serving ajax request. Response is in XML format using JAXB.
	 * Requires use <mvc:annotation-driven/> tab in spring configuration.
	 * Requires JAXB annotations on the Model object. 
	 * 
	 */
	@RequestMapping(value="/course/details-jaxb", method=RequestMethod.GET)
	public @ResponseBody CourseAddlInfo getCourseDetailsJAXB(
			@RequestParam(value="courseId", required=true) String courseId) {
		
		//TODO throw application exception
		throw new UnsupportedOperationException("Not supported. Model bean requires JAXB annotations.");
	}

	
	/**
	 * Method serving ajax request. Automatic JSON conversion by spring MessageConverter using Jackson library.
	 * Requires use <mvc:annotation-driven/> tab in spring configuration.
	 * JSON serialization fails if Bean has empty properties. Resolution needs annotations on the bean properties. 
	 * 
	 */
	@RequestMapping(value="/course/details-jackson", method=RequestMethod.GET)
	public @ResponseBody CourseAddlInfo getCourseDetailsJackson(
			@RequestParam(value="courseId", required=true) String courseId) {
		
		LOGGER.debug("SampleController::getCourseDetails()...");
		CourseAddlInfo course =  null;
		try {
			course = sampleService.getCourseDetails(courseId);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return course;
	}
	
	/**
	 * Method serving ajax request. JSON conversion via json-lib-ext-spring library.
	 * jsonView is a view bean invoked via XmlViewResolver.
	 * 
	 * This library is lenient towards empty bean properties.
	 * 
	 */
	@RequestMapping(value="/course/details-jsonlib", method=RequestMethod.GET)
	public ModelAndView getCourseDetailsJsonlib(
			@RequestParam(value="courseId", required=true) String courseId) {
		ModelAndView modelView = new ModelAndView("jsonView");
		LOGGER.debug("SampleController::getCourseDetailsJsonlib()...");
		try {
			CourseAddlInfo course = sampleService.getCourseDetails(courseId);
			modelView.addObject("course", course);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return modelView;
	}
}
