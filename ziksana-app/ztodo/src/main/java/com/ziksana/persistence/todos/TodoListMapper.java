/**
 * 
 */
package com.ziksana.persistence.todos;

import com.ziksana.domain.todos.TodoList;

/**
 * @author
 * 
 */
public interface TodoListMapper {

	TodoList getTodoList(int todoId);

	void editTodoList(TodoList todolist);

	void deleteTodoList(int todoId);

	void createTodoList(TodoList todolist);
}
