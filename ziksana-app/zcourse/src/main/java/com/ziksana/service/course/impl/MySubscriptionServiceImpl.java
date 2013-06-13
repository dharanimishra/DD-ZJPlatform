/**
 * 
 */
package com.ziksana.service.course.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.Course;
import com.ziksana.persistence.course.subscription.SubscriptionCourseMapper;
import com.ziksana.service.course.MySubscriptionService;

/**
 * @author Ratnesh Kumar
 * 
 */
@Service
public class MySubscriptionServiceImpl implements MySubscriptionService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(MySubscriptionServiceImpl.class);

	@Autowired
	public SubscriptionCourseMapper subscriptionCourseMapper;

	public List<Course> getSubscribedCourseByMember(Integer MemberId) {
		LOGGER.info("Class :" + getClass()
				+ "Method :getSubscribedCourseByMember(Integer MemberId)");
		return null;
	}

	public List<Course> getSubscribedCourseByMemberRole(Integer MemberRoleId) {
		LOGGER.info("Class :"
				+ getClass()
				+ "Method :getSubscribedCourseByMemberRole(Integer MemberRoleId)");
		return null;
	}

}
