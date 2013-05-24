/**
 * 
 */
package com.ziksana.controller.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.common.MediaServerURL;
import com.ziksana.domain.course.ContentStatus;
import com.ziksana.domain.course.ContentType;
import com.ziksana.domain.course.CourseSubjectClassification;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.exception.course.CourseException;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.course.CourseSubjectDetailService;
import com.ziksana.service.course.MyContentService;
import com.ziksana.service.security.MediaService;
import com.ziksana.util.JSONUtil;

/**
 * @author Ratnesh Kumar
 * 
 */

@Controller
@RequestMapping("/zcourse")
public class MyContentController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MyContentController.class);

	@Autowired
	MyContentService myContentService;

	@Autowired
	MediaService mediaService;

	@Autowired
	CourseSubjectDetailService courseSubjectDetailService;

	MediaServerURL mediaServerURL = new MediaServerURL();

	@RequestMapping(value = "1/createcontent", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView createContent() {
		LOGGER.debug(" Entering Class " + getClass() + " createContent()");
		ModelAndView mv = new ModelAndView("mastercreatecontent");
		try {
			mediaServerURL = mediaService.getMediaContents();
			mv.addObject("ms", mediaServerURL);
			mv.addObject("pageTitle", "CreateContent");
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Class " + getClass() + "Exiting createContent(): ");
		return mv;
	}

	@RequestMapping(value = "1/editcontent", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView editContent() {
		LOGGER.debug(" Entering Class " + getClass() + " editContent()");
		ModelAndView mv = new ModelAndView("mastereditcontent");
		try {
			mediaServerURL = mediaService.getMediaContents();
			mv.addObject("ms", mediaServerURL);
			mv.addObject("pageTitle", "EditContent");
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Class " + getClass() + "Exiting editContent(): ");
		return mv;
	}

	@RequestMapping(value = "1/weblinkcontent", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView webLinkContent() {
		LOGGER.debug(" Entering Class " + getClass() + " webLinkContent()");
		ModelAndView mv = new ModelAndView("masterweblinkcontent");
		try {
			mediaServerURL = mediaService.getMediaContents();
			mv.addObject("ms", mediaServerURL);
			mv.addObject("pageTitle", "WeblinkContent");
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Class " + getClass() + "Exiting webLinkContent(): ");
		return mv;
	}

	@RequestMapping(value = "1/mycontent", method = { RequestMethod.GET })
	public @ResponseBody
	ModelAndView myContent() {
		LOGGER.debug(" Entering Class " + getClass() + " myContent()");
		ModelAndView modelView = new ModelAndView("mastermycontent");
		try {
			mediaServerURL = mediaService.getMediaContents();
			modelView.addObject("ms", mediaServerURL);
			modelView.addObject("pageTitle", "My Content");

			Integer memberId = Integer.valueOf(SecurityTokenUtil.getToken()
					.getMemberPersonaId().getStorageID());
			List<LearningContent> learningContents = myContentService
					.getMyContents(memberId);
			String jsonString = JSONUtil.objectToJSONString(learningContents);

			modelView.addObject("learningContentAsJSONString", jsonString);

		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Class " + getClass() + "Exiting myContent(): ");
		return modelView;
	}

	@RequestMapping(value = "1/createcontents", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView createContent(
			@RequestParam(value = "contentPath[]", required = true) String[] contentPath,
			@RequestParam(value = "contentName[]", required = true) String[] contentName,
			@RequestParam(value = "contentType[]", required = true) String[] contentType,
			@RequestParam(value = "contentTypeName[]", required = true) String[] contentTypeName) {

		ModelAndView modelView = new ModelAndView("mastereditcontent");
		List<LearningContent> learningContentlist = new ArrayList<LearningContent>();
		LOGGER.info(" -------------------contentPath :" + contentPath
				+ "contentPath :" + contentPath + "contentType :" + contentType
				+ "contentTypeName :" + contentTypeName + "---------------");

		for (int i = 0; i < contentPath.length; i++) {
			LOGGER.info(" -------------------contentPath :" + contentPath[i]
					+ "contentPath :" + contentPath[i] + "contentType :"
					+ contentType[i] + "contentTypeName :" + contentTypeName[i]
					+ "---------------"
					+ ContentType.valueOf(contentTypeName[i]).getID());

		}

		try {
			MemberPersona accountableMember = new MemberPersona();
			accountableMember.setMemberRoleId(Integer.valueOf(SecurityTokenUtil
					.getToken().getMemberPersonaId().getStorageID()));

			for (int i = 0; i < contentPath.length; i++) {
				LearningContent learningContent = new LearningContent();
				learningContent.setAuthoringMember(accountableMember);
				learningContent.setContentName(contentName[i]);
				learningContent.setContentPath(contentPath[i]);
				learningContent.setStatusId(1);
				learningContent.setActive(true);
//				learningContent.setContentTypeId(ContentType.valueOf(
//						contentTypeName[i]).getID());
				
				learningContent.setContentTypeId(959);
				learningContent.setThumbnailPicturePath(contentPath[i]);
			//	learningContent.setStatusId(ContentStatus.ACTIVE.getID());
				learningContent.setRightsOwningMember(accountableMember);
				LearningContent learningCont = myContentService
						.saveOrUpdate(learningContent);
				learningContentlist.add(learningCont);
			}
			modelView.addObject("learningContentlist", learningContentlist);
		} catch (CourseException exception) {
			LOGGER.error(exception.getMessage(), exception);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modelView;

	}

	@RequestMapping(value = "1/editcontents", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView editContent(
			@RequestParam(value = "ContentId", required = true) String contentId,
			@RequestParam(value = "ContentName", required = false) String contentName,
			@RequestParam(value = "ContentDescription", required = false) String contentDescription,
			@RequestParam(value = "Subject_Area", required = false) String SubjectArea,
			@RequestParam(value = "Subject", required = false) String Subject,
			@RequestParam(value = "Topic", required = false) String Topic,
			@RequestParam(value = "Contenttag_Field", required = false) String contentTags,
			@RequestParam(value = "ContentPath", required = false) String contentPath,
			@RequestParam(value = "ThumbnailPicturePath", required = false) String thumbnailPicturePath,
			@RequestParam(value = "NumberOfThumbnails", required = false) Integer numberOfThumbnails,
			@RequestParam(value = "ContentType", required = false) Integer contentType) {

		ModelAndView modelView = new ModelAndView("mastercreatecontent");

		try {
			MemberPersona accountableMember = new MemberPersona();
			accountableMember.setMemberRoleId(Integer.valueOf(SecurityTokenUtil
					.getToken().getMemberPersonaId().getStorageID()));

			Integer learningContentId = 0, subjClassificationId = 0;

			CourseSubjectClassification courseSubjectClassification = courseSubjectDetailService
					.getSubjectClassification(Topic);

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
			if (!"".equals(contentType) && contentType != null) {
				learningContent.setContentTypeId(contentType);
			}
			learningContent.setThumbnailPicturePath(thumbnailPicturePath);
			learningContent.setScreenshotPath(thumbnailPicturePath);
			learningContent.setStatus(ContentStatus.ACTIVE);
			learningContent.setNumberOfThumbnails(numberOfThumbnails);
			learningContent.setRightsOwningMember(accountableMember);
			try {
				learningContent
						.setSubjClassificationId(courseSubjectClassification
								.getSubjClassificationId());
			} catch (Exception e) {
				LOGGER.error("Class " + getClass()
						+ "Subject Classification not found:" + e);
			}

			LearningContent learningCont = myContentService
					.saveOrUpdate(learningContent);

		} catch (CourseException exception) {
			LOGGER.error(exception.getMessage(), exception);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modelView;

	}

	@RequestMapping(value = "1/weblinkcontents", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView createWeblinkContent(
			@RequestParam(value = "ContentId", required = false) String contentId,
			@RequestParam(value = "ContentName", required = true) String contentName,
			@RequestParam(value = "ContentDescription", required = false) String contentDescription,
			@RequestParam(value = "Subject_Area", required = false) String SubjectArea,
			@RequestParam(value = "Subject", required = false) String Subject,
			@RequestParam(value = "Topic", required = false) String Topic,
			@RequestParam(value = "Contenttag_Field", required = false) String contentTags,
			@RequestParam(value = "AssocContent_Image", required = false) String screenshotPath,
			@RequestParam(value = "LinkType", required = false) String linkType,
			@RequestParam(value = "ContentUpload", required = false) String contentUpload,
			@RequestParam(value = "ContentUrl", required = false) String contentUrl,
			@RequestParam(value = "ContentPath", required = false) String contentPath,
			@RequestParam(value = "ThumbnailPicturePath", required = false) String thumbnailPicturePath,
			@RequestParam(value = "NumberOfThumbnails", required = false) Integer numberOfThumbnails,
			@RequestParam(value = "ContentType", required = false) String contentType,
			@RequestParam(value = "ContentTypeName", required = false) String contentTypeName) {

		ModelAndView modelView = new ModelAndView("masterweblinkcontent");

		try {
			MemberPersona accountableMember = new MemberPersona();
			accountableMember.setMemberRoleId(Integer.valueOf(SecurityTokenUtil
					.getToken().getMemberPersonaId().getStorageID()));

			Integer learningContentId = 0, subjClassificationId = 0;

			CourseSubjectClassification courseSubjectClassification = courseSubjectDetailService
					.getSubjectClassification(Topic);

			LearningContent learningContent = new LearningContent();
			if (!"".equals(contentId) && contentId != null) {
				learningContentId = Integer.parseInt(contentId);
				// learningContent.setLearningContentId(learningContentId);
			}
			learningContent.setAuthoringMember(accountableMember);
			learningContent.setContentName(contentName);
			learningContent.setContentDescription(contentDescription);
			learningContent.setContentPath(contentPath);
			learningContent.setStatusId(1);
			learningContent.setActive(true);
			learningContent.setContentTypeId(959);

			learningContent.setThumbnailPicturePath(thumbnailPicturePath);
			learningContent.setScreenshotPath(screenshotPath);
			// learningContent.setStatus(ContentStatus.ACTIVE);
			learningContent.setNumberOfThumbnails(numberOfThumbnails);
			learningContent.setRightsOwningMember(accountableMember);

			try {
				learningContent
						.setSubjClassificationId(courseSubjectClassification
								.getSubjClassificationId());
			} catch (Exception e) {
				LOGGER.error("Class " + getClass()
						+ "Subject Classification not found:" + e);
			}

			myContentService.saveOrUpdate(learningContent);

		} catch (CourseException exception) {
			LOGGER.error(exception.getMessage(), exception);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modelView;

	}
}
