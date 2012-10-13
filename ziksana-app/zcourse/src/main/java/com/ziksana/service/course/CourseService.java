package com.ziksana.service.course;

import java.util.HashMap;
import java.util.List;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseAdditionalProperty;
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
	 * Save  or Updates the course and its childs(learning component/component content) 
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
	public CourseAdditionalProperty saveAdditionalCourseProperty(CourseAdditionalProperty courseAdditionalProperty)
			throws CourseException;
	
	/**Retrieve the base course information.
	 * @return
	 */
	public Course getBaseCourseDetails(Course course);
	
	/**Retrieve the full course information.
	 * @return
	 */
	public Course getCourseDetails(Course course);


	/**
	 * Retrieve the list of base course information
	 * @param member
	 * @return
	 */
	public List<Course> getListOfCourses(ZID memberPersonaId);
	
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
	public void removeCourse(Course course);
	
	/**
	 * Retrieve list of courses according to the program
	 * @param programName
	 * @return
	 */
	public List<Course> fetchCourses(String programName);

}

	

