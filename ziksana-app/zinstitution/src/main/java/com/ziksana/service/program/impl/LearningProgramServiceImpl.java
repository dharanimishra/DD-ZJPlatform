package com.ziksana.service.program.impl;

import java.util.List;

import com.ziksana.domain.institution.LearningProgram;
import com.ziksana.domain.member.Member;
import com.ziksana.exception.program.ProgramsException;
import com.ziksana.service.program.LearningProgramService;


public class LearningProgramServiceImpl implements LearningProgramService {
	
	@Override
	public List<LearningProgram> getLearningPrograms(Member member)
			throws ProgramsException {
		return null;
	}

	
}
