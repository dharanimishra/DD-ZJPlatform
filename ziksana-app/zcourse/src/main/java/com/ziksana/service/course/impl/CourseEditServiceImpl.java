package com.ziksana.service.course.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.CourseEditResponse;

import com.ziksana.domain.course.ModuleEditResponse;
import com.ziksana.persistence.course.CourseMapper;
import com.ziksana.persistence.course.CourseTagcloudMapper;
import com.ziksana.service.course.CourseEditService;

@Service
public class CourseEditServiceImpl implements CourseEditService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(CourseEditServiceImpl.class);

	@Autowired
	public CourseMapper courseMapper;
	@Autowired
	public CourseTagcloudMapper tagCloudMapper;

	public CourseEditResponse getCourseDetails(Integer courseId) {
		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :getCourseDetails(Integer courseId)" + courseId);
		CourseEditResponse courseEditResponse = courseMapper
				.getCourseDetails(courseId);
		LOGGER.debug("Exiting Class :" + getClass()
				+ " Method Name :getCourseDetails(Integer courseId)"
				+ courseEditResponse);

		return courseEditResponse;
	}

	public ModuleEditResponse getModuleDetails(Integer learningComponentId) {
		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :getModuleDetails(Integer courseId)"
				+ "learningComponentId :" + learningComponentId);
		ModuleEditResponse moduleEditResponse = courseMapper
				.getModuleDetails(learningComponentId);
		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :getCourseDetails(Integer courseId) :learningComponentId :"
				+ learningComponentId + ":" + moduleEditResponse);

		return moduleEditResponse;
	}

}
