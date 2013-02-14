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
		try {
			if (courseTagcloud.getTagCloudId() != null) {
				tags = learningComponentTagcloudMapper.update(courseTagcloud);
			} else {
				tags = learningComponentTagcloudMapper.save(courseTagcloud);
			}
			LOGGER.debug("Exiting Class :" + getClass()
					+ " Method Name :saveOrUpadteTags(Integer courseId):"
					+ tags);

		} catch (Exception e) {
			LOGGER.debug("Exiting Class :"
					+ getClass()
					+ " Method Name :saveOrUpadteTags(Integer courseId): Exception"
					+ tags);
		}

		LOGGER.debug("Exiting Class :" + getClass()
				+ " Method Name :saveOrUpadteTags(Integer courseId)"
				+ courseTagcloud);

		return tags;
	}

	@Override
	public CourseTagcloud getComponentTagClouds(Integer learningComponentId,
			Integer courseId) {
		CourseTagcloud tags = null;
		LOGGER.debug("Entering Class :"
				+ getClass()
				+ " Method Name :getComponentTagClouds(Integer learningComponentId,Integer courseId)"
				+ learningComponentId + "courseId:" + courseId);
		try {
			tags = learningComponentTagcloudMapper.getComponentTagClouds(
					learningComponentId, courseId);
			LOGGER.debug("Exiting Class :"
					+ getClass()
					+ " Method Name :getComponentTagClouds(Integer learningComponentId,Integer courseId):"
					+ tags + "learningComponentId" + learningComponentId
					+ "courseId:" + courseId);
		} catch (Exception e) {
			LOGGER.debug("Exiting Class :"
					+ getClass()
					+ " Method Name :getComponentTagClouds(Integer learningComponentId,Integer courseId): Exception"
					+ tags + "learningComponentId" + learningComponentId
					+ "courseId:" + courseId);
		}

		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :getComponentTagClouds(Integer learningComponentId,Integer courseId)"
				+ "learningComponentId" + learningComponentId + "courseId:"
				+ courseId);

		return tags;
	}

}
