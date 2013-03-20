package com.ziksana.service.todo.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Service;

import com.ziksana.constants.ZiksanaConstants;
import com.ziksana.domain.todo.Todo;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.persistence.todos.TodoMapper;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.todo.TodoService;

/**
 * @author prabu
 * 
 */
@Service
public class TodoServiceImpl implements TodoService {

	private static final Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);
	
	@Autowired
	TodoMapper todoMapper;

	@Override
	public List<Todo> getTodos() {

		List<Todo> todoList = new ArrayList<Todo>();
		try {
			todoList = todoMapper.getTodos(Integer.valueOf(ThreadLocalUtil
					.getToken().getMemberPersonaId().getStorageID()));
		} catch (CannotGetJdbcConnectionException dae) {
			logger.info("Data Access Exception called");
			throw new ZiksanaException(
					ZiksanaConstants.DATABASE_CONNECTION_PROBLEM,
					new Object[] { dae.getMessage() }, dae);
		}
		return todoList;
	}

	@Override
	public void createTodo(Todo todo) {
		logger.info("TODO || Create");
		try {
			todoMapper.createTodo(todo);
		}

		catch (Exception dae) {
			logger.info("Data Access Exception called");
			throw new ZiksanaException(
					ZiksanaConstants.TODO_INSERTQUERY_PROBLEM,
					new Object[] { dae.getMessage() });
		}
	}

	@Override
	public void updateTodo(Todo todo) {
		int rowCount = 0;
		try {
			rowCount = todoMapper.updateTodo(todo);
		}

		catch (CannotGetJdbcConnectionException dae) {
			logger.info("Data Access Exception called");
			throw new ZiksanaException(
					ZiksanaConstants.TODO_UPDATEQUERY_PROBLEM,
					new Object[] { dae.getMessage() }, dae);
		} catch (Exception e) {
			logger.info("Data Access Exception called");
			throw new ZiksanaException(ZiksanaConstants.TODO_UPDATECOUNT_ERROR,
					new Object[] { e.getMessage() }, e);
		}

	}

	@Override
	public void deleteTodo(int todoId) {
		logger.info("TODO || Delete");
		int deleteCount = 0;
		try {
			deleteCount = todoMapper.deleteTodo(todoId);

		} catch (Exception e) {
			if (!(deleteCount == 0)) {
				throw new ZiksanaException(
						ZiksanaConstants.TODO_DELETION_FAILURE,
						new Object[] { e.getMessage() }, e);
			}

		}

	}

	@Override
	public List<Todo> getMapperTodos() {

		Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken()
				.getMemberPersonaId().getStorageID());
		int offset = 0;
		int limit = 3;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Todo> todoList = new ArrayList<Todo>();
		try {
			todoList = todoMapper.getMapperTodos(memberRoleId, rowBounds);
		} catch (CannotGetJdbcConnectionException dae) {
			logger.info("Data Access Exception called");
			throw new ZiksanaException(
					ZiksanaConstants.TODO_UPDATEQUERY_PROBLEM,
					new Object[] { dae.getMessage() }, dae);
		}
		return todoList;
	}

}
