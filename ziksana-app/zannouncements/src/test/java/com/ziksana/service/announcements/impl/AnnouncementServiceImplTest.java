/**
 * 
 */
package com.ziksana.service.announcements.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.announcements.Announcement;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.announcements.AnnouncementService;




/**
 * @author vtg-p13
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class AnnouncementServiceImplTest {
	private static final Logger logger = LoggerFactory
			.getLogger(AnnouncementServiceImplTest.class);

	@Autowired
	private AnnouncementService announcementService;
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
		ZID memberId = new StringZID("1000");
		ZID memberPersonaId = new StringZID("100");

		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		SecurityTokenUtil.setToken(token);

	}
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		SecurityTokenUtil.unset();
	}
	@Ignore
	public void testInsert() {
		logger.info("Class :" + getClass() + ": Entering Method :testInsert()");
		Announcement actual = new Announcement();
		
		actual.setAnnouncementDate(new Date());
		actual.setMessage("New Course Announcement");
		actual.setMessageVisibility(1);
		actual.setValidUntil(new Date());
		actual.setMemberRoleId(100);
		actual.setInstitutionId(1);
		actual.setInstitutionUnitId(1);
		actual.setCurriculumCourseId(1);
		actual.setLearningProgramId(1);
		actual.setCourseId(1);
		actual.setCourseLearningComponentId(1);
		announcementService.createAnnouncement(actual);

		
		logger.info("Class :" + getClass() + ": Leaving Method : testInsert()");

	}
	@Ignore
	public void testGetAnnouncements(){
		
		List<Announcement> announcement = new ArrayList<Announcement>();
		//announcement = announcementService.getAnnouncement(100);
		Assert.assertEquals(2, announcement.size());
		logger.info("announcement size :"+announcement.size());
	}
	
	

}
