/**
 * 
 */
package com.ziksana.service.todo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.todo.Todo;
import com.ziksana.persistence.todos.TodoMapper;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.todo.TodoService;

/**
 * @author prabu
 * 
 */
@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoMapper todoMapper;

	@Override
	public List<Todo> getTodos() {
		// TODO Auto-generated method stub

		System.out.println(" NUMBER OF TODOS "
				+ todoMapper.getTodos(Integer.valueOf(ThreadLocalUtil
						.getToken().getMemberPersonaId().getStorageID())));

		return todoMapper.getTodos(Integer.valueOf(ThreadLocalUtil.getToken()
				.getMemberPersonaId().getStorageID()));
	}

	@Override
	public void createTodo(Todo todo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTodo(Todo todo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTodo(int todoId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Todo completeTodo(int todoId) {
		// TODO Auto-generated method stub
		return null;
	}

}
