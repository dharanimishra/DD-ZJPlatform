/**
 * 
 */
package com.ziksana.persistence.todos;

import com.ziksana.domain.todo.Todo;

/**
 * @author
 * 
 */
public interface TodoMapper {

	public Todo getTodo(long id);

	public Todo selectByNotificationType(int notificationType);

	public void updateTodo(Todo todo);

	public void deleteTodo(int todoId);

	public void createTodo(Todo todo);

}
