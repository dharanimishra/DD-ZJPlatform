package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseAdditionalProperty;
import com.ziksana.domain.course.CourseComponentType;
import com.ziksana.domain.course.CourseContentSecurity;
import com.ziksana.domain.course.CourseDetails;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.CourseTagcloud;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentDetails;
import com.ziksana.domain.course.LearningComponentNest;
import com.ziksana.domain.course.LearningObjectDeleteType;
import com.ziksana.domain.institution.LearningProgram;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;
import com.ziksana.persistence.course.CourseContentSecurityMapper;
import com.ziksana.persistence.course.CourseLearningComponentMapper;
import com.ziksana.persistence.course.CourseMapper;
import com.ziksana.persistence.course.CourseTagcloudMapper;
import com.ziksana.persistence.course.EnrichmentMapper;
import com.ziksana.persistence.course.LearningComponentContentMapper;
import com.ziksana.persistence.course.LearningComponentMapper;
import com.ziksana.persistence.course.LearningComponentNestMapper;
import com.ziksana.persistence.course.LearningContentMapper;
import com.ziksana.persistence.subscription.SubscriptionMapper;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.course.CourseService;

/**
 * @author ratneshkumar
 */
@Service
public class CourseServiceImpl implements CourseService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(CourseServiceImpl.class);

	@Autowired
	public CourseMapper courseMapper;
	@Autowired
	public CourseTagcloudMapper tagCloudMapper;
	@Autowired
	public CourseContentSecurityMapper contSecurityMapper;
	@Autowired
	public LearningComponentMapper learningComponentMapper;

	@Autowired
	public LearningContentMapper learningContentMapper;

	@Autowired
	public LearningComponentNestMapper componentNestMapper;
	@Autowired
	public CourseLearningComponentMapper courseLComponentMapper;
	@Autowired
	public LearningComponentContentMapper learningComponentContentMapper;
	@Autowired
	public EnrichmentMapper enrichMapper;

	@Autowired
	public SubscriptionMapper subscriptionMapper;

	@Transactional
	public Course saveOrUpdateCourse(Course course) throws CourseException {

		CourseContentSecurity contSecurity = null;
		List<CourseTagcloud> tagcloudList = null;

		tagcloudList = new ArrayList<CourseTagcloud>();

		contSecurity = course.getCourseContSecurity();

		if (course.getCourseId() != null) {
			// Update Operation
			LOGGER.debug("Course Id : " + course.getCourseId());

			tagcloudList = course.getCourseTagClouds();

			LOGGER.debug("Before updating the Course ....");
			courseMapper.updateCourse(course);

			if (tagcloudList != null && tagcloudList.size() > 0) {

				LOGGER.debug("Course Tagcloud list size : "
						+ tagcloudList.size());

				for (CourseTagcloud courseTagcloud : tagcloudList) {

					courseTagcloud.setCourse(course);
					courseTagcloud.setCreatingMember(course
							.getAccountableMember());
					if (courseTagcloud.getCourseTagCloudId() != null) {

						LOGGER.debug("Before UPDATING the Course Tagcloud ....");
						tagCloudMapper.update(courseTagcloud);

					} else {

						LOGGER.debug("Before SAVING the Course Tagcloud ....");
						tagCloudMapper.save(courseTagcloud);

					}
				}
			}

			if (contSecurity != null) {
				contSecurity.setCourse(course);
				if (contSecurity.getContentSecurityId() != null) {
					LOGGER.debug("Before updating the Course Content Security ....");
					contSecurityMapper.update(contSecurity);
				} else {
					contSecurityMapper.save(contSecurity);
				}
			}
		} else {
			Boolean isSecurity = false;
			// Insert/Save Operation
			LOGGER.debug("Before saving the Course ....");
			courseMapper.saveCourse(course);
			LOGGER.debug("After saving the Course ID....: "
					+ course.getCourseId());

			tagcloudList = course.getCourseTagClouds();

			if (tagcloudList != null && tagcloudList.size() > 0) {

				LOGGER.debug("Cours e Tagcloud list size : "
						+ tagcloudList.size());
				for (CourseTagcloud courseTagcloud : tagcloudList) {

					courseTagcloud.setCourse(course);

					courseTagcloud.setCreatingMember(course
							.getAccountableMember());

					if (courseTagcloud.getCourseTagCloudId() != null) {

						LOGGER.debug("Before UPDATING the Course Content Security ....");
						tagCloudMapper.update(courseTagcloud);

					} else {

						LOGGER.debug("Before SAVING the Course Content Security ....");
						tagCloudMapper.save(courseTagcloud);

					}
				}
			}
			isSecurity = course.getSecurityIndicator();

			if (isSecurity != null) {
				LOGGER.debug("Course Content Security Indicator ....: "
						+ isSecurity);
				if (contSecurity != null) {
					LOGGER.debug("Course Content Security ....: "
							+ contSecurity.toString());
					LOGGER.debug("Course Content Security CourseID ....: "
							+ course.getCourseId());
					contSecurity.setCourse(course);

					if (contSecurity.getContentSecurityId() != null) {

						LOGGER.debug("Before updating the Course Content Security ....");
						contSecurityMapper.update(contSecurity);

					} else {

						LOGGER.debug("Before Saving the Course Content Security ....");
						contSecurityMapper.save(contSecurity);
					}
				}
			}

		}

		LOGGER.debug("Saved Course :: " + course.toString());

		return course;
	}

	@Transactional
	public Course saveOrUpadteCourseComponents(Course course)
			throws CourseException {
		CourseDetails courseDetails = null;
		List<CourseLearningComponent> courseLearningComponentList = null;
		LearningComponentDetails compDetails = null;
		LearningComponentNest compNest = null;
		LearningComponent learningComp = null;

		courseDetails = course.getCourseDetails();

		courseLearningComponentList = courseDetails
				.getCourseLearningComponentsList();

		for (CourseLearningComponent courseLearningComponent : courseLearningComponentList) {

			learningComp = courseLearningComponent.getLearningComponent();

			// UPDATE OPERATION
			// if (courseLearningComponent.getCourseLearningComponentId() !=
			// null) {
			if (learningComp.getLearningComponentId() != null) {
				LOGGER.debug("Before Updating the CourseLearningComponent ....");
				// courseLComponentMapper
				// .updateCourseLearningComponent(courseLearningComponent);

				LOGGER.debug("Before Updating the Learning Component ....");
				learningComponentMapper.updateLearningComponent(learningComp);
				LOGGER.debug("After Updating the CourseLearningComponent : ");

				course.setLearningComponentId(learningComp
						.getLearningComponentId());

			} else {
				// SAVE OPERATION
				LOGGER.debug("Before Saving the Learning Component ....");
				learningComponentMapper.saveLearningComponent(learningComp);
				LOGGER.debug("After Saving the CourseLearningComponent ID..: "
						+ learningComp.getLearningComponentId().getDisplayID());

				LOGGER.debug("After Saving the CourseLearningComponent Course ID..: "
						+ course.getCourseId().getDisplayID());

				course.setLearningComponentId(learningComp
						.getLearningComponentId());

				courseLearningComponent.setCourse(course);

				courseLearningComponent.setLearningComponent(learningComp);

				LOGGER.debug("Before Saving the CourseLearningComponent ....");
				courseLComponentMapper
						.saveCourseLearningComponent(courseLearningComponent);

				compDetails = learningComp.getLearningComponentDetails();

				compNest = compDetails.getLearningComponentNest();

				compNest.setNestLearningComponent(learningComp);

				LOGGER.debug("Before Saving the LearningComponentNest ....");

				componentNestMapper.saveComponentNest(compNest);

				LOGGER.debug("After Saving the LearningComponentNest ....");
			}
		}
		return course;

	}

	public Course getBaseCourseDetails(ZID courseId) throws CourseException {

		Course course = null;

		LOGGER.debug("Before retrieving the base course details ");

		course = courseMapper.getBaseCourseDetails(new Integer(courseId
				.getStorageID()));

		return course;
	}

	public List<Course> getListOfCourses(Integer memberPersonaId)
			throws CourseException {

		List<Course> courseList = null;
		courseList = new ArrayList<Course>();

		LOGGER.debug("MemberRoleID : " + memberPersonaId);

		courseList = courseMapper.getListOfCourses(memberPersonaId);

		// courseList = getCourseProgress(courseList, memberPersonaId);

		return courseList;
	}

	/**
	 * construct the course progress based on the various steps(course
	 * component, content, enrich, assignment, planner, playbook and socialize)
	 * 
	 * @param courseList
	 * @param memberRoleId
	 * @return
	 */
	private List<Course> getCourseProgress(List<Course> courseList,
			Integer memberRoleId) {

		List<Course> newCourseList = null;
		int courseProgress = 0;
		List<CourseLearningComponent> couseCompList = null;
		Boolean isComponentExists = false;
		Boolean isContentExists = false;
		Boolean isEnriched = false;
		Boolean isAssignmentExist = false;
		Boolean isPlannerExists = false;
		Boolean isPlaybookExists = false;
		Boolean isSocialized = false;
		Integer lCompId = null;
		Integer courseId = null;
		newCourseList = new ArrayList<Course>();

		if (courseList != null && courseList.size() > 0) {

			LOGGER.debug("Courses size : " + courseList.size());
			LearningComponent component = null;

			for (Course course : courseList) {
				courseProgress = 0;
				int componentContentSize = 0;
				int learningContentSize = 0;
				int enrichSize = 0;
				int assignmentSize = 0;
				int coursePlaybookSize = 0;
				int reviewProgressSize = 0;
				int count = 0;

				courseId = Integer.valueOf(course.getCourseId().getDisplayID());

				LOGGER.debug("CoursesID : " + courseId);

				couseCompList = courseLComponentMapper
						.getBaseCourseLearningComponentsByCourse(courseId);

				if (couseCompList != null && couseCompList.size() > 0) {

					isComponentExists = true;
					courseProgress = courseProgress + 15;

					Boolean compCheck = false;
					Boolean enrichCheck = false;
					Boolean assignCheck = false;
					Boolean plannerCheck = false;
					Boolean playbookCheck = true;
					for (CourseLearningComponent courseLearningComp : couseCompList) {

						component = courseLearningComp.getLearningComponent();

						lCompId = Integer.valueOf(component
								.getLearningComponentId().getStorageID());

						componentContentSize = learningComponentContentMapper
								.getCompContentByLComponentId(lCompId);

						if (componentContentSize > 0) {

							if (isContentExists.equals(false)) {

								isContentExists = true;
								courseProgress = courseProgress + 15;
							} else {
								compCheck = true;
							}

							learningContentSize = learningComponentContentMapper
									.getContentByLComponentId(lCompId);

							if (learningContentSize > 0) {

								enrichSize = enrichMapper
										.getEnrichByContentIdOrComponentId(
												lCompId, courseId);
								LOGGER.debug("lCompId : " + lCompId);
								LOGGER.debug("courseId : " + courseId);

								if (enrichSize > 0) {

									if (isEnriched.equals(false)
											|| compCheck.equals(true)) {

										isEnriched = true;
										courseProgress = courseProgress + 15;

									} else {
										enrichCheck = true;
									}
									assignmentSize = courseMapper
											.checkAssignment(lCompId);

									// if (assignmentSize > 0) {
									//
									// if (isAssignmentExist.equals(false)
									// || enrichCheck.equals(true)) {
									// isAssignmentExist = true;
									// courseProgress = courseProgress + 15;
									// } else {
									// assignCheck = true;
									// }
									// count = plannerMapper
									// .isPlannerExists(
									// courseId,
									// new Integer(
									// courseLearningComp
									// .getCourseLearningComponentId()
									// .getStorageID()));
									//
									// if (count > 0) {
									//
									// if (isPlannerExists.equals(false)
									// || assignCheck.equals(true)) {
									// isPlannerExists = true;
									// courseProgress = courseProgress + 15;
									// } else {
									// plannerCheck = true;
									// }
									//
									// coursePlaybookSize = playbookMapper
									// .isPlaybookExists(courseId);
									//
									// if (coursePlaybookSize > 0) {
									//
									// if (isPlaybookExists
									// .equals(false)
									// || plannerCheck
									// .equals(true)) {
									// isPlaybookExists = true;
									// courseProgress = courseProgress + 15;
									// } else {
									// playbookCheck = true;
									// }
									// reviewProgressSize = socializeMapper
									// .isSocializeExists(
									// courseId,
									// memberRoleId);
									//
									// if (reviewProgressSize > 0) {
									//
									// if (isSocialized
									// .equals(false)
									// || playbookCheck
									// .equals(true)) {
									// isSocialized = true;
									// courseProgress = courseProgress + 15;
									// }
									// }
									// }
									// }
									// }
								}
							}

						}
					}
				}
				LOGGER.debug(" Course ID :: [" + courseId + "] Progress :["
						+ courseProgress + "]");
				course.setCourseProgress(courseProgress);

				newCourseList.add(course);

			}
		}
		return newCourseList;

	}

	public Course getCourseComponents(ZID courseId) throws CourseException {

		Course course = null;

		course = courseMapper.getCourseComponents(Integer.valueOf(courseId
				.getStorageID()));

		return course;
	}

	@Transactional
	public void saveAdditionalCourseProperty(
			CourseAdditionalProperty courseAdditionalProperty)
			throws CourseException {

		LOGGER.debug("Before saving the Course Additional Information ... ");
		courseMapper.saveAddnlInfo(courseAdditionalProperty);

	}

	public Course getCourseDetails(ZID courseId) throws CourseException {
		Course course = null;
		course = courseMapper.getBaseCourseDetails(new Integer(courseId
				.getStorageID()));
		return course;
	}

	public List<LearningComponent> getLearningObjects(Integer memberRoleId)
			throws CourseException {
		List<LearningComponent> learningObjectList = null;
		Boolean isLearningObject = true;

		LOGGER.debug("Member role ID : " + memberRoleId);

		learningObjectList = learningComponentMapper.getLearningObjects(
				isLearningObject, memberRoleId);

		return learningObjectList;
	}

	public LearningComponent getLearningObject(ZID learningComponentId)
			throws CourseException {

		LearningComponent learningObject = null;
		Boolean isLearningObject = true;

		learningObject = learningComponentMapper.getLearningObjectById(
				isLearningObject,
				new Integer(learningComponentId.getStorageID()));

		return learningObject;
	}

	@Transactional
	public void deleteLearningObject(ZID learningComponentId,
			LearningObjectDeleteType deleteType) throws CourseException {

		Boolean isDelete = true;
		List<Integer> learningComponentContentIdList = null;
		if (LearningObjectDeleteType.LEARNINGOBJECT.equals(new Integer(1))) {

			learningComponentMapper.delete(isDelete, new Integer(
					learningComponentId.getStorageID()));

		} else if (LearningObjectDeleteType.LEARNINGOBJECT_AND_CONTENTS
				.equals(new Integer(2))) {
			isDelete = false;

			learningComponentContentIdList = learningComponentContentMapper
					.getLearningComponentContentByComponentId(new Integer(
							learningComponentId.getStorageID()), isDelete);

			for (Integer learningComponentContentId : learningComponentContentIdList) {

				learningComponentContentMapper.delete(
						learningComponentContentId, isDelete);

			}

			learningComponentMapper.delete(isDelete, new Integer(
					learningComponentId.getStorageID()));

		}
	}

	public Map getCourseComponentsToPublish(Integer memberRoleId)
			throws CourseException {

		Map<Object, List<LearningComponent>> componentsMap = null;

		componentsMap = new HashMap<Object, List<LearningComponent>>();

		List<LearningComponent> learningObjectList = getLearningObjects(memberRoleId);

		componentsMap.put(CourseComponentType.LEARNING_OBJECT,
				learningObjectList);

		return componentsMap;
	}

	public List<Course> getCoursesByStatus(CourseStatus courseStatus) {
		// TODO Auto-generated method stub
		int status = courseStatus.getID();

		String memberPersonaId = SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID();

		List<Course> courses = courseMapper.getCourses(Integer.valueOf(status),
				Integer.valueOf(memberPersonaId));
		return getCourseProgress(courses, Integer.valueOf(memberPersonaId));

	}

	public List<Course> getAllCoursesByStatus(CourseStatus courseStatus) {

		int status = courseStatus.getID();
		String memberPersonaId = SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID();

		return courseMapper.getAllCourses(Integer.valueOf(status),
				Integer.valueOf(memberPersonaId));
	}

	public Integer totalNumberOfCoursesByStatus(CourseStatus courseStatus) {

		int status = courseStatus.getID();
		String memberPersonaId = SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID();

		return courseMapper.totalNumberOfCourses(Integer.valueOf(status),
				Integer.valueOf(memberPersonaId));
	}

	public List<LearningProgram> getLearningPrograms() {

		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();

		return subscriptionMapper.getLearningPrograms(Integer
				.valueOf(memberRoleId));
	}

	public List<Course> getCoursesByLearningProgram(Integer learningProgramId) {
		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();

		return subscriptionMapper.getCoursesByLearningProgram(
				Integer.valueOf(memberRoleId), learningProgramId);
	}

	public List<Course> getThreeCoursesByLearningProgram(
			Integer learningProgramId) {
		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();

		return subscriptionMapper.getThreeCoursesByLearningProgram(
				Integer.valueOf(memberRoleId), learningProgramId);
	}

	public void removeCourse(Integer courseId) throws CourseException {
		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :removeCourse(Integer courseId)" + courseId);

		courseMapper.deleteCourse(courseId);

		LOGGER.debug("Exiting Class :" + getClass()
				+ " Method Name :removeCourse(Integer courseId)" + courseId);

	}

	public void removeCourseComponents(Integer learningComponentId) {
		LOGGER.debug("Entering Class :"
				+ getClass()
				+ " Method Name :removeCourseComponents(Integer learningComponentId)"
				+ learningComponentId);

		learningComponentMapper.learningComponentdelete(learningComponentId);

		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :removeCourseComponents(Integer learningComponentId)"
				+ learningComponentId);
	}

	public void learningContentdelete(Integer learningContentId) {
		LOGGER.debug("Entering Class :"
				+ getClass()
				+ " Method Name :learningContentdelete(Integer learningContentId)"
				+ learningContentId);

		learningContentMapper.learningContentdelete(learningContentId);

		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :learningContentdelete(Integer learningContentId)"
				+ learningContentId);

	}

	public Course getCourseByCourseId(Integer courseId) {

		return courseMapper.getCourseByCourseId(courseId);
	}

	public Integer createNewCurriculamCourse(int coursesId, int memberRoleId) {
		return courseMapper.saveCurriculamCourse(coursesId, memberRoleId);

	}

	public void getCurriculamCourseByCourseId(int coursesId) {
		courseMapper.saveAndEnableCourse(coursesId);
	}

	public int isCourseNameExists(CourseStatus courseStatus, String courseName) {
		int status = courseStatus.getID();
		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();
		return courseMapper.isCourseNameExists(Integer.valueOf(status),
				Integer.valueOf(memberRoleId), courseName);
	}

	public int getCoursesByCoursename(CourseStatus courseStatus,
			String courseName, int courseId) {
		int status = courseStatus.getID();
		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();
		return courseMapper.getCoursesByCoursename(Integer.valueOf(status),
				Integer.valueOf(memberRoleId), courseName, courseId);
	}

	public int isModuleExists(Integer courseId) {
		// TODO Auto-generated method stub
		return courseMapper.isModuleExists(courseId);
	}

	public int isContentExists(Integer courseId) {
		// TODO Auto-generated method stub
		return courseMapper.isContentExists(courseId);
	}

}