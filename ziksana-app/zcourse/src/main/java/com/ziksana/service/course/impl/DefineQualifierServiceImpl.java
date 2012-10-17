package com.ziksana.service.course.impl;

import java.util.List;

import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentType;
import com.ziksana.domain.member.Member;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;
import com.ziksana.service.course.DefineQualifierService;

public class DefineQualifierServiceImpl implements DefineQualifierService {


	@Override
	public void deleteQualifier(ZID learningComponentTypeId) {

	}

	@Override
	public void updateQualifier(ZID learningComponentTypeId,
			LearningComponent learningComponent) {

	}

	@Override
	public List<LearningComponent> searchQualifier(
			LearningComponent learningComponent) {
		return null;
	}

	@Override
	public void associateNewQualifier(LearningComponent learningComponent) {
	}

	@Override
	public List<LearningComponentType> getDefinedQualifiers(Member member)
			throws CourseException {
		return null;
	}

}
