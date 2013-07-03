package com.ziksana.service.course;

import com.ziksana.domain.course.LearningComponentTagcloud;
import com.ziksana.exception.course.CourseException;

public interface LearningComponentTagCloudService {

	public LearningComponentTagcloud saveOrUpadteTags(
			LearningComponentTagcloud learningComponentTagcloud)
			throws CourseException;

	public LearningComponentTagcloud getComponentTagClouds(
			Integer learningComponentId);

}
