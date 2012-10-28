package com.ziksana.service.program;

import java.util.List;

import com.ziksana.domain.institution.LearningProgram;
import com.ziksana.domain.member.Member;
import com.ziksana.exception.program.ProgramsException;


public interface LearningProgramService {
	
	/**
	 * Gets the list of LearningPrograms which are associated to Curriculum.
	 * @param member
	 * @return
	 * @throws CourseException
	 */
	public List<LearningProgram> getLearningPrograms(Member member) throws ProgramsException;

	
}
