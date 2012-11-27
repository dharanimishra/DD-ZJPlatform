/**
 * 
 */
package com.ziksana.service.todo;

import java.util.List;

import com.ziksana.domain.todo.Todo;

/**
 * @author prabu
 *
 */
public interface TodoService {
	
	List<Todo> getTodos();

	

	void createTodo(Todo todo);

	void updateTodo(Todo todo);

	void deleteTodo(int todoId);

	Todo completeTodo(int todoId);

	
	

}
