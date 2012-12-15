package com.ziksana.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.course.CourseSearchType;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.service.course.CourseContentService;

/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/secure")
public class SearchContentController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SearchContentController.class);

	@Autowired
	CourseContentService courseContentService;

	@RequestMapping(value = "/searchCourseComponent", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView searchCourseComponent(
			@RequestParam MemberPersona MemberPersona,
			@RequestParam String courseSearchType,
			@RequestParam LearningComponent learningComponent) {
		LOGGER.info("Entering Class " + getClass() + " searchCourseComponent()");

		//courseContentService.searchLearningComponentContent(courseSearchType,
		//		learningComponent);
		ModelAndView mv = new ModelAndView("courses/associatecontent");
		LOGGER.info("Exiting Class " + getClass()
				+ " searchCourseComponent(): ");

		return mv;
	}

}
