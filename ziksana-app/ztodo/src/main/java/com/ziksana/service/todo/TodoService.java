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
	
	public List<Todo> getTodos();
	
	public List<Todo> getMapperTodos();

	public void createTodo(Todo todo);

	public void updateTodo(Todo todo);

	public void deleteTodo(int todoId);

	public int getTodosSize();
	
	public List<Todo> getTodoPagination(int pageIndex);


}
