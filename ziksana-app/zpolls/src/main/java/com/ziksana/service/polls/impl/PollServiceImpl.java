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
import org.springframework.stereotype.Service;

import com.ziksana.exception.polls.PollException;
import com.ziksana.domain.member.Member;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionOption;
import com.ziksana.domain.polls.PollQuestionResponse;
import com.ziksana.domain.polls.PollQuestionResult;
import com.ziksana.domain.polls.PollResultNQuestion;

import com.ziksana.persistence.polls.PollMapper;
import com.ziksana.persistence.polls.PollQuestionEntity;
import com.ziksana.persistence.polls.PollQuestionMapper;
import com.ziksana.persistence.polls.PollQuestionResponseMapper;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.polls.PollService;

/**
 * @author prabu
 * 
 */

@Service
public class PollServiceImpl implements PollService {

	private static Logger logger = Logger.getLogger(PollServiceImpl.class);

	@Autowired
	public PollQuestionMapper pollQuestionMapper;
	@Autowired
	public PollQuestionResponseMapper pollQuestionResponseMapper;

	@Override
	public List<PollResultNQuestion> getPollQuestionsAndResults() {

		List<PollQuestionResult> pollResults = pollQuestionMapper
				.getPollResults(Integer.valueOf(ThreadLocalUtil.getToken()
						.getMemberPersonaId().getStorageID()));

		List<PollResultNQuestion> pollQuestionsNResults = new ArrayList<PollResultNQuestion>();

		for (PollQuestionResult pollResult : pollResults) {
			PollResultNQuestion pollQuestionResult = new PollResultNQuestion();

			pollQuestionResult.setPollResult(pollResult);

			pollQuestionsNResults.add(pollQuestionResult);
		}

		List<PollQuestionEntity> pollQuestions = pollQuestionMapper
				.getPollQuestions(Integer.valueOf(ThreadLocalUtil.getToken()
						.getMemberPersonaId().getStorageID()));

		for (PollQuestionEntity pollQuestionEntity : pollQuestions) {
			PollResultNQuestion pollQuestionResult = new PollResultNQuestion();
			// Transformation from pollquestion entity to pollquestion domain
			// object
			// needs to happen here

			PollQuestion pollQuestion = new PollQuestion();
			System.out.println("QUESTION ID IS "
					+ pollQuestionEntity.getID());
						
			pollQuestion.setID(pollQuestionEntity.getID());
			System.out.println("QUESTION TEXT IS "
					+ pollQuestionEntity.getQuestionText());
			pollQuestion.setQuestionText(pollQuestionEntity.getQuestionText());
			List<PollQuestionOption> options = new ArrayList<PollQuestionOption>();
			addOptions(options, pollQuestionEntity);
			System.out.println("THE TOTAL NUMBER OF OPTIONS "+options.size());
			pollQuestion.setActive(true);
			pollQuestion.setOptions(options);

			pollQuestionResult.setPollQuestion(pollQuestion);
			//pollQuestionResult.setPollResult(null);		

			pollQuestionsNResults.add(pollQuestionResult);

		}

		return pollQuestionsNResults;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.polls.PollService#pollResponse(com.ziksana.domain
	 * .member.Member, com.ziksana.domain.polls.PollResponse)
	 */
	@Override
	public void pollResponse(
			PollQuestionResponse pollQuestionResponse) {
		
		Validate.notNull(pollQuestionResponse, "PollQuestion cannot be null.");
					
		
		pollQuestionResponseMapper.createPollTrackerEntry(pollQuestionResponse
				.getPollQuestion().getID(), Integer.valueOf(ThreadLocalUtil.getToken()
						.getMemberPersonaId().getStorageID()));
		pollQuestionResponseMapper.createPollResponse(pollQuestionResponse);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.polls.PollService#getPollResult(com.ziksana.domain
	 * .member.Member, com.ziksana.domain.polls.PollQuestion)
	 */
	@Override
	public PollQuestionResult getPollResult(MemberPersona memberPersona,
			PollQuestion pollQuestion) {

		Validate.notNull(memberPersona, "MemberPersona cannot be null.");
		Validate.notNull(pollQuestion, "PollQuestion cannot be null.");
		PollQuestionResult pollResult = pollQuestionResponseMapper
				.getPollResultByQuestion(pollQuestion.getID(),
						memberPersona.getMemberRoleId());
		return pollResult;

	}

	private void addOptions(List<PollQuestionOption> options,
			PollQuestionEntity pollQuestionEntity) {
		assert pollQuestionEntity != null;

		if (pollQuestionEntity.getAnswer1() != null) {
			options.add( getOption(0, pollQuestionEntity.getAnswer1()));
			
		}

		if (pollQuestionEntity.getAnswer2() != null)
			options.add(getOption(1, pollQuestionEntity.getAnswer2()));

		if (pollQuestionEntity.getAnswer3() != null)
			options.add( getOption(2, pollQuestionEntity.getAnswer3()));

		if (pollQuestionEntity.getAnswer4() != null)
			options.add( getOption(3, pollQuestionEntity.getAnswer4()));

		if (pollQuestionEntity.getAnswer5() != null)
			options.add( getOption(4, pollQuestionEntity.getAnswer5()));

	}

	private PollQuestionOption getOption(int index, String text) {
		PollQuestionOption pollQuestionOption = new PollQuestionOption();
		pollQuestionOption.setText(text);
		pollQuestionOption.setIndex(index);
		return pollQuestionOption;
	}

}
