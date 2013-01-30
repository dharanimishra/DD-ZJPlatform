/**
 * 
 */
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

	@RequestMapping(value = "/slides/{contentId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView slides(@PathVariable Integer contentId) {
		ModelAndView mav = new ModelAndView("courses/Slides");
		Content content = contentService.getContent(contentId);

		mav.addObject("content", content);

		return mav;

	}

	@RequestMapping(value = "/enhancePlayer/{contentId}/{componentId}/{courseId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView enhancePlayer(
			@PathVariable Integer contentId,
			@PathVariable Integer componentId,
			@PathVariable Integer courseId
			) {
		ModelAndView mav = new ModelAndView("courses/enhance_player");
		Content content = contentService.getContent(contentId);
		mav.addObject("content", content);
		mav.addObject("contentId", contentId);
		mav.addObject("componentId", componentId);

		return mav;

	}

	@RequestMapping(value = "/content/getContent", method = RequestMethod.GET)
	public @ResponseBody
	Content getContent(
			@RequestParam(value = "contentId", required = true) String contentId

	) {
		LOGGER.info("Entering Class " + getClass() + " getContent()");
		// ModelAndView mv = new ModelAndView("courses/course");
		LOGGER.info("Exiting Class " + getClass() + " getContent(): ");

		String parsedContentId = contentId.split("_")[3];

		Content content = contentService.getContent(Integer
				.valueOf(parsedContentId));

		if (content.getContentType() != 1 && content.getContentType() != 11 && content.getContentType() != 2 && content.getContentType() != 8 ) {
			content.setContentUrl("/ziksana-web/secure/slides/"
					+ content.getContentId());
		}

		return content;
	}

	@RequestMapping(value = "/content/getContentInfo", method = RequestMethod.GET)
	public @ResponseBody
	Content getContentInfo(
			@RequestParam(value = "contentId", required = true) String contentId) {
		LOGGER.info("Entering Class " + getClass() + " getContent()");
		// ModelAndView mv = new ModelAndView("courses/course");
		LOGGER.info("Exiting Class " + getClass() + " getContent(): ");

		String parsedNodeType = contentId.split("_")[0];
		String parsedContentId = contentId.split("_")[1];

		Content content = contentService.getContent(Integer
				.valueOf(parsedContentId));

		if (content.getContentType() != 1 && content.getContentType() != 2 && content.getContentType() != 8 ) {
			content.setContentUrl("/ziksana-web/secure/slides/"
					+ content.getContentId());
		}

		return content;
	}

}
