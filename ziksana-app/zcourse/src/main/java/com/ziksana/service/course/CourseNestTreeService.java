package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.NestContentNode;
import com.ziksana.domain.course.NestTreeNode;
import com.ziksana.exception.course.CourseException;

public interface CourseNestTreeService {

	List<NestTreeNode> getCourseComponent(Integer courseId)
			throws CourseException;

	List<NestTreeNode> getModuleComponents(Integer courseId)
			throws CourseException;

	List<NestContentNode> getContentComponents(Integer courseId)
			throws CourseException;

}
