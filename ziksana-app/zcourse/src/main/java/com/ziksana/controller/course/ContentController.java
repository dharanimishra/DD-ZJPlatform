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

import com.ziksana.domain.common.MediaServerURL;
import com.ziksana.domain.course.Content;
import com.ziksana.service.data.ContentService;
import com.ziksana.service.security.MediaService;

/**
 * @author prabu
 * 
 */
@Controller
@RequestMapping("/zcourse")
public class ContentController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ContentController.class);

	@Autowired
	ContentService contentService;

	@Autowired
	MediaService mediaService;

	@RequestMapping(value = "/slides/{contentId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView slides(@PathVariable Integer contentId) {
		ModelAndView mav = new ModelAndView("courses/Slides");
		Content content = contentService.getContent(contentId);
		MediaServerURL mediaServerURL = new MediaServerURL();
		mediaServerURL = mediaService.getMediaContents();

		mav.addObject("content", content);
		mav.addObject("ms", mediaServerURL);

		return mav;

	}

	@RequestMapping(value = "/enhanceplayer/{contentId}/{componentId}/{courseId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView enhancePlayer(@PathVariable Integer contentId,
			@PathVariable Integer componentId, @PathVariable Integer courseId) {
		ModelAndView mav = new ModelAndView("courses/enhance_player");
		Content content = contentService.getContent(contentId);
		String enhanced_video_name = content.getContentName() + "-EV";
		mav.addObject("content", content);
		mav.addObject("contentId", contentId);
		mav.addObject("componentId", componentId);
		mav.addObject("enhanced_video_name", enhanced_video_name);
		mav.addObject("ms", mediaService.getMediaContents());
		return mav;

	}

	@RequestMapping(value = "/content/getcontent", method = RequestMethod.GET)
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

		if (content.getContentType() != 1 && content.getContentType() != 11
				&& content.getContentType() != 2
				&& content.getContentType() != 8) {
			content.setContentUrl("/ziksana-web/zcourse/slides/"
					+ content.getContentId());
		}

		return content;
	}

	@RequestMapping(value = "/content/getcontentinfo", method = RequestMethod.GET)
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

		if (content.getContentType() != 1 && content.getContentType() != 11
				&& content.getContentType() != 2
				&& content.getContentType() != 8) {
			content.setContentUrl("/ziksana-web/zcourse/slides/"
					+ content.getContentId());
		}

		return content;
	}

}
