/**
 * 
 */
package com.ziksana.service.todo;

import com.ziksana.domain.todos.TodoList;

/**
 * @author
 * 
 */
public interface TodoListService {

	TodoList getTodoList(int todoId);

	void updateTodoList(TodoList todolist);

	void deleteTodoList(int todoId);

	void createTodoList(TodoList todolist);
}
