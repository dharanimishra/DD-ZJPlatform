package com.vtg.todolist.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vtg.dao.TodoListDao;
import com.vtg.dao.impl.TodoListDaoImpl;
import com.vtg.model.TodoList;

/**
 * Test Case
 * 
 * @author
 */

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TodoListTestCase {

	private static TodoListDao todoListDAO;

	@BeforeClass
	public static void runBeforeClass() {
		todoListDAO = new TodoListDaoImpl();
	}

	@AfterClass
	public static void runAfterClass() {
		todoListDAO = null;
	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.TodoListDao#insert(com.vtg.model.TodoList)}.
	 */
	@Test
	public void testInsert() {

		TodoList actual = new TodoList();
		todoListDAO.insert(actual);

		assertEquals(1, actual.getId());
		TodoList expected = todoListDAO.getTodoList("1");
		assertEquals(actual, expected);
		assertNotSame(actual, expected);

	}

	/**
	 * Test method for {@link com.vtg.dao.TodoListDao#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		List<TodoList> list = (List<TodoList>) todoListDAO.selectAll();
		assertNotNull(list);
		assertEquals(1, 1);
	}

	/**
	 * Test method for {@link com.vtg.dao.TodoListDao#getTodoList(String)}.
	 */
	@Test
	public void testSelectById() {
		TodoList actual = new TodoList();
		TodoList expected = todoListDAO.getTodoList(actual.getId());

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.TodoListDao#update(com.vtg.model.TodoList)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		TodoList actual = new TodoList();

		TodoList expected = todoListDAO.getTodoList("1");
		expected.setName("Todo List");
		todoListDAO.editTodoList(expected);
		expected = todoListDAO.getTodoList(actual.getId());

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for {@link com.vtg.dao.TodoListDao#delete(String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		todoListDAO.deleteTodoList("1");
		TodoList expected = todoListDAO.getTodoList("1");
		assertNull(expected);
	}

}
