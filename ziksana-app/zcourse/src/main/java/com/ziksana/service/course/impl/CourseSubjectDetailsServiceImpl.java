
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

}
