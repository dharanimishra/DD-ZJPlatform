/**
 * 
 */
package com.ziksana.persistence.todos;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.ziksana.domain.todo.Todo;

/**
 * @author prabu
 *
 */
public interface TodoMapper {
	
	public List<Todo> getTodos(Integer memberRoleId);
	
	public List<Todo> getMapperTodos(Integer memberRoleId, RowBounds rowBounds);

	public Todo getTodo(int todoId);

	public Todo selectByNotificationType(int notificationType);

	public void updateTodo(Todo todo);

	public void deleteTodo(int todoId);

	public void createTodo(Todo todo);

}
