/**
 * 
 */
package com.ziksana.service.todo;

import com.ziksana.domain.todo.Todo;

/**
 * @author
 * 
 */
public interface TodoService {

	Todo findTodo(int todoId);

	void createTodo(Todo todo);

	void updateTodo(Todo todo);

	void deleteTodo(int todoId);

	Todo completeTodo(int todoId);

}
