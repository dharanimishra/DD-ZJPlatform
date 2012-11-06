package com.ziksana.service.program;

import java.util.List;

import com.ziksana.domain.institution.LearningProgram;
import com.ziksana.exception.program.ProgramsException;


/**
 * @author bhashasp
 */
public interface LearningProgramService {
	
	/**
	 * Gets the list of LearningPrograms which are associated to Curriculum.
	 * @param member
	 * @return
	 * @throws CourseException
	 */
	public List<LearningProgram> getLearningPrograms(Integer memberRoleId) throws ProgramsException;
	
	

	
}
