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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.ziksana.service.assignment.impl.AssignmentServiceImpl#createAssignment(java.lang.Integer)}.
	 */
	@Test
	public void testCreateAssignment() {
		fail("Not yet implemented");
	}

}
