package com.ziksana.service.course.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.CourseTagcloud;
import com.ziksana.exception.course.CourseException;
import com.ziksana.persistence.course.CourseTagcloudMapper;
import com.ziksana.service.course.TagCloudService;

@Service
public class TagCloudServiceImpl implements TagCloudService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(TagCloudServiceImpl.class);

	@Autowired
	public CourseTagcloudMapper courseTagcloudMapper;

	@Override
	public CourseTagcloud saveOrUpadteTags(CourseTagcloud courseTagcloud)
			throws CourseException {
		CourseTagcloud tags = null;
		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :saveOrUpadteTags(Integer courseId)"
				+ courseTagcloud);
		if (courseTagcloud.getCourseTagCloudId() != null) {
			tags = courseTagcloudMapper.update(courseTagcloud);
		} else {
			tags = courseTagcloudMapper.save(courseTagcloud);
		}

		LOGGER.debug("Exiting Class :" + getClass()
				+ " Method Name :saveOrUpadteTags(Integer courseId)"
				+ courseTagcloud);

		return tags;
	}

	@Override
	public CourseTagcloud getCourseTagClouds(Integer courseId) {
		CourseTagcloud tags = null;
		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :saveOrUpadteTags(Integer courseId)" + courseId);

		tags = courseTagcloudMapper.getCourseTagClouds(courseId);

		LOGGER.debug("Exiting Class :" + getClass()
				+ " Method Name :saveOrUpadteTags(Integer courseId)" + courseId);

		return tags;
	}

}
