/**
 * 
 */
package com.ziksana.service.polls;

import java.util.Date;
import java.util.List;

import com.ziksana.domain.member.Member;
import com.ziksana.domain.polls.MemberPersona;
import com.ziksana.domain.polls.Poll;
import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionNResult;
import com.ziksana.domain.polls.PollQuestionResponse;
import com.ziksana.domain.polls.PollResponse;
import com.ziksana.domain.polls.PollResult;

/**
 * @author prabu
 *
 */
public interface PollService {
	
	
	
	
	public List<PollQuestionNResult> getPollQuestionsAndResults(MemberPersona memberPersona);
	
	
	public void  pollResponse(MemberPersona memberPersona,PollResponse pollResponse);
	
	public PollResult getPollResult(MemberPersona memberPersona, PollQuestion pollQuestion);
	
    public List<PollQuestion>  getUnansweredPollQuestions(Integer memberRoleId);
		
	
	public PollQuestionResponse answerPoll(Integer memberRoleId, Integer pollQuestionId, Integer pollAnswerId);
 	
	public int getTotalUnansweredQuestions(Integer memberRoleId);
	
	
	
}
