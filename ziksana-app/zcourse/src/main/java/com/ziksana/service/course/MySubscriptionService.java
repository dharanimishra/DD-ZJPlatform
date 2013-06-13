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
public interface MySubscriptionService {

	List<Course> getSubscribedCourseByMember(Integer MemberId);

	List<Course> getSubscribedCourseByMemberRole(Integer MemberRoleId);

}
