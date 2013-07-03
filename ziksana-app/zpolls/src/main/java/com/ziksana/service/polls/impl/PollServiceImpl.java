package com.ziksana.service.polls.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.constants.ZiksanaConstants;
import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionOption;
import com.ziksana.domain.polls.PollQuestionResponse;
import com.ziksana.domain.polls.PollQuestionResult;
import com.ziksana.domain.polls.PollResult;
import com.ziksana.domain.polls.PollResultNQuestion;
import com.ziksana.exception.polls.PollException;
import com.ziksana.persistence.polls.PollQuestionEntity;
import com.ziksana.persistence.polls.PollQuestionMapper;
import com.ziksana.persistence.polls.PollQuestionResponseMapper;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.polls.PollService;

/**
 * @author prabu
 * 
 */

@Service
public class PollServiceImpl implements PollService {

	private static Logger logger = LoggerFactory
			.getLogger(PollServiceImpl.class);

	@Autowired
	public PollQuestionMapper pollQuestionMapper;
	@Autowired
	public PollQuestionResponseMapper pollQuestionResponseMapper;

	public List<PollResultNQuestion> getPollQuestionsAndResults() {

		List<PollResultNQuestion> pollQuestionsNResults = new ArrayList<PollResultNQuestion>();

		/*
		 * List<PollQuestionResult> pollResults = pollQuestionMapper
		 * .getPollResults(Integer.valueOf(SecurityTokenUtil.getToken()
		 * .getMemberPersonaId().getStorageID()));
		 * 
		 * 
		 * logger.debug(" THE MEMBER PERSONA ID IN POLL IS "+Integer.valueOf(
		 * SecurityTokenUtil.getToken() .getMemberPersonaId().getStorageID()));
		 * 
		 * logger.debug(" THE POLL RESULTS SIZE IS "+pollResults.size());
		 * 
		 * 
		 * 
		 * for (PollQuestionResult pollResult : pollResults) {
		 * PollResultNQuestion pollQuestionResult = new PollResultNQuestion();
		 * 
		 * if (pollResult == null ) { logger.debug(" POLL RESULT IS NULL"); }
		 * 
		 * pollQuestionResult.setPollResult(pollResult);
		 * 
		 * pollQuestionsNResults.add(pollQuestionResult); }
		 */

		List<PollQuestionEntity> pollQuestions = pollQuestionMapper
				.getPollQuestions(Integer.valueOf(SecurityTokenUtil.getToken()
						.getMemberPersonaId().getStorageID()));

		for (PollQuestionEntity pollQuestionEntity : pollQuestions) {
			PollResultNQuestion pollQuestionResult = new PollResultNQuestion();
			// Transformation from pollquestion entity to pollquestion domain
			// object
			// needs to happen here

			PollQuestion pollQuestion = new PollQuestion();

			logger.debug("QUESTION ID IS " + pollQuestionEntity.getID());

			pollQuestion.setID(pollQuestionEntity.getID());
			logger.debug("QUESTION TEXT IS "
					+ pollQuestionEntity.getQuestionText());
			pollQuestion.setQuestionText(pollQuestionEntity.getQuestionText());
			List<PollQuestionOption> options = new ArrayList<PollQuestionOption>();
			addOptions(options, pollQuestionEntity);
			logger.debug("THE TOTAL NUMBER OF OPTIONS " + options.size());
			pollQuestion.setActive(true);
			pollQuestion.setOptions(options);

			pollQuestionResult.setPollQuestion(pollQuestion);
			// pollQuestionResult.setPollResult(null);

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

	public void pollResponse(PollQuestionResponse pollQuestionResponse) {

		Validate.notNull(pollQuestionResponse, "PollQuestion cannot be null.");

		pollQuestionResponseMapper.createPollTrackerEntry(pollQuestionResponse
				.getPollQuestion().getID(), Integer.valueOf(SecurityTokenUtil
				.getToken().getMemberPersonaId().getStorageID()));
		pollQuestionResponseMapper.createPollResponse(pollQuestionResponse);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.polls.PollService#getPollResult(com.ziksana.domain
	 * .member.Member, com.ziksana.domain.polls.PollQuestion)
	 */

	public PollQuestionResult getPollResult(PollQuestion pollQuestion) {

		Validate.notNull(pollQuestion, "PollQuestion cannot be null.");
		PollQuestionResult pollResult = pollQuestionResponseMapper
				.getPollResultByQuestion(
						pollQuestion.getID(),
						Integer.valueOf(SecurityTokenUtil.getToken()
								.getMemberPersonaId().getStorageID()));
		PollQuestionEntity pollQuestionEntity = pollQuestionResponseMapper
				.getPollQuestionById(pollQuestion.getID());

		PollQuestion question = new PollQuestion();
		logger.debug("QUESTION ID IS " + pollQuestionEntity.getID());

		question.setID(pollQuestionEntity.getID());
		logger.debug("QUESTION TEXT IS " + pollQuestionEntity.getQuestionText());
		question.setQuestionText(pollQuestionEntity.getQuestionText());
		List<PollQuestionOption> options = new ArrayList<PollQuestionOption>();
		addOptions(options, pollQuestionEntity);
		logger.debug("THE TOTAL NUMBER OF OPTIONS " + options.size());
		question.setActive(true);
		question.setOptions(options);

		pollResult.setQuestion(question);

		PollResult pr = pollQuestionMapper
				.getPollResultByQuestion(pollQuestionEntity.getID());
		pollResult.setPercentage1(pr.getAnswer1());
		pollResult.setPercentage2(pr.getAnswer2());
		pollResult.setPercentage3(pr.getAnswer3());
		pollResult.setPercentage4(pr.getAnswer4());
		pollResult.setPercentage5(pr.getAnswer5());

		return pollResult;

	}

	private void addOptions(List<PollQuestionOption> options,
			PollQuestionEntity pollQuestionEntity) {
		assert pollQuestionEntity != null;

		if (pollQuestionEntity.getAnswer1() != null) {
			options.add(getOption(0, pollQuestionEntity.getAnswer1()));

		}

		if (pollQuestionEntity.getAnswer2() != null)
			options.add(getOption(1, pollQuestionEntity.getAnswer2()));

		if (pollQuestionEntity.getAnswer3() != null)
			options.add(getOption(2, pollQuestionEntity.getAnswer3()));

		if (pollQuestionEntity.getAnswer4() != null)
			options.add(getOption(3, pollQuestionEntity.getAnswer4()));

		if (pollQuestionEntity.getAnswer5() != null)
			options.add(getOption(4, pollQuestionEntity.getAnswer5()));

	}

	private PollQuestionOption getOption(int index, String text) {
		PollQuestionOption pollQuestionOption = new PollQuestionOption();
		pollQuestionOption.setText(text);
		pollQuestionOption.setIndex(index);
		return pollQuestionOption;
	}

	public List<PollQuestionEntity> getAllPollQuestions() {
		// TODO Auto-generated method stub
		return pollQuestionMapper.getPollQuestions(Integer
				.valueOf(SecurityTokenUtil.getToken().getMemberPersonaId()
						.getStorageID()));
	}

	public PollResult getPollResultByQuestion(Integer questionId) {
		// TODO Auto-generated method stub
		return pollQuestionMapper.getPollResultByQuestion(questionId);
	}

	// @Override
	// public List<PollQuestionEntity> getAllPollQuestionsByDate(Date startDate,
	// Date endDate) {
	//
	// return pollQuestionMapper.getPollQuestionsByDate(startDate, endDate);
	//
	//
	// }

	public List<PollQuestionEntity> getAllPollQuestion() {
		// TODO Auto-generated method stub
		return pollQuestionMapper.getPollQuestion(Integer
				.valueOf(SecurityTokenUtil.getToken().getMemberPersonaId()
						.getStorageID()));
	}

	public List<PollQuestionEntity> getAllPollQuestionsByDate(String startDate,
			String endDate) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date formatStartDate;
		Date formatEndDate;
		try {
			formatStartDate = null;
			formatStartDate = dateFormat.parse(startDate);
			Date formatDate = null;
			formatEndDate = combineDateTime(formatDate);
			formatDate = dateFormat.parse(endDate);
			logger.debug(" start date is " + formatEndDate);
		} catch (ParseException e) {
			throw new PollException(ZiksanaConstants.POLL_DATE_PARSE_ERROR, e);
		}

		// Integer memberRoleId =
		// Integer.valueOf(SecurityTokenUtil.getToken().getMemberPersonaId().getStorageID());
		return pollQuestionMapper.getPollQuestionsByDate(formatStartDate,
				formatEndDate);

	}

	private static Date combineDateTime(Date dateFormat) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFormat);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

}
