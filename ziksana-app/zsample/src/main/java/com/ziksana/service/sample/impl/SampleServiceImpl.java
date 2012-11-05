package com.ziksana.service.sample.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ziksana.domain.sample.AcademicProgram;
import com.ziksana.domain.sample.Blog;
import com.ziksana.domain.sample.Course;
import com.ziksana.domain.sample.CourseAddlInfo;
import com.ziksana.domain.sample.CourseContents;
import com.ziksana.service.sample.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

	public List<Course> getAvailableCourses() {
		
		Course course1 = new Course();
		course1.setCourseId("CS101");
		course1.setCourseName("Computer Architecture");
		course1.setCourseDescription("Basic introduction about computer architecture");
		course1.setEducatorFullName("John Smith");
		course1.setCourseImageName("cs101.png");

		Course course2 = new Course();
		course2.setCourseId("EM301");
		course2.setCourseName("Engineering Materials");
		course2.setCourseDescription("Basic introduction about engineering materials");
		course2.setEducatorFullName("Jane Metal");
		course2.setCourseImageName("em301.png");
		
		List<Course> courseList = new ArrayList<Course>();
		courseList.add(course1);
		courseList.add(course2);
		
		return courseList;
	}
	
	public CourseAddlInfo getCourseDetails(String courseId) {
		
		CourseAddlInfo course = new CourseAddlInfo();
		course.setCourseId("CS101");
		course.setCourseName("Computer Architecture");
		course.setCourseDescription("Basic introduction about computer architecture");
		course.setEducatorFullName("John Smith");
		course.setCourseImageName("cs101.png");
		
		course.setMerits(50);
		course.setDurationInWeeks(20);
		course.setAcademciProgram(new AcademicProgram());
		course.setCourseContents(new CourseContents());
		
		return course;
	}
	
	public List<Blog> getBlogList(){
		List<String> blogTag = new ArrayList<String>();
		blogTag.add("Innovation");
		blogTag.add("Apple");
		blogTag.add("Computer");
		
		Blog blg1 = new Blog();
		blg1.setBlogId("1");
		blg1.setBlogDate("03/09/2012");
		blg1.setBlogTitle("Innovation in IT Industry");
		blg1.setBlogDetail("Apple has brought out new products every year, is that an example of innovation");
		blg1.setBlogTags(blogTag);
		
		Blog blg2 = new Blog();
		blg2.setBlogId("2");
		blg2.setBlogDate("03/10/2012");
		blg2.setBlogTitle("Scala - next gen language");
		blg2.setBlogDetail("Scala is very popular language and gaining acceptance in Java Developer Community");
		blg2.setBlogTags(blogTag);
		
		List<Blog> blogList = new ArrayList<Blog>();
		
		blogList.add(blg1);
		blogList.add(blg2);
		
		return blogList;
	}
}
