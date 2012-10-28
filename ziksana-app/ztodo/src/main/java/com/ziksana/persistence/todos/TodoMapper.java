/**
 * 
 */
package com.ziksana.persistence.todos;

import com.ziksana.domain.todos.Todo;

/**
 * @author
 * 
 */
public interface TodoMapper {

	Todo findTodo(int todoId);

	void createTodo(Todo todo);

	void updateTodo(Todo todo);

	void deleteTodo(int todoId);

}
