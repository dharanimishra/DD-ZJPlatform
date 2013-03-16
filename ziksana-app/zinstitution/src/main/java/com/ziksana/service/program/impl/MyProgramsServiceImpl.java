package com.ziksana.service.program.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.institution.ProgramNameType;
import com.ziksana.exception.program.ProgramsException;
import com.ziksana.persistence.program.ProgramsMapper;
import com.ziksana.service.program.MyProgramsService;

/**
 * @author bhashasp
 */
public class MyProgramsServiceImpl implements MyProgramsService {

	private static Logger logger = LoggerFactory.getLogger(MyProgramsServiceImpl.class);
	
	@Autowired
	public ProgramsMapper programsMapper;
	
	
	@Override
	public Map<ProgramNameType, Integer> getMyPrograms(Integer memberRoleId)
			throws ProgramsException {

		Map<ProgramNameType, Integer> myProgramsMap = new HashMap<ProgramNameType,Integer>();
		int rowCount = 0;
		
		if(memberRoleId == null){
			throw new ProgramsException("Member Role ID cannot be null ");
		}
		
		logger.debug("Member role ID : "+memberRoleId);
		
		rowCount = programsMapper.getCoursesCountByMemberRoleId(memberRoleId);
		myProgramsMap.put(ProgramNameType.COURSE, rowCount);
		Boolean isLearningObject = true;
		
		rowCount = programsMapper.getLearningObjectsCountByMemberRoleId(isLearningObject, memberRoleId);
		myProgramsMap.put(ProgramNameType.LEARNING_OBJECT, rowCount);
		
		rowCount = programsMapper.getLearningContentsCountByMemberRoleId(memberRoleId);
		myProgramsMap.put(ProgramNameType.LEARNING_CONTENT, rowCount);
		
		rowCount = programsMapper.getLearningProgramsCountByMemberRoleId(memberRoleId);
		if(rowCount>0){
			myProgramsMap.put(ProgramNameType.LEARNING_PROGRAM, rowCount);	
		}
		
		logger.debug("My Programs row count details : "+myProgramsMap);
		
		return myProgramsMap;
	}

}
