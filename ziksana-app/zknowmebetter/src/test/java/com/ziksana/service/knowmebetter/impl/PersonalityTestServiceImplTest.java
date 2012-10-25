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


import com.ziksana.domain.common.Question;
import com.ziksana.domain.myblogs.BlogPost;
import com.ziksana.domain.myblogs.Comment;
import com.ziksana.domain.myblogs.Tag;
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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetUnansweredQuestions() {
		ZID memberId = new StringZID("1000");
		ZID memberPersonaId = new StringZID("100");
		
		
		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		ThreadLocalUtil.setToken(token);
			
		
		List<Question> questions = personalityTestService.getUnansweredQuestions();
		
               
        Assert.assertTrue(questions.size() == 1);
        
		
		
	}

	@Ignore
	public void testSaveAnswer() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testAnsweredQuestions() {
		fail("Not yet implemented");
	}

}
