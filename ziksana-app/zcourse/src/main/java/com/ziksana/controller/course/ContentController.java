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
import com.ziksana.service.course.ContentService;
import com.ziksana.service.course.CourseContentService;
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

	@RequestMapping(value = "1/createcontent", method = RequestMethod.POST)
	public @ResponseBody
	CourseJsonResponse createContent(
			@RequestParam(value = "ContentId", required = false) String contentId,
			@RequestParam(value = "Content_Name", required = true) String contentName,
			@RequestParam(value = "Content_Description", required = true) String contentDescription,
			@RequestParam(value = "Subject_Area", required = true) String SubjectArea,
			@RequestParam(value = "Subject", required = true) String Subject,
			@RequestParam(value = "Topic", required = true) String Topic,
			@RequestParam(value = "Contenttag_Field", required = false) String contentTags,
			@RequestParam(value = "AssocContent_Image", required = false) String screenshotPath,
			@RequestParam(value = "LinkType", required = false) String linkType,
			@RequestParam(value = "ContentUpload", required = false) String contentUpload,
			@RequestParam(value = "ContentUrl", required = false) String contentUrl,
			@RequestParam(value = "ContentPath", required = false) String contentPath,
			@RequestParam(value = "ThumbnailPicturePath", required = false) String thumbnailPicturePath,
			@RequestParam(value = "NumberOfThumbnails", required = false) Integer numberOfThumbnails,
			@RequestParam(value = "ContentType", required = false) Integer contentType) {

		try {
			MemberPersona accountableMember = new MemberPersona();
			accountableMember.setMemberRoleId(Integer.valueOf(SecurityTokenUtil
					.getToken().getMemberPersonaId().getStorageID()));

			Integer learningContentId = 0;

			LearningContent learningContent = new LearningContent();
			if (!"".equals(contentId) && contentId != null) {
				learningContentId = Integer.parseInt(contentId);
				learningContent.setLearningContentId(learningContentId);
			}
			learningContent.setAuthoringMember(accountableMember);
			learningContent.setContentName(contentName);
			learningContent.setContentDescription(contentDescription);
			learningContent.setContentPath(contentPath);
			learningContent.setStatusId(1);
			learningContent.setActive(true);
			learningContent.setContentTypeId(contentType);
			learningContent.setThumbnailPicturePath(thumbnailPicturePath);
			learningContent.setScreenshotPath(screenshotPath);
			learningContent.setStatus(ContentStatus.ACTIVE);
			learningContent.setNumberOfThumbnails(numberOfThumbnails);
			learningContent.setRightsOwningMember(accountableMember);

			courseContentService.saveOrUpdateLearningContent(learningContent);

		} catch (CourseException exception) {
			LOGGER.error(exception.getMessage(), exception);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
