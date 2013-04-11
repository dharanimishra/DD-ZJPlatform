package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentType;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;
import com.ziksana.persistence.course.CourseMapper;
import com.ziksana.service.course.DefineQualifierService;

@Service
public class DefineQualifierServiceImpl implements DefineQualifierService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(DefineQualifierServiceImpl.class);

	private final static String INSTITUTION = "Institution";

	private final static String ME = "Me";

	@Autowired
	public CourseMapper courseMapper;

	public void deleteQualifier(Integer memberRoleId,
			final ZID learningComponentTypeId) throws CourseException {

		final Boolean isDelete = true;

		courseMapper.deleteQualifier(isDelete, memberRoleId,
				Integer.valueOf(learningComponentTypeId.getStorageID()));

	}

	public void updateQualifier(LearningComponentType learningComponentType)
			throws CourseException {

		courseMapper.updateQualifier(learningComponentType);

	}

	public List<LearningComponent> searchQualifier(
			LearningComponent learningComponent) {
		return null;
	}

	public void associateNewQualifier(LearningComponent learningComponent) {
	}

	@Transactional
	public List<LearningComponentType> getDefinedQualifiersList(
			final MemberPersona memberPersona) throws CourseException {

		List<LearningComponentType> defineQualifierList = null;
		Boolean isDefineQualifier = true;
		List<LearningComponentType> updatedDefineQualifierList = null;
		MemberPersona memPersona = null;
		Integer memberRoleId = memberPersona.getMemberRoleId();

		defineQualifierList = courseMapper.getDefinieQualifiers(memberRoleId,
				isDefineQualifier);

		updatedDefineQualifierList = new ArrayList<LearningComponentType>();

		for (LearningComponentType learningComponentType : defineQualifierList) {

			memPersona = learningComponentType.getCreatorMemberPersona();

			Integer institutionId = courseMapper.checkInstitution(memPersona
					.getMemberRoleId());

			if (institutionId != null) {
				learningComponentType.setDefinedBy(INSTITUTION);
			} else {
				learningComponentType.setDefinedBy(ME);
			}

			updatedDefineQualifierList.add(learningComponentType);
		}

		LOGGER.debug("Define Qualifiers list size : "
				+ updatedDefineQualifierList.size());

		return updatedDefineQualifierList;
	}

	public LearningComponentType getQualifier(Integer memberRoleId,
			final ZID learningComponentTypeId) throws CourseException {
		LearningComponentType learningComponentType = null;
		Boolean isDelete = false;

		learningComponentType = courseMapper.getQualifier(isDelete,
				memberRoleId,
				Integer.valueOf(learningComponentTypeId.getStorageID()));

		return learningComponentType;
	}

}
