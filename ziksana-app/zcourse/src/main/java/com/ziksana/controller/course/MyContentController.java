/**
 * 
 */
package com.ziksana.controller.course;

import java.util.ArrayList;
import java.util.List;

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
import com.ziksana.domain.course.ContentFormat;
import com.ziksana.domain.course.ContentType;
import com.ziksana.domain.course.CourseJsonResponse;
import com.ziksana.domain.course.CourseSubjectClassification;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.json.JSONLearningContent;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.ZiksanaException;
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

	@RequestMapping(value = "1/createeditcontent/{contentId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView createEditContent(@PathVariable Integer contentId) {
		LOGGER.debug(" Entering Class " + getClass() + " createEditContent()");
		ModelAndView modelView = new ModelAndView("mastercreateeditcontent");
		List<LearningContent> learningContentlist = new ArrayList<LearningContent>();
		try {
			LearningContent learningContent = myContentService
					.getContent(contentId);
			learningContentlist.add(learningContent);
			mediaServerURL = mediaService.getMediaContents();
			modelView.addObject("ms", mediaServerURL);
			modelView.addObject("pageTitle", "EditContent");
			modelView.addObject("learningContentlist", learningContentlist);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Class " + getClass() + "Exiting createEditContent(): ");
		return modelView;
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

	@RequestMapping(value = "1/editweblinkcontent/{contentId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView editWebLinkContent(@PathVariable Integer contentId) {
		LOGGER.debug(" Entering Class " + getClass() + " webLinkContent()");
		ModelAndView modelView = new ModelAndView("editweblinkcontent");
		List<LearningContent> learningContentlist = new ArrayList<LearningContent>();
		try {
			LearningContent learningContent = myContentService
					.getContent(contentId);
			learningContentlist.add(learningContent);
			mediaServerURL = mediaService.getMediaContents();
			modelView.addObject("ms", mediaServerURL);
			modelView.addObject("pageTitle", "EditContent");
			modelView.addObject("learningContentlist", learningContentlist);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Class " + getClass() + "Exiting editWebLinkContent(): ");
		return modelView;
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
			List<JSONLearningContent> jsonLearningContentlList = getJSONLearningContentObjects(learningContents);
			String jsonString = JSONUtil
					.objectToJSONString(jsonLearningContentlList);

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
			@RequestParam(value = "contentPath", required = true) String[] contentPath,
			@RequestParam(value = "contentName", required = true) String[] contentName,
			@RequestParam(value = "contentType", required = true) String[] contentType,
			@RequestParam(value = "contentTypeName", required = true) String[] contentTypeName,
			@RequestParam(value = "contentFormatName", required = true) String[] contentFormatName,
			@RequestParam(value = "thumbnailPath", required = true) String[] thumbnailPath,
			@RequestParam(value = "noOfThumbnails", required = true) String[] noOfThumbnails) {

		ModelAndView modelView = new ModelAndView("mastereditcontent");
		List<LearningContent> learningContentlist = new ArrayList<LearningContent>();

		try {
			MemberPersona accountableMember = new MemberPersona();
			accountableMember.setMemberRoleId(Integer.valueOf(SecurityTokenUtil
					.getToken().getMemberPersonaId().getStorageID()));
			for (int i = 0; i < contentPath.length; i++) {
				try {
					LearningContent learningContent = new LearningContent();
					learningContent.setAuthoringMember(accountableMember);
					learningContent.setContentName(contentName[i]);
					learningContent.setContentPath(contentPath[i]);
					learningContent.setStatusId(1);
					learningContent.setActive(true);
					ContentType contentTypeObj = ContentType
							.getValueOf(contentTypeName[i].toUpperCase());
					learningContent.setContentType(contentTypeObj);
					learningContent.setContentTypeId(contentTypeObj.getID());
					ContentFormat contentFormat = ContentFormat
							.getValueOf(contentFormatName[i].toUpperCase());
					learningContent.setContentFormat(contentFormat);
					learningContent.setContentFormatId(contentFormat.getID());
					learningContent.setStatusId(1);
					learningContent.setRightsOwningMember(accountableMember);
					try {
						learningContent
								.setThumbnailPicturePath(thumbnailPath[i]);
						learningContent.setNumberOfThumbnails(Integer
								.parseInt(noOfThumbnails[i]));
					} catch (Exception e) {
						LOGGER.error("setThumbnailPicturePath :");

					}
					LearningContent learningCont = myContentService
							.saveOrUpdate(learningContent);
					LOGGER.info("learningContent created ################### "
							+ i + "   " + learningCont.getId());
					LOGGER.debug("learningContent create ################### "
							+ i + "  " + learningCont.getContentName());
					learningContentlist.add(learningCont);
					modelView.addObject("contentId", learningCont.getId());
				} catch (Exception e) {
					LOGGER.error("Content Exception  :" + e);
				}
			}
			modelView.addObject("learningContentlist", learningContentlist);
			modelView.addObject("message", "Content uploaded successfully.");

		} catch (ZiksanaException exception) {
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
			@RequestParam(value = "content_id[]", required = true) String[] contentId,
			@RequestParam(value = "thumbnail_path[]", required = false) String[] screenshotPath,
			@RequestParam(value = "content_name[]", required = false) String[] contentName,
			@RequestParam(value = "content_desc[]", required = false) String[] contentDesc,
			@RequestParam(value = "content_tags[]", required = false) String[] contentTags,
			@RequestParam(value = "content_area[]", required = false) String[] contentArea,
			@RequestParam(value = "content_subject[]", required = false) String[] contentSubject,
			@RequestParam(value = "content_topic[]", required = false) String[] contentTopic) {

		ModelAndView modelView = new ModelAndView("mastermycontent");

		List<LearningContent> learningContentlist = new ArrayList<LearningContent>();

		try {
			MemberPersona accountableMember = new MemberPersona();
			accountableMember.setMemberRoleId(Integer.valueOf(SecurityTokenUtil
					.getToken().getMemberPersonaId().getStorageID()));

			Integer learningContentId = 0;

			for (int i = 0; i < contentId.length; i++) {
				LearningContent learningContent = new LearningContent();
				learningContent.setAuthoringMember(accountableMember);
				learningContent.setStatusId(1);
				learningContent.setActive(true);
				learningContent.setRightsOwningMember(accountableMember);

				try {
					if (contentId != null && contentId.length > 0) {
						learningContentId = Integer.parseInt(contentId[i]);
						learningContent.setLearningContentId(learningContentId);
					}
					if (contentName != null && contentName.length > 0) {
						learningContent.setContentName(contentName[i]);
					}
					if (contentDesc != null && contentDesc.length > 0) {
						learningContent.setContentDescription(contentDesc[i]);
					}
					if (screenshotPath != null && screenshotPath.length > 0) {
						learningContent.setScreenshotPath(screenshotPath[i]);
					}
					if (contentTopic != null && contentTopic.length > 0) {
						CourseSubjectClassification courseSubjectClassification = courseSubjectDetailService
								.getSubjectClassification(contentTopic[i]);
						learningContent
								.setSubjClassificationId(courseSubjectClassification
										.getSubjClassificationId());
					}

				} catch (Exception e) {
					LOGGER.error("Class " + getClass()
							+ "Subject Classification not found:" + e);
				}

				LearningContent learningCont = myContentService
						.saveOrUpdate(learningContent);

				learningContentlist.add(learningCont);
			}

			mediaServerURL = mediaService.getMediaContents();
			modelView.addObject("ms", mediaServerURL);
			modelView.addObject("pageTitle", "My Content");
			modelView.addObject("message", "Content uploaded successfully.");

			Integer memberId = Integer.valueOf(SecurityTokenUtil.getToken()
					.getMemberPersonaId().getStorageID());
			List<LearningContent> learningContents = myContentService
					.getMyContents(memberId);
			List<JSONLearningContent> jsonLearningContentlList = getJSONLearningContentObjects(learningContents);
			String jsonString = JSONUtil
					.objectToJSONString(jsonLearningContentlList);

			modelView.addObject("learningContentAsJSONString", jsonString);

		} catch (ZiksanaException exception) {
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
			@RequestParam(value = "contentId", required = true) String contentId,
			@RequestParam(value = "contentPath", required = false) String thumbnailPicturePath,
			@RequestParam(value = "contentName", required = true) String contentName,
			@RequestParam(value = "contentUrl", required = true) String contentUrl,
			@RequestParam(value = "contentDescription", required = false) String contentDescription,
			@RequestParam(value = "contentTag", required = false) String Topic,
			@RequestParam(value = "contentArea", required = false) String contentArea,
			@RequestParam(value = "contentSubject", required = false) String contentSubject,
			@RequestParam(value = "contentTopic", required = false) String contentTopic) {

		ModelAndView modelView = new ModelAndView("mastermycontent");

		LOGGER.info("Class :" + getClass() + " thumbnailPicturePath :"
				+ thumbnailPicturePath);

		try {
			MemberPersona accountableMember = new MemberPersona();
			accountableMember.setMemberRoleId(Integer.valueOf(SecurityTokenUtil
					.getToken().getMemberPersonaId().getStorageID()));

			LearningContent learningContent = new LearningContent();
			learningContent.setLearningContentId(Integer.parseInt(contentId));
			learningContent.setAuthoringMember(accountableMember);
			learningContent.setContentName(contentName);
			learningContent.setContentDescription(contentDescription);
			learningContent.setContentPath(contentUrl);
			learningContent.setStatusId(1);
			learningContent.setActive(true);
			learningContent.setContentType(ContentType.getContentType(612));
			try {
				learningContent.setContentTypeId(ContentType.valueOf(
						"Link".toUpperCase()).getID());
			} catch (Exception e) {
				learningContent.setContentTypeId(959);
			}
			String screenshotPath = thumbnailPicturePath.replace(",'++'", "");
			learningContent.setThumbnailPicturePath(screenshotPath);
			learningContent.setScreenshotPath(screenshotPath);
			learningContent.setRightsOwningMember(accountableMember);

			try {
				CourseSubjectClassification courseSubjectClassification = courseSubjectDetailService
						.getSubjectClassification(Topic);
				learningContent
						.setSubjClassificationId(courseSubjectClassification
								.getSubjClassificationId());
			} catch (Exception e) {
				LOGGER.error("Class " + getClass()
						+ "Subject Classification not found:" + e);
			}

			myContentService.saveOrUpdate(learningContent);

			mediaServerURL = mediaService.getMediaContents();
			modelView.addObject("ms", mediaServerURL);
			modelView.addObject("pageTitle", "My Content");
			modelView.addObject("message", "Content updated successfully.");

			Integer memberId = Integer.valueOf(SecurityTokenUtil.getToken()
					.getMemberPersonaId().getStorageID());
			List<LearningContent> learningContents = myContentService
					.getMyContents(memberId);
			List<JSONLearningContent> jsonLearningContentlList = getJSONLearningContentObjects(learningContents);
			String jsonString = JSONUtil
					.objectToJSONString(jsonLearningContentlList);

			modelView.addObject("learningContentAsJSONString", jsonString);

		} catch (ZiksanaException exception) {
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

	@RequestMapping(value = "1/multiweblinkcontents", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView createMultiWeblinkContent(
			@RequestParam(value = "contentPath[]", required = false) String[] thumbnailPicturePath,
			@RequestParam(value = "contentName[]", required = true) String[] contentName,
			@RequestParam(value = "contentUrl[]", required = true) String[] contentUrl,
			@RequestParam(value = "contentDescription[]", required = false) String[] contentDescription,
			@RequestParam(value = "contentTag[]", required = false) String[] Topic,
			@RequestParam(value = "contentArea[]", required = false) String[] contentArea,
			@RequestParam(value = "contentSubject[]", required = false) String[] contentSubject,
			@RequestParam(value = "contentTopic[]", required = false) String[] contentTopic) {

		ModelAndView modelView = new ModelAndView("mastermycontent");

		LOGGER.info("Class :" + getClass() + " thumbnailPicturePath :"
				+ thumbnailPicturePath);

		try {
			MemberPersona accountableMember = new MemberPersona();
			accountableMember.setMemberRoleId(Integer.valueOf(SecurityTokenUtil
					.getToken().getMemberPersonaId().getStorageID()));

			for (int i = 0; i < contentName.length; i++) {
				LearningContent learningContent = new LearningContent();
				learningContent.setAuthoringMember(accountableMember);
				if (contentName != null && contentName.length > 0) {
					learningContent.setContentName(contentName[i]);
				}
				if (contentUrl != null && contentUrl.length > 0) {
					learningContent.setContentPath(contentUrl[i]);
				}
				learningContent.setStatusId(1);
				learningContent.setActive(true);
				learningContent.setRightsOwningMember(accountableMember);

				try {
					ContentType contentTypeObj = ContentType.getValueOf("LINK"
							.toUpperCase());
					learningContent.setContentType(contentTypeObj);
					learningContent.setContentTypeId(contentTypeObj.getID());
					ContentFormat contentFormat = ContentFormat
							.getValueOf("LINK".toUpperCase());
					learningContent.setContentFormat(contentFormat);
					learningContent.setContentFormatId(contentFormat.getID());

				} catch (Exception e) {
					learningContent.setContentTypeId(960);
					learningContent.setContentFormatId(969);
					LOGGER.error("Class " + getClass() + "Exception found:" + e);

				}
				if (thumbnailPicturePath != null
						&& thumbnailPicturePath.length > 0) {
					String screenshotPath = thumbnailPicturePath[i];
					learningContent.setThumbnailPicturePath(screenshotPath);
					learningContent.setScreenshotPath(screenshotPath);
					LOGGER.error("Class " + getClass()
							+ "screenshotPath found:" + screenshotPath);
				}
				if (contentDescription != null && contentDescription.length > 0) {
					learningContent
							.setContentDescription(contentDescription[i]);
				}

				try {
					if (contentTopic != null && contentTopic.length > 0) {
						CourseSubjectClassification courseSubjectClassification = courseSubjectDetailService
								.getSubjectClassification(contentTopic[i]);
						learningContent
								.setSubjClassificationId(courseSubjectClassification
										.getSubjClassificationId());
					}
				} catch (Exception e) {
					LOGGER.error("Class " + getClass()
							+ "Subject Classification not found:" + e);
				}
				myContentService.saveOrUpdate(learningContent);

			}

			mediaServerURL = mediaService.getMediaContents();
			modelView.addObject("ms", mediaServerURL);
			modelView.addObject("pageTitle", "My Content");
			modelView.addObject("message", "Content uploaded successfully.");

			Integer memberId = Integer.valueOf(SecurityTokenUtil.getToken()
					.getMemberPersonaId().getStorageID());
			List<LearningContent> learningContents = myContentService
					.getMyContents(memberId);
			List<JSONLearningContent> jsonLearningContentlList = getJSONLearningContentObjects(learningContents);
			String jsonString = JSONUtil
					.objectToJSONString(jsonLearningContentlList);

			modelView.addObject("learningContentAsJSONString", jsonString);

		} catch (ZiksanaException exception) {
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

	@RequestMapping(value = "/1/deletecontent", method = RequestMethod.POST)
	public @ResponseBody
	CourseJsonResponse deleteContent(
			@RequestParam(value = "contentId", required = true) Integer contentId) {
		CourseJsonResponse jsonResponse = new CourseJsonResponse();
		try {
			myContentService.deleteContent(contentId);
			LOGGER.info("delete conetnt contentId :" + contentId);
			jsonResponse.setResponse("success");
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
			jsonResponse.setResponse("Failed");
		}
		return jsonResponse;

	}

	@RequestMapping(value = "/1/checkcontentassociation", method = RequestMethod.POST)
	public @ResponseBody
	CourseJsonResponse checkContentAssociation(
			@RequestParam(value = "contentId", required = true) Integer contentId) {
		CourseJsonResponse jsonResponse = new CourseJsonResponse();
		boolean check = false;
		try {
			check = myContentService.checkContentAssociation(contentId);
			LOGGER.info("checkContentAssociation contentId :" + contentId);
			if (check) {
				jsonResponse.setResponse("active");
			} else {
				jsonResponse.setResponse("notactive");
			}

		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
			jsonResponse.setResponse("Failed");
		}
		return jsonResponse;

	}

	/**
	 * This method converts collection of {@link LearningContent} objects into
	 * {@link JSONLearningContent} objects
	 * 
	 * @param learningContentList
	 * @return
	 */
	private List<JSONLearningContent> getJSONLearningContentObjects(
			List<LearningContent> learningContentList) {
		List<JSONLearningContent> jsonLearningContentList = new ArrayList<JSONLearningContent>();
		for (LearningContent learningContent : learningContentList) {
			jsonLearningContentList
					.add(new JSONLearningContent(learningContent));
		}
		return jsonLearningContentList;

	}
}
