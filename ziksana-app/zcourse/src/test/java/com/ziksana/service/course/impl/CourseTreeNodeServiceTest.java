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
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out
				.println("learningComponentType :"
						+ learningComponentType.getQualifierIndicator()
						+ " learningComponentType "
						+ learningComponentType.getActive());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

	}

	@Test
	public void getLearningContentPartsTest() throws Exception {
		Integer learningContentId = 6;
		System.out
				.println("@@@@@@@@@@@@@@@@@@@@@getLearningComponentTest() @@@@@@@@@@@@@@@@@@@@@@@@");

		List<LearningContentParts> list = courseTreeNodeService
				.getLearningContentParts(learningContentId);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("learningComponent list  :" + list.size());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

	}

	@Test
	public void getLearningContentTest() throws Exception {
		Integer learningContentId = 7;
		System.out
				.println("@@@@@@@@@@@@@@@@@@@@@getLearningContentTest() @@@@@@@@@@@@@@@@@@@@@@@@");

		LearningContent LearningContent = courseTreeNodeService
				.getLearningContent(learningContentId);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("LearningContent  :" + LearningContent
				+ " LearningContent :" + LearningContent.getContentName());

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

	}

	@Test
	public void getLearningComponentTest() throws Exception {
		Integer learningComponentId = 4;
		System.out
				.println("@@@@@@@@@@@@@@@@@@@@@getLearningComponentTest() @@@@@@@@@@@@@@@@@@@@@@@@");

		LearningComponent learningComponent = courseTreeNodeService
				.getLearningComponent(learningComponentId);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("learningComponent list  :"
				+ learningComponent.getName() + learningComponent);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

	}

	@Test
	public void CourseLearningComponentTest() throws Exception {
		Integer courseId = 101;
		System.out
				.println("@@@@@@@@@@@@@@@@@@@@@CourseLearningComponentTest() @@@@@@@@@@@@@@@@@@@@@@@@");
		List<CourseLearningComponent> list = courseTreeNodeService
				.getLearningComponents(courseId);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("List<CourseLearningComponent> list  :"
				+ list.size());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

	}

	@Test
	public void CourseTreeNodeTest() throws Exception {
		System.out
				.println("@@@@@@@@@@@@@@@@@@@ CourseTreeNodeTest() @@@@@@@@@@@@@@@@@@@@@@@@@@");
		Integer courseId = 100;
		Course course = courseTreeNodeService.getCourseComponents(courseId);

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("Course :" + course.getName());
		System.out.println("Course Description:" + course.getDescription());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

	}

}
