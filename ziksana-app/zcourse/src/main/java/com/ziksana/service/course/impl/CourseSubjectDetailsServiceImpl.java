
package com.ziksana.service.course.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

		return null;
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
		return null;
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
		return null;
	}

}
