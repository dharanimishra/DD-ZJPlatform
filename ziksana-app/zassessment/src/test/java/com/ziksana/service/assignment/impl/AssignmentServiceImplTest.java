/**
 * 
 */
package com.ziksana.service.assignment.impl;

import static org.junit.Assert.*;

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
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.model.assignment.Assignment;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.assignment.AssignmentService;

/**
 * @author prabu
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public class AssignmentServiceImplTest {

	@Autowired
	AssignmentService assignmentService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ZID memberId = new StringZID("1002");
		ZID memberPersonaId = new StringZID("202");
		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		ThreadLocalUtil.setToken(token);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.ziksana.service.assignment.impl.AssignmentServiceImpl#createAssignment(java.lang.Integer)}
	 * .
	 */
	@Test
	@ExpectedDatabase(assertionMode=DatabaseAssertionMode.NON_STRICT, value="classpath:testdata.xml")
	public void testCreateAssignment() {

		Assignment assignment = new Assignment();
		assignment.setName("assignment from springtest");
		assignment.setContent("testContent");
		assignment.setLearningComponentId(10);
		
		Assignment createdAssignment = assignmentService
				.createAssignment(assignment);

	}

}
