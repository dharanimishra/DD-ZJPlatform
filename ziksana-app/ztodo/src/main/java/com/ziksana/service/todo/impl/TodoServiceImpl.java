package com.ziksana.service.todo.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Service;

import com.ziksana.constants.ZiksanaConstants;
import com.ziksana.domain.todo.Todo;
import com.ziksana.exception.DataBaseException;
import com.ziksana.exception.SystemException;
import com.ziksana.exception.todo.TodoException;
import com.ziksana.persistence.todos.TodoMapper;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.todo.TodoService;

/**
 * @author prabu
 * 
 */
@Service
public class TodoServiceImpl implements TodoService {

	private static final Logger logger = LoggerFactory
			.getLogger(TodoServiceImpl.class);

	@Autowired
	TodoMapper todoMapper;

	@Override
	public List<Todo> getTodos() {

		List<Todo> todoList = new ArrayList<Todo>();
		todoList = todoMapper.getTodos(Integer.valueOf(ThreadLocalUtil
				.getToken().getMemberPersonaId().getStorageID()));
		return todoList;
	}

	@Override
	public void createTodo(Todo todo) {
		logger.info("TODO || Create");
		todoMapper.createTodo(todo);
	}

	@Override
	public void updateTodo(Todo todo) {
		int rowCount = 0;
		rowCount = todoMapper.updateTodo(todo);

	}

	@Override
	public void deleteTodo(int todoId) {
		logger.info("TODO || Delete");
		int deleteCount = 0;
		deleteCount = todoMapper.deleteTodo(todoId);
	}

	@Override
	public List<Todo> getMapperTodos() {

		int offset = 0;
		int limit = 3;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Todo> todoList = new ArrayList<Todo>();
		Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken()
				.getMemberPersonaId().getStorageID());
		todoList = todoMapper.getMapperTodos(memberRoleId, rowBounds);
		return todoList;
	}

}
