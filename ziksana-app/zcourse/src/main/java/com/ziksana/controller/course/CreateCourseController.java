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
import com.ziksana.exception.course.CourseException;
import com.ziksana.service.course.CourseService;

/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/secure")
public class CreateCourseController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CreateCourseController.class);

	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/createcourse", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showCourse() {
		LOGGER.info(" Entering Class " + getClass() + " showCourse()");
		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.info("Class " + getClass() + "Exiting showCourse(): ");

		return mv;
	}

	@RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveCourse(@RequestParam Course course) throws CourseException {
		LOGGER.info("Entering Class " + getClass()
				+ " saveCourse(): coursename :" + course.getCourseId()
				+ " coursedescription :" + course.getCourseDetails());
		courseService.saveOrUpdateCourse(course);
		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.info("Exiting Class " + getClass() + " saveCourse(): ");

		return mv;
	}

	@RequestMapping(value = "/saveCourseComponents", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveCourseComponents(@RequestParam Course course)
			throws CourseException {
		LOGGER.info("Entering Class " + getClass()
				+ " saveCourseComponents(): coursename :"
				+ course.getCourseId() + " coursedescription :"
				+ course.getCourseDetails());
		courseService.saveOrUpadteCourseComponents(course);
		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.info("Exiting Class " + getClass() + " saveCourseComponents(): ");

		return mv;
	}

	@RequestMapping(value = "/removeCourseComponents", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView removeCourseComponents(@RequestParam Course course)
			throws CourseException {
		LOGGER.info("Entering Class " + getClass()
				+ " removeCourseComponents(): coursename :"
				+ course.getCourseId() + " coursedescription :"
				+ course.getCourseDetails());
		courseService.removeCourse(course);
		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.info("Exiting Class " + getClass()
				+ " removeCourseComponents(): ");

		return mv;
	}

	@RequestMapping(value = "/searchCourseComponents", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView searchCourseComponents(@RequestParam String memberRoleId,
			@RequestParam String searchIndicator,
			@RequestParam LearningComponent learningComponent) {
		LOGGER.info("Entering  Class " + getClass()
				+ "searchCourseComponents(): coursename :" + memberRoleId
				+ " coursedescription :" + searchIndicator);

		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.info("Exiting  Class " + getClass()
				+ "searchCourseComponents(): ");

		return mv;
	}

}
