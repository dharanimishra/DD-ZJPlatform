/**
 * 
 */
package com.ziksana.service.polls;

import java.util.List;

import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionResponse;
import com.ziksana.domain.polls.PollQuestionResult;
import com.ziksana.domain.polls.PollResult;
import com.ziksana.domain.polls.PollResultNQuestion;
import com.ziksana.persistence.polls.PollQuestionEntity;


/**
 * @author prabu
 *
 */
public interface PollService {
	
	
	
	
	public List<PollResultNQuestion> getPollQuestionsAndResults();
	
	
	public void  pollResponse(PollQuestionResponse pollResponse);
	
	public PollQuestionResult getPollResult( PollQuestion pollQuestion);
	
	public List<PollQuestionEntity>  getAllPollQuestions();
	
	public List<PollQuestionEntity>  getAllPollQuestion();
	
	
	public PollResult getPollResultByQuestion(Integer questionId);
	
	
	public List<PollQuestionEntity>  getAllPollQuestionsByDate(String startDate, String endDate);
	
	
}
