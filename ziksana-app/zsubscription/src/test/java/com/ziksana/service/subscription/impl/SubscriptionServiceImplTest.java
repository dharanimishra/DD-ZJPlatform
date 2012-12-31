package com.ziksana.service.subscription.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.course.Node;
import com.ziksana.domain.course.subscription.Note;
import com.ziksana.domain.course.subscription.SubscriptionCourse;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.subscription.SubscriptionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class SubscriptionServiceImplTest {

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

		ZID memberId = new StringZID("1000");
		ZID memberPersonaId = new StringZID("100");
		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		ThreadLocalUtil.setToken(token);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetLearnerContent() {

		SubscriptionCourse course = new SubscriptionCourse();
		course.setSubscriptionCourseId(1000);
		Node node = new Node();
		node.setId(1);
		node.setType(1000);
		List<Note> notes = subscriptionService.getLearnerContent(course, node);
		assertNotNull(notes);

	}

	@Test
	public void testGetEducatorContent() {

		SubscriptionCourse course = new SubscriptionCourse();
		course.setSubscriptionCourseId(1000);
		Node node = new Node();
		node.setId(1);
		node.setType(1000);

		// TODO
		List<Note> notes = subscriptionService.getEducatorContent(course, node, 1);
		assertNotNull(notes);

		assertTrue(notes.size() == 0);

	}

	@Test
	public void testAddLearnerContent() {
		String noteText = "test note";
		//Note note = new Note();
		//note.setContent(noteText);
		
		Node node = new Node();
        node.setType(1000);
        node.setId(1000);
		
		subscriptionService.addLearnerContent(noteText, node);

	}

}
