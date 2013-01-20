
/**
 * 
 */
package com.ziksana.service.polls.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.member.MemberRoleType;
import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionResponse;
import com.ziksana.domain.polls.PollQuestionResult;
import com.ziksana.domain.polls.PollResultNQuestion;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.persistence.polls.PollQuestionEntity;
import com.ziksana.persistence.polls.PollQuestionMapper;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.polls.PollService;

/**
 * @author prabu
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class PollServiceImplTest {

	@Autowired
	private PollService pollService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ZID memberId = new StringZID("1000");
		ZID memberPersonaId = new StringZID("100");

		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		ThreadLocalUtil.setToken(token);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ThreadLocalUtil.unset();
	}

	@Ignore
	@Test
	public void testGetPollQuestionsAndResults() {
		String questionText = "who wins the t20 world cup?";

		List<PollResultNQuestion> pollQuestionNResults = pollService
				.getPollQuestionsAndResults();

		for (PollResultNQuestion pollQuestionNResult : pollQuestionNResults) {

			System.out.println(" the obejct is " + pollQuestionNResult);

		}

		Assert.isTrue(pollQuestionNResults.size() == 1);

	}

	@Ignore
	@Test
	public void testPollResponse() {
		// MemberPersona memberPersona = new
		// MemberPersona(MemberRoleType.LEARNER);
		// memberPersona.setMemberRoleId(Integer.valueOf(100));
		PollQuestion pollQuestion = new PollQuestion();
		pollQuestion.setID(Integer.valueOf(5));
		List<Integer> answers = new ArrayList();
		answers.add(Integer.valueOf(1));
		PollQuestionResponse pollResponse = new PollQuestionResponse();
		pollResponse.setPollQuestion(pollQuestion);
		pollResponse.setAnswers(answers);
		pollService.pollResponse(pollResponse);

	}

	@Ignore
	@Test
	public void testGetPollResult() {

		PollQuestion pollQuestion = new PollQuestion();
		pollQuestion.setID(Integer.valueOf(6));
		PollQuestionResult pollResult = pollService.getPollResult(pollQuestion);
		System.out.println(pollResult.getID());
		System.out.println(pollResult.getQuestion().getID());
		System.out.println("ANswer2 count is " + pollResult.getAnswer2Count());
		// Assert.isTrue(pollResult.getOptionCount(0) == 6);

	}

	@Test
	public void testGetAllPollQuestionsByDate() {
		/*
		Calendar startDate = new GregorianCalendar(2008, 01, 01);
		Calendar endDate = Calendar.getInstance();
		List<PollQuestionEntity> pollQuestions = pollService
				.getAllPollQuestionsByDate(startDate.getTime(),
						endDate.getTime());
		assertTrue(pollQuestions.size() > 0);
		*/

	}

	@Test
	public void testGetAllPollQuestion() {

		List<PollQuestionEntity> pollQuestions = pollService
				.getAllPollQuestion();

		for (PollQuestionEntity question : pollQuestions) {
			System.out.println(" POLL QUESTION DATE " + question.getPollDate());
		}

	}

}

