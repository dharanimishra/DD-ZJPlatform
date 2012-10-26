/**
 * 
 */
package com.vtg.service;

import java.util.Collection;

import com.vtg.model.Category;
import com.vtg.model.MemberPersona;
import com.vtg.model.Todo;
import com.vtg.model.TodoList;

/**
 * @author 
 * 
 */
public interface TodoListService {

	Collection<TodoList> getTodoList(MemberPersona member);

	void createTodoItem(MemberPersona member, Todo todo);

	void editTodoItem(MemberPersona member, Todo todo);

	void createCategory(MemberPersona member, Category category);

}
