package com.ziksana.service.course.impl;

import java.util.Date;
import java.util.List;

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
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
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

	@Test
	public void testGetPlaybook() throws CourseException{
		
		System.out.println("****INSIDE testGetPlaybook METHOD **********");
		Integer coursePlaybookId = 13;
		
		CoursePlaybook coursePB = playbookService.getCoursePlaybook(coursePlaybookId);
		
		System.out.println("Course play book : "+coursePB.getCoursePlaybookId());
		
		System.out.println("Course play book : "+coursePB.toString());
		
	}
	
	@Test
	public void testDeletePlaybook() throws CourseException{
		
		System.out.println("****INSIDE testDeletePlaybook METHOD **********");
		
		ZID playbookId = new StringZID("13");
		
		playbookService.deleteCoursePlaybook(playbookId);
		
	}
	
	@Test
	public void testUpdatePlaybook() throws CourseException{
		
		System.out.println("****INSIDE testUpdatePlaybook METHOD **********");
		
		CoursePlaybook playbook = constructPlaybookForUpdate();
		
		playbookService.updateCoursePlaybook(playbook);
	
	}
	
	@Test
	public void testGetPlaybookList() throws CourseException{
		
		System.out.println("****INSIDE testUpdatePlaybook METHOD **********");
		
		List<CoursePlaybook> playbookList = null;
		Integer courseId = 100;
		playbookList = playbookService.getPlaybookList(courseId);
	
		System.out.println("Playbook list size : "+playbookList.size());
	}
	
	
	
	
	private CoursePlaybook constructPlaybookForUpdate(){
		CoursePlaybook playbook = null;
		
		playbook = new CoursePlaybook();
		playbook.setCoursePlaybookId(13);
		
		CoursePlaybookView pbView = new CoursePlaybookView();
		pbView.setCoursePlaybook(playbook);
		
		pbView.setCoursePlaybookViewId(3);
		
		pbView.setContentMarkupPath("/content/playbookview/");
		pbView.setName("Mathathematics Playbook");
				
		playbook.setPlaybookView(pbView);
		return playbook;
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
