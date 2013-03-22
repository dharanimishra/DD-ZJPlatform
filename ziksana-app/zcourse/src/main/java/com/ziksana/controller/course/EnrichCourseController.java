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

import com.ziksana.exception.ZiksanaException;
import com.ziksana.service.course.CourseService;

/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/zcourse")
public class EnrichCourseController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EnrichCourseController.class);
	
	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/enrichcontent", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showEnrichCourse() {
		LOGGER.debug("Entering showEnrichCourse(): ");
		ModelAndView mv = new ModelAndView("organizeenrichcontent");

		return mv;
	}

	@RequestMapping(value = "/enrichcontent/{contentId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showEnrichMyCourse(@PathVariable String contentId) {
		LOGGER.debug("Entering showEnrichCourse(): ");

		ModelAndView modelView = null;
		try {
			Integer courseid = 0;
				courseid = Integer.parseInt(contentId.split("_")[1]);
			if (courseid > 0) {
				int contentCount = courseService.isContentExists(courseid);
				if(contentCount == 0){
					return new ModelAndView("redirect:/zcourse/associatecontent/course_"+courseid+"");
				}else{
					modelView = new ModelAndView("organizeenrichcontent");
					modelView.addObject("courseid", courseid);
				}
			} else {
				modelView = new ModelAndView("createcourse");
				modelView.addObject("courseid", courseid);
			}
			modelView.addObject("courseId", contentId);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return modelView;
	}
}
