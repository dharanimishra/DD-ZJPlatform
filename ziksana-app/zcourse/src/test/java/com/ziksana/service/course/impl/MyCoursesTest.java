package com.ziksana.service.course.impl;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.member.MemberRoleType;
import com.ziksana.service.course.CourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class MyCoursesTest extends BaseTest{
	
	@Autowired
	public CourseService courseService;
	
	
	@Test
	public void testMyCourses() throws Exception{
		System.out.println("***********Inside testMyCourses method ******************");
		List<Course> coursesList = null;
		
		MemberPersona memberPersona = new MemberPersona(MemberRoleType.EDUCATOR);
		memberPersona.setMemberRoleId(Integer.valueOf(100));
		
		coursesList = courseService.getListOfCourses(memberPersona.getMemberRoleId());
		
		System.out.println("Courses List in Test case : "+coursesList);
		System.out.println("Courses List in Test case : "+coursesList.toString());
		
		System.out.println("Courses List in Test case : "+coursesList.size());
		
		Assert.isTrue(coursesList.size()>0);
		
	}
	
	

}
