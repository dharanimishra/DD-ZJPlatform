package com.vtg.announcement.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vtg.dao.AnnouncementDao;
import com.vtg.dao.impl.AnnouncementDaoImpl;
import com.vtg.model.Announcement;

/**
 * Test Case
 * 
 * @author
 */

@ContextConfiguration("AnnouncementTestCase-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AnnouncementTestCase {

	private static AnnouncementDao announcementDAO;

	private static final Logger logger = Logger
			.getLogger(AnnouncementTestCase.class);

	@BeforeClass
	public static void runBeforeClass() {
		announcementDAO = new AnnouncementDaoImpl();
	}

	@AfterClass
	public static void runAfterClass() {
		announcementDAO = null;
	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.AnnouncementDao#insert(com.vtg.model.Announcement)}.
	 */
	@Test
	public void testInsert() {
		logger.info("Class :" + getClass() + ": Entering Method :testInsert()");
		Announcement actual = new Announcement(1, new Date(),
				"Announcement Message", 1, new Date(), 1, 1, 1, 1, 1, 1, 1);
		announcementDAO.insert(actual);

		assertEquals(1, actual.getAnnouncementId());
		Announcement expected = announcementDAO.selectById(actual
				.getAnnouncementId());
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
		logger.info("Class :" + getClass() + ": Leaving Method : testInsert()");

	}

	/**
	 * Test method for {@link com.vtg.dao.AnnouncementDao#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		logger.info("Class :" + getClass() + ": Entering Method :testInsert()");
		Collection<Announcement> list = announcementDAO.selectAll();
		assertNotNull(list);
		assertEquals(1, list.size());
		logger.info("Class :" + getClass() + ": Leaving Method : testInsert()");
	}

	/**
	 * Test method for {@link com.vtg.dao.AnnouncementDao#selectById(int)}.
	 */
	@Test
	public void testSelectById() {
		logger.info("Class :" + getClass()
				+ ": Entering Method : testSelectById()");
		Announcement actual = new Announcement(1, new Date(),
				"Announcement Message", 1, new Date(), 1, 1, 1, 1, 1, 1, 1);
		Announcement expected = announcementDAO.selectById(1);

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
		logger.info("Class :" + getClass()
				+ ": Leaving Method : testSelectById()");
	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.AnnouncementDao#update(com.vtg.model.Announcement)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		logger.info("Class :" + getClass() + ": Entering Method : testUpdate()");
		Announcement actual = new Announcement();
		Announcement expected = announcementDAO.selectById(1);
		expected.setMessage("Announcement Message");
		announcementDAO.update(expected);
		expected = announcementDAO.selectById(1);

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);

		logger.info("Class :" + getClass() + ": Leaving Method : testUpdate()");
	}

	/**
	 * Test method for {@link com.vtg.dao.AnnouncementDao#delete(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {
		// logger.info("Class :" + getClass() +
		// ": Entering Method :testInsert()");
		// announcementDAO.delete(1);
		// Announcement expected = announcementDAO.selectById(2);
		// assertNull(expected);
	}

}
