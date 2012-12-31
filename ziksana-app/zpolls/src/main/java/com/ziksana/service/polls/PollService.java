/**
 * 
 */
package com.ziksana.service.polls;

import java.util.Date;
import java.util.List;

import com.ziksana.domain.member.Member;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.polls.Poll;
import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionResponse;
import com.ziksana.domain.polls.PollQuestionResult;
import com.ziksana.domain.polls.PollResultNQuestion;


/**
 * @author prabu
 *
 */
public interface PollService {
	
	
	
	
	public List<PollResultNQuestion> getPollQuestionsAndResults();
	
	
	public void  pollResponse(PollQuestionResponse pollResponse);
	
	public PollQuestionResult getPollResult( PollQuestion pollQuestion);
	
    
	
	
}
