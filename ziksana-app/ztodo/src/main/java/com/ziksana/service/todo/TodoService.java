/**
 * 
 */
package com.ziksana.service.todo;

import java.util.List;

import com.ziksana.domain.todo.Todo;

/**
 * @author Ratnesh Kumar
 * 
 */
public interface TodoService {

	List<Todo> getTodos(int memberRoleId);

	Todo findTodo(int todoId);

	void createTodo(Todo todo);

	void updateTodo(Todo todo);

	void deleteTodo(int todoId);

	Todo completeTodo(int todoId);

}
