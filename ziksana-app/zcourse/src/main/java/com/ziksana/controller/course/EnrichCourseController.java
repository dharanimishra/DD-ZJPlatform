package com.ziksana.controller.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.service.course.CourseService;

/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/secure")
public class EnrichCourseController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EnrichCourseController.class);
	
	@Autowired
	CourseService courseService;

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

		Integer courseid = 0;
		try {
			courseid = Integer.parseInt(contentId.split("_")[1]);
		} catch (NumberFormatException nfe) {
			LOGGER.error("NumberFormatException courseid:" + nfe);
		}
		ModelAndView modelView = null;
		if (courseid > 0) {
			int contentCount = courseService.isContentExists(courseid);
			if(contentCount == 0){
				return new ModelAndView("redirect:/secure/associatecontent/course_"+courseid+"");
			}else{
				modelView = new ModelAndView("courses/enrichcontent");
				modelView.addObject("courseid", courseid);
			}
		} else {
			modelView = new ModelAndView("courses/definecourse");
			modelView.addObject("courseid", courseid);
		}
		modelView.addObject("courseId", contentId);
		return modelView;
	}
}
