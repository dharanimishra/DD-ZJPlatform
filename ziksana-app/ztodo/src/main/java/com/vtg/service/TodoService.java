/**
 * 
 */
package com.vtg.service;

import java.util.Collection;

import com.vtg.model.Todo;
import com.vtg.model.MemberPersona;

/**
 * @author
 * 
 */
public interface TodoService {

	Todo findTodo(String todoId);

	Collection<Todo> findAssignedTodos(MemberPersona member);

	void createTodo(String toListId, Todo todo);

	void updateTodo(Todo todo);

	void deleteTodo(String todoId);

	Todo completeTodo(String todoId);

}
