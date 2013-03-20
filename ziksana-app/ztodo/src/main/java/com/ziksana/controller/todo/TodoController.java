package com.ziksana.controller.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.constants.ZiksanaConstants;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.todo.Todo;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.todo.TodoService;

@Controller
@RequestMapping("/ztodo")
public class TodoController {
	private static final Logger logger = LoggerFactory.getLogger(TodoController.class);
	
	@Autowired
	private TodoService todoService;
	
	/**
	 * Retrive all todo items to display on the dashboard
	 */
	@RequestMapping(value = "/showalltodo", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showMyTodos() {
		
		ModelAndView modelView = new ModelAndView("xml/todolist");
		try{		
		modelView.addObject("todoItems", todoService.getTodos());
		}catch (ZiksanaException zexception) {
			modelView.addObject("errorResponse", zexception.getMessage());
			logger.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelView;
	}
	
	@RequestMapping(value = "/gettodosize", method = RequestMethod.GET)
	public @ResponseBody int getTodoSize() {

		int todoSize = 0;
		List<Todo> todoList = new ArrayList<Todo>();
		try{
		todoList = todoService.getTodos();
		}catch (ZiksanaException zexception) {
			
			logger.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		todoSize = todoList.size();
		
		return todoSize;
	}
	
	

	/**
	 * Retrive Three todo items to display on the dashboard
	 */
	@RequestMapping(value = "/getthreetodo", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showTodos() {

		ModelAndView modelView = new ModelAndView("xml/todolist");	
		try{
		modelView.addObject("todoItems", todoService.getMapperTodos());
		}catch (ZiksanaException zexception) {
			modelView.addObject("errorResponse", zexception.getMessage());
			logger.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelView;
	}
	
	/**
	 * Creating new TODO item based on the Todo object
	 * @return mav
	 */
	@RequestMapping(value = "/createtodo", method = RequestMethod.POST)
	public @ResponseBody String createTodo(
			@RequestParam(value = "category", required = true) String category,
			@RequestParam(value = "notificationContent", required = true) String notificationContent) {

		logger.info("Entering  the Create New Todo item");
		
		String response = "";
		// service call
		Todo todo = new Todo();
		todo.setCategory(category);
		todo.setNotificationContent(notificationContent.toString());
		todo.setCreationDate(new Date());
		todo.setActivationDate(new Date());
		todo.setNotificationType(491);
		todo.setPriority(163);
		MemberPersona creatingMember = new MemberPersona();
		creatingMember.setMemberRoleId(Integer.valueOf(ThreadLocalUtil
		.getToken().getMemberPersonaId().getStorageID()));
		logger.info("Member Role Id :"+creatingMember.getMemberRoleId());
		todo.setCreatingMember(creatingMember);
		todo.setForMember(creatingMember);
		try {			
			todoService.createTodo(todo);
			response = ZiksanaConstants.TODO_INSERTED_SUCCESSFULLY;
			
		} catch (ZiksanaException zexception) {
			response = zexception.getMessage();		
			logger.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		
		return response;

	}

	@RequestMapping(value = "/gettodopopuppage", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getPopupWindow() {
		logger.info("Popup window");
		ModelAndView modelAndView = new ModelAndView("common/todo");
		

		return modelAndView;
		
	}
	
	
	
	
	/**
	 * Delete a todo item based on todo item id
	 */
	@RequestMapping(value = "/deletetodo/{todoItemId}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteTodoItem(@PathVariable String todoItemId) {
	
		String response = "";
		try{
		todoService.deleteTodo(Integer.valueOf(todoItemId));
		response = ZiksanaConstants.TODO_DELETED_SUCCESSFULLY;
		}
		catch(ZiksanaException zexception){
			response = zexception.getMessage();
			logger.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		logger.info("Exiting deleteTodoItem(): " + todoItemId);
		return response;
	}
	
	@RequestMapping(value = "/updatetodo", method=RequestMethod.POST)
	public @ResponseBody String updateTodo(
			@RequestParam(value = "todoItemId", required = true) String todoItemId,
			@RequestParam(value = "notificationContent", required = true) String notificationContent,
			@RequestParam(value = "category", required = true) String category) {
		
		String response = "";
		Todo todo = new Todo();
		todo.setId(Integer.parseInt(todoItemId));
		todo.setCategory(category);
		todo.setNotificationContent(notificationContent);
		todo.setCreationDate(new Date());
		todo.setActivationDate(new Date());
		try {			
			todoService.updateTodo(todo);
			response = ZiksanaConstants.TODO_UPDATED_SUCCESSFULLY;
		} catch (ZiksanaException ZException) {
			logger.error("Caught Exception. class ="+ ZException.getClass().getName() + ",message ="+ ZException.getMessage());
			response = ZException.getMessage();
		}
		
		return response;
	}
	
	@RequestMapping(value = "/gettodocategory", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getCategoryById(){
		
		ModelAndView modelView = new ModelAndView();
		
		List<Todo> todoList = new ArrayList<Todo>();
		List<String> categoryList = new ArrayList<String>();
		for(Todo todo :todoList){
			String category = todo.getCategory();
			categoryList.add(category);
		}
		modelView.addObject("categoryList");
		
		return modelView;
	}

}
