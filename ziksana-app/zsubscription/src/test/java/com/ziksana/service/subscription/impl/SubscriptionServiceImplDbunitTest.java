/**
 * 
 */
package com.ziksana.service.subscription.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.ziksana.domain.course.subscription.Note;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.subscription.SubscriptionService;


/**
 * @author prabu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
public class SubscriptionServiceImplDbunitTest {
	
	
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		ZID memberId = new StringZID("1002");
		ZID memberPersonaId = new StringZID("202");
		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		SecurityTokenUtil.setToken(token);

	}

	@After
	public void tearDown() throws Exception {
	}


	
	@Test
	@DatabaseSetup("classpath:testdata.xml")
	public void testGetLearnerNotes() {
		List<Note> notes = subscriptionService.getLearnerNotes(100, 51, 91, 2000);
		assertEquals(1, notes.size());
		
	}

}
