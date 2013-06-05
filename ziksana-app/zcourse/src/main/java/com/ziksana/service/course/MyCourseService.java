/**
 * 
 */
package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.Course;

/**
 * @author Ratnesh Kumar
 * 
 */
public interface MyCourseService {

	public List<Course> getMyCourses(Integer authMemberRoleId);

	public List<Course> getActiveCourses(Integer authMemberRoleId);

	public List<Course> getDraftCourses(Integer authMemberRoleId);

	public List<Course> getReviewCourses(Integer authMemberRoleId);

}
