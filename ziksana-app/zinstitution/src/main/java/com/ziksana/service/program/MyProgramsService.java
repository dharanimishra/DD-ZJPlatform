/**
 * 
 */
package com.ziksana.service.program;

import java.util.Map;

import com.ziksana.domain.institution.ProgramNameType;
import com.ziksana.exception.program.ProgramsException;

/**
 * @author bhashasp
 */
public interface MyProgramsService {
	
	/**
	 * Get the row count for Programs (LearningProgram, Learning Object, Course and Learning Content).
	 * @param member
	 * @return
	 * @throws ProgramsException
	 */
	public Map<ProgramNameType,Integer> getMyPrograms(Integer memberRoleId) throws ProgramsException;

}
