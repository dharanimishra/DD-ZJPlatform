/**
 * 
 */
package com.ziksana.service.polls.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionNResult;
import com.ziksana.domain.polls.PollResponse;
import com.ziksana.domain.polls.PollResult;
import com.ziksana.persistence.polls.PollQuestionMapper;
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
	
	
	
	
	@Test
	public void testGetPollQuestionsAndResults() {
		String questionText = "who wins the t20 world cup?";
		MemberPersona memberPersona = new MemberPersona();
		memberPersona.setMemberRoleId(Integer.valueOf(102));
		List<PollQuestionNResult> pollQuestionNResults = pollService.getPollQuestionsAndResults(memberPersona);
		
		for (PollQuestionNResult pollQuestionNResult: pollQuestionNResults)
		{
			if(pollQuestionNResult.isThisQuestion())
			{
			System.out.println("the questions is "+pollQuestionNResult.getPollQuestion());
			Assert.isTrue(pollQuestionNResult.getPollQuestion().getQuestionText().equals(questionText));
			}
			
		}
		
		Assert.isTrue(pollQuestionNResults.size() == 3);
		
		
	}
	
	
	@Test
	public void testPollResponse() {
		MemberPersona memberPersona = new MemberPersona();
		memberPersona.setMemberRoleId(Integer.valueOf(100));
		PollResponse pollResponse = new PollResponse();
		PollQuestion pollQuestion = new PollQuestion();
		pollQuestion.setID(Integer.valueOf(2));
		pollResponse.setPollQuestion(pollQuestion);
		List<Integer> answers = new ArrayList();
		answers.add(Integer.valueOf(1));
		pollResponse.setAnswers(answers);
		pollService.pollResponse(memberPersona, pollResponse);
		
		
	}
	
	
	@Test
	public void testGetPollResult() {
		MemberPersona memberPersona = new MemberPersona();
		memberPersona.setMemberRoleId(Integer.valueOf(102));
		PollQuestion pollQuestion = new PollQuestion();
		pollQuestion.setID(Integer.valueOf(3));
		PollResult pollResult =  pollService.getPollResult(memberPersona, pollQuestion);
		Assert.isTrue(pollResult.getAnswer1Count() == 2);
		
	}
	
	
	
	
	
	
}
