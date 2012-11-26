/**
 * 
 */
package com.ziksana.persistence.todos;

import java.util.List;

import com.ziksana.domain.todo.Todo;

/**
 * @author prabu
 *
 */
public interface TodoMapper {
	
	public List<Todo> getTodos(int memberRoleId);

	public Todo getTodo(int todoId);

	public Todo selectByNotificationType(int notificationType);

	public void updateTodo(Todo todo);

	public void deleteTodo(int todoId);

	public void createTodo(Todo todo);

}
