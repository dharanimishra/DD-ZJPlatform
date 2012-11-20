package com.ziksana.service.course.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.service.course.CourseContentService;

/**
 * @author bhashasp
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class AssociateContentServiceTest extends BaseTest {

	@Autowired
	public CourseContentService contentService;
	
	
	@Test
	public void testSaveOrUpdateAssociateContent() throws Exception{
		
		Course course = null;
		
		course = constructContent(course);
		
	}


	private Course constructContent(Course course) {
		
		course = new Course();
		
		course.setCourseId(100);
		
		LearningComponent component = new LearningComponent();
		component.setLearningComponentId(3);
		
		LearningComponentContent compContent = new LearningComponentContent();
		compContent.setLearningComponent(component);
		
		LearningContent content = new LearningContent();
		content.setBaseComponentContent(compContent);
		content.setContentName("Trignometry Intro");
		
		
		return null;
	}
}
