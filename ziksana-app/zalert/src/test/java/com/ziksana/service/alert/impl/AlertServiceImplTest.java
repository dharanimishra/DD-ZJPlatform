/**
 * 
 */
package com.ziksana.service.alert.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.alerts.Alert;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.alert.AlertsService;

/**
 * @author prabu
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class AlertServiceImplTest {

	@Autowired
	private AlertsService alertService;

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
		ThreadLocalUtil.setToken(token);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ThreadLocalUtil.unset();
	}

	/**
	 * Test method for
	 * {@link com.ziksana.service.alert.impl.AlertServiceImpl#getAlertList()}.
	 */
	@Test
	public void testGetAlertList() {

		ZID memberId = new StringZID("1000");
		ZID memberPersonaId = new StringZID("100");

		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		ThreadLocalUtil.setToken(token);
		List<Alert> alerts = alertService.getAlertList();

		Assert.assertFalse(alerts.isEmpty());
		Assert.assertTrue(alerts.size() == 1);

	}

	/**
	 * Test method for
	 * {@link com.ziksana.service.alert.impl.AlertServiceImpl#createAlertItem(com.ziksana.domain.alerts.Alert)}
	 * .
	 */
	@Test
	public void testCreateAlertItem() {
		
		Alert alert = new Alert();
		alert.setCategory("Assignment");
		alert.setActivationDate(new Date());
		MemberPersona creatingMember = new MemberPersona();
		creatingMember.setMemberRoleId(Integer.valueOf(ThreadLocalUtil.getToken()
				.getMemberPersonaId().getStorageID()));
		alert.setCreatingMember(creatingMember);
		alert.setForMember(creatingMember);
		alert.setDescription(" new video coming up for the course");
		alert.setPriority(Integer.valueOf(1000));
		alertService.createAlertItem(alert);
		
	}

	/**
	 * Test method for
	 * {@link com.ziksana.service.alert.impl.AlertServiceImpl#editAlertItem(com.ziksana.domain.alerts.Alert)}
	 * .
	 */
	@Test
	public void testEditAlertItem() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.ziksana.service.alert.impl.AlertServiceImpl#deleteAlertItem(java.lang.Integer, java.lang.Integer)}
	 * .
	 */
	@Test
	public void testDeleteAlertItem() {
		fail("Not yet implemented");
	}

}
