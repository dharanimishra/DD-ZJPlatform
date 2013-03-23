package com.ziksana.service.knowmebetter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import com.ziksana.constants.ZiksanaConstants;
import com.ziksana.domain.common.Choice;
import com.ziksana.domain.common.Question;
import com.ziksana.domain.common.QuestionResponse;
import com.ziksana.exception.knowmebetter.KnowmebetterException;
import com.ziksana.persistence.knowmebetter.PersonalityTestMapper;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.knowmebetter.PersonalityTestService;

@Service
public class PersonalityTestServiceImpl implements PersonalityTestService {

	
	
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
		try{
		personalityTestMapper.saveAnswer(question, userChoice,memberRoleId);
		}
		catch(BadSqlGrammarException ex){
			throw new KnowmebetterException(ZiksanaConstants.KNOWMEBETTER_SQL_DATACCESS_ERROR, ex.getSQLException());
		}

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
		
		try{
		personalityTestMapper.updateAnswer(question, userChoice);
		}
		catch(BadSqlGrammarException ex){
			throw new KnowmebetterException(ZiksanaConstants.KNOWMEBETTER_SQL_DATACCESS_ERROR, ex.getSQLException());
		}
		
	}



	@Override
	public List<Question> getUnansweredQuestionsbyId(Integer questionBankId) {
		 List<Question> questionList = new ArrayList<Question>();
			Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID());
			try{
			questionList =personalityTestMapper.getUnansweredQuestionsbyId(memberRoleId, questionBankId);
			}
			catch(BadSqlGrammarException ex){
				throw new KnowmebetterException(ZiksanaConstants.KNOWMEBETTER_SQL_DATACCESS_ERROR, ex.getSQLException());
			}
			if(questionList.isEmpty()){
				throw new KnowmebetterException(ZiksanaConstants.KNOWMEBETTER_NO_QUESTION_FOUND);
			}
			
			return questionList;
	}
	
	
}
