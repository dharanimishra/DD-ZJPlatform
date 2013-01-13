package com.ziksana.controller.course;

import java.util.ArrayList;
import java.util.Date;
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

import com.ziksana.domain.assessment.TagType;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseContentSecurity;
import com.ziksana.domain.course.CourseDetails;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.CourseTagcloud;
import com.ziksana.domain.course.Duration;
import com.ziksana.domain.course.DurationUnits;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentDetails;
import com.ziksana.domain.course.LearningComponentNest;
import com.ziksana.domain.course.LearningComponentType;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.course.CourseTreeNodeService;

/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/secure")
public class CreateCourseController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CreateCourseController.class);

	@Autowired
	CourseService courseService;

	@Autowired
	CourseTreeNodeService courseTreeNodeService;

	private static String LOGO_PATH = "/content/logo/";

	@RequestMapping(value = "/createcourse", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView showCourse() {
		LOGGER.info(" Entering Class " + getClass() + " showCourse()");
		ModelAndView mv = new ModelAndView("courses/definecourse");
		LOGGER.info("Class " + getClass() + "Exiting showCourse(): ");

		return mv;
	}

	@RequestMapping(value = "/createmodule/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView coursemodule(@PathVariable String courseId) {
		LOGGER.info(" Entering Class " + getClass() + " showCourse()");

		ModelAndView mv = new ModelAndView("courses/coursecreation");
		mv.addObject("courseId", courseId);
		LOGGER.info("Class " + getClass() + "Exiting showCourse(): ");

		return mv;
	}

	@RequestMapping(value = "/saveCourse", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView saveCourse(
			@RequestParam(value = "Course_id", required = false) String CourseId,
			@RequestParam(value = "Course_Name", required = true) String CourseName,
			@RequestParam(value = "Course_Description", required = true) String CourseDescription,
			@RequestParam(value = "Subject_Area", required = false) String Subject_Area,
			@RequestParam(value = "Subject", required = false) String Subject,
			@RequestParam(value = "Topic", required = false) String Topic,
			@RequestParam(value = "Coursetag_Field", required = false) String CourseTags,
			@RequestParam(value = "Course_Credits", required = true) String CourseCredits,
			@RequestParam(value = "Extra_Credits", required = true) String CourseExtraCredits,
			@RequestParam(value = "Course_Duration", required = true) String CourseDuration,
			@RequestParam(value = "Duration_Type", required = true) String CourseDurationUnit,
			@RequestParam(value = "Assoc_Image", required = false) String UploadImage)
			throws CourseException {
		LOGGER.info("Entering Class " + getClass()
				+ " saveCourse(): CourseId :" + CourseId + " CourseName :"
				+ CourseName + " CourseDescription :" + CourseDescription
				+ " Subject_Area:" + Subject_Area + "Subject " + Subject
				+ "Topic " + Topic + " Coursetag_Field:" + CourseTags
				+ " CourseCredits :" + CourseCredits + " CourseExtraCredits :"
				+ CourseExtraCredits + " Course_Duration :" + CourseDuration
				+ " CourseDurationUnit :" + CourseDurationUnit);

		Integer courseDuration = 0;
		Integer SubjClassificationId = 1;
		try {
			courseDuration = Integer.parseInt(CourseDuration);
			SubjClassificationId = Integer.parseInt(Topic);
		} catch (NumberFormatException nfe) {
			LOGGER.debug(" Class :" + getClass()
					+ " Method: saveCourse : NumberFormatException" + nfe);
		}

		ZID memberId = new StringZID("1000");
		ZID memberPersonaId = new StringZID("100");

		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		ThreadLocalUtil.setToken(token);

		MemberPersona accountableMember = new MemberPersona();
		accountableMember.setMemberRoleId(Integer.valueOf(ThreadLocalUtil
				.getToken().getMemberPersonaId().getStorageID()));

		// Service call for Course

		Course courseObj = null;
		List<CourseTagcloud> tagcloudList = new ArrayList<CourseTagcloud>();
		try {

			// Creating Course Object for adding parameters
			Course course = new Course();
			course.setName(CourseName);
			course.setDescription(CourseDescription);
			course.setCourseCredits(CourseCredits);
			course.setExtraCredits(CourseExtraCredits);
			course.setThumbnailPicturePath(LOGO_PATH + UploadImage);
			course.setCourseStatusId(1);
			course.setAdditionalInfoIndicator(true);
			course.setVersion(1);

			// Duration duration = new Duration(courseDuration,
			// DurationUnits.getDurationUnits(Integer
			// .valueOf(CourseDurationUnit)));

			Duration duration = new Duration(courseDuration,
					DurationUnits.getDurationUnits(1));
			course.setCourseDuration(duration);
			// course.setCourseStatus(CourseStatus.UNDER_CONSTRUCT);

			course.setSecurityIndicator(true);
			CourseContentSecurity courseSecurity = new CourseContentSecurity();
			//courseSecurity.setContentSecurityId(20);
			courseSecurity.setFlotingIndicator(true);
			courseSecurity.setLogoPath(LOGO_PATH);
			courseSecurity.setCourse(course);
			course.setCourseContSecurity(courseSecurity);

			CourseTagcloud tagcloud = new CourseTagcloud();
			tagcloud.setCreatingMember(accountableMember);
			tagcloud.setTagName(CourseTags);
			tagcloud.setTagType(TagType.TAG_TYPE1);
			tagcloudList.add(tagcloud);

			tagcloud.setCourse(course);
			course.setCourseTagClouds(tagcloudList);
			course.setValidFromDate(new Date());
			course.setValidToDate(new Date());

			// Adding Member Role
			course.setAccountableMember(accountableMember);

			// Subject Classification
			// course.setSubjClassification(subjClassification);

			LOGGER.info("Class :" + getClass()
					+ " Method saveCourse :Before courseService:" + course);

			// Return the course Object
			courseObj = courseService.saveOrUpdateCourse(course);
			LOGGER.info("Class :" + getClass()
					+ " Method saveCourse : After courseService:" + courseObj);

		} catch (Exception e) {
			LOGGER.error("Class :" + getClass()
					+ " Method Exception :saveCourse : CourseId :" + CourseId
					+ " Course Name :" + CourseName + " CourseDescription:"
					+ CourseDescription + " Subject_Area:" + Subject_Area
					+ "Subject " + Subject + "Topic " + Topic
					+ " CourseCredits :" + CourseCredits
					+ " CourseExtraCredits :" + CourseExtraCredits
					+ " courseDuration :" + courseDuration + "-" + e);

		}

		ModelAndView modelView = new ModelAndView("xml/definecourse");
		modelView.addObject("CourseId", courseObj.getCourseId().getStorageID());

		LOGGER.info("Exiting Class " + getClass() + " saveCourse(): CourseId :"
				+ courseObj.getCourseId().getStorageID() + " Course Name :"
				+ CourseName + " CourseDescription:" + CourseDescription
				+ " Subject_Area:" + Subject_Area + "Subject " + Subject
				+ "Topic " + Topic + " CourseCredits :" + CourseCredits
				+ " CourseExtraCredits :" + CourseExtraCredits
				+ " courseDuration :" + courseDuration + " courseObj :"
				+ courseObj);

		return modelView;
	}

	@RequestMapping(value = "/saveLearningComponent", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView saveCourseComponents(
			@RequestParam(value = "Course_id", required = false) String CourseId,
			@RequestParam(value = "Course_Module", required = true) String CourseModule,
			@RequestParam(value = "Module_Description", required = true) String CourseModuleDescription,
			@RequestParam(value = "Subject_Area", required = true) String Subject_Area,
			@RequestParam(value = "Subject", required = true) String Subject,
			@RequestParam(value = "Topic", required = true) String Topic,
			@RequestParam(value = "Moduletag_Field", required = true) String ModuleTags,
			@RequestParam(value = "Module_Weight", required = true) String ModuleWeight,
			@RequestParam(value = "LearningObject", required = false) String LearningObject,
			@RequestParam(value = "Module_Duration", required = false) String Duration,
			@RequestParam(value = "ModuleDuration_Type", required = false) String UnitofDuration,
			@RequestParam(value = "Assoc_Image", required = false) String UploadImage

	) throws CourseException {
		LOGGER.info("Entering Class " + getClass()
				+ " saveCourseComponents(): courseId :" + CourseId
				+ " CourseModule :" + CourseModule
				+ " CourseModuleDescription :" + CourseModuleDescription
				+ " ModuleTags :" + ModuleTags + " ModuleWeight :"
				+ ModuleWeight + " LearningObject :" + LearningObject
				+ " Duration :" + Duration + " UnitofDuration :"
				+ UnitofDuration + " UploadImage :" + UploadImage);

		ZID memberId = new StringZID("1000");
		ZID memberPersonaId = new StringZID("100");
		Integer courseid = 150;
		try {
			courseid = Integer.parseInt(CourseId);
		} catch (NumberFormatException nfe) {
			LOGGER.error("NumberFormatException :" + nfe);
		}

		Integer courseDuration = 0, moduleWeight = 0;
		try {
			courseDuration = Integer.parseInt(Duration);
			moduleWeight = Integer.parseInt(ModuleWeight);
		} catch (NumberFormatException nfe) {
			LOGGER.debug(" Class :" + getClass()
					+ " Method: saveCourse : NumberFormatException" + nfe);
		}

		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		ThreadLocalUtil.setToken(token);

		MemberPersona accountableMember = new MemberPersona();
		accountableMember.setMemberRoleId(Integer.valueOf(ThreadLocalUtil
				.getToken().getMemberPersonaId().getStorageID()));

		Course courseObj = null;
		try {
			List<CourseLearningComponent> compList = new ArrayList<CourseLearningComponent>();
			List<CourseTagcloud> tagcloudList = new ArrayList<CourseTagcloud>();
			Course course = new Course();
			MemberPersona authoredMember = new MemberPersona();
			authoredMember.setMemberRoleId(100);
			course.setCourseId(courseid);
			course.setAccountableMember(authoredMember);
			course.setCourseStatus(CourseStatus.UNDER_CONSTRUCT);
			course.setCourseStatusId(CourseStatus.UNDER_CONSTRUCT.getID());
			course.setDescription(CourseModuleDescription);
			/*
			 * course1.setSecurityIndicator(true); CourseContentSecurity
			 * courseSecurity = new CourseContentSecurity();
			 * courseSecurity.setContentSecurityId(17);
			 * courseSecurity.setFlotingIndicator(true);
			 * courseSecurity.setLogoPath("/newlogopath/");
			 * courseSecurity.setCourse(course1);
			 * course1.setCourseContSecurity(courseSecurity);
			 */
			/*
			 * CourseTagcloud tagcloud = new CourseTagcloud();
			 * tagcloud.setCreatingMember(authoredMember);
			 * tagcloud.setTagName("Trigonometry");
			 * tagcloud.setTagType(TagType.TAG_TYPE1); tagcloudList.add(tagcloud);
			 * //tagcloud.setCourse(course1);
			 * course1.setCourseTagClouds(tagcloudList);
			 */
			LearningComponent comp1 = new LearningComponent();
			comp1.setAuthoredMember(authoredMember);

			comp1.setName(CourseModule);
			LearningComponentNest compNest1 = new LearningComponentNest(null, comp1);
			compNest1.setNestLearningComponent(comp1);
			// compNest1.setComponentNestId(11);
			LearningComponentDetails compDetails1 = new LearningComponentDetails();
			// comp1.getLearningComponentDetails();
			compDetails1.setLearningComponentNest(compNest1);

			LearningComponentType compType1 = new LearningComponentType();
			compType1.setLearningComponentTypeId(1);

			comp1.setLearningComponentType(compType1);

			CourseLearningComponent corComp1 = new CourseLearningComponent();
			corComp1.setLearningComponent(comp1);
			corComp1.setLearningComponentType(compType1);
			corComp1.setCourse(course);

			compDetails1.setCourseLearningComponent(corComp1);

			comp1.setLearningComponentDetails(compDetails1);

			compList.add(corComp1);

			CourseDetails courseDetails = new CourseDetails();

			courseDetails.setCourseLearningComponentsList(compList);

			course.setCourseDetails(courseDetails);

			System.out.println("Constructed Course  : " + course);

			LOGGER.error("Entering Class "
					+ getClass()
					+ " saveCourseComponents()  before calling service : courseId :"
					+ CourseId + " getting course " + course);

			System.out.println("Constructed Course  : " + course);
			// Saving the course Object
			courseObj = courseService.saveOrUpadteCourseComponents(course);

			LOGGER.error("Entering Class "
					+ getClass()
					+ " saveCourseComponents()  after calling service : courseId :"
					+ CourseId + " getting course " + course);

		} catch (Exception e) {
			LOGGER.debug("Class :" + getClass()
					+ "Method : saveCourseComponents :Exception :"
					+ e.getMessage());

		}

		ModelAndView modelView = new ModelAndView("xml/definemodule");
		modelView.addObject("CourseId", CourseId);
		LOGGER.info("Exiting Class " + getClass()
				+ " saveCourseComponents(): courseObj :" + courseObj);
		return modelView;
	}

	@RequestMapping(value = "/removeCourseComponents", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView removeCourseComponents(@RequestParam Course course)
			throws CourseException {
		LOGGER.info("Entering Class " + getClass()
				+ " removeCourseComponents(): coursename :"
				+ course.getCourseId() + " coursedescription :"
				+ course.getCourseDetails());
		courseService.removeCourse(course);
		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.info("Exiting Class " + getClass()
				+ " removeCourseComponents(): ");

		return mv;
	}

	@RequestMapping(value = "/searchCourseComponents", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView searchCourseComponents(@RequestParam String memberRoleId,
			@RequestParam String searchIndicator,
			@RequestParam LearningComponent learningComponent) {
		LOGGER.info("Entering  Class " + getClass()
				+ "searchCourseComponents(): coursename :" + memberRoleId
				+ " coursedescription :" + searchIndicator);

		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.info("Exiting  Class " + getClass()
				+ "searchCourseComponents(): ");

		return mv;
	}
}
