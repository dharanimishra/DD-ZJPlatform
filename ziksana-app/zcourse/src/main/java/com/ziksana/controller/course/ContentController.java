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
import com.ziksana.domain.course.ContentStatus;
import com.ziksana.domain.course.CourseJsonResponse;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.exception.course.CourseException;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.course.LearningContentService;
import com.ziksana.service.course.CourseContentService;
import com.ziksana.service.security.MediaService;

/**
 * @author Ratnesh Kumar
 * 
 */
@Controller
@RequestMapping("/zcourse")
public class ContentController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ContentController.class);

	@Autowired
	LearningContentService contentService;

	@Autowired
	MediaService mediaService;

	@Autowired
	CourseContentService courseContentService;

	@RequestMapping(value = "/slides/{contentId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView slides(@PathVariable Integer contentId) {
		ModelAndView mav = new ModelAndView("courses/Slides");
		try {
			Content content = contentService.getContent(contentId);
			MediaServerURL mediaServerURL = new MediaServerURL();
			mediaServerURL = mediaService.getMediaContents();

			mav.addObject("content", content);
			mav.addObject("ms", mediaServerURL);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		return mav;

	}

	@RequestMapping(value = "/enhanceplayer/{contentId}/{componentId}/{courseId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView enhancePlayer(@PathVariable Integer contentId,
			@PathVariable Integer componentId, @PathVariable Integer courseId) {
		ModelAndView mav = new ModelAndView("courses/enhance_player");
		try {
			Content content = contentService.getContent(contentId);
			String enhanced_video_name = content.getContentName() + "-EV";
			mav.addObject("content", content);
			mav.addObject("contentId", contentId);
			mav.addObject("componentId", componentId);
			mav.addObject("enhanced_video_name", enhanced_video_name);
			mav.addObject("ms", mediaService.getMediaContents());
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return mav;

	}

	@RequestMapping(value = "/content/getcontent", method = RequestMethod.GET)
	public @ResponseBody
	Content getContent(
			@RequestParam(value = "contentId", required = true) String contentId

	) {
		LOGGER.debug("Entering Class " + getClass() + " getContent()");
		// ModelAndView mv = new ModelAndView("courses/course");

		Content content = null;
		try {
			String parsedContentId = contentId.split("_")[3];

			content = contentService.getContent(Integer
					.valueOf(parsedContentId));

			if (content.getContentType() != 1 && content.getContentType() != 11
					&& content.getContentType() != 2
					&& content.getContentType() != 8) {
				content.setContentUrl("/ziksana-web/zcourse/slides/"
						+ content.getContentId());
			}
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Exiting Class " + getClass() + " getContent(): ");
		return content;
	}

	@RequestMapping(value = "/content/getcontentinfo", method = RequestMethod.GET)
	public @ResponseBody
	Content getContentInfo(
			@RequestParam(value = "contentId", required = true) String contentId) {
		LOGGER.debug("Entering Class " + getClass() + " getContent()");

		String parsedNodeType = contentId.split("_")[0];
		String parsedContentId = contentId.split("_")[1];

		Content content = null;
		try {
			content = contentService.getContent(Integer
					.valueOf(parsedContentId));

			if (content.getContentType() != 1 && content.getContentType() != 11
					&& content.getContentType() != 2
					&& content.getContentType() != 8) {
				content.setContentUrl("/ziksana-web/zcourse/slides/"
						+ content.getContentId());
			}
		} catch (ZiksanaException exception) {
			// TODO Auto-generated catch block
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Exiting Class " + getClass() + " getContent(): ");
		return content;
	}

	

}
