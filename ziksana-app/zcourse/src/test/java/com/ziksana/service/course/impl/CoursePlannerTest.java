package com.ziksana.service.course.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.CourseLearningPlanner;
import com.ziksana.domain.course.Duration;
import com.ziksana.service.course.CoursePlannerService;

/**
 * @author bhashasp
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CoursePlannerTest extends BaseTest{
	
	@Autowired
	public CoursePlannerService coursePlannerService;
	
	@Test
	public void testSaveCoursePlanner() throws Exception{
		
		System.out.println("*****INSIDE testSaveCoursePlanner METHOD ************");
		Course course = null;
		
		course = constructPlannerToSave(course);
		
		System.out.println("Constructed course planner size : "+course.getCourseLearningPlannerList().size());
		
		coursePlannerService.saveCoursePlanner(course);
		
	}
	

	private Course constructPlannerToSave(Course course) {
		
		course = new Course();
		course.setCourseId(100);
		
		CourseLearningComponent clComp = new CourseLearningComponent();
		
		clComp.setCourseLearningComponentId(null);
		
		List<CourseLearningPlanner> 	courseLearningPlannerList 	= null;
		courseLearningPlannerList = new ArrayList<CourseLearningPlanner>();
		
		CourseLearningPlanner planner1 = new CourseLearningPlanner();
		planner1.setCourse(course);
		planner1.setStartPeriod(new Date(System.currentTimeMillis()));
		Duration duration = new Duration(10,null);
		planner1.setDuration(duration);
		planner1.setCourseLearningComponent(clComp);
		courseLearningPlannerList.add(planner1);
		
		CourseLearningPlanner planner2 = new CourseLearningPlanner();
		planner2.setCourse(course);
		planner2.setStartPeriod(new Date(System.currentTimeMillis()));
		Duration duration1 = new Duration(20,null);
		planner2.setDuration(duration1);
		planner2.setCourseLearningComponent(clComp);
		courseLearningPlannerList.add(planner2);

		CourseLearningPlanner planner3 = new CourseLearningPlanner();
		planner3.setCourse(course);
		planner3.setStartPeriod(new Date(System.currentTimeMillis()));
		Duration duration2 = new Duration(30,null);
		planner3.setDuration(duration2);
		planner3.setCourseLearningComponent(clComp);
		courseLearningPlannerList.add(planner3);
		
		course.setCourseLearningPlannerList(courseLearningPlannerList);

		return course;
	}

	
}
