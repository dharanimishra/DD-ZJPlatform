package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.institution.LearningProgram;
import com.ziksana.domain.member.Member;
import com.ziksana.exception.course.CourseException;


public interface LearningProgramService {
	
	/**
	 * Gets the list of LearningPrograms which are associated to Curriculum.
	 * @param member
	 * @return
	 * @throws CourseException
	 */
	public List<LearningProgram> getLearningPrograms(Member member) throws CourseException;

	
}
