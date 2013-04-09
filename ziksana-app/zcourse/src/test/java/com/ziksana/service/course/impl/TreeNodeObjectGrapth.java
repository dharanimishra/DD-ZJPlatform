package com.ziksana.service.course.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.service.course.CourseTreeNodeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TreeNodeObjectGrapth extends BaseTest {

	@Autowired
	public CourseTreeNodeService courseTreeNodeService;

	@Test
	public void getCourseComponetTest() throws Exception {
		Integer courseId = 100;

		Course course = courseTreeNodeService.getCourseComponents(courseId);

		List<CourseLearningComponent> list = courseTreeNodeService
				.getLearningComponents(courseId);

		for (CourseLearningComponent courseLearningComponent : list) {

			String getCourseLearningComponentId = courseLearningComponent
					.getCourseLearningComponentId().getStorageID();

			LearningContent LearningContent = courseTreeNodeService
					.getLearningContent(Integer
							.valueOf(getCourseLearningComponentId));

		}

	}
}
