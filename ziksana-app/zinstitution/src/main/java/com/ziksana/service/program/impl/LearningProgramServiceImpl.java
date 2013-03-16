package com.ziksana.service.program.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.institution.LearningProgram;
import com.ziksana.exception.program.ProgramsException;
import com.ziksana.persistence.program.ProgramsMapper;
import com.ziksana.service.program.LearningProgramService;

public class LearningProgramServiceImpl implements LearningProgramService {

	private static Logger logger = Logger
			.getLogger(LearningProgramServiceImpl.class);

	@Autowired
	public ProgramsMapper programsMapper;

	@Override
	public List<LearningProgram> getLearningPrograms(Integer memberRoleId)
			throws ProgramsException {

		if (memberRoleId == null) {
			throw new ProgramsException("Member Role ID cannot be null ");
		}

		logger.debug("Member role ID : " + memberRoleId);

		List<LearningProgram> learningProgramsList = null;

		learningProgramsList = programsMapper.getLearningPrograms(memberRoleId);

		return learningProgramsList;
	}

}
