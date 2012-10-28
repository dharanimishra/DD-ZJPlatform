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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.todos.Todo;
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
	 * Test method for
	 * {@link com.vtg.dao.TodoMapper#insert(com.vtg.model.TodoMapper)}.
	 */
	@Test
	public void testInsert() {

		Todo actual = new Todo(1, "todo category", "todo description", true, 1,
				new Date());
		todoService.createTodo("1", actual);

		assertEquals(1, actual.getId());
		Todo expected = todoService.findTodo(actual.getId());
		assertEquals(actual, expected);
		assertNotSame(actual, expected);

	}

	/**
	 * Test method for {@link com.vtg.dao.TodoMapper#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		Todo list = todoService.findTodo(1);
		assertNotNull(list);
		assertEquals(1, 1);
	}

	/**
	 * Test method for {@link com.vtg.dao.TodoMapper#selectById(int)}.
	 */
	@Test
	public void testSelectById() {
		/*
		 * Todo(int id, String category, String description, boolean complete,
		 * int memberRoleId, Date creationDate) {
		 */
		Todo actual = new Todo(1, "todo category", "todo description", true, 0,
				new Date());
		Todo expected = todoService.findTodo(actual.getId());

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.TodoMapper#update(com.vtg.model.TodoMapper)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		Todo actual = new Todo(1, "todo category", "update todo description",
				true, 1, new Date());

		Todo expected = todoService.findTodo(1);
		expected.setDescription("update todo description");
		todoService.updateTodo(expected);
		expected = todoService.findTodo(1);

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for {@link com.vtg.dao.TodoMapper#delete(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		todoService.deleteTodo(1);
		Todo expected = todoService.findTodo(1);
		assertNull(expected);
	}

}
