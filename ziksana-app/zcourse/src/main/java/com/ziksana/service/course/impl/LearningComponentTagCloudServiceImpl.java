package com.ziksana.service.course.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.CourseTagcloud;
import com.ziksana.exception.course.CourseException;
import com.ziksana.persistence.course.LearningComponentTagcloudMapper;
import com.ziksana.service.course.LearningComponentTagCloudService;

@Service
public class LearningComponentTagCloudServiceImpl implements
		LearningComponentTagCloudService {

	private final static Logger LOGGER = Logger
			.getLogger(LearningComponentTagCloudServiceImpl.class);

	@Autowired
	public LearningComponentTagcloudMapper learningComponentTagcloudMapper;

	@Override
	public CourseTagcloud saveOrUpadteTags(CourseTagcloud courseTagcloud)
			throws CourseException {
		CourseTagcloud tags = null;
		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :saveOrUpadteTags(Integer courseId)"
				+ courseTagcloud);
		if (courseTagcloud.getTagCloudId() > 0) {
			tags = learningComponentTagcloudMapper.update(courseTagcloud);
		} else {
			tags = learningComponentTagcloudMapper.save(courseTagcloud);
		}

		LOGGER.debug("Exiting Class :" + getClass()
				+ " Method Name :saveOrUpadteTags(Integer courseId)"
				+ courseTagcloud);

		return tags;
	}

	@Override
	public CourseTagcloud getComponentTagClouds(Integer learningComponentId) {
		CourseTagcloud tags = null;
		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :getComponentTagClouds(Integer courseId)"
				+ learningComponentId);

		tags = learningComponentTagcloudMapper
				.getComponentTagClouds(learningComponentId);

		LOGGER.debug("Exiting Class :" + getClass()
				+ " Method Name :getComponentTagClouds(Integer courseId)"
				+ learningComponentId);

		return tags;
	}

}
