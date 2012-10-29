package com.ziksana.service.course;

import com.ziksana.domain.course.Course;
import com.ziksana.exception.course.CourseException;

/**
 * @author bhashasp
 */
public interface CoursePlannerService {

	/**
	 * saves the course/LO planner 
	 * @param course
	 * @throws CourseException
	 */
	public void saveCoursePlanner(Course course) throws CourseException;
}
