package com.ziksana.todo.test;

import java.util.Date;

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

import com.ziksana.domain.todo.MemberPersona;
import com.ziksana.domain.todo.Todo;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.todo.TodoService;

/**
 * Test Case
 * 
 * @author
 */

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TodoTestCase {

	@Autowired
	TodoService todoService;

	@BeforeClass
	public static void runBeforeClass() {

	}

	@AfterClass
	public static void runAfterClass() {

	}

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
		ZID memberId = new StringZID("1");
		ZID memberPersonaId = new StringZID("1");
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

		Todo members = todoService.findTodo(1);

	}

	/**
	 * Test method for
	 * {@link com.ziksana.service.alert.impl.AlertServiceImpl#createAlertItem(com.ziksana.domain.alerts.Alert)}
	 * .
	 */
	@Test
	public void testCreateAlertItem() {

		Todo member = new Todo();
		member.setCategory("Assignment");
		member.setActivationDate(new Date());
		// member.setNotificationType(100);
		MemberPersona creatingMember = new MemberPersona();
		// creatingMember.setMemberRoleId(Integer.valueOf(ThreadLocalUtil
		// .getToken().getMemberPersonaId().getStorageID()));

		// member.setCreatingMember(creatingMember);
		// member.setForMember(creatingMember);
		member.setDescription(" new video coming up for the course");
		member.setPriority(Integer.valueOf(1000));
		Assert.assertNotNull(member);
		todoService.createTodo(member);

	}

	/**
	 * Test method for
	 * {@link com.ziksana.service.alert.impl.AlertServiceImpl#editAlertItem(com.ziksana.domain.alerts.Alert)}
	 * .
	 */
	@Test
	public void testEditAlertItem() {
		Todo member = new Todo();
		member.setId(2);
		member.setActivationDate(new Date());
		member.setCategory("Course");
		member.setDescription("New online course coming up for the organic chemistry");
		member.setPriority(Integer.valueOf(1001));
		Assert.assertNotNull(member);
		todoService.updateTodo(member);

	}

	/**
	 * Test method for
	 * {@link com.ziksana.service.alert.impl.AlertServiceImpl#deleteAlertItem(java.lang.Integer, java.lang.Integer)}
	 * .
	 */
	@Test
	public void testDeleteAlertItem() {

		//todoService.deleteTodo(Integer.valueOf(1));

	}

}
