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

import com.ziksana.domain.assessment.TagType;
import com.ziksana.domain.common.MediaServerURL;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseEditResponse;
import com.ziksana.domain.course.CourseJsonResponse;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.CourseSubjectClassification;
import com.ziksana.domain.course.CourseTagcloud;
import com.ziksana.domain.course.Duration;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.exception.course.CourseException;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.course.CourseEditService;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.course.CourseSubjectDetailService;
import com.ziksana.service.course.CourseTreeNodeService;
import com.ziksana.service.course.LearningComponentTagCloudService;
import com.ziksana.service.course.TagCloudService;
import com.ziksana.service.security.MediaService;

/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/zcourse")
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
	LearningComponentTagCloudService learningComponentTagCloudService;

	@Autowired
	CourseSubjectDetailService courseSubjectDetailService;

	@Autowired
	CourseTreeNodeService courseTreeNodeService;

	@Autowired
	MediaService mediaService;

	MediaServerURL mediaServerURL = new MediaServerURL();

	@RequestMapping(value = "/iscourseexists", method = { RequestMethod.POST })
	public @ResponseBody
	String isCourseNameExists(
			@RequestParam(value = "courseId", required = false) String courseId,
			@RequestParam(value = "courseName", required = true) String courseName) {

		String iscourseExists = null;
		try {
			int courseCount;
			if (courseId.isEmpty()) {
				LOGGER.debug("CourseId is Empty");
				courseCount = courseService.isCourseNameExists(
						CourseStatus.DRAFT, courseName);
				LOGGER.debug("courseCount is :" + courseCount);
				if (courseCount == 0) {
					// Allow user to create a new course
					iscourseExists = "COURSE NOT EXISTS";
				} else {
					// Don't allow user to create a new course
					iscourseExists = "COURSE EXISTS";
				}
			} else {
				LOGGER.debug("CourseId is not is Empty");
				courseCount = courseService.getCoursesByCoursename(
						CourseStatus.DRAFT, courseName,
						Integer.parseInt(courseId));

				LOGGER.debug("courseCount is :" + courseCount);
				if (courseCount >= 1) {
					// Allow user to create a new course
					iscourseExists = "COURSE ALREADY EXISTS";
				} else {
					// Don't allow user to create a new course
					iscourseExists = "COURSE NOT EXISTS";
				}
			}
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return iscourseExists;

	}

	@RequestMapping(value = "/ismoduleexists/{courseId}", method = { RequestMethod.GET })
	public @ResponseBody
	int isModuleExists(@PathVariable String courseId) {
		// TODO this method should return Integer
		int isModuleExists = 0;
		Integer course_id = Integer.parseInt(courseId.split("_")[1]);
		try {
			isModuleExists = courseService.isModuleExists(course_id);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Module Size= >" + isModuleExists);
		return isModuleExists;
	}

	@RequestMapping(value = "/createcourse", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView createNewCourse() {
		LOGGER.debug(" Entering Class " + getClass() + " showCourse()");
		ModelAndView mv = new ModelAndView("mastercreatecourse");
		try {
			mediaServerURL = mediaService.getMediaContents();
			mv.addObject("ms", mediaServerURL);
			mv.addObject("pageTitle", "CreateCourse");
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Class " + getClass() + "Exiting showCourse(): ");
		return mv;
	}

	@RequestMapping(value = "/editcourse/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showMyEditCourse(@PathVariable String courseId) {
		LOGGER.debug(" Entering Class " + getClass() + " showCourse()");

		ModelAndView modelView = null;
		try {
			Integer course_id = Integer.parseInt(courseId.split("_")[1]);

			int isModuleExists = 0;
			if (course_id != null) {
				isModuleExists = courseService.isModuleExists(course_id);
				LOGGER.debug("Module Size= >" + isModuleExists);
			}
			if (course_id > 0) {
				CourseTagcloud tag = null;
				tag = tagCloudService.getCourseTagClouds(course_id);
				String selected_tags = tag.getTagName();

				modelView = new ModelAndView("mastercreatecourse");
				mediaServerURL = mediaService.getMediaContents();
				modelView.addObject("CourseId", course_id);
				modelView.addObject("selected_tags", selected_tags);
				modelView.addObject("courseId", courseId);
				modelView.addObject("ms", mediaServerURL);
				modelView.addObject("module", isModuleExists);
			} else {
				modelView = new ModelAndView("mastercreatecourse");
				mediaServerURL = mediaService.getMediaContents();
				modelView.addObject("CourseId", course_id);
				modelView.addObject("ms", mediaServerURL);
				modelView.addObject("courseId", courseId);
				modelView.addObject("module", isModuleExists);
			}
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Class " + getClass() + "Exiting showCourse(): ");
		return modelView;
	}

	@RequestMapping(value = "/createcourse/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView editCourse(@PathVariable String courseId) {
		LOGGER.debug(" Entering Class " + getClass() + " showCourse()");
		ModelAndView modelView = null;
		Integer course_id = 0;

		try {
			course_id = Integer.parseInt(courseId.split("_")[1]);
		} catch (Exception e) {
		}

		try {
			int isModuleExists = 0;
			if (course_id != null) {
				isModuleExists = courseService.isModuleExists(course_id);
				LOGGER.debug("Module Size= >" + isModuleExists);
			}
			mediaServerURL = mediaService.getMediaContents();
			if (course_id > 0) {
				modelView = new ModelAndView("mastercreatemodule");
				modelView.addObject("CourseId", course_id);
				modelView.addObject("ms", mediaServerURL);
				modelView.addObject("module", isModuleExists);
			} else {
				modelView = new ModelAndView("mastercreatecourse");
				modelView.addObject("CourseId", course_id);
				modelView.addObject("ms", mediaServerURL);
				modelView.addObject("module", isModuleExists);
			}

			LOGGER.debug("Class " + getClass() + "Exiting showCourse(): ");
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return modelView;
	}

	@RequestMapping(value = "/savecourse", method = RequestMethod.POST)
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
			@RequestParam(value = "Assoc_Image", required = false) String UploadImage) {
		LOGGER.debug("Entering Class " + getClass()
				+ " saveCourse(): CourseId :" + CourseId + " CourseName :"
				+ CourseName + " CourseDescription :" + CourseDescription
				+ " Subject_Area:" + subjectArea + "Subject " + subjectCategory
				+ "Topic " + subjectTopic + " Coursetag_Field:" + CourseTags
				+ " CourseCredits :" + CourseCredits + " CourseExtraCredits :"
				+ CourseExtraCredits + " Course_Duration :" + CourseDuration
				+ " CourseDurationUnit :" + CourseDurationUnit);

		Integer courseId = 0, courseDuration = 0, courseDurationUnit = 1, subjClassificationId = 0, courseIds = 0;
		CourseJsonResponse json = new CourseJsonResponse();

		try {

			MemberPersona accountableMember = new MemberPersona();
			accountableMember.setMemberRoleId(Integer.valueOf(SecurityTokenUtil
					.getToken().getMemberPersonaId().getStorageID()));

			// Service call for Course

			CourseSubjectClassification courseSubjectClassification = courseSubjectDetailService
					.getSubjectClassification(subjectTopic);
			LOGGER.debug(" Class :" + getClass()
					+ " Method: saveCourse() courseSubjectClassification :"
					+ courseSubjectClassification);
			Course courseObj = null;
			// Creating Course Object for adding parameters
			Course course = new Course();

			try {
				courseId = Integer.parseInt(CourseId.split("_")[1]);
				LOGGER.info("Course id  exist :" + courseId);
			} catch (Exception e) {
				LOGGER.info("Course id not exist :" + e);

			}

			if (!"".equals(CourseDuration) && CourseDuration != null) {
				courseDuration = Integer.parseInt(CourseDuration);
			}
			if (!"".equals(CourseDurationUnit) && CourseDurationUnit != null) {
				courseDurationUnit = Integer.parseInt(CourseDurationUnit);
			}

			if (courseId != null && courseId != 0) {
				course.setCourseId(courseId);
				course.setName(CourseName);
				course.setDescription(CourseDescription);

				course.setCourseStatus(CourseStatus.getCourseStatus(586));
				try {
					course.setCourseStatusId(CourseStatus.valueOf(
							"DRAFT".toUpperCase()).getID());
					LOGGER.info("CourseStatus.valueOf(DRAFT.toUpperCase()).getID()"
							+ CourseStatus.valueOf("DRAFT".toUpperCase())
									.getID());
				} catch (Exception e) {
					course.setCourseStatusId(586);
					LOGGER.error("Exception :CourseStatus.valueOf(DRAFT.toUpperCase()).getID()"
							+ CourseStatus.valueOf("DRAFT".toUpperCase())
									.getID());
				}

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
				try {
					course.setSubjClassificationId(courseSubjectClassification
							.getSubjClassificationId());
				} catch (Exception e) {

				}
			} else {
				course.setName(CourseName);
				course.setDescription(CourseDescription);
				course.setCourseCredits(CourseCredits);
				course.setExtraCredits(CourseExtraCredits);
				course.setThumbnailPicturePath(UploadImage);

				course.setCourseStatus(CourseStatus.getCourseStatus(586));
				try {
					course.setCourseStatusId(CourseStatus.valueOf(
							"DRAFT".toUpperCase()).getID());
					LOGGER.info("CourseStatus.valueOf(DRAFT.toUpperCase()).getID()"
							+ CourseStatus.valueOf("DRAFT".toUpperCase())
									.getID());
				} catch (Exception e) {
					course.setCourseStatusId(586);
					LOGGER.error("Exception :CourseStatus.valueOf(DRAFT.toUpperCase()).getID()"
							+ CourseStatus.valueOf("DRAFT".toUpperCase())
									.getID());
				}

				course.setAdditionalInfoIndicator(true);
				course.setIsDelete(false);
				course.setVersion(1);
				course.setSubjClassificationId(subjClassificationId);
				Duration duration = new Duration(courseDuration,
						courseDurationUnit);
				course.setCourseDuration(duration);
				course.setSecurityIndicator(true);
				course.setAccountableMember(accountableMember);
				try {
					course.setSubjClassificationId(courseSubjectClassification
							.getSubjClassificationId());
				} catch (Exception e) {

				}

			}

			LOGGER.debug("Class :" + getClass()
					+ " Method saveCourse :Before courseService:" + course);

			// Return the course Object
			courseObj = courseService.saveOrUpdateCourse(course);
			LOGGER.debug("Class :" + getClass()
					+ " Method saveCourse : After courseService:" + courseObj);

			courseIds = Integer
					.parseInt(courseObj.getCourseId().getStorageID());
			if (courseIds > 0 && courseId > 0) {
				CourseTagcloud tagcloud = new CourseTagcloud();
				CourseTagcloud getTagcloud = tagCloudService
						.getCourseTagClouds(courseId);
				tagcloud.setTagCloudId(getTagcloud.getTagCloudId());
				tagcloud.setCourseTagCloudId(getTagcloud.getTagCloudId());
				tagcloud.setTagName(CourseTags);
				getTagcloud.setZeniSuggestedIndicator(true);
				tagcloud.setCourseId(courseIds);
				tagCloudService.saveOrUpadteTags(tagcloud);

				LOGGER.debug("Class :"
						+ getClass()
						+ " Method saveOrUpadteTags : After courseService: Update CourseId Exception :tagcloud");
			} else if (courseIds > 0) {
				CourseTagcloud tagcloud = new CourseTagcloud();
				tagcloud.setTagName(CourseTags);
				tagcloud.setTagType(TagType.TAG_TYPE1);
				tagcloud.setCourseId(courseIds);
				tagCloudService.saveOrUpadteTags(tagcloud);
				LOGGER.debug("Class :"
						+ getClass()
						+ " Method saveOrUpadteTags : After courseService: Save CourseId Exception :tagcloud");
			}

		} catch (CourseException exception) {
			LOGGER.error(exception.getMessage(), exception);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO no statck trace for above errors

		if (courseIds == 0) {
			json.setResponse("failed");
			LOGGER.debug("Class :" + getClass()
					+ " Method saveCourse : After courseService: CourseId :"
					+ CourseId);
		} else {
			json.setId("COURSE_" + courseIds);
			json.setResponse("success");
			LOGGER.debug("Class :" + getClass()
					+ " Method saveCourse : After courseService: CourseId :"
					+ CourseId);
		}
		LOGGER.debug("Exiting Class " + getClass()
				+ " saveCourse(): CourseId :" + " Course Name :" + CourseName
				+ " CourseDescription:" + CourseDescription + " Subject_Area:"
				+ subjectArea + "Subject " + subjectCategory + "Topic "
				+ subjectTopic + " CourseCredits :" + CourseCredits
				+ " CourseExtraCredits :" + CourseExtraCredits
				+ " courseDuration :" + courseDuration);

		return json;
	}

	@RequestMapping(value = "1/removecourse", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	void removeCourse(
			@RequestParam(value = "courseId", required = true) String courseId)
			throws CourseException {
		LOGGER.debug("Entering Class " + getClass()
				+ " removeCourse(): CourseId :" + courseId);

		Integer courseid = 0;
		try {
			courseid = Integer.parseInt(courseId);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		try {
			courseService.removeCourse(courseid);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Class :" + getClass()
				+ " Method removeCourse : After courseService: CourseId :"
				+ courseId);

	}

	@RequestMapping(value = "/removecoursecomponents", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	CourseJsonResponse removeCourseComponents(
			@RequestParam(value = "Course_id", required = true) String CourseId,
			@RequestParam(value = "Component_id", required = true) String learningComponentId)
			throws CourseException {
		LOGGER.debug("Entering Class " + getClass()
				+ " removeCourseComponents(): CourseId :" + CourseId
				+ " ComponentId :" + learningComponentId);

		CourseJsonResponse json = new CourseJsonResponse();
		try {
			Integer learningCompId = 0;
			learningCompId = Integer
					.parseInt(learningComponentId.split("_")[1]);
			courseService.removeCourseComponents(learningCompId);

			json.setId(CourseId);
			json.setResponse("success");

			LOGGER.debug("Class :"
					+ getClass()
					+ " Method removeCourseComponents : After courseService: CourseId :"
					+ CourseId);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		return json;

	}

	@RequestMapping(value = "/removecoursecontents", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	CourseJsonResponse removeCourseContents(
			@RequestParam(value = "Course_id", required = true) String CourseId,
			@RequestParam(value = "Content_id", required = true) String learningContentId)
			throws CourseException {
		LOGGER.debug("Entering Class " + getClass()
				+ " removeCourseContents(): CourseId :" + CourseId
				+ " ComponentId :" + learningContentId);

		CourseJsonResponse json = new CourseJsonResponse();
		try {
			Integer learningContId = 0;
			try {
				learningContId = Integer
						.parseInt(learningContentId.split("_")[1]);
			} catch (NumberFormatException nfe) {
				LOGGER.debug(" Class :"
						+ getClass()
						+ " Method: removeCourseContents : NumberFormatException"
						+ nfe);
			}
			courseService.learningContentdelete(learningContId);
			json.setId(CourseId);
			json.setResponse("success");
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Class :"
				+ getClass()
				+ " Method removeCourseContents : After courseService: CourseId :"
				+ CourseId);

		return json;

	}

	@RequestMapping(value = "/getcourse", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	CourseEditResponse getCourse(
			@RequestParam(value = "Course_id", required = true) String CourseId)
			throws CourseException {
		LOGGER.debug("Entering Class " + getClass()
				+ " getCourse(): CourseId :" + CourseId);

		CourseEditResponse json = null;
		try {
			Integer courseid = 0;
			try {
				courseid = Integer.parseInt(CourseId.split("_")[1]);
			} catch (Exception e) {

			}
			String selected_tags = "";
			String available_tags = "";
			CourseTagcloud tag = null;
			tag = tagCloudService.getCourseTagClouds(courseid);
			selected_tags = tag.getTagName();
			available_tags = tag.getTagName();
			json = courseEditService.getCourseDetails(courseid);
			json.setResponse("success");
			json.setSelected_tags(selected_tags);
			json.setAvailable_tags(available_tags);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Exiting Class " + getClass() + " getCourse(): CourseId :"
				+ CourseId + " json :" + json);

		return json;
	}

	@RequestMapping(value = "/searchcoursecomponents", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView searchCourseComponents(@RequestParam String memberRoleId,
			@RequestParam String searchIndicator,
			@RequestParam LearningComponent learningComponent) {
		LOGGER.debug("Entering Class " + getClass()
				+ "searchCourseComponents(): coursename :" + memberRoleId
				+ " coursedescription :" + searchIndicator);

		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.debug("Exiting Class " + getClass()
				+ "searchCourseComponents(): ");

		return mv;
	}
}