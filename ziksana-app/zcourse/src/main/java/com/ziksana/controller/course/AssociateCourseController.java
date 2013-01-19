package com.ziksana.controller.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.course.Content;
import com.ziksana.service.data.ContentService;


/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/secure")
public class AssociateCourseController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AssociateCourseController.class);

	@Autowired
	ContentService contentService;

	@RequestMapping(value = "/associatecontent/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showAssociateCourse(@PathVariable String courseId) {
		LOGGER.info("Entering showAssociateCourse(): ");
		ModelAndView mv = new ModelAndView("courses/associatecontent");
		mv.addObject("courseId", courseId);
		return mv;
	}

	@RequestMapping(value = "/modalplayer/{contentId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showmodalplayer(@PathVariable String contentId) {
		LOGGER.info("Entering showmodalplayer(): ");
		ModelAndView mv = new ModelAndView("courses/modalplayer");

		Content content = contentService.getContent(Integer.valueOf(contentId));
		mv.addObject("content", content);

		return mv;
	}

	@RequestMapping(value = "/enhance", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView enhance(
			@RequestParam(value = "flashcontentpath", required = true) String flashcontentpath) {
		ModelAndView mav = new ModelAndView("courses/enrich_player");
		mav.addObject("flashcontentpath", flashcontentpath);
		return mav;

	}
}
