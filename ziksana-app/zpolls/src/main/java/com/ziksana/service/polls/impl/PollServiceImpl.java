/**
 * 
 */
package com.ziksana.service.polls.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.member.Member;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionNResult;
import com.ziksana.domain.polls.PollResponse;
import com.ziksana.domain.polls.PollResult;

import com.ziksana.persistence.polls.PollMapper;
import com.ziksana.persistence.polls.PollQuestionMapper;
import com.ziksana.persistence.polls.PollQuestionResponseMapper;
import com.ziksana.service.polls.PollService;

/**
 * @author prabu
 * 
 */

public class PollServiceImpl implements PollService {

	private static Logger logger = Logger.getLogger(PollServiceImpl.class);
	
	
	@Autowired
	public PollQuestionMapper pollQuestionMapper;
	@Autowired
	public PollQuestionResponseMapper pollQuestionResponseMapper;

	

	

	@Override
	public List<PollQuestionNResult> getPollQuestionsAndResults(
			MemberPersona memberPersona) {
		
		Validate.notNull(memberPersona, "MemberPersona cannot be null.");
		List<PollResult> pollResults =  pollQuestionMapper.getPollResults(memberPersona.getMemberRoleId());
		
		List<PollQuestionNResult> pollQuestionsNResults = new ArrayList<PollQuestionNResult>();
		
		for (PollResult pollResult : pollResults)
		{
			PollQuestionNResult pollQuestionResult = new PollQuestionNResult();
			pollQuestionResult.setPollResult(pollResult);
			pollQuestionsNResults.add(pollQuestionResult);
		}
		
		List<PollQuestion> pollQuestions =  pollQuestionMapper.getPollQuestions(memberPersona.getMemberRoleId());
		
		for(PollQuestion pollQuestion: pollQuestions)
		{
			PollQuestionNResult pollQuestionResult = new PollQuestionNResult();
			pollQuestionResult.setPollQuestion(pollQuestion);
			pollQuestionsNResults.add(pollQuestionResult);
			
		}
		
		
		return pollQuestionsNResults;
	}

	/* (non-Javadoc)
	 * @see com.ziksana.service.polls.PollService#pollResponse(com.ziksana.domain.member.Member, com.ziksana.domain.polls.PollResponse)
	 */
	@Override
	public void pollResponse(MemberPersona memberPersona, PollResponse pollResponse) {
		 Validate.notNull(memberPersona, "MemberPersona cannot be null.");
		 Validate.notNull(pollResponse,  "PollQuestion cannot be null.");		
		 pollQuestionResponseMapper.createPollTrackerEntry(pollResponse.getPollQuestion().getID(), memberPersona.getMemberRoleId());
		 pollQuestionResponseMapper.createPollResponse(pollResponse);
		
		
	}

	/* (non-Javadoc)
	 * @see com.ziksana.service.polls.PollService#getPollResult(com.ziksana.domain.member.Member, com.ziksana.domain.polls.PollQuestion)
	 */
	@Override
	public PollResult getPollResult(MemberPersona memberPersona,
			PollQuestion pollQuestion) {
		
		Validate.notNull(memberPersona, "MemberPersona cannot be null.");
		Validate.notNull(pollQuestion,  "PollQuestion cannot be null.");
		PollResult pollResult = pollQuestionResponseMapper.getPollResultByQuestion(pollQuestion.getID(), memberPersona.getMemberRoleId());
		return pollResult;
		
		
	}
	
	
	

}
