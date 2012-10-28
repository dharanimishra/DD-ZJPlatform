package com.vtg.todolist.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.todos.TodoList;
import com.ziksana.service.todo.TodoListService;

/**
 * Test Case
 * 
 * @author
 */

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TodoListTestCase {

	@Autowired
	TodoListService todoListService;

	@BeforeClass
	public static void runBeforeClass() {

	}

	@AfterClass
	public static void runAfterClass() {

	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.TodoListDao#insert(com.ziksana.domain.todos.TodoList)}
	 * .
	 */
	@Test
	public void testInsert() {

		TodoList actual = new TodoList();
		todoListService.createTodoList(actual);

		assertEquals(1, actual.getId());
		TodoList expected = todoListService.getTodoList(1);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);

	}

	/**
	 * Test method for {@link com.vtg.dao.TodoListDao#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		// List<TodoList> list = (List<TodoList>) todoListDAO.selectAll();
		// assertNotNull(list);
		// assertEquals(1, 1);
	}

	/**
	 * Test method for {@link com.vtg.dao.TodoListDao#getTodoList(String)}.
	 */
	@Test
	public void testSelectById() {
		TodoList actual = new TodoList();
		TodoList expected = todoListService.getTodoList(Integer.parseInt(actual
				.getId()));

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.TodoListDao#update(com.ziksana.domain.todos.TodoList)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		TodoList actual = new TodoList();

		TodoList expected = todoListService.getTodoList(1);
		expected.setName("Todo List");
		todoListService.updateTodoList(expected);
		expected = todoListService
				.getTodoList(Integer.parseInt(actual.getId()));

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

		todoListService.deleteTodoList(1);
		TodoList expected = todoListService.getTodoList(1);
		assertNull(expected);
	}

}
