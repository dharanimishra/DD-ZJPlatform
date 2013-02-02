package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.CourseSubjectClassification;
import com.ziksana.domain.course.Option;

/**
 * @author ratneshkumar Dec 15, 2012
 * 
 * 
 */
public interface CourseSubjectDetailService {

	public List<Option> getSubjectCategory();

	public List<Option> getSubjectArea(String subjectArea);

	public List<Option> getSubjectTopic(String subjectTopic);

	public CourseSubjectClassification getSubjectClassification(
			String subjectTopic);

}
