/**
 * 
 */
package com.ziksana.service.course.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Map<String, String> getSubjectCategory() {
		// TODO Auto-generated method stub

		Map<String, String> map = courseSubjectDetailMapper
				.getSubjectCategory();
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.course.CourseSubjectDetailService#getSubjectArea(
	 * java.lang.Integer)
	 */
	@Override
	public Map<String, String> getSubjectArea(String subjectArea) {
		Map<String, String> map = courseSubjectDetailMapper
				.getSubjectArea(subjectArea);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.course.CourseSubjectDetailService#getSubjectTopic
	 * (java.lang.Integer)
	 */
	@Override
	public Map<String, String> getSubjectTopic(String subjectTopic) {
		Map<String, String> map = courseSubjectDetailMapper
				.getSubjectTopic(subjectTopic);
		return map;
	}

}
