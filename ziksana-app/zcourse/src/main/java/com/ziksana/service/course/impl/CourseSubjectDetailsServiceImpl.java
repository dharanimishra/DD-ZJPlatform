package com.ziksana.service.course.impl;

import java.util.List;

import org.apache.log4j.Logger;
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

	private final static Logger LOGGER = Logger
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
	@Override
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
	@Override
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
	@Override
	public List<Option> getSubjectTopic(String subjectTopic) {
		List<Option> list = courseSubjectDetailMapper
				.getSubjectTopic(subjectTopic);
		return list;
	}

	@Override
	public CourseSubjectClassification getSubjectClassification(
			String subjectTopic) {
		CourseSubjectClassification courseSubjectClassification = null;
		LOGGER.debug("Entering Class :"
				+ getClass()
				+ " Method Name :getSubjectClassification(String subjectArea, String subjectCategory, String subjectTopic) :subjectArea "

				+ " subjectTopic :" + subjectTopic);
		try {
			courseSubjectClassification = courseSubjectDetailMapper
					.getSubjectClassification(subjectTopic);
		} catch (Exception e) {
			LOGGER.error("Exiting Class :"
					+ getClass()
					+ " Method Name :getCoursgetSubjectClassificationeDetails(String subjectArea, String subjectCategory, String subjectTopic):subjectArea "

					+ " subjectTopic :" + subjectTopic + "Exception :" + e);
		}

		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :getCoursgetSubjectClassificationeDetails(String subjectArea, String subjectCategory, String subjectTopic):subjectArea "
				+ " subjectTopic :" + subjectTopic);

		return courseSubjectClassification;
	}

}
