package com.ziksana.service.knowmebetter.impl;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.common.Choice;
import com.ziksana.domain.common.Question;
import com.ziksana.domain.common.QuestionResponse;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.knowmebetter.PersonalityTestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class PersonalityTestServiceImplTest {

	@Autowired
	private PersonalityTestService personalityTestService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ZID memberId = new StringZID("1000");
		ZID memberPersonaId = new StringZID("100");

		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		ThreadLocalUtil.setToken(token);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	public void testGetUnansweredQuestions() {
		ZID memberId = new StringZID("1000");
		ZID memberPersonaId = new StringZID("100");

		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		ThreadLocalUtil.setToken(token);

		List<Question> questions = personalityTestService
				.getUnansweredQuestions();

		Assert.assertTrue(questions.size() == 1);

	}

	@Ignore
	public void testSaveAnswer() {

		List<Question> questions = personalityTestService.getUnansweredQuestions();

		Question question = questions.get(0);
		Choice userChoice = (Choice) question.getChoices().iterator().next();
		userChoice.setMemPstTestId(Integer.valueOf(1));
		personalityTestService.saveAnswer(question, userChoice);

	}
	
	@Test
	public void testUpateAnswer() {

		
		/*Question question = new Question(1,"do you like video courses");
		Choice userChoice =new Choice(2, 2, "No", Integer.valueOf(1));
		personalityTestService.updateAnswer(question, userChoice);*/

	}

	@Ignore
	public void testAnsweredQuestions() {

		List<QuestionResponse> questionResponses = personalityTestService
				.answeredQuestions();

		QuestionResponse questionResponse = questionResponses.get(0);

		Assert.assertTrue(questionResponse.getQuestion().getText()
				.equals("do you like video courses"));
		Assert.assertTrue(questionResponse.getChoice().getText().equals("No"));

	}

}
