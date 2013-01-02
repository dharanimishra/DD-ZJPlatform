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

import com.ziksana.domain.course.Content;
import com.ziksana.service.course.ContentService;
import com.ziksana.service.course.CourseTreeNodeService;

/**
 * @author prabu
 *
 */
@Controller
@RequestMapping("/secure")
public class ContentController {
	
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ContentController.class);
	
	
	@Autowired
	ContentService contentService;


	@RequestMapping(value = "/content/getContent", method = RequestMethod.GET)
	public @ResponseBody
	Content getContent(
			@RequestParam(value = "contentId", required = true) String contentId
			
			) {
		LOGGER.info("Entering Class " + getClass() + " getContent()");
		//ModelAndView mv = new ModelAndView("courses/course");
		LOGGER.info("Exiting Class " + getClass() + " getContent(): ");
		String parsedContentId = contentId.split("_")[2];
		

		return contentService.getContent(Integer.valueOf(parsedContentId));
	}

}
