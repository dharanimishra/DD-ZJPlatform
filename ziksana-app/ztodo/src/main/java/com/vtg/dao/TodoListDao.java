/**
 * 
 */
package com.vtg.dao;

import java.util.Collection;

import com.vtg.model.TodoList;

/**
 * @author
 * 
 */
public interface TodoListDao {

	Collection<TodoList> selectAll();

	TodoList getTodoList(String todoId);

	void createTodoList(TodoList todolist);

	void editTodoList(TodoList todolist);

	void deleteTodoList(String todoId);

	void insert(TodoList todolist);
}
