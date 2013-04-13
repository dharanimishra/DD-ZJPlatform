package com.ziksana.service.knowmebetter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.common.Choice;
import com.ziksana.domain.common.Question;
import com.ziksana.domain.common.QuestionResponse;
import com.ziksana.persistence.knowmebetter.PersonalityTestMapper;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.knowmebetter.PersonalityTestService;

@Service
public class PersonalityTestServiceImpl implements PersonalityTestService {

	@Autowired
	PersonalityTestMapper personalityTestMapper;

	public List<Question> getUnansweredQuestions() {
		List<Question> questionList = new ArrayList<Question>();
		Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID());

		questionList = personalityTestMapper
				.getUnansweredQuestions(memberRoleId);

		return questionList;
	}

	public void saveAnswer(Question question, Choice userChoice) {
		Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID());

		personalityTestMapper.saveAnswer(question, userChoice, memberRoleId);

	}

	public List<QuestionResponse> answeredQuestions() {
		List<QuestionResponse> questionResponse = new ArrayList<QuestionResponse>();

		Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID());
		questionResponse = personalityTestMapper
				.answeredQuestions(memberRoleId);

		return questionResponse;

	}

	public void updateAnswer(Question question, Choice userChoice) {

		personalityTestMapper.updateAnswer(question, userChoice);

	}

	public List<Question> getUnansweredQuestionsbyId(Integer questionBankId) {
		List<Question> questionList = new ArrayList<Question>();
		Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID());

		questionList = personalityTestMapper.getUnansweredQuestionsbyId(
				memberRoleId, questionBankId);

		return questionList;
	}

}
