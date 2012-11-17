/**
 * 
 */
package com.ziksana.service.polls.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
	
	
    @Test
	public void testGetPollQuestionsAndResults() {
		String questionText = "who wins the t20 world cup?";
		
		List<PollResultNQuestion> pollQuestionNResults = pollService.getPollQuestionsAndResults();
		
		
		for (PollResultNQuestion pollQuestionNResult: pollQuestionNResults)
		{
			
			System.out.println(" the obejct is "+pollQuestionNResult);
			
		}
		
		
		Assert.isTrue(pollQuestionNResults.size() == 1);
		
		
	}
	
	
    @Test
	public void testPollResponse() {
		MemberPersona memberPersona = new MemberPersona(MemberRoleType.LEARNER);
		memberPersona.setMemberRoleId(Integer.valueOf(100));
		PollQuestion pollQuestion = new PollQuestion();
		pollQuestion.setID(Integer.valueOf(5));
		List<Integer> answers = new ArrayList();
		answers.add(Integer.valueOf(1));
		PollQuestionResponse pollResponse = new PollQuestionResponse();
		pollResponse.setPollQuestion(pollQuestion);
		pollResponse.setAnswers(answers);
		pollService.pollResponse(memberPersona, pollResponse);
		
		
	}
	
	
    @Test
	public void testGetPollResult() {
		MemberPersona memberPersona = new MemberPersona(MemberRoleType.LEARNER);
		memberPersona.setMemberRoleId(Integer.valueOf(100));
		PollQuestion pollQuestion = new PollQuestion();
		pollQuestion.setID(Integer.valueOf(5));
		PollQuestionResult pollResult =  pollService.getPollResult(memberPersona, pollQuestion);
		Assert.isTrue(pollResult.getOptionCount(0) == 6);
		
	}
	
	
	
	
	
	
}
