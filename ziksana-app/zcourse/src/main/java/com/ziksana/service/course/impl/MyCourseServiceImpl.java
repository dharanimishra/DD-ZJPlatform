/**
 * 
 */
package com.ziksana.service.course.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.Course;
import com.ziksana.service.course.MyCourseService;

/**
 * @author Ratnesh Kumar
 * 
 */

@Service
public class MyCourseServiceImpl implements MyCourseService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(MyCourseServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.course.MyCourseService#getMyCourses(java.lang.Integer
	 * )
	 */
	public List<Course> getMyCourses(Integer authMemberRoleId) {
		// TODO Auto-generated method stub

		LOGGER.info("Entering Class :" + getClass()
				+ " Method Name :getMyCourses(Integer authMemberRoleId)");

		LOGGER.info("Exiting Class :" + getClass()
				+ " Method Name :getMyCourses(Integer authMemberRoleId)");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.course.MyCourseService#getActiveCourses(java.lang
	 * .Integer)
	 */
	public List<Course> getActiveCourses(Integer authMemberRoleId) {

		LOGGER.info("Entering Class :" + getClass()
				+ " Method Name :getMyCourses(Integer authMemberRoleId)");

		LOGGER.info("Exiting Class :" + getClass()
				+ " Method Name :getMyCourses(Integer authMemberRoleId)");

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.course.MyCourseService#getDraftCourses(java.lang.
	 * Integer)
	 */
	public List<Course> getDraftCourses(Integer authMemberRoleId) {
		LOGGER.info("Entering Class :" + getClass()
				+ " Method Name :getDraftCourses(Integer authMemberRoleId)");

		LOGGER.info("Exiting Class :" + getClass()
				+ " Method Name :getDraftCourses(Integer authMemberRoleId)");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.course.MyCourseService#getReviewCourses(java.lang
	 * .Integer)
	 */
	public List<Course> getReviewCourses(Integer authMemberRoleId) {
		LOGGER.info("Entering Class :" + getClass()
				+ " Method Name :getReviewCourses(Integer authMemberRoleId)");

		LOGGER.info("Exiting Class :" + getClass()
				+ " Method Name :getReviewCourses(Integer authMemberRoleId)");
		return null;
	}

}
