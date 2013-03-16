/**
 * 
 */
package com.ziksana.service.todo.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	private static final Logger logger = LoggerFactory
			.getLogger(TodoServiceImpl.class);
	@Autowired
	TodoMapper todoMapper;

	@Override
	public List<Todo> getTodos() {

		System.out.println(" NUMBER OF TODOS "
				+ todoMapper.getTodos(Integer.valueOf(ThreadLocalUtil
						.getToken().getMemberPersonaId().getStorageID())));

		return todoMapper.getTodos(Integer.valueOf(ThreadLocalUtil.getToken()
				.getMemberPersonaId().getStorageID()));
	}

	@Override
	public void createTodo(Todo todo) {
		logger.info("TODO || Create");

		todoMapper.createTodo(todo);

	}

	@Override
	public void updateTodo(Todo todo) {
		
		todoMapper.updateTodo(todo);

	}

	@Override
	public void deleteTodo(int todoId) {
		logger.info("TODO || Delete");
		try {
			todoMapper.deleteTodo(todoId);

		} catch (Exception e) {

		}

	}

	@Override
	public Todo completeTodo(int todoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Todo> getMapperTodos() {
		// TODO Auto-generated method stub

		Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken()
				.getMemberPersonaId().getStorageID());
		int offset = 0;
		int limit = 3;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return todoMapper.getMapperTodos(memberRoleId, rowBounds);
	}

}
