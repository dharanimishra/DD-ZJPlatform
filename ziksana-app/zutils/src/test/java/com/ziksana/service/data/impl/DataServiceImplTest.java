/**
 * 
 */
package com.ziksana.service.data.impl;



import static org.junit.Assert.assertTrue;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.service.data.DataService;

/**
 * @author prabu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class DataServiceImplTest {
	
	@Autowired
	DataService dataService;

	/**
	 * @throws java.lang.Exception
	 */
	protected static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	protected static void tearDownAfterClass() throws Exception {
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		
	}

	/**
	 * Test method for {@link com.ziksana.service.data.impl.DataServiceImpl#fetchData(java.lang.String)}.
	 */
	@Test
	public void testFetchData() {
		Map<String,Integer> map = dataService.fetchData("notificationtype");
		Assert.assertNotNull(map);
		
		assertTrue(map.size()==3);
	}

}
