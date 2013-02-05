package com.ziksana.service.course;

import com.ziksana.domain.course.CourseTagcloud;
import com.ziksana.exception.course.CourseException;

public interface TagCloudService {

	public CourseTagcloud saveOrUpadteTags(CourseTagcloud courseTagcloud)
			throws CourseException;

	public CourseTagcloud getCourseTagClouds(Integer courseId);

}
