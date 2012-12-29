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
		System.out
				.println("@@@@@@@@@@@@@@@@@@@@@ getCourseTest() @@@@@@@@@@@@@@@@@@@@@@@@");

		Course course = courseTreeNodeService.getCourseComponents(courseId);
		System.out.println("course :" + course.getName() + course);

		System.out.println("<Node ID=" + course.getCourseId().getDisplayID()
				+ " Name=" + course.getName() + ">");

		List<CourseLearningComponent> list = courseTreeNodeService
				.getLearningComponents(courseId);

		for (CourseLearningComponent courseLearningComponent : list) {
			System.out.println("Second Loop ------");
			System.out.println("<Node ID=\""
					+ courseLearningComponent.getCourseLearningComponentId()
							.getDisplayID() + "\" Name="
					+ courseLearningComponent.getLearningComponent().getName()
					+ "\">");
			String getCourseLearningComponentId = courseLearningComponent
					.getCourseLearningComponentId().getStorageID();
			System.out.println("Second Loop ------" + courseLearningComponent);

			LearningContent LearningContent = courseTreeNodeService
					.getLearningContent(Integer
							.valueOf(getCourseLearningComponentId));
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

			System.out.println("<Node ID=\""
					+ LearningContent.getLearningContentId() + "\" Name='"
					+ LearningContent.getContentName() + "\">");

			System.out.println("LearningContent :" + LearningContent);
			System.out.println("</Node>");
			System.out.println("</Node>");
			System.out.println("Second Loop End ------");
		}

		System.out.println("</Node>");
		System.out.println("First Loop End------");

	}
}
