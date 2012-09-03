/**
 * 
 */
package com.vtgindia.webapp.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author prabu
 *
 */
public class AuthenticationUtilTest {

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
	 * Test method for {@link com.vtgindia.webapp.util.AuthenticationUtil#authenticate(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAuthenticate() {
		
		Assert.assertTrue(AuthenticationUtil.authenticate("uid=prabu,ou=users,ou=system", "xyz100"));
		//fail("Not yet implemented");
	}

}
