package com.ziksana.service.sample;

import java.util.List;

import com.ziksana.domain.sample.Blog;
import com.ziksana.domain.sample.Course;
import com.ziksana.domain.sample.CourseAddlInfo;

public interface SampleService {

	public List<Course> getAvailableCourses();
	
	public CourseAddlInfo getCourseDetails(String courseId);
	
	public List<Blog> getBlogList();
}
