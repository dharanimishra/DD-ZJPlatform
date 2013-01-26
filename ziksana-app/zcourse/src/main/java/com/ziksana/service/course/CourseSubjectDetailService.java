package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.Option;

/**
 * @author ratneshkumar Dec 15, 2012
 * 
 * 
 */
public interface CourseSubjectDetailService {

	List<Option> getSubjectCategory();

	List<Option> getSubjectArea(String subjectArea);

	List<Option> getSubjectTopic(String subjectTopic);

}
