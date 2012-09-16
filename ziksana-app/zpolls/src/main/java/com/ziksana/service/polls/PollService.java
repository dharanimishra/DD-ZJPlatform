/**
 * 
 */
package com.ziksana.service.polls;

import java.util.Date;

import com.ziksana.domain.polls.Poll;
import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionResponse;

/**
 * @author prabu
 *
 */
public interface PollService {
	
	public PollQuestion getPoll(Integer memberRoleId, Integer pollId, Date pollStartDate,Date pollEndDate);
	
	
	public PollQuestionResponse answerPoll(Integer pollQuestionId, Integer pollAnswerId);
	

}
