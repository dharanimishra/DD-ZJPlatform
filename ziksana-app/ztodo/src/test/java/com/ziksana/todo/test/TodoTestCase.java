package com.ziksana.todo.test;

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
 * @author Ratnesh Kumar
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
	 * {@link com.ziksana.service.todo.TodoServiceImpl#getTodos()}.
	 */
	@Test
	public void testGetTodos() {

		List<Todo> members = todoService.getTodos(1);
		Assert.assertNotNull(members);

	}

	/**
	 * Test method for
	 * {@link com.ziksana.service.todo.TodoServiceImpl#getTodo()}.
	 */
	@Test
	public void testGetTodo() {

		Todo member = todoService.findTodo(2);
		Assert.assertNotNull(member);
	}

	/**
	 * Test method for
	 * {@link com.ziksana.service.todo.TodoServiceImpl#createTodo()} .
	 */
	@Test
	public void testCreateTodo() {

		Todo member = new Todo();
		member.setCategory("Assignment");
		member.setActivationDate(new Date());
		member.setNotificationType(1);
		member.setDescription("Todo Services testing");
		MemberPersona creatingMember = new MemberPersona();
		// creatingMember.setMemberRoleId(Integer.valueOf(ThreadLocalUtil
		// .getToken().getMemberPersonaId().getStorageID()));

		// member.setCreatingMember(creatingMember);
		// member.setForMember(creatingMember);
		member.setDescription("new video coming up for the course");
		member.setPriority(Integer.valueOf(1000));
		Assert.assertNotNull(member);
		todoService.createTodo(member);

	}

	/**
	 * Test method for
	 * {@link com.ziksana.service.todo.TodoServiceImpl#updateTodo()} .
	 */
	@Test
	public void testUpdateTodo() {
		Todo member = new Todo();
		member.setId(2);
		member.setActivationDate(new Date());
		member.setCategory("Course");
		member.setNotificationType(1);
		member.setDescription("New online course coming up for the organic chemistry");
		member.setPriority(Integer.valueOf(1001));
		Assert.assertNotNull(member);
		todoService.updateTodo(member);

	}

	/**
	 * Test method for
	 * {@link com.ziksana.service.todo.TodoServiceImpl#deleteTodo(java.lang.Integer)}
	 * .
	 */
	@Test
	public void testDeleteTodo() {
		todoService.deleteTodo(Integer.valueOf(1));

	}

}
