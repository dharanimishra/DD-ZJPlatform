/**
 * 
 */
package com.ziksana.service.polls.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.member.Member;
import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionNResult;
import com.ziksana.domain.polls.PollQuestionResponse;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ziksana.service.polls.PollService#answerPoll(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public PollQuestionResponse answerPoll(Integer memberRoleId, Integer pollQuestionId,
			Integer pollAnswerId) {
        logger.info("answerPoll method is invoked");
		// Create pollquestionresponse object based on pollquestionid
		PollQuestionResponse pollQuestionResponse = new PollQuestionResponse();
		pollQuestionResponseMapper.updateByPrimaryKey(pollQuestionResponse);
		// TODO Auto-generated method stub
		return pollQuestionResponse;
	}

	@Override
	public int  getTotalUnansweredQuestions(Integer id) {
		// TODO Auto-generated method stub
		return pollQuestionMapper.getTotalQuestions(id);
		
	}

	@Override
	public List<PollQuestionNResult> getPollQuestionsAndResults(
			Member memberPersona) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
