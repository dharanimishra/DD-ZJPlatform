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

import com.ziksana.domain.assessment.TagType;
import com.ziksana.domain.common.MediaServerURL;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseDetails;
import com.ziksana.domain.course.CourseEditResponse;
import com.ziksana.domain.course.CourseJsonResponse;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.CourseSubjectClassification;
import com.ziksana.domain.course.CourseTagcloud;

import com.ziksana.domain.course.Duration;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentDetails;
import com.ziksana.domain.course.LearningComponentNest;
import com.ziksana.domain.course.LearningComponentType;
import com.ziksana.domain.course.ModuleEditResponse;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.course.CourseException;

import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.course.CourseEditService;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.course.CourseSubjectDetailService;
import com.ziksana.service.course.CourseTreeNodeService;
import com.ziksana.service.course.TagCloudService;
import com.ziksana.service.security.MediaService;

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
	CourseEditService courseEditService;

	@Autowired
	TagCloudService tagCloudService;

	@Autowired
	CourseSubjectDetailService courseSubjectDetailService;

	@Autowired
	CourseTreeNodeService courseTreeNodeService;

	@Autowired
	MediaService mediaService;

	MediaServerURL mediaServerURL = new MediaServerURL();

	@RequestMapping(value = "/createcourse", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView showCourse() {
		LOGGER.info(" Entering Class " + getClass() + " showCourse()");
		mediaServerURL = mediaService.getMediaContents();

		ModelAndView mv = new ModelAndView("courses/definecourse");
		mv.addObject("ms", mediaServerURL);
		LOGGER.info("Class " + getClass() + "Exiting showCourse(): ");
		return mv;
	}

	@RequestMapping(value = "/editcourse/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showMyEditCourse(@PathVariable String courseId) {
		LOGGER.info(" Entering Class " + getClass() + " showCourse()");

		Integer course_id = Integer.parseInt(courseId.split("_")[1]);
		ModelAndView modelView = null;
		if (course_id > 0) {
			modelView = new ModelAndView("courses/definecourse");
			mediaServerURL = mediaService.getMediaContents();
			modelView.addObject("CourseId", course_id);
			modelView.addObject("ms", mediaServerURL);
		} else {
			mediaServerURL = mediaService.getMediaContents();
			modelView.addObject("CourseId", course_id);
			modelView.addObject("ms", mediaServerURL);
		}

		LOGGER.info("Class " + getClass() + "Exiting showCourse(): ");
		return modelView;
	}

	@RequestMapping(value = "/createcourse/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showMyCourse(@PathVariable String courseId) {
		LOGGER.info(" Entering Class " + getClass() + " showCourse()");

		Integer course_id = Integer.parseInt(courseId.split("_")[1]);
		mediaServerURL = mediaService.getMediaContents();
		ModelAndView modelView = null;
		if (course_id > 0) {

			modelView = new ModelAndView("courses/coursecreation");
			modelView.addObject("CourseId", course_id);
			modelView.addObject("ms", mediaServerURL);
		} else {
			modelView = new ModelAndView("courses/definecourse");
			modelView.addObject("CourseId", course_id);
			modelView.addObject("ms", mediaServerURL);
		}

		LOGGER.info("Class " + getClass() + "Exiting showCourse(): ");
		return modelView;
	}

	@RequestMapping(value = "/createmodule/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView courseModule(@PathVariable String courseId) {

		LOGGER.info(" Entering Class " + getClass() + " courseModule()");
		Integer course_id = Integer.parseInt(courseId.split("_")[1]);

		mediaServerURL = mediaService.getMediaContents();
		ModelAndView modelView = null;
		if (course_id > 0) {
			modelView = new ModelAndView("courses/coursecreation");
			modelView.addObject("CourseId", course_id);
			modelView.addObject("ms", mediaServerURL);
		} else {
			modelView = new ModelAndView("courses/definecourse");
			modelView.addObject("CourseId", course_id);
			modelView.addObject("ms", mediaServerURL);
		}

		LOGGER.info("Class " + getClass() + "Exiting courseModule(): ");

		return modelView;
	}

	@RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
	public @ResponseBody
	CourseJsonResponse saveCourse(
			@RequestParam(value = "Course_id", required = false) String CourseId,
			@RequestParam(value = "Course_Name", required = true) String CourseName,
			@RequestParam(value = "Course_Description", required = false) String CourseDescription,
			@RequestParam(value = "Subject_Area", required = false) String subjectArea,
			@RequestParam(value = "Subject", required = false) String subjectCategory,
			@RequestParam(value = "Topic", required = false) String subjectTopic,
			@RequestParam(value = "Coursetag_Field", required = false) String CourseTags,
			@RequestParam(value = "Course_Credits", required = false) String CourseCredits,
			@RequestParam(value = "Extra_Credits", required = false) String CourseExtraCredits,
			@RequestParam(value = "Course_Duration", required = false) String CourseDuration,
			@RequestParam(value = "Duration_Type", required = false) String CourseDurationUnit,
			@RequestParam(value = "Assoc_Image", required = false) String UploadImage)
			throws CourseException {
		LOGGER.info("Entering Class " + getClass()
				+ " saveCourse(): CourseId :" + CourseId + " CourseName :"
				+ CourseName + " CourseDescription :" + CourseDescription
				+ " Subject_Area:" + subjectArea + "Subject " + subjectCategory
				+ "Topic " + subjectTopic + " Coursetag_Field:" + CourseTags
				+ " CourseCredits :" + CourseCredits + " CourseExtraCredits :"
				+ CourseExtraCredits + " Course_Duration :" + CourseDuration
				+ " CourseDurationUnit :" + CourseDurationUnit);

		Integer courseId = 0, courseDuration = 0, courseDurationUnit = 1, subjClassificationId = 0;

		try {
			courseId = Integer.parseInt(CourseId);
		} catch (NumberFormatException nfe) {
			LOGGER.debug(" Class :"
					+ getClass()
					+ " Method: saveCourse() : NumberFormatException : courseId :"
					+ nfe);
		}
		try {
			courseDuration = Integer.parseInt(CourseDuration);
			courseDurationUnit = Integer.parseInt(CourseDurationUnit);
		} catch (NumberFormatException nf) {
			LOGGER.debug(" Class :"
					+ getClass()
					+ " Method: saveCourse() : NumberFormatException : courseDurationUnit"
					+ nf);
		}

		MemberPersona accountableMember = new MemberPersona();
		accountableMember.setMemberRoleId(Integer.valueOf(ThreadLocalUtil
				.getToken().getMemberPersonaId().getStorageID()));

		// Service call for Course

		CourseSubjectClassification courseSubjectClassification = courseSubjectDetailService
				.getSubjectClassification(subjectTopic);
		LOGGER.debug(" Class :" + getClass()
				+ " Method: saveCourse() courseSubjectClassification :"
				+ courseSubjectClassification);
		Course courseObj = null;

		try {

			// Creating Course Object for adding parameters
			Course course = new Course();

			if (courseId > 0) {
				course.setCourseId(courseId);
				course.setName(CourseName);
				course.setDescription(CourseDescription);
				course.setCourseStatus(CourseStatus.UNDER_CONSTRUCT);
				course.setCourseStatusId(CourseStatus.UNDER_CONSTRUCT.getID());
				course.setAccountableMember(accountableMember);
				course.setSecurityIndicator(true);
				course.setCourseCredits(CourseCredits);
				course.setExtraCredits(CourseExtraCredits);
				course.setAdditionalInfoIndicator(true);
				Duration duration = new Duration(courseDuration,
						courseDurationUnit);
				course.setCourseDuration(duration);
				course.setThumbnailPicturePath(UploadImage);
				course.setVersion(1);
				course.setSubjClassificationId(courseSubjectClassification
						.getSubjClassificationId());

			} else {
				course.setName(CourseName);
				course.setDescription(CourseDescription);
				course.setCourseCredits(CourseCredits);
				course.setExtraCredits(CourseExtraCredits);
				course.setThumbnailPicturePath(UploadImage);
				course.setCourseStatus(CourseStatus.UNDER_CONSTRUCT);
				course.setCourseStatusId(CourseStatus.UNDER_CONSTRUCT.getID());
				course.setAdditionalInfoIndicator(true);
				course.setIsDelete(false);
				course.setVersion(1);
				course.setSubjClassificationId(subjClassificationId);
				Duration duration = new Duration(courseDuration,
						courseDurationUnit);
				course.setCourseDuration(duration);
				course.setSecurityIndicator(true);
				course.setAccountableMember(accountableMember);
				course.setSubjClassificationId(courseSubjectClassification
						.getSubjClassificationId());

			}

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
					+ CourseDescription + " Subject_Area:" + subjectArea
					+ "Subject " + subjectCategory + "Topic " + subjectTopic
					+ " CourseCredits :" + CourseCredits
					+ " CourseExtraCredits :" + CourseExtraCredits
					+ " courseDuration :" + courseDuration + "-" + e);

		}

		Integer courseIds = 0;
		try {
			courseIds = Integer
					.parseInt(courseObj.getCourseId().getStorageID());
		} catch (Exception e) {
			LOGGER.info("Class :"
					+ getClass()
					+ " Method saveCourse : After courseService: CourseId Exception :"
					+ e);
		}
		if (courseIds > 0 && courseId > 0) {
			CourseTagcloud tagcloud = new CourseTagcloud();
			try {
				CourseTagcloud getTagcloud = tagCloudService
						.getCourseTagClouds(courseId);
				tagcloud.setTagCloudId(getTagcloud.getTagCloudId());
				tagcloud.setCourseTagCloudId(getTagcloud.getTagCloudId());
				tagcloud.setTagName(CourseTags);
				getTagcloud.setZeniSuggestedIndicator(true);
//				tagcloud.setCourseId(courseIds);
//				try {
//					tagcloud.setTagType(TagType.TAG_TYPE1);
//				} catch (NoSuchMethodException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				tagcloud.setCourseId(courseIds);
				tagCloudService.saveOrUpadteTags(tagcloud);

				LOGGER.info("Class :"
						+ getClass()
						+ " Method saveOrUpadteTags : After courseService: Update CourseId Exception :tagcloud");
			} catch (Exception e) {
				LOGGER.info("Class :"
						+ getClass()
						+ " Method saveCourse : After courseService: CourseId Exception :Update tagcloud"
						+ tagcloud + e);
			}
		} else if (courseIds > 0) {
			CourseTagcloud tagcloud = new CourseTagcloud();
			try {
				tagcloud.setTagName(CourseTags);
				try {
					tagcloud.setTagType(TagType.TAG_TYPE1);
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tagcloud.setCourseId(courseIds);
				tagCloudService.saveOrUpadteTags(tagcloud);
				LOGGER.info("Class :"
						+ getClass()
						+ " Method saveOrUpadteTags : After courseService: Save CourseId Exception :tagcloud");
			} catch (Exception e) {
				LOGGER.info("Class :"
						+ getClass()
						+ " Method saveCourse : After courseService: CourseId Exception : Save tagcloud"
						+ tagcloud + e);
			}
		}
		CourseJsonResponse json = new CourseJsonResponse();

		if (courseIds == 0) {
			json.setResponse("failed");
			LOGGER.info("Class :" + getClass()
					+ " Method saveCourse : After courseService: CourseId :"
					+ CourseId);
		} else {
			json.setId("COURSE_" + courseIds);
			json.setResponse("success");
			// IF COURSE CREATION SUCCESSFUL ASSOCIATE CURRICULUM COURSE
			// get Course BY courseId
			Course course = new Course();
			course = courseService.getCourseByCourseId(courseIds);
			// Ensure only Educator(207) if SUCCESS create a new curriculam
			// course
			if (course.getMemberRoleId() == 207) {

				Integer curriculamId = courseService.createNewCurriculamCourse(
						course.getCoursesId(), course.getMemberRoleId());
				System.out.println("curriculamId == >" + curriculamId);
				if (curriculamId == 1) {
					courseService.getCurriculamCourseByCourseId(course
							.getCoursesId());
				}
			}
			LOGGER.info("Class :" + getClass()
					+ " Method saveCourse : After courseService: CourseId :"
					+ CourseId);
		}

		LOGGER.info("Exiting Class " + getClass() + " saveCourse(): CourseId :"
				+ " Course Name :" + CourseName + " CourseDescription:"
				+ CourseDescription + " Subject_Area:" + subjectArea
				+ "Subject " + subjectCategory + "Topic " + subjectTopic
				+ " CourseCredits :" + CourseCredits + " CourseExtraCredits :"
				+ CourseExtraCredits + " courseDuration :" + courseDuration);

		return json;
	}

	@RequestMapping(value = "/saveLearningComponent", method = RequestMethod.POST)
	public @ResponseBody
	CourseJsonResponse saveCourseComponents(
			@RequestParam(value = "Course_id", required = true) String CourseId,
			@RequestParam(value = "CourseLearningComponentId", required = false) String CourseLearningComponentId,
			@RequestParam(value = "LearningComponentId", required = false) String LearningComponentId,
			@RequestParam(value = "Course_Module", required = true) String CourseModule,
			@RequestParam(value = "Module_Description", required = false) String CourseModuleDescription,
			@RequestParam(value = "Subject_Area", required = false) String Subject_Area,
			@RequestParam(value = "Subject", required = false) String Subject,
			@RequestParam(value = "Topic", required = false) String subjectTopic,
			@RequestParam(value = "Moduletag_Field", required = false) String ModuleTags,
			@RequestParam(value = "Module_Weight", required = false) String ModuleWeight,
			@RequestParam(value = "LearningObject", required = false) String LearningObject,
			@RequestParam(value = "Module_Duration", required = false) String Duration,
			@RequestParam(value = "ModuleDuration_Type", required = false) String UnitofDuration,
			@RequestParam(value = "Assoc_Image", required = false) String UploadImage

	) throws CourseException {
		LOGGER.info("Entering Class " + getClass()
				+ " saveCourseComponents(): courseId :" + CourseId
				+ "CourseLearningComponentId :" + CourseLearningComponentId
				+ " CourseModule :" + CourseModule
				+ " CourseModuleDescription :" + CourseModuleDescription
				+ " ModuleTags :" + ModuleTags + " ModuleWeight :"
				+ ModuleWeight + " LearningObject :" + LearningObject
				+ " Duration :" + Duration + " UnitofDuration :"
				+ UnitofDuration + " UploadImage :" + UploadImage);

		Integer courseid = 0, courseLearningComponentId = 0, learningComponentId = 0;
		try {
			courseid = Integer.parseInt(CourseId.split("_")[1]);
			LOGGER.info("Entering Class " + getClass()
					+ " saveCourseComponents(): courseid :" + courseid);
		} catch (NumberFormatException nfe) {
			LOGGER.error("NumberFormatException courseid :" + courseid + nfe);
		}

		try {
			courseLearningComponentId = Integer
					.parseInt(CourseLearningComponentId);
			LOGGER.info("Entering Class " + getClass()
					+ " saveCourseComponents(): courseLearningComponentId :"
					+ courseLearningComponentId);
		} catch (NumberFormatException nfe) {
			LOGGER.error("Class "
					+ getClass()
					+ " saveCourseComponents(): NumberFormatException courseLearningComponentId :"
					+ courseLearningComponentId + nfe);
		}

		try {
			learningComponentId = Integer.parseInt(LearningComponentId);
			LOGGER.info("Entering Class " + getClass()
					+ " saveCourseComponents(): learningComponentId :"
					+ learningComponentId);
		} catch (NumberFormatException nfe) {
			LOGGER.error("NumberFormatException learningComponentId :"
					+ learningComponentId + nfe);
		}
		Integer courseDuration = 0, unitofDuration = 1, moduleWeight = 0;
		try {
			courseDuration = Integer.parseInt(Duration);
			unitofDuration = Integer.parseInt(UnitofDuration);
		} catch (NumberFormatException nfe) {
			LOGGER.debug(" Class :"
					+ getClass()
					+ " Method: saveCourse : NumberFormatException : courseDuration:"
					+ courseDuration + nfe);
		}

		try {
			moduleWeight = Integer.parseInt(ModuleWeight);
		} catch (NumberFormatException nfe) {
			LOGGER.debug(" Class :"
					+ getClass()
					+ " Method: saveCourse : NumberFormatException : moduleWeight :"
					+ moduleWeight + nfe);
		}

		CourseSubjectClassification courseSubjectClassification = courseSubjectDetailService
				.getSubjectClassification(subjectTopic);

		MemberPersona accountableMember = new MemberPersona();
		accountableMember.setMemberRoleId(Integer.valueOf(ThreadLocalUtil
				.getToken().getMemberPersonaId().getStorageID()));

		Course courseObj = null;
		try {
			List<CourseLearningComponent> compList = new ArrayList<CourseLearningComponent>();
			List<CourseTagcloud> tagcloudList = new ArrayList<CourseTagcloud>();
			Course course = new Course();
			course.setCourseId(courseid);
			course.setAccountableMember(accountableMember);
			course.setCourseStatus(CourseStatus.UNDER_CONSTRUCT);
			course.setCourseStatusId(CourseStatus.UNDER_CONSTRUCT.getID());

			if (courseLearningComponentId > 0 && learningComponentId > 0) {

				LearningComponent comp1 = new LearningComponent();
				comp1.setLearningComponentId(learningComponentId);
				comp1.setAuthoredMember(accountableMember);
				comp1.setName(CourseModule);
				comp1.setDescription(CourseModuleDescription);
				comp1.setThumbnailPicturePath(UploadImage);
				Duration prescribedDuration = new Duration(courseDuration,
						unitofDuration);
				comp1.setPrescribedDuration(prescribedDuration);
				comp1.setSubjClassificationId(courseSubjectClassification
						.getSubjClassificationId());

				// Learning Component Nesting

				LearningComponentNest compNest1 = new LearningComponentNest(
						null, comp1);
				compNest1.setNestLevel(0);

				// Learning Component Nesting

				compNest1.setNestLearningComponent(comp1);
				LearningComponentDetails compDetails1 = new LearningComponentDetails();
				compDetails1.setLearningComponentNest(compNest1);

				LearningComponentType compType1 = new LearningComponentType();
				compType1.setLearningComponentTypeId(1);

				comp1.setLearningComponentType(compType1);

				CourseLearningComponent corComp1 = new CourseLearningComponent();
				corComp1.setCourseLearningComponentId(courseLearningComponentId);
				corComp1.setLearningComponent(comp1);
				corComp1.setLearningComponentType(compType1);
				corComp1.setCourse(course);

				compDetails1.setCourseLearningComponent(corComp1);

				comp1.setLearningComponentDetails(compDetails1);

				compList.add(corComp1);

				CourseDetails courseDetails = new CourseDetails();

				courseDetails.setCourseLearningComponentsList(compList);

				course.setCourseDetails(courseDetails);
				LOGGER.error("Entering Class "
						+ getClass()
						+ " saveCourseComponents() After Edit Module service : courseId :"
						+ CourseId + " getting course " + course);

			} else {

				LearningComponent comp1 = new LearningComponent();
				comp1.setAuthoredMember(accountableMember);
				comp1.setName(CourseModule);
				comp1.setDescription(CourseModuleDescription);
				comp1.setThumbnailPicturePath(UploadImage);
				Duration prescribedDuration = new Duration(courseDuration,
						unitofDuration);
				comp1.setPrescribedDuration(prescribedDuration);
				comp1.setSubjClassificationId(courseSubjectClassification
						.getSubjClassificationId());

				// Learning Component Nesting

				LearningComponentNest compNest1 = new LearningComponentNest(
						null, comp1);
				compNest1.setNestLevel(0);

				// Learning Component Nesting

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

				LOGGER.error("Entering Class "
						+ getClass()
						+ " saveCourseComponents() After Add Module service : courseId :"
						+ CourseId + " getting course " + course);

			}
			System.out.println("Constructed Course : " + course);

			LOGGER.error("Entering Class "
					+ getClass()
					+ " saveCourseComponents() before calling service : courseId :"
					+ CourseId + " getting course " + course);

			// Saving the course Object
			courseObj = courseService.saveOrUpadteCourseComponents(course);

			LOGGER.error("Entering Class "
					+ getClass()
					+ " saveCourseComponents() after calling service : courseId :"
					+ CourseId + " getting course " + course);

		} catch (Exception e) {
			LOGGER.debug("Class :" + getClass()
					+ "Method : saveCourseComponents :Exception :"
					+ e.getMessage());

		}
		Integer courseIds = 0;
		try {
			courseIds = Integer
					.parseInt(courseObj.getCourseId().getStorageID());
		} catch (Exception e) {
			LOGGER.info("Class :"
					+ getClass()
					+ " Method saveCourse : After courseService: CourseId Exception :"
					+ e);
		}

		CourseJsonResponse json = new CourseJsonResponse();

		if (courseIds == 0) {
			json.setResponse("failed");

			LOGGER.info("Class :" + getClass()
					+ " Method saveCourse : After courseService: CourseId :"
					+ CourseId);
		} else {
			json.setId("COURSE_" + courseIds);
			json.setResponse("success");
			LOGGER.info("Class :" + getClass()
					+ " Method saveCourse : After courseService: CourseId :"
					+ CourseId);
		}
		return json;
	}

	@RequestMapping(value = "/removeCourse/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	CourseJsonResponse removeCourse(@PathVariable String courseId)
			throws CourseException {
		LOGGER.info("Entering Class " + getClass()
				+ " removeCourse(): CourseId :" + courseId);

		Integer courseIds = 0;
		try {
			courseIds = Integer.parseInt(courseId.split("_")[1]);
		} catch (NumberFormatException nfe) {
			LOGGER.debug(" Class :" + getClass()
					+ " Method: removeCourse : NumberFormatException" + nfe);
		}
		courseService.removeCourse(courseIds);

		CourseJsonResponse json = new CourseJsonResponse();

		json.setId(courseId);
		json.setResponse("success");
		LOGGER.info("Class :" + getClass()
				+ " Method removeCourse : After courseService: CourseId :"
				+ courseId);

		return json;

	}

	@RequestMapping(value = "/removeCourseComponents", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	CourseJsonResponse removeCourseComponents(
			@RequestParam(value = "Course_id", required = true) String CourseId,
			@RequestParam(value = "Component_id", required = true) String learningComponentId)
			throws CourseException {
		LOGGER.info("Entering Class " + getClass()
				+ " removeCourseComponents(): CourseId :" + CourseId
				+ " ComponentId :" + learningComponentId);

		Integer learningCompId = 0;
		try {
			learningCompId = Integer
					.parseInt(learningComponentId.split("_")[1]);
		} catch (NumberFormatException nfe) {
			LOGGER.debug(" Class :" + getClass()
					+ " Method: removeCourseComponents : NumberFormatException"
					+ nfe);
		}
		courseService.removeCourseComponents(learningCompId);

		CourseJsonResponse json = new CourseJsonResponse();

		json.setId(CourseId);
		json.setResponse("success");

		LOGGER.info("Class :"
				+ getClass()
				+ " Method removeCourseComponents : After courseService: CourseId :"
				+ CourseId);

		return json;

	}

	@RequestMapping(value = "/removeCourseContents", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	CourseJsonResponse removeCourseContents(
			@RequestParam(value = "Course_id", required = true) String CourseId,
			@RequestParam(value = "Content_id", required = true) String learningContentId)
			throws CourseException {
		LOGGER.info("Entering Class " + getClass()
				+ " removeCourseContents(): CourseId :" + CourseId
				+ " ComponentId :" + learningContentId);

		Integer learningContId = 0;
		try {
			learningContId = Integer.parseInt(learningContentId.split("_")[1]);
		} catch (NumberFormatException nfe) {
			LOGGER.debug(" Class :" + getClass()
					+ " Method: removeCourseContents : NumberFormatException"
					+ nfe);
		}
		courseService.learningContentdelete(learningContId);
		CourseJsonResponse json = new CourseJsonResponse();
		json.setId(CourseId);
		json.setResponse("success");
		LOGGER.info("Class :"
				+ getClass()
				+ " Method removeCourseContents : After courseService: CourseId :"
				+ CourseId);

		return json;

	}

	@RequestMapping(value = "/getCourse", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	CourseEditResponse getCourse(
			@RequestParam(value = "Course_id", required = true) String CourseId)
			throws CourseException {
		LOGGER.info("Entering Class " + getClass() + " getCourse(): CourseId :"
				+ CourseId);

		Integer courseid = 0;
		try {
			courseid = Integer.parseInt(CourseId.split("_")[1]);
		} catch (NumberFormatException nfe) {
			LOGGER.error("NumberFormatException :" + nfe);
		}
		String selected_tags = "";
		String available_tags = "";
		CourseTagcloud tag = null;
		try {
			tag = tagCloudService.getCourseTagClouds(courseid);
			selected_tags = tag.getTagName();
			available_tags = tag.getTagName();
		} catch (Exception e) {
			LOGGER.error("tag Exception :" + tag);
		}

		CourseEditResponse json = null;
		json = courseEditService.getCourseDetails(courseid);
		json.setResponse("success");
		json.setSelected_tags(selected_tags);
		json.setAvailable_tags(available_tags);

		LOGGER.info("Exiting Class " + getClass() + " getCourse(): CourseId :"
				+ CourseId + " json :" + json);

		return json;
	}

	@RequestMapping(value = "/getCourseModule", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModuleEditResponse getCourseModule(
			@RequestParam(value = "Course_id", required = true) String CourseId,
			@RequestParam(value = "Component_id", required = true) String ComponentId)
			throws CourseException {
		LOGGER.info("Entering Class " + getClass()
				+ " getCourseModule(): CourseId :" + CourseId
				+ " learningComponentId :" + ComponentId);

		Integer courseid = 0, learningComponentId = 0;
		try {
			courseid = Integer.parseInt(CourseId.split("_")[1]);
			learningComponentId = Integer.parseInt(ComponentId.split("_")[1]);
		} catch (NumberFormatException nfe) {
			LOGGER.error("NumberFormatException :" + nfe);
		}

		ModuleEditResponse json = null;
		json = courseEditService.getModuleDetails(learningComponentId);
		json.setResponse("success");

		LOGGER.info("Exiting Class " + getClass() + " getCourse(): CourseId :"
				+ CourseId + " learningComponentId :" + ComponentId + " json :"
				+ json);

		return json;
	}

	@RequestMapping(value = "/searchCourseComponents", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView searchCourseComponents(@RequestParam String memberRoleId,
			@RequestParam String searchIndicator,
			@RequestParam LearningComponent learningComponent) {
		LOGGER.info("Entering Class " + getClass()
				+ "searchCourseComponents(): coursename :" + memberRoleId
				+ " coursedescription :" + searchIndicator);

		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.info("Exiting Class " + getClass()
				+ "searchCourseComponents(): ");

		return mv;
	}
}