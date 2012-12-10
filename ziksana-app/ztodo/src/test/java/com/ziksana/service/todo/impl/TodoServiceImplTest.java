/**
 * 
 */
package com.ziksana.service.todo.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;


import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.todo.Todo;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.todo.TodoService;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
/**
 * @author prabu
 * 
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
	DbUnitTestExecutionListener.class
     })
public class TodoServiceImplTest {

	@Autowired
	TodoService todoService;

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
	@DatabaseSetup("SampleData.xml")
	public void testGetTodos() {

		List<Todo> todos = todoService.getTodos();
		assertNotNull(todos);

	}

	

	/**
	 * Test method for
	 * {@link com.ziksana.service.todo.TodoServiceImpl#createTodo()} .
	 */
	@Ignore 
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
		assertNotNull(member);
		todoService.createTodo(member);

	}

	/**
	 * Test method for
	 * {@link com.ziksana.service.todo.TodoServiceImpl#updateTodo()} .
	 */
	@Ignore 
	public void testUpdateTodo() {
		Todo member = new Todo();
		member.setId(2);
		member.setActivationDate(new Date());
		member.setCategory("Course");
		member.setNotificationType(1);
		member.setDescription("New online course coming up for the organic chemistry");
		member.setPriority(Integer.valueOf(1001));
		assertNotNull(member);
		todoService.updateTodo(member);

	}

	/**
	 * Test method for
	 * {@link com.ziksana.service.todo.TodoServiceImpl#deleteTodo(java.lang.Integer)}
	 * .
	 */
	@Ignore 
	public void testDeleteTodo() {
		todoService.deleteTodo(Integer.valueOf(1));

	}

}
