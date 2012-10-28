/**
 * 
 */
package com.ziksana.service.todo;

import com.ziksana.domain.todos.Todo;

/**
 * @author
 * 
 */
public interface TodoService {

	Todo findTodo(int todoId);

	void createTodo(String toListId, Todo todo);

	void updateTodo(Todo todo);

	void deleteTodo(int todoId);

	Todo completeTodo(int todoId);

}
