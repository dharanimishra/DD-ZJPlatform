package com.ziksana.service.knowmebetter.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.common.Choice;
import com.ziksana.domain.common.Question;
import com.ziksana.domain.common.QuestionResponse;
import com.ziksana.persistence.knowmebetter.PersonalityTestMapper;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.knowmebetter.PersonalityTestService;

@Service
public class PersonalityTestServiceImpl implements PersonalityTestService {

	private static Logger logger = LoggerFactory.getLogger(PersonalityTestServiceImpl.class);
	
	@Autowired
	PersonalityTestMapper personalityTestMapper;
	
	@Override
	public List<Question> getUnansweredQuestions() {
		 List<Question> questionList = new ArrayList<Question>();
		Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID());
		questionList =personalityTestMapper.getUnansweredQuestions(memberRoleId);
		
		
		return questionList;
	}

	

	@Override
	public void saveAnswer(Question question, Choice userChoice) {
		Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID());
		personalityTestMapper.saveAnswer(question, userChoice,memberRoleId);

	}

	@Override
	public List<QuestionResponse> answeredQuestions() {
		List<QuestionResponse> questionResponse = new ArrayList<QuestionResponse>();
		Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID());
		questionResponse = personalityTestMapper.answeredQuestions(memberRoleId);
		
		return questionResponse;
		
	}



	@Override
	public void updateAnswer(Question question, Choice userChoice) {
		personalityTestMapper.updateAnswer(question, userChoice);
		
	}



	@Override
	public List<Question> getUnansweredQuestionsbyId(Integer questionBankId) {
		 List<Question> questionList = new ArrayList<Question>();
			Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID());
			questionList =personalityTestMapper.getUnansweredQuestionsbyId(memberRoleId, questionBankId);
			
			
			return questionList;
	}
	
	
}
