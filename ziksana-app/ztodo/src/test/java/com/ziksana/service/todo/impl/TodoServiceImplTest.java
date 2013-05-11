/**
 * 
 */
package com.ziksana.service.todo.impl;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

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

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.todo.Todo;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.todo.TodoService;
/**
 * @author prabu
 * 
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")

public class TodoServiceImplTest {
	private static final Logger logger = LoggerFactory.getLogger(TodoServiceImplTest.class);

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

		ZID memberId = new StringZID("1001");
		ZID memberPersonaId = new StringZID("201");
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

	/**
	 * Test method for
	 * {@link com.ziksana.service.todo.TodoServiceImpl#getTodos()}.
	 */
	
	@Ignore
	public void testGetTodos() {

		List<Todo> todos = todoService.getTodos();
		//assertEquals(todos);

	}
	@Ignore
	public void testMapperTodos(){
		List<Todo> todoMapper = todoService.getMapperTodos();
		logger.info("Mappper todos :"+todoMapper.size());
	}
	
	@Ignore
	public void testGetAllDataBaseDatas(){
		
		// Fetch database data after executing your code
		
     /*   IDataSet databaseDataSet = 
        ITable actualTable = databaseDataSet.getTable("TABLE_NAME");

        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("expectedDataSet.xml"));
        ITable expectedTable = expectedDataSet.getTable("TABLE_NAME");

        // Assert actual database table match expected table
        Assertion.assertEquals(expectedTable, actualTable);*/
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
		//member.setNotificationType(1);
		member.setNotificationContent("Todo Services testing");
		MemberPersona creatingMember = new MemberPersona();
		creatingMember.setMemberRoleId(Integer.valueOf(SecurityTokenUtil
		.getToken().getMemberPersonaId().getStorageID()));
		logger.info("Member Role Id :"+creatingMember.getMemberRoleId());
		member.setCreatingMember(creatingMember);
		member.setForMember(creatingMember);
		
		//member.setDescription("new video coming up for the course");
		//member.setPriority(Integer.valueOf(1000));
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
