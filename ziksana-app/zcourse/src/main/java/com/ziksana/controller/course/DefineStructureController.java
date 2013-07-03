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

import com.ziksana.domain.assessment.TagType;
import com.ziksana.domain.common.MediaServerURL;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseDetails;
import com.ziksana.domain.course.CourseJsonResponse;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.CourseSubjectClassification;
import com.ziksana.domain.course.Duration;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentDetails;
import com.ziksana.domain.course.LearningComponentNest;
import com.ziksana.domain.course.LearningComponentTagcloud;
import com.ziksana.domain.course.LearningComponentType;
import com.ziksana.domain.course.ModuleEditResponse;
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
 * @author Ratnesh Kumar
 * 
 */

@Controller
@RequestMapping("/zcourse")
public class DefineStructureController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DefineStructureController.class);

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

	@RequestMapping(value = "/createmodule/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView courseModule(@PathVariable String courseId) {

		LOGGER.debug(" Entering Class " + getClass() + " courseModule()");
		ModelAndView modelView = null;
		try {
			Integer course_id = Integer.parseInt(courseId.split("_")[1]);
			int isModuleExists = 0;
			if (course_id != null) {
				isModuleExists = courseService.isModuleExists(course_id);
			}
			mediaServerURL = mediaService.getMediaContents();
			if (course_id > 0) {
				modelView = new ModelAndView("mastercreatemodule");
				modelView.addObject("CourseId", course_id);
				modelView.addObject("module", isModuleExists);
				modelView.addObject("ms", mediaServerURL);
			} else {
				modelView = new ModelAndView("mastercreatecourse");
				modelView.addObject("CourseId", course_id);
				modelView.addObject("module", isModuleExists);
				modelView.addObject("ms", mediaServerURL);
			}
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Class " + getClass() + "Exiting courseModule(): ");

		return modelView;
	}

	@RequestMapping(value = "/savelearningcomponent", method = RequestMethod.POST)
	public @ResponseBody
	CourseJsonResponse saveCourseComponents(
			@RequestParam(value = "Course_id", required = true) String CourseId,
			@RequestParam(value = "CourseLearningComponentId", required = false) String CourseLearningComponentId,
			@RequestParam(value = "ParentLearningComponentId", required = false) String ParentLearningComponentId,
			@RequestParam(value = "LearningComponentId", required = false) String LearningComponentId,
			@RequestParam(value = "Course_Module", required = true) String CourseModule,
			@RequestParam(value = "Module_Description", required = false) String CourseModuleDescription,
			@RequestParam(value = "Subject_Area", required = false) String Subject_Area,
			@RequestParam(value = "Subject", required = false) String Subject,
			@RequestParam(value = "Topic", required = false) String subjectTopic,
			@RequestParam(value = "Moduletag_Field", required = false) String ModuleTags,
			@RequestParam(value = "Learning_Object", required = false) String Learning_Object,
			@RequestParam(value = "Module_Weight", required = false) String ModuleWeight,
			@RequestParam(value = "LearningObject", required = false) String LearningObject,
			@RequestParam(value = "Module_Duration", required = false) String Duration,
			@RequestParam(value = "ModuleDuration_Type", required = false) String UnitofDuration,
			@RequestParam(value = "Assoc_Image", required = false) String UploadImage

	) {
		LOGGER.debug("Entering Class " + getClass()
				+ " saveCourseComponents(): courseId :" + CourseId
				+ "CourseLearningComponentId :" + CourseLearningComponentId
				+ "ParentLearningComponentId :" + ParentLearningComponentId
				+ "LearningComponentId :" + LearningComponentId
				+ " CourseModule :" + CourseModule
				+ " CourseModuleDescription :" + CourseModuleDescription
				+ " ModuleTags :" + ModuleTags + " ModuleWeight :"
				+ ModuleWeight + " LearningObject :" + LearningObject
				+ " Duration :" + Duration + " UnitofDuration :"
				+ UnitofDuration + " UploadImage :" + UploadImage);
		CourseJsonResponse json = new CourseJsonResponse();
		Integer courseIds = 0;
		try {

			Integer courseid = 0, courseLearningComponentId = 0, learningComponentId = 0, learningObjIndicator = 0, parentLearningComponentId = 0;

			if (!"".equals(CourseId) && CourseId != null) {
				courseid = Integer.parseInt(CourseId.split("_")[1]);
			}
			LOGGER.debug("Entering Class " + getClass()
					+ " saveCourseComponents(): courseid :" + courseid);
			if (!"".equals(CourseLearningComponentId)
					&& CourseLearningComponentId != null) {
				courseLearningComponentId = Integer
						.parseInt(CourseLearningComponentId);
			}

			LOGGER.debug("Entering Class " + getClass()
					+ " saveCourseComponents(): courseLearningComponentId :"
					+ courseLearningComponentId);
			if (!"".equals(ParentLearningComponentId)
					&& ParentLearningComponentId != null) {
				parentLearningComponentId = Integer
						.parseInt(ParentLearningComponentId.split("_")[1]);
			}
			LOGGER.debug("Entering Class " + getClass()
					+ " saveCourseComponents(): parentLearningComponentId :"
					+ parentLearningComponentId);

			if (!"".equals(LearningComponentId) && LearningComponentId != null) {
				learningComponentId = Integer.parseInt(LearningComponentId);
			}
			LOGGER.debug("Entering Class " + getClass()
					+ " saveCourseComponents(): learningComponentId :"
					+ learningComponentId);

			if (!"".equals(Learning_Object) && Learning_Object != null) {
				learningObjIndicator = Integer.parseInt(Learning_Object);
			}

			LOGGER.debug("Entering Class " + getClass()
					+ " saveCourseComponents(): Learning_Object :"
					+ Learning_Object);
			Integer courseDuration = 0, unitofDuration = 1, moduleWeight = 0;
			if (!"".equals(Duration) && Duration != null) {
				courseDuration = Integer.parseInt(Duration);
			}
			if (!"".equals(UnitofDuration) && UnitofDuration != null) {
				unitofDuration = Integer.parseInt(UnitofDuration);
			}
			if (!"".equals(ModuleWeight) && ModuleWeight != null) {
				moduleWeight = Integer.parseInt(ModuleWeight);
			}
			CourseSubjectClassification courseSubjectClassification = courseSubjectDetailService
					.getSubjectClassification(subjectTopic);

			MemberPersona accountableMember = new MemberPersona();
			accountableMember.setMemberRoleId(Integer.valueOf(SecurityTokenUtil
					.getToken().getMemberPersonaId().getStorageID()));

			boolean flag = false;

			Course courseObj = null;
			List<CourseLearningComponent> compList = new ArrayList<CourseLearningComponent>();
			Course course = new Course();
			course.setCourseId(courseid);
			course.setAccountableMember(accountableMember);
			course.setCourseStatus(CourseStatus.DRAFT);
			course.setCourseStatusId(CourseStatus.DRAFT.getID());
			LearningComponent learningComponentParent = null;
			if (courseLearningComponentId > 0 && learningComponentId > 0) {
				flag = true;
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
				comp1.setLearningObjIndicator(learningObjIndicator);

				// Learning Component Nesting
				learningComponentParent = new LearningComponent();
				if (parentLearningComponentId == courseid) {
					parentLearningComponentId = 0;
				} else {
					learningComponentParent
							.setLearningComponentId(parentLearningComponentId);
				}
				LearningComponentNest compNest1 = new LearningComponentNest(
						learningComponentParent, comp1);
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
				flag = false;
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
				comp1.setLearningObjIndicator(learningObjIndicator);

				// Learning Component Nesting

				learningComponentParent = new LearningComponent();
				if (learningComponentId == courseid) {
					parentLearningComponentId = 0;
				} else {
					learningComponentParent
							.setLearningComponentId(parentLearningComponentId);
				}
				LearningComponentNest compNest1 = new LearningComponentNest(
						learningComponentParent, comp1);
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

			LOGGER.debug("Exiting Class " + getClass()
					+ " saveCourseComponents(): courseId :" + CourseId
					+ "CourseLearningComponentId :" + CourseLearningComponentId
					+ "ParentLearningComponentId :" + ParentLearningComponentId
					+ "LearningComponentId :" + LearningComponentId
					+ " CourseModule :" + CourseModule
					+ " CourseModuleDescription :" + CourseModuleDescription
					+ " ModuleTags :" + ModuleTags + " ModuleWeight :"
					+ ModuleWeight + " LearningObject :" + LearningObject
					+ " Duration :" + Duration + " UnitofDuration :"
					+ UnitofDuration + " UploadImage :" + UploadImage);
			Integer updatedLearningComponentId = 0;

			courseIds = Integer
					.parseInt(courseObj.getCourseId().getStorageID());

			LOGGER.debug("Class :" + getClass()
					+ " Method saveCourse : After courseService: courseIds :"
					+ courseIds);
			updatedLearningComponentId = Integer.parseInt(courseObj
					.getLearningComponentId().getStorageID());

			LOGGER.debug("Class :"
					+ getClass()
					+ " Method saveCourse : After courseService: updatedLearningComponentId :"
					+ updatedLearningComponentId);

			LearningComponentTagcloud getTagcloud = null;
			LearningComponentTagcloud tagcloudObj = new LearningComponentTagcloud();
			getTagcloud = learningComponentTagCloudService
					.getComponentTagClouds(learningComponentId);

			LearningComponentTagcloud tagcloud = new LearningComponentTagcloud();
			if (flag) {
				tagcloud.setTagCloudId(getTagcloud.getTagCloudId());
				tagcloud.setComponentTagCloudId(updatedLearningComponentId);
				tagcloud.setTagName(ModuleTags);
				tagcloud.setZeniSuggestedIndicator(true);
				tagcloud.setLearningComponentId(updatedLearningComponentId);
				try {
					tagcloudObj = learningComponentTagCloudService
							.saveOrUpadteTags(tagcloud);
				} catch (Exception e) {
					LOGGER.error("Class :"
							+ getClass()
							+ " Method saveOrUpadteTags Exception : After courseService :tagcloud"
							+ tagcloud + "learningComponentId :"
							+ learningComponentId
							+ "updatedLearningComponentId :"
							+ updatedLearningComponentId);
				}
				LOGGER.debug("Class :"
						+ getClass()
						+ " Method saveOrUpadteTags : After courseService: :tagcloud"
						+ tagcloud + " learningComponentId :"
						+ learningComponentId + "updatedLearningComponentId :"
						+ updatedLearningComponentId);

			} else {
				tagcloud.setTagName(ModuleTags);
				tagcloud.setZeniSuggestedIndicator(true);
				tagcloud.setLearningComponentId(updatedLearningComponentId);
				tagcloud.setTagType(TagType.TAG_TYPE1);

				try {
					tagcloudObj = learningComponentTagCloudService
							.saveOrUpadteTags(tagcloud);
				} catch (Exception e) {
					LOGGER.error("Class :"
							+ getClass()
							+ " Method saveOrUpadteTags Exception : After courseService :tagcloud"
							+ tagcloud + "learningComponentId :"
							+ learningComponentId
							+ "updatedLearningComponentId :"
							+ updatedLearningComponentId);
				}
				LOGGER.debug("Class :"
						+ getClass()
						+ " Method saveOrUpadteTags : After courseService :tagcloud"
						+ tagcloud + "learningComponentId :"
						+ learningComponentId + "updatedLearningComponentId :"
						+ updatedLearningComponentId);

			}

			try {
				learningComponentTagCloudService.saveOrUpadteTags(tagcloudObj);
				LOGGER.debug("Class :"
						+ getClass()
						+ " Method saveCourse : After courseService: learningComponentTagCloudService : learningComponentTagCloudService");
			} catch (Exception e) {
				LOGGER.error("Class :"
						+ getClass()
						+ " Method saveCourse Exception : After courseService: learningComponentTagCloudService : learningComponentTagCloudService");
			}

		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block ex
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		return json;
	}

	@RequestMapping(value = "/getcoursemodule", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModuleEditResponse getCourseModule(
			@RequestParam(value = "Course_id", required = true) String CourseId,
			@RequestParam(value = "Component_id", required = true) String ComponentId)
			throws CourseException {
		LOGGER.debug("Entering Class " + getClass()
				+ " getCourseModule(): CourseId :" + CourseId
				+ " learningComponentId :" + ComponentId);

		ModuleEditResponse json = null;
		ModelAndView modelView = new ModelAndView();
		try {
			Integer courseid = 0, learningComponentId = 0;
			learningComponentId = Integer.parseInt(ComponentId.split("_")[1]);
			String tagfield = "";
			LearningComponentTagcloud tag = null;
			try {
				tag = learningComponentTagCloudService
						.getComponentTagClouds(learningComponentId);
			} catch (Exception e) {

			}
			tagfield = tag.getTagName();
			LOGGER.error("Class " + getClass()
					+ "Method Name :getCourseModule : tag  :" + tag
					+ "tagfield :" + tagfield);

			json = courseEditService.getModuleDetails(learningComponentId);
			json.setResponse("success");
			json.setTagfield(tagfield);
			modelView.addObject("tagfield", tagfield);

		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Exiting Class " + getClass()
				+ " getCourseModule(): CourseId :" + CourseId
				+ " learningComponentId :" + ComponentId + " json :" + json);

		return json;
	}
}
