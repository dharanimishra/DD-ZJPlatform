/**
 * 
 */
package com.ziksana.service.polls.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionNResult;
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
	public void testGetPoll() {
		
		List<PollQuestion> pollQuestions = pollService.getUnansweredPollQuestions(Integer.valueOf(101));
		Assert.isTrue(pollQuestions.size() == 1);
		System.out.println(" pollquestion question is "+pollQuestions.get(0).getQuestionText());
			
	}
	
	
	@Test
	public void testGetTotalQuestions() {
		int totalQuestions = pollService. getTotalUnansweredQuestions(Integer.valueOf(101));
		Assert.isTrue(totalQuestions == 1, "total number of questions is not correct");
	}
	
	
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
	
	
}
