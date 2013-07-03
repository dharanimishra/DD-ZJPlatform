/**
 * 
 */
package com.ziksana.service.knowmebetter;

import java.util.List;

import com.ziksana.domain.common.Choice;
import com.ziksana.domain.common.Question;
import com.ziksana.domain.common.QuestionResponse;

/**
 * @author prabu
 *
 */
public interface PersonalityTestService {
	
	public List<Question>  getUnansweredQuestions();
	
	public void saveAnswer(Question question,Choice userChoice);
	
	public void updateAnswer(Question question,Choice userChoice);
	
	public List<QuestionResponse> answeredQuestions();
	
	public List<Question> getUnansweredQuestionsbyId(Integer questionBankId);
	

}
