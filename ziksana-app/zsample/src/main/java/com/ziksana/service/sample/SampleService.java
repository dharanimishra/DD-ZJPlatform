package com.ziksana.service.sample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ziksana.domain.sample.AcademicProgram;
import com.ziksana.domain.sample.Course;
import com.ziksana.domain.sample.CourseAddlInfo;
import com.ziksana.domain.sample.CourseContents;

@Service
public class SampleService {

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
}
