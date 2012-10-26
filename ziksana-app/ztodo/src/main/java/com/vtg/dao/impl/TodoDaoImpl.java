/**
 * 
 */
package com.vtg.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.vtg.dao.TodoDao;
import com.vtg.mapper.TodoMapper;

import com.vtg.model.Todo;

/**
 * @author
 * 
 */
public class TodoDaoImpl implements TodoDao {

	@Autowired
	TodoMapper todoMapper;
	private static final Logger logger = Logger.getLogger(TodoDaoImpl.class);

	public void setTodoMapper(TodoMapper todoMapper) {
		this.todoMapper = todoMapper;
		logger.info("Class :TodoDaoImpl : Method :setTodoMapper(TodoMapper todoMapper)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoDao#findTodo(java.lang.String)
	 */
	public Todo findTodo(String todoId) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :findTodo(String todoId)");
		Todo list = todoMapper.selectById(todoId);
		logger.debug("Class :" + getClass()
				+ ":TodoDaoImpl : Method :findTodo(String todoId): Todo :"
				+ todoId);
		logger.info("Class :" + getClass()
				+ " : Leaving Method :findTodo(String todoId)");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoDao#createTodo(java.lang.String, com.vtg.model.Todo)
	 */
	public void createTodo(Todo todo) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :createTodo(Todo todo)");
		try {
			todoMapper.insert(todo);
			logger.info("Class :" + getClass()
					+ ":TodoDaoImpl : Method :createTodo(Todo todo): Todo :"
					+ todo.getId());
		} catch (Exception e) {
			logger.info("Class :" + getClass()
					+ ":TodoDaoImpl : Method :createTodo(Todo todo): Todo :"
					+ todo.getId() + "Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :createTodo(Todo todo)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoDao#updateTodo(com.vtg.model.Todo)
	 */
	public void updateTodo(Todo todo) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :updateTodo(Todo todo)");
		try {
			todoMapper.update(todo);
			logger.info("Class :" + getClass()
					+ ":TodoDaoImpl : Method :updateTodo(Todo todo): Todo :"
					+ todo.getId());
		} catch (Exception e) {
			logger.error("Class :" + getClass()
					+ ":TodoDaoImpl : Method :updateTodo(Todo todo): Todo :"
					+ todo.getId() + "Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :updateTodo(Todo todo)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoDao#deleteTodo(java.lang.String)
	 */
	public void deleteTodo(String todoId) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :deleteTodo(String todoId)");
		try {
			todoMapper.delete(todoId);
			logger.info("Class :" + getClass()
					+ " : Method :deleteTodo(String todoId): TodoId :" + todoId);
		} catch (Exception e) {
			logger.error("Class :" + getClass()
					+ ": Method :deleteTodo(String todoId): TodoId :" + todoId
					+ "Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :deleteTodo(String todoId)");
	}
}
