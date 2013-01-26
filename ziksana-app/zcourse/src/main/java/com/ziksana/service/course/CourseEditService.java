package com.ziksana.service.course;

import com.ziksana.domain.course.CourseEditResponse;
import com.ziksana.domain.course.ModuleEditResponse;

public interface CourseEditService {

	public CourseEditResponse getCourseDetails(Integer courseId);

	public ModuleEditResponse getModuleDetails(Integer courseId,Integer learningCompId);

}
