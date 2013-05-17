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
import com.ziksana.exception.ZiksanaException;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.course.ContentService;
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

	@RequestMapping(value = "/1/associatecontent", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView showAssociateContent() {
		LOGGER.debug("Entering showAssociateCourse(): ");
		ModelAndView modelView = new ModelAndView("createcourse");
		try {
			mediaServerURL = mediaService.getMediaContents();
			modelView.addObject("ms", mediaServerURL);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(),exception);
		}
		return modelView;
	}

	@RequestMapping(value = "/1/associatecontent/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showAssociateCourse(@PathVariable String courseId) {
		Integer course_id = 0;
		ModelAndView modelView = null;
		try {
			LOGGER.debug("Entering showAssociateCourse(): ");
			course_id = Integer.parseInt(courseId.split("_")[1]);
			if (course_id > 0) {
				
				//TODO we should throw module exist exception here??
				int isModuleExists = courseService.isModuleExists(course_id);
				LOGGER.debug("Module Size= >"+isModuleExists);
				if(isModuleExists == 0 ){
					return new ModelAndView("redirect:/zcourse/createcourse/"+courseId+"");
				}else{
				modelView = new ModelAndView("associatecontent");
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
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage() + exception);
		}
		return modelView;
	}

	@RequestMapping(value = "/modalplayer/{contentId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showmodalplayer(@PathVariable String contentId) {
		LOGGER.debug("Entering showmodalplayer(): ");
		ModelAndView mv = new ModelAndView("courses/modalplayer");
		try {
			mediaServerURL = mediaService.getMediaContents();
			Content content = contentService.getContent(Integer.valueOf(contentId));
			mv.addObject("content", content);
			mv.addObject("ms", mediaServerURL);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(),exception);
		}
		return mv;
	}
	
	@RequestMapping(value = "/ev_modalplayer/{contentId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showevmodalplayer(@PathVariable String contentId) {
		LOGGER.debug("Entering showmodalplayer(): ");
		ModelAndView mv = new ModelAndView("courses/ev_modalplayer");

		try {
			Content content = contentService.getContent(Integer.valueOf(contentId));
			mv.addObject("content", content);
			mediaServerURL = mediaService.getMediaContents();
			mv.addObject("ms", mediaServerURL);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(),exception);
		}
		return mv;
	}

	@RequestMapping(value = "/enhance", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView enhance(
			@RequestParam(value = "flashcontentpath", required = true) String flashcontentpath) {
		ModelAndView mav = new ModelAndView("courses/enrich_player");
		try {
			mav.addObject("flashcontentpath", flashcontentpath);
			mediaServerURL = mediaService.getMediaContents();
			mav.addObject("ms", mediaServerURL);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(),exception);
		}
		return mav;

	}
}
