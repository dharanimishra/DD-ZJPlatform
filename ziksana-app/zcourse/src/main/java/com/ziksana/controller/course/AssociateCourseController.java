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

import com.ziksana.domain.common.MediaServerURL;
import com.ziksana.domain.course.Content;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.data.ContentService;
import com.ziksana.service.security.MediaService;

/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/zcourse")
public class AssociateCourseController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AssociateCourseController.class);

	@Autowired
	ContentService contentService;
	
	@Autowired
	MediaService mediaService;
	
	@Autowired
	CourseService courseService;
	
	MediaServerURL mediaServerURL = new MediaServerURL();

	@RequestMapping(value = "/associatecontent", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView showAssociateContent() {
		LOGGER.info("Entering showAssociateCourse(): ");
		ModelAndView modelView = null;
		modelView = new ModelAndView("createcourse");
		mediaServerURL = mediaService.getMediaContents();
		modelView.addObject("ms", mediaServerURL);
		return modelView;
	}

	@RequestMapping(value = "/associatecontent/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showAssociateCourse(@PathVariable String courseId) {
		Integer course_id = 0;
		LOGGER.info("Entering showAssociateCourse(): ");
		try {
			course_id = Integer.parseInt(courseId.split("_")[1]);
		} catch (NumberFormatException nfe) {
			LOGGER.error("Entering showAssociateCourse(): NumberFormatException nfe: "
					+ nfe);
		}
		ModelAndView modelView = null;
		
		
		

		if (course_id > 0) {
			int isModuleExists = courseService.isModuleExists(course_id);
			LOGGER.info("Module Size= >"+isModuleExists);
			if(isModuleExists == 0 ){
				return new ModelAndView("redirect:/zcourse/createcourse/"+courseId+"");
			}else{
			modelView = new ModelAndView("createmodule");
			modelView.addObject("CourseId", courseId);
			mediaServerURL = mediaService.getMediaContents();
			modelView.addObject("ms", mediaServerURL);
			}
		} else {
			modelView = new ModelAndView("createcourse");
			modelView.addObject("CourseId", courseId);
			mediaServerURL = mediaService.getMediaContents();
			modelView.addObject("ms", mediaServerURL);
		}

		return modelView;
	}

	@RequestMapping(value = "/modalplayer/{contentId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showmodalplayer(@PathVariable String contentId) {
		LOGGER.info("Entering showmodalplayer(): ");
		ModelAndView mv = new ModelAndView("courses/modalplayer");
		mediaServerURL = mediaService.getMediaContents();
		Content content = contentService.getContent(Integer.valueOf(contentId));
		mv.addObject("content", content);
		mv.addObject("ms", mediaServerURL);
		
		
		return mv;
	}
	
	@RequestMapping(value = "/ev_modalplayer/{contentId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showevmodalplayer(@PathVariable String contentId) {
		LOGGER.info("Entering showmodalplayer(): ");
		ModelAndView mv = new ModelAndView("courses/ev_modalplayer");

		Content content = contentService.getContent(Integer.valueOf(contentId));
		mv.addObject("content", content);
		mediaServerURL = mediaService.getMediaContents();
		mv.addObject("ms", mediaServerURL);
		return mv;
	}

	@RequestMapping(value = "/enhance", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView enhance(
			@RequestParam(value = "flashcontentpath", required = true) String flashcontentpath) {
		ModelAndView mav = new ModelAndView("courses/enrich_player");
		mav.addObject("flashcontentpath", flashcontentpath);
		mediaServerURL = mediaService.getMediaContents();
		mav.addObject("ms", mediaServerURL);
		return mav;

	}
}
