/**
 * 
 */
package com.ziksana.service.polls;

import com.ziksana.domain.polls.Poll;
import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionResponse;

/**
 * @author prabu
 *
 */
public interface PollService {
	
	public PollQuestion getPoll(Integer pollId);
	
	
	public PollQuestionResponse answerPoll(Integer pollQuestionId, Integer pollAnswerId);
	

}
