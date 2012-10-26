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
	private static final Logger logger = Logger
			.getLogger(TodoListDaoImpl.class);

	public void setTodoMapper(TodoListMapper todoListMapper) {
		this.todoListMapper = todoListMapper;
		logger.info("Class :" + getClass()
				+ ": Method :setTodoMapper(TodoListMapper todoListMapper)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoListDao#getTodoList(com.vtg.model.Member)
	 */
	public Collection<TodoList> selectAll() {
		logger.info("Class :" + getClass() + " : Entering Method :selectAll()");
		Collection<TodoList> list = todoListMapper.selectAll();
		logger.info("Class :" + getClass()
				+ " : Method :selectAll(): list.isEmpty():" + list.isEmpty());
		logger.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoListDao#getTodoList(java.lang.String)
	 */
	public TodoList getTodoList(String todoId) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :getTodoList(String todoId)");
		TodoList list = todoListMapper.selectById(todoId);
		logger.info("Class :" + getClass()
				+ " : Method :getTodoList(String todoId): TodoList:"
				+ list.getId());
		logger.info("Class :" + getClass()
				+ " : Leaving Method :getTodoList(String todoId)");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoListDao#createTodoList(com.vtg.model.TodoList)
	 */
	public void createTodoList(TodoList todolist) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :createTodoList(TodoList todolist)");
		try {
			todoListMapper.insert(todolist);
			logger.info("Class :"
					+ getClass()
					+ " : Method :createTodoList(TodoList todolist): TodoList: Id"
					+ todolist.getId());
		} catch (Exception e) {
			logger.error("Class :"
					+ getClass()
					+ " : Method :createTodoList(TodoList todolist): TodoList: Id"
					+ todolist.getId() + "Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :createTodoList(TodoList todolist)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoListDao#editTodoList(com.vtg.model.TodoList)
	 */
	public void editTodoList(TodoList todolist) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :editTodoList(TodoList todolist)");
		try {
			todoListMapper.update(todolist);
			logger.info("Class :" + getClass()
					+ " : Method :editTodoList(TodoList todolist): TodoList:Id"
					+ todolist.getId());
		} catch (Exception e) {
			logger.error("Class :" + getClass()
					+ " : Method :editTodoList(TodoList todolist): Todo :"
					+ todolist.getId() + "Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :editTodoList(TodoList todolist)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoListDao#deleteTodoList(java.lang.String)
	 */
	public void deleteTodoList(String todoId) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :deleteTodoList(String todoId)");
		try {
			todoListMapper.delete(todoId);
			logger.info("Class :" + getClass()
					+ " : Method :deleteTodoList(String todoId): TodoList:Id"
					+ todoId);
		} catch (Exception e) {
			logger.error("Class :" + getClass()
					+ " : Method :editTodoList(TodoList todolist): TodoList:Id"
					+ todoId + "Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :deleteTodoList(String todoId)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.TodoListDao#insert(com.vtg.model.TodoList)
	 */
	public void insert(TodoList todolist) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :insert(TodoList todolist)");
		try {
			todoListMapper.insert(todolist);
			logger.info("Class :" + getClass()
					+ " : Method :deleteTodoList(String todoId): TodoList:Id"
					+ todolist.getId());
		} catch (Exception e) {
			logger.error("Class :" + getClass()
					+ " : Method :insert(TodoList todolist): TodoList:Id"
					+ todolist.getId() + "Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :insert(TodoList todolist)");
	}
}
