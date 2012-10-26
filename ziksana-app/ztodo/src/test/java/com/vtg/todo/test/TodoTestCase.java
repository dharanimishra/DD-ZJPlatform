package com.vtg.todo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vtg.dao.TodoDao;
import com.vtg.dao.impl.TodoDaoImpl;
import com.vtg.model.Todo;

/**
 * Test Case
 * 
 * @author
 */

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TodoTestCase {

	private static TodoDao todoDAO;

	@BeforeClass
	public static void runBeforeClass() {
		todoDAO = new TodoDaoImpl();
	}

	@AfterClass
	public static void runAfterClass() {
		todoDAO = null;
	}

	/**
	 * Test method for {@link com.vtg.dao.TodoDao#insert(com.vtg.model.Todo)}.
	 */
	@Test
	public void testInsert() {

		Todo actual = new Todo("1", "todo category", "todo description", true,
				1, new Date());
		todoDAO.createTodo(actual);

		assertEquals(1, actual.getId());
		Todo expected = todoDAO.findTodo(actual.getId());
		assertEquals(actual, expected);
		assertNotSame(actual, expected);

	}

	/**
	 * Test method for {@link com.vtg.dao.TodoDao#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		Todo list = todoDAO.findTodo("1");
		assertNotNull(list);
		assertEquals(1, 1);
	}

	/**
	 * Test method for {@link com.vtg.dao.TodoDao#selectById(int)}.
	 */
	@Test
	public void testSelectById() {
		Todo actual = new Todo();
		Todo expected = todoDAO.findTodo(actual.getId());

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for {@link com.vtg.dao.TodoDao#update(com.vtg.model.Todo)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		Todo actual = new Todo("1", "todo category", "todo description", true,
				1, new Date());

		Todo expected = todoDAO.findTodo("1");
		expected.setDescription("todo description");
		todoDAO.updateTodo(expected);
		expected = todoDAO.findTodo("1");

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for {@link com.vtg.dao.TodoDao#delete(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		todoDAO.deleteTodo("1");
		Todo expected = todoDAO.findTodo("1");
		assertNull(expected);
	}

}
