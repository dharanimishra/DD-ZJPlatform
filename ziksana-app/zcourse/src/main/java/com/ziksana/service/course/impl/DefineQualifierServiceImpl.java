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

	private final static Logger LOGGER = Logger
			.getLogger(DefineQualifierServiceImpl.class);

	private final static String INSTITUTION = "Institution";

	private final static String ME = "Me";

	@Autowired
	public CourseMapper courseMapper;

	@Override
	public void deleteQualifier(Integer memberRoleId,
			final ZID learningComponentTypeId) throws CourseException {

		final Boolean isDelete = true;

		if (learningComponentTypeId == null) {
			throw new CourseException("LearningComponentTypeId cannot be null");
		}

		courseMapper.deleteQualifier(isDelete, memberRoleId,
				Integer.valueOf(learningComponentTypeId.getStorageID()));

	}

	@Override
	public void updateQualifier(LearningComponentType learningComponentType)
			throws CourseException {

		if (learningComponentType == null) {
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

	@Override
	public LearningComponentType getQualifier(Integer memberRoleId,
			final ZID learningComponentTypeId) throws CourseException {
		LearningComponentType learningComponentType = null;
		Boolean isDelete = false;

		if (learningComponentTypeId == null) {
			throw new CourseException("LearningComponentTypeId cannot be null");
		}

		learningComponentType = courseMapper.getQualifier(isDelete,
				memberRoleId,
				Integer.valueOf(learningComponentTypeId.getStorageID()));

		return learningComponentType;
	}

}
