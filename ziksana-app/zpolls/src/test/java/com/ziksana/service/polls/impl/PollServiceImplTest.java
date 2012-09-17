/**
 * 
 */
package com.ziksana.service.polls.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.persistence.polls.PollQuestionMapper;

/**
 * @author prabu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jdbc-context.xml")
public class PollServiceImplTest {

	@Autowired
    private PollQuestionMapper pollQuestionMapper;
	
	
	
	@Test
	public void testGetPoll() {
		
		PollQuestion pollQuestion = pollQuestionMapper.getPoll(new Integer(500));
		System.out.println(" pollquestion question is "+pollQuestion.getQuestionText());
		
	}
}
