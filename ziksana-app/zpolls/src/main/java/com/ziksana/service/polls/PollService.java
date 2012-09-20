/**
 * 
 */
package com.ziksana.service.polls;

import java.util.Date;
import java.util.List;

import com.ziksana.domain.polls.Poll;
import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionResponse;

/**
 * @author prabu
 *
 */
public interface PollService {
	
	public List<PollQuestion>  getUnansweredPollQuestions(Integer memberRoleId);
	
	
	public PollQuestionResponse answerPoll(Integer memberRoleId, Integer pollQuestionId, Integer pollAnswerId);
 	
	int getTotalUnansweredQuestions(Integer memberRoleId); 
	
	
}
