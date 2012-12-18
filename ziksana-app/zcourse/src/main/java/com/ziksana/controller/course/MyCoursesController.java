/**
 * 
 */
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
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.exception.course.CourseException;
import com.ziksana.service.course.CourseContentService;
import com.ziksana.service.course.CourseService;

/**
 * @author prabu
 * 
 */
@Controller
@RequestMapping("/secure")
public class MyCoursesController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MyCoursesController.class);

	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/readMyCourses", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView readMyCourses() throws CourseException {

		LOGGER.info("Entering Class " + getClass() + " showCourse()");

		courseService.getCoursesByStatus(CourseStatus.UNDER_CONSTRUCT);

		ModelAndView mv = new ModelAndView("courses/createcourses");

		LOGGER.info("Exiting Class " + getClass() + " showCourse(): ");

		//TODO  we need to add object		

		return mv;
	}

}
