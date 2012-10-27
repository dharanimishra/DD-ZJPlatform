package com.ziksana.service.knowmebetter.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.common.Choice;
import com.ziksana.domain.common.Question;
import com.ziksana.domain.common.QuestionResponse;
import com.ziksana.persistence.knowmebetter.PersonalityTestMapper;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.knowmebetter.PersonalityTestService;

public class PersonalityTestServiceImpl implements PersonalityTestService {

	@Autowired
	PersonalityTestMapper personalityTestMapper;
	
	@Override
	public List<Question> getUnansweredQuestions() {
		// TODO Auto-generated method stub
		Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID());
		return personalityTestMapper.getUnansweredQuestions(memberRoleId);
		
	}

	@Override
	public void saveAnswer(Question question, Choice userChoice) {
		personalityTestMapper.saveAnswer(question, userChoice);

	}

	@Override
	public List<QuestionResponse> answeredQuestions() {
		
		Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID());
		return personalityTestMapper.answeredQuestions(memberRoleId);
		
	}

}
