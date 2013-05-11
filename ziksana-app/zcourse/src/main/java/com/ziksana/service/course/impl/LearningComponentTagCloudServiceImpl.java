package com.ziksana.service.course.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.LearningComponentTagcloud;
import com.ziksana.exception.course.CourseException;
import com.ziksana.persistence.course.LearningComponentTagcloudMapper;
import com.ziksana.service.course.LearningComponentTagCloudService;

@Service
public class LearningComponentTagCloudServiceImpl implements
		LearningComponentTagCloudService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(LearningComponentTagCloudServiceImpl.class);

	@Autowired
	public LearningComponentTagcloudMapper learningComponentTagcloudMapper;

	public LearningComponentTagcloud saveOrUpadteTags(
			LearningComponentTagcloud learningComponentTagcloud)
			throws CourseException {
		LearningComponentTagcloud tags = null;
		LOGGER.debug("Entering Class :"
				+ getClass()
				+ " Method Name :saveOrUpadteTags(LearningComponentTagcloud learningComponentTagcloud)"
				+ learningComponentTagcloud);
		if (learningComponentTagcloud.getTagCloudId() != null) {
			tags = learningComponentTagcloudMapper
					.update(learningComponentTagcloud);
		} else {
			tags = learningComponentTagcloudMapper
					.save(learningComponentTagcloud);
		}
		LOGGER.info("Class :"
				+ getClass()
				+ " Method Name :saveOrUpadteTags(LearningComponentTagcloud learningComponentTagcloud):"
				+ tags);

		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :saveOrUpadteTags(LearningComponentTagcloud learningComponentTagcloud)"
				+ learningComponentTagcloud);

		return tags;
	}

	public LearningComponentTagcloud getComponentTagClouds(
			Integer learningComponentId) {
		LearningComponentTagcloud tags = null;
		LOGGER.info("Entering Class :"
				+ getClass()
				+ " Method Name :getComponentTagClouds(Integer learningComponentId,Integer courseId)"
				+ learningComponentId);
		tags = learningComponentTagcloudMapper
				.getComponentTagClouds(learningComponentId);
		LOGGER.info("Class :"
				+ getClass()
				+ " Method Name :getComponentTagClouds(Integer learningComponentId,Integer courseId):"
				+ tags + "learningComponentId" + learningComponentId);

		LOGGER.info("Exiting Class :"
				+ getClass()
				+ " Method Name :getComponentTagClouds(Integer learningComponentId,Integer courseId)"
				+ "learningComponentId" + learningComponentId);

		return tags;
	}

}
