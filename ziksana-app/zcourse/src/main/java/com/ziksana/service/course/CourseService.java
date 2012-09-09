package com.ziksana.service.course;

import java.util.HashMap;
import java.util.List;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.member.MemberRole;


/**
 * @author vtg-p6
 *
 */
public interface CourseService {

	/**Retrieve the base course information from database.
	 * @return
	 */
	public Course getBaseCourseDetails(Course course);

	/**
	 * Retrieve the list of base course information
	 * @param member
	 * @return
	 */
	public List<Course> getListOfCourses(MemberRole memberRole);
	
	/**
	 * Retrieves the course and course catalog(modules,chapters, topics,...) from the database.
	 * @param member
	 * @return
	 */
	public HashMap<String,List<String>> getCourseCatalog(Integer courseId);

	/**updates the course information
	 * @param course
	 * @return
	 */
	public Course updateCourse(Course course);

	/**
	 * remove the course record from the database.
	 * @param course
	 * @return
	 */
	public boolean removeCourse(Course course);

	/**
	 * creates a new course entry into the database.
	 * @param course
	 * @return
	 */
	public int saveOrUpdateCourse(Course course);


	/**
	 * creates a new course entry into the database.
	 * @param course
	 * @return
	 */
	public int saveOrUpdateCourseComponents(Course course);

	
	/**
	 * Updates the course additional properties
	 * @param course
	 * @return
	 */
	public Course modifyCourseProperties(Course course);
	

}
