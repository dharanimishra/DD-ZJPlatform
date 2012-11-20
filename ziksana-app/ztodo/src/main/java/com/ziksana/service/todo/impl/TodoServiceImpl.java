/**
 * 
 */
package com.ziksana.service.todo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.todo.Todo;
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
	 * @see com.ziksana.service.todo.TodoService#getTodos(int)
	 */
	@Override
	public List<Todo> getTodos(int memberRoleId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :getTodos(int memberRoleId)");
		LOGGER.debug("Class :"
				+ getClass()
				+ " : Method :getTodos(int memberRoleId) :getTodos(memberRoleId):List Size:"
				+ todoMapper.getTodos(memberRoleId).size());
		List<Todo> list = todoMapper.getTodos(memberRoleId);
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :getTodos(int memberRoleId)");
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ziksana.service.todo.TodoService#findTodo(int)
	 */
	@Override
	public Todo findTodo(int todoId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :findTodo(int id)");
		LOGGER.debug("Class :"
				+ getClass()
				+ " : Method :findTodo(int id) :memberNotificationDaoImpl.findTodo(id):"
				+ todoMapper.getTodo(todoId).getId());
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int id)");
		return todoMapper.getTodo(todoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ziksana.service.todo.TodoService#createTodo(java.lang.String,
	 * com.ziksana.domain.todo.Todo)
	 */
	@Override
	public void createTodo(Todo todo) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :createTodo(Todo todo)");
		try {
			todoMapper.createTodo(todo);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :createTodo(Todo todo) :memberNotificationDaoImpl.createTodo(todo);"
					+ todo.getId());
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :createTodo(Todo todo) :memberNotificationDaoImpl.createTodo(todo);"
					+ todo.getId() + "Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :createTodo(Todo todo)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.todo.TodoService#updateTodo(com.ziksana.domain.todo
	 * .Todo)
	 */
	@Override
	public void updateTodo(Todo todo) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :updateTodo(Todo todo)");
		try {
			todoMapper.updateTodo(todo);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :updateTodo(Todo todo) :memberNotificationServiceImpl.updateTodo(Todo todo):");
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :updateTodo(Todo todo) :memberNotificationDaoImpl.updateTodo(Todo todo): Exception :"
					+ e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :updateTodo(Todo todo)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ziksana.service.todo.TodoService#deleteTodo(int)
	 */
	@Override
	public void deleteTodo(int todoId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :deleteTodo(int todoId)");
		try {
			todoMapper.deleteTodo(todoId);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :deleteTodo(int todoId) :memberNotificationDaoImpl.deleteTodo(todoId):"
					+ todoId);
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :deleteTodo(int todoId) :memberNotificationDaoImpl.deleteTodo(todoId):"
					+ todoId + " Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :deleteTodo(int todoId)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ziksana.service.todo.TodoService#completeTodo(int)
	 */
	@Override
	public Todo completeTodo(int todoId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :completeTodo(int id)");
		LOGGER.debug("Class :"
				+ getClass()
				+ " : Method :completeTodo(int id) :memberNotificationDaoImpl.completeTodo(id):"
				+ todoMapper.getTodo(todoId).getId());
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :completeTodo(int id)");
		return todoMapper.getTodo(todoId);
	}

}
