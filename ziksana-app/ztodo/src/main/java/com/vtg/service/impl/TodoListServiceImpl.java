/**
 * 
 */
package com.vtg.service.impl;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vtg.dao.impl.CategoryDaoImpl;
import com.vtg.dao.impl.TodoDaoImpl;
import com.vtg.dao.impl.TodoListDaoImpl;
import com.vtg.model.Category;
import com.vtg.model.MemberPersona;
import com.vtg.model.Todo;
import com.vtg.model.TodoList;
import com.vtg.service.TodoListService;

/**
 * @author
 * 
 */
public class TodoListServiceImpl implements TodoListService {

	@Autowired
	TodoListDaoImpl todoListDaoImpl;

	@Autowired
	TodoDaoImpl todoDaoImpl;

	@Autowired
	CategoryDaoImpl categoryDaoImpl;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TodoListServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.TodoListService#getTodoList(com.vtg.model.Member)
	 */
	public Collection<TodoList> getTodoList() {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :getTodoList()");
		final Collection<TodoList> list = todoListDaoImpl.selectAll();
		LOGGER.info("Class :" + getClass()
				+ " : Method : getTodoList() :todoListDaoImpl.selectAll():"
				+ list.isEmpty());
		LOGGER.info("Class :" + getClass() + " : Leaving Method :getTodoList()");
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.TodoListService#getTodoList(com.vtg.model.Member)
	 */
	public Collection<TodoList> getTodoList(final MemberPersona member) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :getTodoList(MemberPersona member)");
		Collection<TodoList> list = todoListDaoImpl.selectAll();
		LOGGER.info("Class :"
				+ getClass()
				+ " : Method : getTodoList(MemberPersona member) :todoListDaoImpl.selectAll():"
				+ list.isEmpty());
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method : getTodoList(MemberPersona member)");
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.TodoListService#createTodoItem(com.vtg.model.Member,
	 * com.vtg.model.Todo)
	 */
	public void createTodoItem(final MemberPersona member, final Todo todo) {
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method : createTodoItem(MemberPersona member, Todo todo)");
		try {
			todoDaoImpl.createTodo(todo);
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : createTodoItem(MemberPersona member, Todo todo) :todoDaoImpl.createTodo(todo);");
		} catch (Exception e) {
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : createTodoItem(MemberPersona member, Todo todo) :todoDaoImpl.createTodo(todo);:");
		}
		LOGGER.info("Class :"
				+ getClass()
				+ " : Leaving Method : createTodoItem(MemberPersona member, Todo todo)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.TodoListService#editTodoItem(com.vtg.model.Member,
	 * com.vtg.model.Todo)
	 */
	public void editTodoItem(final MemberPersona member, final Todo todo) {
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method : editTodoItem(MemberPersona member, Todo todo)");
		try {
			todoDaoImpl.updateTodo(todo);
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : editTodoItem(MemberPersona member, Todo todo) :todoDaoImpl.updateTodo(todo):");
		} catch (Exception e) {
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : editTodoItem(MemberPersona member, Todo todo) :todoDaoImpl.updateTodo(todo):");
		}
		LOGGER.info("Class :"
				+ getClass()
				+ " : Leaving Method : editTodoItem(MemberPersona member, Todo todo)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.TodoListService#createCategory(com.vtg.model.Member,
	 * com.vtg.model.Category)
	 */
	public void createCategory(final MemberPersona member,
			final Category category) {
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method : createCategory(MemberPersona member, Category category)");
		try {
			categoryDaoImpl.insert(category);
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : createCategory(MemberPersona member, Category category) :categoryDaoImpl.insert(category):");
		} catch (Exception e) {
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method : createCategory(MemberPersona member, Category category) :categoryDaoImpl.insert(category):");
		}
		LOGGER.info("Class :"
				+ getClass()
				+ " : Leaving Method : createCategory(MemberPersona member, Category category)");
	}
}
