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

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseDetails;
import com.ziksana.domain.course.CourseEditResponse;
import com.ziksana.domain.course.CourseJsonResponse;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.CourseTagcloud;
import com.ziksana.domain.course.Duration;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentDetails;
import com.ziksana.domain.course.LearningComponentNest;
import com.ziksana.domain.course.LearningComponentType;
import com.ziksana.domain.course.ModuleEditResponse;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.course.CourseEditService;
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
	CourseEditService courseEditService;

	@Autowired
	CourseTreeNodeService courseTreeNodeService;

	@RequestMapping(value = "/createcourse", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView showCourse() {
		LOGGER.info(" Entering Class " + getClass() + " showCourse()");
		ModelAndView mv = new ModelAndView("courses/definecourse");
		LOGGER.info("Class " + getClass() + "Exiting showCourse(): ");
		return mv;
	}

	@RequestMapping(value = "/createcourse/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showMyCourse(@PathVariable String courseId) {
		LOGGER.info(" Entering Class " + getClass() + " showCourse()");

		Integer course_id = Integer.parseInt(courseId.split("_")[1]);
		ModelAndView modelView = null;
		if (course_id > 0) {
			modelView = new ModelAndView("courses/coursecreation");
			modelView.addObject("CourseId", course_id);
		} else {
			modelView = new ModelAndView("courses/definecourse");
			modelView.addObject("CourseId", course_id);
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
		ModelAndView modelView = null;
		if (course_id > 0) {
			modelView = new ModelAndView("courses/coursecreation");
			modelView.addObject("CourseId", course_id);
		} else {
			modelView = new ModelAndView("courses/definecourse");
			modelView.addObject("CourseId", course_id);
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
			@RequestParam(value = "Subject_Area", required = false) String Subject_Area,
			@RequestParam(value = "Subject", required = false) String Subject,
			@RequestParam(value = "Topic", required = false) String Topic,
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
				+ " Subject_Area:" + Subject_Area + "Subject " + Subject
				+ "Topic " + Topic + " Coursetag_Field:" + CourseTags
				+ " CourseCredits :" + CourseCredits + " CourseExtraCredits :"
				+ CourseExtraCredits + " Course_Duration :" + CourseDuration
				+ " CourseDurationUnit :" + CourseDurationUnit);

		Integer courseDuration = 0, courseId = 0, courseDurationUnit = 1, subjClassificationId = 0;

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

		try {
			subjClassificationId = Integer.parseInt(Topic);
		} catch (NumberFormatException fe) {
			LOGGER.debug(" Class :"
					+ getClass()
					+ " Method: saveCourse() : NumberFormatException : subjClassificationId"
					+ fe);
		}

		ZID memberId = new StringZID("1001");
		ZID memberPersonaId = new StringZID("201");
		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		ThreadLocalUtil.setToken(token);

		LOGGER.debug(" Class :"
				+ getClass()
				+ " Method: saveCourse() : setMemberRoleId"
				+ Integer.valueOf(ThreadLocalUtil.getToken()
						.getMemberPersonaId().getStorageID()));

		MemberPersona accountableMember = new MemberPersona();
		accountableMember.setMemberRoleId(Integer.valueOf(ThreadLocalUtil
				.getToken().getMemberPersonaId().getStorageID()));

		// Service call for Course

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
				course.setAdditionalInfoIndicator(true);
				Duration duration = new Duration(courseDuration,
						courseDurationUnit);
				course.setCourseDuration(duration);
				course.setThumbnailPicturePath(UploadImage);
				course.setVersion(1);

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
					+ CourseDescription + " Subject_Area:" + Subject_Area
					+ "Subject " + Subject + "Topic " + Topic
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

		CourseJsonResponse json = new CourseJsonResponse();

		if (courseIds == 0) {
			json.setResponse("failed");
			json.setMessage("Course Creation Failed!");
			LOGGER.info("Class :" + getClass()
					+ " Method saveCourse : After courseService: CourseId :"
					+ CourseId);
		} else {
			json.setId("COURSE_" + courseIds);
			json.setResponse("success");
			json.setMessage("Course Creation Success");

			LOGGER.info("Class :" + getClass()
					+ " Method saveCourse : After courseService: CourseId :"
					+ CourseId);
		}

		LOGGER.info("Exiting Class " + getClass() + " saveCourse(): CourseId :"
				+ " Course Name :" + CourseName + " CourseDescription:"
				+ CourseDescription + " Subject_Area:" + Subject_Area
				+ "Subject " + Subject + "Topic " + Topic + " CourseCredits :"
				+ CourseCredits + " CourseExtraCredits :" + CourseExtraCredits
				+ " courseDuration :" + courseDuration);

		return json;
	}

	@RequestMapping(value = "/saveLearningComponent", method = RequestMethod.POST)
	public @ResponseBody
	CourseJsonResponse saveCourseComponents(
			@RequestParam(value = "Course_id", required = true) String CourseId,
			@RequestParam(value = "Course_Module", required = true) String CourseModule,
			@RequestParam(value = "Module_Description", required = true) String CourseModuleDescription,
			@RequestParam(value = "Subject_Area", required = true) String Subject_Area,
			@RequestParam(value = "Subject", required = true) String Subject,
			@RequestParam(value = "Topic", required = true) String Topic,
			@RequestParam(value = "Moduletag_Field", required = true) String ModuleTags,
			@RequestParam(value = "Module_Weight", required = false) String ModuleWeight,
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

		Integer courseid = 0;
		try {
			courseid = Integer.parseInt(CourseId.split("_")[1]);
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
			course.setDescription(CourseModuleDescription);

			LearningComponent comp1 = new LearningComponent();
			comp1.setAuthoredMember(accountableMember);

			comp1.setName(CourseModule);
			LearningComponentNest compNest1 = new LearningComponentNest(null,
					comp1);
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
		json.setMessage("Course Delete Success");
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
		json.setMessage("Component Delete Success");
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
		json.setMessage("Component Delete Success");
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

		CourseEditResponse json = null;

		json = courseEditService.getCourseDetails(courseid);
		json.setResponse("success");
		json.setSubjectarea("Computer science, knowledge & systems");
		json.setSubject("Bibliography");
		json.setTopic("Bibliography");
		json.setMessage("Course Edit Details");

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
		json = courseEditService
				.getModuleDetails(learningComponentId);
		json.setResponse("success");
		json.setSubjectarea("Computer science, knowledge & systems");
		json.setSubject("Bibliography");
		json.setTopic("Bibliography");
		json.setMessage("Course Edit Details");

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
		LOGGER.info("Entering  Class " + getClass()
				+ "searchCourseComponents(): coursename :" + memberRoleId
				+ " coursedescription :" + searchIndicator);

		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.info("Exiting  Class " + getClass()
				+ "searchCourseComponents(): ");

		return mv;
	}
}
