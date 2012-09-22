/**
 * 
 */
package com.ziksana.service.polls.impl;

import java.util.Date;
import java.util.List;

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
	public PollMapper pollMapper;
	@Autowired
	public PollQuestionMapper pollQuestionMapper;
	@Autowired
	public PollQuestionResponseMapper pollQuestionResponseMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ziksana.service.polls.PollService#getPoll(java.lang.Integer)
	 */
	@Override
	public List<PollQuestion> getUnansweredPollQuestions(Integer memberRoleId) {
		logger.info("getPoll method is invoked");
		return pollQuestionMapper.getPoll(memberRoleId);

	}

	
	
	@Override
	public int  getTotalUnansweredQuestions(Integer id) {
		// TODO Auto-generated method stub
		return pollQuestionMapper.getTotalQuestions(id);
		
	}

	@Override
	public List<PollQuestionNResult> getPollQuestionsAndResults(
			MemberPersona memberPersona) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ziksana.service.polls.PollService#pollResponse(com.ziksana.domain.member.Member, com.ziksana.domain.polls.PollResponse)
	 */
	@Override
	public void pollResponse(MemberPersona memberPersona, PollResponse pollResponse) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.ziksana.service.polls.PollService#getPollResult(com.ziksana.domain.member.Member, com.ziksana.domain.polls.PollQuestion)
	 */
	@Override
	public PollResult getPollResult(MemberPersona memberPersona,
			PollQuestion pollQuestion) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
