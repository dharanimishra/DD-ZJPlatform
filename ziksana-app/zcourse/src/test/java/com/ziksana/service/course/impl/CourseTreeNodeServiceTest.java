/**
 * 
 */
package com.ziksana.service.course.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentType;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentParts;
import com.ziksana.service.course.CourseTreeNodeService;

/**
 * @author ratneshkumar Dec 10, 2012
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CourseTreeNodeServiceTest extends BaseTest {

	@Autowired
	public CourseTreeNodeService courseTreeNodeService;

	@Test
	public void getLearningComponentTypeTest() throws Exception {
		Integer learningComponentTypeId = 3;
		System.out
				.println("@@@@@@@@@@@@@@@@@@@@@getLearningComponentTypeTest()() @@@@@@@@@@@@@@@@@@@@@@@@");
		LearningComponentType learningComponentType = courseTreeNodeService
				.getLearningComponentType(learningComponentTypeId);

	}

	@Test
	public void getLearningContentPartsTest() throws Exception {
		Integer learningContentId = 6;

		List<LearningContentParts> list = courseTreeNodeService
				.getLearningContentParts(learningContentId);

	}

	@Test
	public void getLearningContentTest() throws Exception {
		Integer learningContentId = 7;

		LearningContent LearningContent = courseTreeNodeService
				.getLearningContent(learningContentId);

	}

	@Test
	public void getLearningComponentTest() throws Exception {
		Integer learningComponentId = 4;
		System.out
				.println("@@@@@@@@@@@@@@@@@@@@@getLearningComponentTest() @@@@@@@@@@@@@@@@@@@@@@@@");

		LearningComponent learningComponent = courseTreeNodeService
				.getLearningComponent(learningComponentId);

	}

	@Test
	public void CourseLearningComponentTest() throws Exception {
		Integer courseId = 101;

		List<CourseLearningComponent> list = courseTreeNodeService
				.getLearningComponents(courseId);

	}

	@Test
	public void CourseTreeNodeTest() throws Exception {

		Integer courseId = 100;
		Course course = courseTreeNodeService.getCourseComponents(courseId);

	}

}
