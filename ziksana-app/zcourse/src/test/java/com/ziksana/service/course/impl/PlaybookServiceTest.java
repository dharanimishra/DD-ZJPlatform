package com.ziksana.service.course.impl;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CoursePlaybook;
import com.ziksana.domain.course.CoursePlaybookStatus;
import com.ziksana.domain.course.CoursePlaybookView;
import com.ziksana.domain.course.PlaybookDeliveryType;
import com.ziksana.domain.course.PlaybookType;
import com.ziksana.service.course.PlaybookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class PlaybookServiceTest extends BaseTest {
	
	@Autowired
	public PlaybookService playbookService;
	
	@Test
	public void testSaveDefaultPlaybook() throws Exception{
		System.out.println("****INSIDE testSaveDefaultPlaybook METHOD **********");
		CoursePlaybook 			coursePlaybook 	= null;

		coursePlaybook = constructDefaultPlaybook(coursePlaybook);
		
		playbookService.createDefaultPlaybook(coursePlaybook);
		
		
		
	}
	
	private CoursePlaybook constructDefaultPlaybook(CoursePlaybook coursePB){
		
		coursePB 		= new CoursePlaybook();
		CoursePlaybookView 		playbookView 	= new CoursePlaybookView();
		
		Course course = new Course();
		course.setCourseId(100);
		coursePB.setCourse(course);
		
		coursePB.setFromDate(new Date(System.currentTimeMillis()));
		
		
		coursePB.setCoursePBStatusId(CoursePlaybookStatus.UNDER_CONSTRUCT.getID());
		
		coursePB.setPlaybookTypeId(PlaybookType.PREVIEW.getID());
		
		playbookView.setCoursePlaybook(coursePB);
		playbookView.setName("Defualt Playbook for Course");
		playbookView.setLayoutMarkupPath("/layout/pbview/");
		playbookView.setContentMarkupPath("/content/pbview/");
		playbookView.setBrochureContentPath("/brochur/pbview");
		playbookView.setDeliveryTypeId(PlaybookDeliveryType.PDF.getID());
		
		coursePB.setPlaybookView(playbookView);
		
		return coursePB;
	}
	
	
}
