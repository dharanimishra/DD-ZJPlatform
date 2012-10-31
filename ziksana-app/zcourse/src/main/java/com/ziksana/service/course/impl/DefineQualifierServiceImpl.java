package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentType;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;
import com.ziksana.persistence.course.CourseMapper;
import com.ziksana.service.course.DefineQualifierService;

public class DefineQualifierServiceImpl implements DefineQualifierService {

	private static Logger logger = Logger.getLogger(DefineQualifierServiceImpl.class);
	
	private static String INSTITUTION = "Institution";
	
	private static String ME	= "Me";
	
	@Autowired
	public CourseMapper courseMapper;
	
	@Override
	public void deleteQualifier(Integer memberRoleId, ZID learningComponentTypeId) throws  CourseException {

		Boolean isDelete = true;
		
		if(learningComponentTypeId == null){
			throw new CourseException("LearningComponentTypeId cannot be null");
		}
		
		courseMapper.deleteQualifier(isDelete, memberRoleId, new Integer(learningComponentTypeId.getStorageID()));
		
	}
	
	@Override
	public void updateQualifier(LearningComponentType learningComponentType) throws CourseException {

		if(learningComponentType == null){
			throw new CourseException("LearningComponentTypeId cannot be null");
		}
		
		courseMapper.updateQualifier(learningComponentType);

	}

	@Override
	public List<LearningComponent> searchQualifier(
			LearningComponent learningComponent) {
		return null;
	}

	@Override
	public void associateNewQualifier(LearningComponent learningComponent) {
	}

	@Transactional
	@Override
	public List<LearningComponentType> getDefinedQualifiersList(MemberPersona memberPersona)
			throws CourseException {
		
		List<LearningComponentType> defineQualifierList 		= null;
		Boolean 					isDefineQualifier 			= true;
		List<LearningComponentType> updatedDefineQualifierList 	= null;
		MemberPersona				memPersona					= null;
		Integer memberRoleId = memberPersona.getMemberRoleId();	
		
		defineQualifierList = courseMapper.getDefinieQualifiers(memberRoleId, isDefineQualifier);
		
		updatedDefineQualifierList = new ArrayList<LearningComponentType>();
		
		for (LearningComponentType learningComponentType : defineQualifierList) {
			
			memPersona = learningComponentType.getCreatorMemberPersona();
			
			Integer institutionId = courseMapper.checkInstitution(memPersona.getMemberRoleId());
			
			if(institutionId!=null){
				learningComponentType.setDefinedBy(INSTITUTION);
			}else{
				learningComponentType.setDefinedBy(ME);
			}
			
			updatedDefineQualifierList.add(learningComponentType);
		}
		
		logger.debug("Define Qualifiers list size : "+updatedDefineQualifierList.size());
		
		return updatedDefineQualifierList;
	}

	@Override
	public LearningComponentType getQualifier(Integer memberRoleId, ZID learningComponentTypeId)
			throws CourseException {
		LearningComponentType learningComponentType = null;
		Boolean isDelete = false;
		
		if(learningComponentTypeId == null){
			throw new CourseException("LearningComponentTypeId cannot be null");
		}
		
		learningComponentType = courseMapper.getQualifier(isDelete, memberRoleId, new Integer(learningComponentTypeId.getStorageID()));

		return learningComponentType;
	}

}
