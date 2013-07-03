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

import com.ziksana.domain.course.ComponentContentType;
import com.ziksana.domain.course.ContentStatus;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseJsonResponse;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.Enrichment;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.course.CourseException;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.course.CourseContentService;
import com.ziksana.service.course.CourseEnrichmentService;

/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/zcourse")
public class CourseContentController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CourseContentController.class);

	@Autowired
	public CourseContentService courseContentService;


	@RequestMapping(value = "/saveorupdatecontent", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	CourseJsonResponse saveOrUpdateContent(
			@RequestParam(value = "Course_id", required = true) String CourseId,
			@RequestParam(value = "LearningComponentId", required = true) String LearningComponentId,
			@RequestParam(value = "Content_Name", required = true) String ContentName,
			@RequestParam(value = "Content_Description", required = true) String ContentDescription,
			@RequestParam(value = "Subject_Area", required = true) String SubjectArea,
			@RequestParam(value = "Subject", required = true) String Subject,
			@RequestParam(value = "Topic", required = true) String Topic,
			@RequestParam(value = "Contenttag_Field", required = false) String ContentTags,
			@RequestParam(value = "AssocContent_Image", required = false) String ScreenshotPath,
			@RequestParam(value = "LinkType", required = false) String LinkType,
			@RequestParam(value = "ContentUpload", required = false) String ContentUpload,
			@RequestParam(value = "ContentUrl", required = false) String ContentUrl,
			@RequestParam(value = "ContentDesc", required = false) String ContentDesc,
			@RequestParam(value = "ContentPath", required = false) String ContentPath,
			@RequestParam(value = "ThumbnailPicturePath", required = false) String ThumbnailPicturePath,
			@RequestParam(value = "NumberOfThumbnails", required = false) Integer numberOfThumbnails,
			@RequestParam(value = "ContentType", required = false) Integer ContentType) {

		LOGGER.debug("Entering Class " + getClass()
				+ " saveOrUpdateContent(): CourseId :" + CourseId
				+ " Content_Name :" + ContentName + " ContentDescription:"
				+ ContentDescription + " Subject_Area:" + SubjectArea
				+ "Subject " + Subject + "Topic " + Topic + " ContentTags :"
				+ ContentTags + " ScreenshotPath :" + ScreenshotPath
				+ " LinkType :" + LinkType + "LinkType :" + LinkType
				+ "ContentUpload :" + ContentUpload + "ContentUrl :"
				+ ContentUrl + " ContentDesc :" + ContentDesc
				+ " ContentPath :" + ContentPath + "ThumbnailPicturePath : "
				+ ThumbnailPicturePath + " numberOfThumbnails :"
				+ numberOfThumbnails + " ContentType :" + ContentType);

		LOGGER.debug(" Class :"
				+ getClass()
				+ " Method: saveCourse() : setMemberRoleId"
				+ Integer.valueOf(SecurityTokenUtil.getToken()
						.getMemberPersonaId().getStorageID()));
		CourseJsonResponse json = null;
		try {
		MemberPersona accountableMember = new MemberPersona();
		accountableMember.setMemberRoleId(Integer.valueOf(SecurityTokenUtil
				.getToken().getMemberPersonaId().getStorageID()));

		Integer courseid = 0, contentTypeId = 0;
		courseid = Integer.parseInt(CourseId.split("_")[1]);
		contentTypeId = ContentType;
		Integer learnComponentId = 0;
		learnComponentId = Integer
					.parseInt(LearningComponentId.split("_")[1]);
		 
			Course course = new Course();
			course.setCourseId(courseid);

			LearningComponent component = new LearningComponent();
			component.setLearningComponentId(learnComponentId);

			LearningContent content = new LearningContent();
			content.setAuthoringMember(accountableMember);
			content.setContentName(ContentName);
			content.setContentDescription(ContentDescription);
			content.setContentPath(ContentPath);
			content.setStatusId(1);
			content.setActive(true);
			content.setContentTypeId(ContentType);
			content.setThumbnailPicturePath(ThumbnailPicturePath);
			content.setScreenshotPath(ScreenshotPath);
			content.setStatus(ContentStatus.ACTIVE);
			content.setNumberOfThumbnails(numberOfThumbnails);
			content.setRightsOwningMember(accountableMember);

			LearningComponentContent compContent = new LearningComponentContent();
			compContent.setContentDescription(ContentDescription);
			compContent.setLearningComponent(component);
			compContent
					.setCompContentTypeId(ComponentContentType.COURSE_CONTENT
							.getID());
			compContent.setBaseLearningContent(content);

			compContent.setCourseStatusId(CourseStatus.ACTIVE.getID());

			courseContentService.saveOrUpdateContent(compContent);


			json = new CourseJsonResponse();

		if (courseid == 0) {
			json.setResponse("failed");
			json.setMessage("Content Creation Failed!");
			LOGGER.info("CourseContentController.saveOrUpdateContent(), content creation failed");
			LOGGER.debug("Class :" + getClass()
					+ " Method saveCourse : After courseService: CourseId :"
					+ CourseId);
		} else {
			json.setId("COURSE_" + courseid);
			json.setResponse("success");
			json.setMessage("Content Creation Success");

			LOGGER.debug("Class :" + getClass()
					+ " Method saveCourse success : After courseService: CourseId :"
					+ CourseId);
		}

		} catch (CourseException ce) {
			LOGGER.error("Class :" + getClass()
					+ " Method Exception :saveOrUpdateContent() : CourseId :"
					+ CourseId + " Content_Name :" + ContentName
					+ " ContentDescription:" + ContentDescription
					+ " Subject_Area:" + SubjectArea + "Subject " + Subject
					+ "Topic " + Topic + " ContentTags :" + ContentTags
					+ " ScreenshotPath :" + ScreenshotPath + " LinkType :"
					+ LinkType + "LinkType :" + LinkType + "ContentUpload :"
					+ ContentUpload + "ContentUrl :" + ContentUrl
					+ " ContentDesc :" + ContentDesc + " ContentPath :"
					+ ContentPath + "ThumbnailPicturePath : "
					+ ThumbnailPicturePath + " NumberOfThumbnails :"
					+ numberOfThumbnails + " ContentType :" + ContentType + ce);
		}

		return json;
	}

	@RequestMapping(value = "/getcomponentcontent", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView getComponentContent(@RequestParam Course course) {
		LOGGER.debug("Entering Class " + getClass() + " getComponentContent()");
		ModelAndView mv = new ModelAndView("createmodule");
		LOGGER.debug("Exiting Class " + getClass() + " getComponentContent(): ");

		return mv;
	}

	@RequestMapping(value = "/course/deletenode", method = RequestMethod.POST)
	public @ResponseBody
	String deleteContent(@RequestParam String nodeId) {
		LOGGER.debug("Entering Class " + getClass() + " deleteContent()");

		LOGGER.debug("Exiting Class " + getClass() + " deleteContent(): ");

		return "1";
	}

}
