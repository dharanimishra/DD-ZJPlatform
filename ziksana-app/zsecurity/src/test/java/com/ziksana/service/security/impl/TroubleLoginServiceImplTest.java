/**
 * 
 */
package com.ziksana.service.security.impl;

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

import com.ziksana.service.security.TroubleLoginService;

/**
 * @author vtg-p13
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TroubleLoginServiceImplTest {

	@Autowired
	TroubleLoginService troubleLoginService;
	
	
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
	
	@Before
	public void setUp() throws Exception {
	}

	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testIsUserIdExists(){
		String userId = "ravip";
		Assert.assertEquals(true, troubleLoginService.isUserIdExists(userId));
	}
	
	@Ignore
	public void testIsSecurityAnswerExists(){
		String userId = "1001";
		String memberAnswer = "amma";
		String secretQuestion = "What is your mother's maiden name?";
		
		Assert.assertEquals(true, troubleLoginService.isSecretAnswerExists(memberAnswer, secretQuestion, userId));
	}
	
	
	
}
