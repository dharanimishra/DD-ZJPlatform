package com.ziksana.controller;

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

import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.todo.Todo;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.todo.TodoService;

@Controller
@RequestMapping("/secure")
public class TodoController {
	private static final Logger logger = LoggerFactory.getLogger(TodoController.class);
	
	@Autowired
	TodoService todoService;
	
	//educatorlouncher
	
	
	/**
	 * Retrive all todo items to display on the dashboard
	 */
	@RequestMapping(value = "/showmytodo/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showMyTodos(@PathVariable String memberId) {
		logger.info("Entering showMyTodos(): " + memberId);
		ModelAndView modelView = new ModelAndView("xml/todolist");
		
		
		modelView.addObject("todoItems", todoService.getTodos());
		
		
		
		logger.info("Exiting showMyTodos(): " + memberId);
		return modelView;
	}
	
	@RequestMapping(value = "/getmytodosize/{memberId}", method = RequestMethod.GET)
	public @ResponseBody int getTodoSize(@PathVariable String memberId) {
		logger.info("Entering showMyTodos(): " + memberId);
		int todoSize = 0;
		List<Todo> todoList = new ArrayList<Todo>();
		todoList = todoService.getTodos();
		todoSize = todoList.size();
		
		return todoSize;
	}
	
	

	/**
	 * Retrive Three todo items to display on the dashboard
	 */
	@RequestMapping(value = "/showtodo/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showTodos(@PathVariable String memberId) {
		logger.info("Entering showMyTodos(): " + memberId);
		ModelAndView modelView = new ModelAndView("xml/todolist");
		
		
		modelView.addObject("todoItems", todoService.getMapperTodos());
		logger.info("Exiting showMyTodos(): " + memberId);
		return modelView;
	}
	
	/**
	 * Creating new TODO item based on the Todo object
	 * @return mav
	 */
	@RequestMapping(value = "/createtodo", method = RequestMethod.POST)
	public @ResponseBody ModelAndView createTodo(
			@RequestParam(value = "category", required = true) String category,
			@RequestParam(value = "notificationContent", required = true) String notificationContent) {

		logger.info("Entering  the Create New Todo item");
		logger.info("category  :"+category);
		logger.info("NotificationContent  :"+notificationContent);
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
			
		} catch (Exception exception) {
			logger.error("Caught Exception. class ="+ exception.getClass().getName() + ",message ="+ exception.getMessage());
		}
		// retrun the Todo domain object
		ModelAndView modelView = new ModelAndView("xml/todolist");
		modelView.addObject("todoItems", todoService.getTodos());
		return modelView;

	}

	@RequestMapping(value = "/gettodopopupwindow", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getPopupWindow() {
		logger.info("Popup window");
		ModelAndView modelAndView = new ModelAndView("xml/moretodo");
		

		return modelAndView;
		
	}
	
	
	
	@RequestMapping(value = "/launcher", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getEducatorLouncher() {
		logger.info("Popup window");
		ModelAndView modelAndView = new ModelAndView("common/educator_louncher");
		

		return modelAndView;
		
	}
	
	
	@RequestMapping(value = "/educatordashboard", method = RequestMethod.GET)
	public @ResponseBody ModelAndView redirectEducatorLauncherPage() {
		logger.info("Popup window");
		ModelAndView modelAndView = new ModelAndView("dashboard-div");
		

		return modelAndView;
		
	}
	/**
	 * Delete a todo item based on todo item id
	 */
	@RequestMapping(value = "/deletetodo/{todoItemId}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteTodoItem(@PathVariable String todoItemId) {
		logger.info("Entering deleteTodoItem(): " + todoItemId);
		
		todoService.deleteTodo(Integer.valueOf(todoItemId));
		
		logger.info("Exiting deleteTodoItem(): " + todoItemId);
		return "Successfully Deleted";
	}
	
	@RequestMapping(value = "/gettodocategory/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getCategoryById(@PathVariable String memberId){
		logger.info("Entering showMyTodos(): " + memberId);
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
