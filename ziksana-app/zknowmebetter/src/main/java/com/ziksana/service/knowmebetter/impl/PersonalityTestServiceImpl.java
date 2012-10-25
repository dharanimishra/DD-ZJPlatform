package com.ziksana.service.knowmebetter.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.common.Choice;
import com.ziksana.domain.common.Question;
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
		// TODO Auto-generated method stub

	}

	@Override
	public Map<Question, Choice> answeredQuestions() {
		// TODO Auto-generated method stub
		return null;
	}

}
