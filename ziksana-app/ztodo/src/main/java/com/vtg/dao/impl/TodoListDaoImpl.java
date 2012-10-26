/**
 * 
 */
package com.vtg.dao.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vtg.dao.TodoListDao;
import com.vtg.mapper.TodoListMapper;
import com.vtg.model.TodoList;

/**
 * @author
 * 
 */
public class TodoListDaoImpl implements TodoListDao {

	@Autowired
	TodoListMapper todoListMapper;
	private static final Logger LOGGER = Logger
			.getLogger(TodoListDaoImpl.class);

	public void setTodoMapper(TodoListMapper todoListMapper) {
		this.todoListMapper = todoListMapper;
		LOGGER.info("Class :" + getClass()
				+ ": Method :setTodoMapper(TodoListMapper todoListMapper)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoListDao#getTodoList(com.vtg.model.Member)
	 */
	public Collection<TodoList> selectAll() {
		LOGGER.info("Class :" + getClass() + " : Entering Method :selectAll()");
		final Collection<TodoList> list = todoListMapper.selectAll();
		LOGGER.info("Class :" + getClass()
				+ " : Method :selectAll(): list.isEmpty():" + list.isEmpty());
		LOGGER.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoListDao#getTodoList(java.lang.String)
	 */
	public TodoList getTodoList(final String todoId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :getTodoList(String todoId)");
		TodoList list = todoListMapper.selectById(todoId);
		LOGGER.info("Class :" + getClass()
				+ " : Method :getTodoList(String todoId): TodoList:"
				+ list.getId());
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :getTodoList(String todoId)");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoListDao#createTodoList(com.vtg.model.TodoList)
	 */
	public void createTodoList(final TodoList todolist) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :createTodoList(TodoList todolist)");
		try {
			todoListMapper.insert(todolist);
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method :createTodoList(TodoList todolist): TodoList: Id"
					+ todolist.getId());
		} catch (Exception e) {
			LOGGER.error("Class :"
					+ getClass()
					+ " : Method :createTodoList(TodoList todolist): TodoList: Id"
					+ todolist.getId() + "Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :createTodoList(TodoList todolist)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoListDao#editTodoList(com.vtg.model.TodoList)
	 */
	public void editTodoList(final TodoList todolist) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :editTodoList(TodoList todolist)");
		try {
			todoListMapper.update(todolist);
			LOGGER.info("Class :" + getClass()
					+ " : Method :editTodoList(TodoList todolist): TodoList:Id"
					+ todolist.getId());
		} catch (Exception e) {
			LOGGER.error("Class :" + getClass()
					+ " : Method :editTodoList(TodoList todolist): Todo :"
					+ todolist.getId() + "Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :editTodoList(TodoList todolist)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoListDao#deleteTodoList(java.lang.String)
	 */
	public void deleteTodoList(final String todoId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :deleteTodoList(String todoId)");
		try {
			todoListMapper.delete(todoId);
			LOGGER.info("Class :" + getClass()
					+ " : Method :deleteTodoList(String todoId): TodoList:Id"
					+ todoId);
		} catch (Exception e) {
			LOGGER.error("Class :" + getClass()
					+ " : Method :editTodoList(TodoList todolist): TodoList:Id"
					+ todoId + "Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :deleteTodoList(String todoId)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoListDao#insert(com.vtg.model.TodoList)
	 */
	public void insert(TodoList todolist) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :insert(TodoList todolist)");
		try {
			todoListMapper.insert(todolist);
			LOGGER.info("Class :" + getClass()
					+ " : Method :deleteTodoList(String todoId): TodoList:Id"
					+ todolist.getId());
		} catch (Exception e) {
			LOGGER.error("Class :" + getClass()
					+ " : Method :insert(TodoList todolist): TodoList:Id"
					+ todolist.getId() + "Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :insert(TodoList todolist)");
	}
}
