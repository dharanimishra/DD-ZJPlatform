/**
 * 
 */
package com.ziksana.service.knowmebetter;

import java.util.List;
import java.util.Map;

import com.ziksana.domain.common.Choice;
import com.ziksana.domain.common.Question;

/**
 * @author prabu
 *
 */
public interface PersonalityTestService {
	
	public List<Question>  getUnansweredQuestions();
	
	public void saveAnswer(Question question,Choice userChoice);

	public Map<Question,Choice> answeredQuestions();
	
	

}
