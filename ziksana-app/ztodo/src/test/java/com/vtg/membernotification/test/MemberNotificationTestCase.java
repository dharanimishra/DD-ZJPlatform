package com.vtg.membernotification.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vtg.dao.MemberNotificationDao;
import com.vtg.dao.impl.MemberNotificationDaoImpl;
import com.vtg.model.MemberNotification;

/**
 * Test Case
 * 
 * @author
 */

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberNotificationTestCase {

	private static MemberNotificationDao memberNotificationDAO;

	@BeforeClass
	public static void runBeforeClass() {
		memberNotificationDAO = new MemberNotificationDaoImpl();
	}

	@AfterClass
	public static void runAfterClass() {
		memberNotificationDAO = null;
	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.CategoryDao#insert(com.vtg.model.Category)}.
	 */
	@Test
	public void testInsert() {

		MemberNotification actual = new MemberNotification();
		memberNotificationDAO.insert(actual);

		assertEquals(1, actual.getId());
		MemberNotification expected = memberNotificationDAO.selectById(actual.getId());
		assertEquals(actual, expected);
		assertNotSame(actual, expected);

	}

	/**
	 * Test method for {@link com.vtg.dao.CategoryDao#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		Collection<MemberNotification> list = memberNotificationDAO.selectAll();
		assertNotNull(list);
		assertEquals(1, 1);
	}

	/**
	 * Test method for {@link com.vtg.dao.CategoryDao#selectById(int)}.
	 */
	@Test
	public void testSelectById() {
		MemberNotification actual = new MemberNotification();
		MemberNotification expected = memberNotificationDAO.selectById(actual.getId());

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.CategoryDao#update(com.vtg.model.Category)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		MemberNotification actual = new MemberNotification();

		MemberNotification expected = memberNotificationDAO.selectById(actual.getId());
		expected.setNotificationContent("Notification Content");
		memberNotificationDAO.update(expected);
		expected = memberNotificationDAO.selectById(actual.getId());

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for {@link com.vtg.dao.CategoryDao#delete(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		memberNotificationDAO.delete(1);
		MemberNotification expected = memberNotificationDAO.selectById(1);
		assertNull(expected);
	}

}
