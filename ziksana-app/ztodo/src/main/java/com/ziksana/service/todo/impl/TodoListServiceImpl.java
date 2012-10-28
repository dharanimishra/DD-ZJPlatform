/**
 * 
 */
package com.ziksana.service.todo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.todos.TodoList;
import com.ziksana.persistence.todos.TodoListMapper;
import com.ziksana.service.todo.TodoListService;

/**
 * @author
 * 
 */
public class TodoListServiceImpl implements TodoListService {

	@Autowired
	TodoListMapper todoListMapper;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TodoListServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.TodoListService#createTodoItem(com.vtg.model.Member,
	 * com.vtg.model.Todo)
	 */
	public void createTodoList(final TodoList todo) {
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method : createTodoItem(MemberPersona member, Todo todo)");
		try {
			todoListMapper.createTodoList(todo);
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : createTodoItem(MemberPersona member, Todo todo) :todoDaoImpl.createTodo(todo);");
		} catch (Exception e) {
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : createTodoItem(MemberPersona member, Todo todo) :todoDaoImpl.createTodo(todo);:");
		}
		LOGGER.info("Class :"
				+ getClass()
				+ " : Leaving Method : createTodoItem(MemberPersona member, Todo todo)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.TodoListService#editTodoItem(com.vtg.model.Member,
	 * com.vtg.model.Todo)
	 */
	public void updateTodoList(final TodoList todo) {
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method : editTodoItem(MemberPersona member, Todo todo)");
		try {
			todoListMapper.editTodoList(todo);
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : editTodoItem(MemberPersona member, Todo todo) :todoDaoImpl.updateTodo(todo):");
		} catch (Exception e) {
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : editTodoItem(MemberPersona member, Todo todo) :todoDaoImpl.updateTodo(todo):");
		}
		LOGGER.info("Class :"
				+ getClass()
				+ " : Leaving Method : editTodoItem(MemberPersona member, Todo todo)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ziksana.service.todo.TodoListService#getTodoList(int)
	 */
	@Override
	public TodoList getTodoList(int todoId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method : completeTodo(String todoId)");
		TodoList todo = null;
		try {
			todo = todoListMapper.getTodoList(todoId);
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : completeTodo(String todoId) :todoDaoImpl.findTodo(todoId):todoId"
					+ todoId);
		} catch (Exception e) {
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : completeTodo(String todoId) :todoDaoImpl.findTodo(todoId):todoId:"
					+ todoId + "Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :deleteTodo(String todoId)");
		return todo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ziksana.service.todo.TodoListService#deleteTodoList(int)
	 */
	@Override
	public void deleteTodoList(int todoId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method : deleteTodo(String todoId)");
		try {
			todoListMapper.deleteTodoList(todoId);
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : deleteTodo(String todoId) :todoDaoImpl.deleteTodo(todoId):todoId"
					+ todoId);
		} catch (Exception e) {
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : deleteTodo(String todoId) :todoDaoImpl.updateTodo(todo):todoId:"
					+ todoId + "Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :deleteTodo(String todoId)");

	}

}
