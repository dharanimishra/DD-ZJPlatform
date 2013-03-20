package com.ziksana.service.program.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.institution.LearningProgram;
import com.ziksana.persistence.program.ProgramsMapper;
import com.ziksana.service.program.LearningProgramService;

public class LearningProgramServiceImpl implements LearningProgramService {

	private static Logger logger = LoggerFactory
			.getLogger(LearningProgramServiceImpl.class);

	@Autowired
	public ProgramsMapper programsMapper;

	@Override
	public List<LearningProgram> getLearningPrograms(Integer memberRoleId)
			{

		if (memberRoleId == null) {
			
		}

		logger.debug("Member role ID : " + memberRoleId);

		List<LearningProgram> learningProgramsList = null;

		learningProgramsList = programsMapper.getLearningPrograms(memberRoleId);

		return learningProgramsList;
	}

}
