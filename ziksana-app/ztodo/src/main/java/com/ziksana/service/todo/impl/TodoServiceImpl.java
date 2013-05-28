package com.ziksana.service.todo.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.todo.Todo;
import com.ziksana.persistence.todos.TodoMapper;
import com.ziksana.security.util.SecurityTokenUtil;
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


	public List<Todo> getTodos() {

		List<Todo> todoList = new ArrayList<Todo>();
		todoList = todoMapper.getTodos(Integer.valueOf(SecurityTokenUtil
				.getToken().getMemberPersonaId().getStorageID()));
		return todoList;
	}


	public void createTodo(Todo todo) {
		logger.info("TODO || Create");
		todoMapper.createTodo(todo);
	}


	public void updateTodo(Todo todo) {
		int rowCount = 0;
		rowCount = todoMapper.updateTodo(todo);

	}


	public void deleteTodo(int todoId) {
		logger.info("TODO || Delete");
		int deleteCount = 0;
		deleteCount = todoMapper.deleteTodo(todoId);
	}


	public List<Todo> getMapperTodos() {

		int offset = 0;
		int limit = 3;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Todo> todoList = new ArrayList<Todo>();
		Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID());
		todoList = todoMapper.getMapperTodos(memberRoleId, rowBounds);
		return todoList;
	}


	public int getTodosSize() {

		return todoMapper.getTodoSize(Integer.valueOf(SecurityTokenUtil.getToken().getMemberPersonaId().getStorageID()));
	}


	public List<Todo> getTodoPagination(int pageIndex, int itemsPerPage) {
		
		return todoMapper.getTodoPagination(pageIndex,itemsPerPage, Integer.valueOf(SecurityTokenUtil.getToken().getMemberPersonaId().getStorageID()));
	}


	

}
