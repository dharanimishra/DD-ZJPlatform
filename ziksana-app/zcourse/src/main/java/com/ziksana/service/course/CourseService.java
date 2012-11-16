package com.ziksana.service.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseAdditionalProperty;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningObjectDeleteType;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;

public interface CourseService {

	/**
	 * Save or Updates the course related information.
	 * @param course
	 * @return
	 * @throws CourseException
	 */
	public Course saveOrUpdateCourse(Course course) throws CourseException;

	/**
	 * Save  or Updates the course and its childs(learning component/component content) 
	 * @param course
	 * @return
	 * @throws CourseException
	 */
	public Course saveOrUpadteCourseComponents(Course course)
			throws CourseException;

	/**
	 * Save course additional property  
	 * @param courseAdditionalProperty
	 * @return
	 * @throws CourseException
	 */
	public void saveAdditionalCourseProperty(CourseAdditionalProperty courseAdditionalProperty)
			throws CourseException;
	
	/**Retrieve the base course information.
	 * @return
	 */
	public Course getBaseCourseDetails(ZID courseId) throws CourseException;
	
	/**Retrieve the full course information.
	 * @return
	 */
	public Course getCourseDetails(ZID courseId) throws CourseException;


	/**
	 * Retrieve the list of base course information
	 * @param member
	 * @return
	 */
	public List<Course> getListOfCourses(ZID memberPersonaId) throws CourseException;
	
	
	/**
	 * Retrieves the course and course components(modules,chapters, topics,...) 
	 * @param member
	 * @return
	 */
	public HashMap<String,List<String>> getCourseComponents(ZID courseId);

	/**
	 * remove the course for member.
	 * @param course
	 * @return
	 */
	public void removeCourse(Course course) throws CourseException;
	

	/**
	 * @param memberRoleId
	 * @return
	 * @throws CourseException
	 */
	public List<LearningComponent> getLearningObjects(Integer memberRoleId) throws CourseException;
	
	/**
	 * @param learningComponentId
	 * @return
	 * @throws CourseException
	 */
	public LearningComponent getLearningObject(ZID learningComponentId) throws CourseException;
	
	/**
	 * @param learningComponentId
	 * @param deleteType
	 * @throws CourseException
	 */
	public void deleteLearningObject(ZID learningComponentId, LearningObjectDeleteType deleteType) throws CourseException;
	
	/**
	 * @param memberRoleId
	 * @return
	 * @throws CourseException
	 */
	public Map<Object, Object> getCourseComponentsToPublish(Integer memberRoleId) throws CourseException;

}

	

