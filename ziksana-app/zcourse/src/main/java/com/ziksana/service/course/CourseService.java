package com.ziksana.service.course;

import java.util.List;
import java.util.Map;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseAdditionalProperty;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningObjectDeleteType;
import com.ziksana.domain.institution.LearningProgram;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;

public interface CourseService {

	/**
	 * Save or Updates the course related information.
	 * 
	 * @param course
	 * @return
	 * @throws CourseException
	 */
	public Course saveOrUpdateCourse(Course course) throws CourseException;

	/**
	 * Save or Updates the course and its childs(learning component/component
	 * content)
	 * 
	 * @param course
	 * @return
	 * @throws CourseException
	 */
	public Course saveOrUpadteCourseComponents(Course course)
			throws CourseException;

	/**
	 * Save course additional property
	 * 
	 * @param courseAdditionalProperty
	 * @return
	 * @throws CourseException
	 */
	public void saveAdditionalCourseProperty(
			CourseAdditionalProperty courseAdditionalProperty)
			throws CourseException;

	/**
	 * Retrieve the base course information.
	 * 
	 * @return
	 */
	public Course getBaseCourseDetails(ZID courseId) throws CourseException;

	/**
	 * Retrieve the full course information.
	 * 
	 * @return
	 */
	public Course getCourseDetails(ZID courseId) throws CourseException;

	/**
	 * Retrieve the list of base course information
	 * 
	 * @param member
	 * @return
	 */
	public List<Course> getListOfCourses(Integer memberPersonaId)
			throws CourseException;

	/**
	 * Retrieves the course and course components(modules,chapters, topics,...)
	 * 
	 * @param member
	 * @return
	 * @throws CourseException
	 */
	public Course getCourseComponents(ZID courseId) throws CourseException;

	/**
	 * remove the course for member.
	 * 
	 * @param course
	 * @return
	 */

	public void removeCourse(Integer courseId) throws CourseException;

	public void removeCourseComponents(Integer learningComponentId);

	public void learningContentdelete(Integer learningContentId);

	/**
	 * @param memberRoleId
	 * @return
	 * @throws CourseException
	 */
	public List<LearningComponent> getLearningObjects(Integer memberRoleId)
			throws CourseException;

	/**
	 * @param learningComponentId
	 * @return
	 * @throws CourseException
	 */
	public LearningComponent getLearningObject(ZID learningComponentId)
			throws CourseException;

	/**
	 * @param learningComponentId
	 * @param deleteType
	 * @throws CourseException
	 */
	public void deleteLearningObject(ZID learningComponentId,
			LearningObjectDeleteType deleteType) throws CourseException;

	/**
	 * @param memberRoleId
	 * @return
	 * @throws CourseException
	 */
	public Map<Object, Object> getCourseComponentsToPublish(Integer memberRoleId)
			throws CourseException;

	/**
	 * This method returns the list of 3 courses by course
	 * status(Drafted,Reviewed, Published)
	 * 
	 * @param courseStatus
	 * @return List of courses
	 */
	public List<Course> getCoursesByStatus(CourseStatus courseStatus);

	/**
	 * This method returns list of all courses by course
	 * status(Drafted,Reviewed, Published)
	 * 
	 * @param courseStatus
	 * @return
	 */
	public List<Course> getAllCoursesByStatus(CourseStatus courseStatus);

	/**
	 * This method returns the total number of courses by course status()
	 * 
	 * @param courseStatus
	 * @return
	 */
	public Integer totalNumberOfCoursesByStatus(CourseStatus courseStatus);

	public List<LearningProgram> getLearningPrograms();

	public List<Course> getCoursesByLearningProgram(Integer learningProgramId);

	public List<Course> getThreeCoursesByLearningProgram(Integer learningProgramId);

	public Course getCourseByCourseId(Integer courseId);

	public Integer createNewCurriculamCourse(int coursesId, int memberRoleId);

	public void getCurriculamCourseByCourseId(int coursesId);

	public int isCourseNameExists(CourseStatus courseStatus, String courseName);

	public int getCoursesByCoursename(CourseStatus underConstruct,String courseName, int courseId);
}
