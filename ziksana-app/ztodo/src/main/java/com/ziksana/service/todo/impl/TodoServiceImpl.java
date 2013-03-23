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
		try {
			todoList = todoMapper.getTodos(Integer.valueOf(ThreadLocalUtil
					.getToken().getMemberPersonaId().getStorageID()));
		} catch (CannotGetJdbcConnectionException dae) {
			logger.info("Data Access Exception called");
			throw new DataBaseException(dae);
		}
		catch(NullPointerException ne){
			throw new TodoException(ZiksanaConstants.ZIKSANA_OBJECT_NULL);
		}
		return todoList;
	}

	@Override
	public void createTodo(Todo todo) {
		logger.info("TODO || Create");
		try {
			todoMapper.createTodo(todo);
		}

		catch (CannotGetJdbcConnectionException dae) {
			logger.info("Data Access Exception called");
			throw new DataBaseException(dae);
		}
		catch(BadSqlGrammarException bq){
			throw new TodoException(ZiksanaConstants.SQL_ERROR, new Object[] {bq.getSQLException()});
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
			throw new DataBaseException(dae);
		} catch(NullPointerException ne){
			throw new TodoException(ZiksanaConstants.ZIKSANA_OBJECT_NULL);
		}

	}

	@Override
	public void deleteTodo(int todoId) {
		logger.info("TODO || Delete");
		int deleteCount = 0;
		try {
			deleteCount = todoMapper.deleteTodo(todoId);

		} catch(CannotGetJdbcConnectionException e) {
			
				throw new TodoException(ZiksanaConstants.TODO_UPDATECOUNT_ERROR, e);
			

		}

	}

	@Override
	public List<Todo> getMapperTodos() {

		
		int offset = 0;
		int limit = 3;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Todo> todoList = new ArrayList<Todo>();
		try {
			Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken()
					.getMemberPersonaId().getStorageID());
			todoList = todoMapper.getMapperTodos(memberRoleId, rowBounds);
		} 
		catch (CannotGetJdbcConnectionException dae) {
			logger.info("Data Access Exception called");
			throw new DataBaseException(dae);
		}
		catch(NullPointerException ne){
			throw new TodoException(ZiksanaConstants.ZIKSANA_OBJECT_NULL);
		}
		return todoList;
	}

	
}
