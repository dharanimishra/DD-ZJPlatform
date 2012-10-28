/**
 * 
 */
package com.ziksana.service.todo.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.todos.Todo;
import com.ziksana.persistence.todos.TodoMapper;
import com.ziksana.service.todo.TodoService;

/**
 * @author
 * 
 */
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoMapper todoMapper;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TodoServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.TodoService#findTodo(java.lang.String)
	 */
	public Todo findTodo(final int todoId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :findTodo(String todoId)");
		final Todo todo = todoMapper.findTodo(todoId);
		LOGGER.info("Class :"
				+ getClass()
				+ " : Method : findTodo(String todoId) :todoDaoImpl.findTodo(todoId):");
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :findTodo(String todoId)");
		return todo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.TodoService#createTodo(java.lang.String,
	 * com.vtg.model.Todo)
	 */
	public void createTodo(final String todoListId, final Todo todo) {
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method : createTodo(String todoListId, Todo todo)");
		try {
			// todo.setTodoListId(todoListId);
			todoMapper.createTodo(todo);
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : createTodo(String todoListId, Todo todo) :todoDaoImpl.createTodo(todo):");
		} catch (Exception e) {
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : createTodo(String todoListId, Todo todo) :todoDaoImpl.createTodo(todo):Exception :"
					+ e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :createTodo(String todoListId, Todo todo)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.TodoService#updateTodo(com.vtg.model.Todo)
	 */
	public void updateTodo(final Todo todo) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method : updateTodo(Todo todo)");
		try {
			todoMapper.updateTodo(todo);
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : updateTodo(Todo todo) :todoDaoImpl.updateTodo(todo):");
		} catch (Exception e) {
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : updateTodo(Todo todo) :todoDaoImpl.updateTodo(todo):Exception :"
					+ e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :updateTodo(Todo todo)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.TodoService#deleteTodo(java.lang.String)
	 */
	public void deleteTodo(final int todoId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method : deleteTodo(String todoId)");
		try {
			todoMapper.deleteTodo(todoId);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.TodoService#completeTodo(java.lang.String)
	 */
	public Todo completeTodo(int todoId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method : completeTodo(String todoId)");
		Todo todo = null;
		try {
			todo = todoMapper.findTodo(todoId);
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

}
