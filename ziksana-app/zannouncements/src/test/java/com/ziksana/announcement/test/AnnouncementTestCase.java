package com.ziksana.announcement.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.announcements.Announcement;
import com.ziksana.service.announcements.AnnouncementService;

/**
 * Test Case
 * 
 * @author
 */

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AnnouncementTestCase {

	@Autowired
	AnnouncementService announcementService;

	private static final Logger logger = Logger
			.getLogger(AnnouncementTestCase.class);

	@BeforeClass
	public static void runBeforeClass() {

	}

	@AfterClass
	public static void runAfterClass() {

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
		announcementService.createAnnouncement(actual);

		assertEquals(1, actual.getAnnouncementId());
		Announcement expected = announcementService.getAnnouncement(actual
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
		Announcement list = announcementService.getAnnouncement(1);
		assertNotNull(list);
		assertEquals(1, 1);
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
		Announcement expected = announcementService.getAnnouncement(1);

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
		Announcement expected = announcementService.getAnnouncement(1);
		expected.setMessage("Announcement Message");
		announcementService.updateAnnouncement(expected);
		expected = announcementService.getAnnouncement(1);

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
		logger.info("Class :" + getClass() + ": Entering Method :testInsert()");
		announcementService.deleteAnnouncement(2);
		Announcement expected = announcementService.getAnnouncement(2);
		assertNull(expected);
	}

}
