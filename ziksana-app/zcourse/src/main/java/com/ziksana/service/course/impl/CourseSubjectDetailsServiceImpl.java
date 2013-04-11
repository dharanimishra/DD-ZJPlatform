package com.ziksana.service.course.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.CourseSubjectClassification;
import com.ziksana.domain.course.Option;
import com.ziksana.persistence.course.CourseSubjectDetailMapper;
import com.ziksana.service.course.CourseSubjectDetailService;

/**
 * @author ratneshkumar Dec 15, 2012
 * 
 * 
 */
@Service
public class CourseSubjectDetailsServiceImpl implements
		CourseSubjectDetailService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(CourseSubjectDetailsServiceImpl.class);

	@Autowired
	CourseSubjectDetailMapper courseSubjectDetailMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.course.CourseSubjectDetailService#getSubjectCategory
	 * ()
	 */

	public List<Option> getSubjectCategory() {
		// TODO Auto-generated method stub

		List<Option> list = courseSubjectDetailMapper.getSubjectCategory();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.course.CourseSubjectDetailService#getSubjectArea(
	 * java.lang.Integer)
	 */

	public List<Option> getSubjectArea(String subjectArea) {
		List<Option> list = courseSubjectDetailMapper
				.getSubjectArea(subjectArea);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.course.CourseSubjectDetailService#getSubjectTopic
	 * (java.lang.Integer)
	 */

	public List<Option> getSubjectTopic(String subjectTopic) {
		List<Option> list = courseSubjectDetailMapper
				.getSubjectTopic(subjectTopic);
		return list;
	}

	public CourseSubjectClassification getSubjectClassification(
			String subjectTopic) {
		CourseSubjectClassification courseSubjectClassification = null;
		LOGGER.debug("Entering Class :"
				+ getClass()
				+ " Method Name :getSubjectClassification(String subjectArea, String subjectCategory, String subjectTopic) :subjectArea "

				+ " subjectTopic :" + subjectTopic);
		courseSubjectClassification = courseSubjectDetailMapper
				.getSubjectClassification(subjectTopic);
		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :getCoursgetSubjectClassificationeDetails(String subjectArea, String subjectCategory, String subjectTopic):subjectArea "
				+ " subjectTopic :" + subjectTopic);

		return courseSubjectClassification;
	}

	public CourseSubjectClassification getCourseClassification(Integer courseId) {
		CourseSubjectClassification courseSubjectClassification = null;
		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :getSubjectClassification(Integer courseId) : "

				+ " courseId :" + courseId);
		courseSubjectClassification = courseSubjectDetailMapper
				.getCourseClassification(courseId);
		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :getCourseClassification(Integer courseId): courseId :"
				+ courseId);

		return courseSubjectClassification;
	}

}
