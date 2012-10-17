package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.CourseSearchType;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.member.Member;
import com.ziksana.exception.course.CourseException;

public interface CourseSearchService {

	public List<LearningComponent> searchCourseComponent(
			Member member, CourseSearchType courseSearchType,
			LearningComponent learningComponnt) throws CourseException;

}
