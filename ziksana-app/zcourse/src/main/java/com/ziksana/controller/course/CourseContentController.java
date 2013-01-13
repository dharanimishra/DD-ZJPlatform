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
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.course.CourseContentService;

/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/secure")
public class CourseContentController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CourseContentController.class);

	private static String CONTENT_PATH = "/content/";

	@Autowired
	public CourseContentService courseContentService;

	@RequestMapping(value = "/saveOrUpdateContent", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView saveOrUpdateContent(
			@RequestParam(value = "Course_id", required = true) String CourseId,
			@RequestParam(value = "LearningComponentId", required = true) String LearningComponentId,
			@RequestParam(value = "Content_Name", required = true) String ContentName,
			@RequestParam(value = "Content_Description", required = true) String ContentDescription,
			@RequestParam(value = "Subject_Area", required = true) String SubjectArea,
			@RequestParam(value = "Subject", required = true) String Subject,
			@RequestParam(value = "Topic", required = true) String Topic,
			@RequestParam(value = "Contenttag_Field", required = false) String ContentTags,
			@RequestParam(value = "AssocContent_Image", required = false) String ContentImage,
			@RequestParam(value = "LinkType", required = false) String LinkType,
			@RequestParam(value = "ContentUpload", required = false) String ContentUpload,
			@RequestParam(value = "ContentUrl", required = false) String ContentUrl,
			@RequestParam(value = "ContentDesc", required = false) String ContentDesc)
			throws CourseException {

		LOGGER.info("Entering Class " + getClass()
				+ " saveOrUpdateContent(): CourseId :" + CourseId
				+ " Content_Name :" + ContentName + " ContentDescription:"
				+ ContentDescription + " Subject_Area:" + SubjectArea
				+ "Subject " + Subject + "Topic " + Topic + " ContentTags :"
				+ ContentTags + " AssocContent_Image :" + ContentImage
				+ " LinkType :" + LinkType + "LinkType :" + LinkType
				+ "ContentUpload :" + ContentUpload + "ContentUrl :"
				+ ContentUrl + " ContentDesc :" + ContentDesc);

		MemberPersona authoredMember = new MemberPersona();
		authoredMember.setMemberRoleId(100);
		String course_id = CourseId.split("_")[1];
		Integer courseid = 150;
		try {
			courseid = Integer.parseInt(course_id);
		} catch (NumberFormatException nfe) {
			LOGGER.error("NumberFormatException courseid:" + nfe);
		}

		String learningComponentId = LearningComponentId.split("_")[1];

		Integer learnComponentId = 3;
		try {
			learnComponentId = Integer.parseInt(learningComponentId);
		} catch (NumberFormatException nfe) {
			LOGGER.error("NumberFormatException :learnComponentId" + nfe);
		}

		try {
			Course course = new Course();
			course.setCourseId(courseid);

			LearningComponent component = new LearningComponent();
			component.setLearningComponentId(learnComponentId);

			LearningContent content = new LearningContent();
			content.setAuthoringMember(authoredMember);
			content.setContentName(ContentName);
			content.setContentDescription(ContentDescription);
			content.setContentPath(CONTENT_PATH);
			content.setStatusId(1);

			// content.setContentTypeId(ContentType.TEXTUAL.getID());

			content.setRightsOwningMember(authoredMember);
			// content.setContentFormatId(ContentFormat.WORD.getID());

			LearningComponentContent compContent = new LearningComponentContent();
			compContent.setContentDescription(ContentDescription);
			compContent.setLearningComponent(component);
			compContent
					.setCompContentTypeId(ComponentContentType.COURSE_CONTENT
							.getID());
			compContent.setBaseLearningContent(content);
			// compContent.setCourseStatusId(CourseStatus.UNDER_CONSTRUCT.getID());

			courseContentService.saveOrUpdateContent(compContent);

		} catch (CourseException ce) {
			LOGGER.error("Class :" + getClass()
					+ " Method Exception :saveOrUpdateContent() : CourseId :"
					+ CourseId + " Content_Name :" + ContentName
					+ " ContentDescription:" + ContentDescription
					+ " Subject_Area:" + SubjectArea + "Subject " + Subject
					+ "Topic " + Topic + " ContentTags :" + ContentTags
					+ " AssocContent_Image :" + ContentImage + " LinkType :"
					+ LinkType + "LinkType :" + LinkType + "ContentUpload :"
					+ ContentUpload + "ContentUrl :" + ContentUrl
					+ " ContentDesc :" + ContentDesc + ce);
		}
		ModelAndView modelView = new ModelAndView("xml/contentcourse");
		modelView.addObject("CourseId", courseid);

		return modelView;
	}

	@RequestMapping(value = "/getComponentContent", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView getComponentContent(@RequestParam Course course) {
		LOGGER.info("Entering Class " + getClass() + " getComponentContent()");
		ModelAndView mv = new ModelAndView("courses/associatecontent");
		LOGGER.info("Exiting Class " + getClass() + " getComponentContent(): ");

		return mv;
	}

	@RequestMapping(value = "/deleteContent", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView deleteContent(
			@RequestParam LearningComponentContent learningComponentContent) {
		LOGGER.info("Entering Class " + getClass() + " deleteContent()");
		ModelAndView mv = new ModelAndView("courses/associatecontent");
		LOGGER.info("Exiting Class " + getClass() + " deleteContent(): ");

		return mv;
	}

}
