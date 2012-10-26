/**
 * 
 */
package com.vtg.dao;

import com.vtg.model.Todo;

/**
 * @author
 * 
 */
public interface TodoDao {

	Todo findTodo(String todoId);

	void createTodo(Todo todo);

	void updateTodo(Todo todo);

	void deleteTodo(String todoId);

}
